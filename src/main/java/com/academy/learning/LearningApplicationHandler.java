package com.academy.learning;



import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.testutils.Timer;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.serverless.proxy.spring.SpringBootProxyHandlerBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Instant;
import java.util.EnumSet;


public class LearningApplicationHandler implements RequestStreamHandler {
    public static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
    static {
        try {

            //For applications that take longer than 10 seconds to start, use the async builder:
            long startTime = Instant.now().toEpochMilli();
            handler = new SpringBootProxyHandlerBuilder()
                    .defaultProxy()
                    .asyncInit(startTime)
                    .springBootApplication(LearningApplication.class)
                    .buildAndInitialize();

            // we use the onStartup method of the handler to register our custom filter
            handler.onStartup(servletContext -> {
                FilterRegistration.Dynamic registration = servletContext.addFilter("CognitoIdentityFilter", CognitoIdentityFilter.class);
                registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
            });
        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Spring Boot application", e);
        }
    }

    public LearningApplicationHandler() {
        // we enable the timer for debugging. This SHOULD NOT be enabled in production.
        Timer.enable();
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
        handler.proxyStream(inputStream, outputStream, context);
    }
}