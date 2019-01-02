package com.tibco.opentracing.customtracer;

import io.opentracing.Tracer;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tibco.bw.tpcl.io.opentracing.OpenTracingService;

public class JaegerTracingService implements OpenTracingService {
	
	static private ConcurrentHashMap<String,Tracer> tracerMap = new ConcurrentHashMap<String,Tracer>();
	private static final Logger        logger      = LoggerFactory.getLogger(JaegerTracingService.class);

	@Override
	public Tracer getTracer(String applicationName) {
		Tracer tracer = tracerMap.get(applicationName);
		if(tracer == null){
		    tracer = initializeTracer(applicationName);
			tracerMap.put(applicationName, tracer);
		}
		return tracer;
	}

	private Tracer initializeTracer(String applicationName) {
		return null;
//		if(logger.isInfoEnabled()){
//			StringBuilder loggerString = new StringBuilder();
//			loggerString.append("Configuration for Open Tracing : \n"
//					+"JAEGER_AGENT_HOST :  "+ReporterConfiguration.fromEnv().getSenderConfiguration().getAgentHost()+"   \n"
//					+"JAEGER_AGENT_PORT :  "+ReporterConfiguration.fromEnv().getSenderConfiguration().getAgentPort()+"   \n"
//					+"JAEGER_AUTH_TOKEN :  "+ReporterConfiguration.fromEnv().getSenderConfiguration().getAuthToken()+"   \n"
//					+"JAEGER_USER :  "+ReporterConfiguration.fromEnv().getSenderConfiguration().getAuthUsername()+"   \n"
//					+"JAEGER_REPORTER_FLUSH_INTERVAL :  "+ReporterConfiguration.fromEnv().getFlushIntervalMs()+"   \n"
//					+"JAEGER_REPORTER_MAX_QUEUE_SIZE :  "+ReporterConfiguration.fromEnv().getMaxQueueSize()+"   \n"
//					+"JAEGER_REPORTER_LOG_SPANS :  "+ReporterConfiguration.fromEnv().getLogSpans()+"   \n"
//					+"JAEGER_ENDPOINT :  "+ReporterConfiguration.fromEnv().getSenderConfiguration().getEndpoint()+"   \n"
//					+"JAEGER_SAMPLER_PARAM :  "+SamplerConfiguration.fromEnv().getParam()+"   \n"
//					+"JAEGER_SAMPLER_TYPE :  "+SamplerConfiguration.fromEnv().getType()+"   \n"
//			        +"JAEGER_SAMPLER_MANAGER_HOST_PORT :  "+SamplerConfiguration.fromEnv().getManagerHostPort());
//			logger.info(loggerString.toString());
//		}
//		return new Configuration(applicationName)
//				.withReporter(ReporterConfiguration.fromEnv())
//				.withSampler(SamplerConfiguration.fromEnv())
//				.withCodec(CodecConfiguration.fromEnv()).getTracer();
//	}
	}
}
