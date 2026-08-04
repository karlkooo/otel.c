package com.como.archi.otel.extension;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import io.opentelemetry.sdk.autoconfigure.spi.traces.ConfigurableSpanExporterProvider;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;

/** Provides concise parent-aware span logging to the OpenTelemetry Java Agent. */
public final class ParentAwareLoggingSpanExporterProvider
        implements ConfigurableSpanExporterProvider {

    @Override
    public SpanExporter createExporter(ConfigProperties config) {
        return new ParentAwareLoggingSpanExporter();
    }

    @Override
    public String getName() {
        return "parent-logging";
    }

    private static final class ParentAwareLoggingSpanExporter implements SpanExporter {

        private static final Logger logger =
                Logger.getLogger(ParentAwareLoggingSpanExporter.class.getName());
        private static final AttributeKey<String> SERVICE_NAME =
                AttributeKey.stringKey("service.name");

        @Override
        public CompletableResultCode export(Collection<SpanData> spans) {
            for (SpanData span : spans) {
                String tracerVersion = span.getInstrumentationScopeInfo().getVersion();
                logger.log(Level.INFO, String.format(
                        "OTEL_SPAN service=%s name='%s' traceId=%s spanId=%s parentSpanId=%s "
                                + "kind=%s remoteParent=%s status=%s tracer=%s:%s attributes=%s",
                        span.getResource().getAttribute(SERVICE_NAME),
                        span.getName(),
                        span.getTraceId(),
                        span.getSpanId(),
                        span.getParentSpanId(),
                        span.getKind(),
                        span.getParentSpanContext().isRemote(),
                        span.getStatus().getStatusCode(),
                        span.getInstrumentationScopeInfo().getName(),
                        tracerVersion == null ? "" : tracerVersion,
                        span.getAttributes()));
            }
            return CompletableResultCode.ofSuccess();
        }

        @Override
        public CompletableResultCode flush() {
            return CompletableResultCode.ofSuccess();
        }

        @Override
        public CompletableResultCode shutdown() {
            return CompletableResultCode.ofSuccess();
        }
    }
}
