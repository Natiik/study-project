package org.example.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class TrackAspect {
    private final static Logger logger = LoggerFactory.getLogger(TrackAspect.class);

    @Around("@annotation(org.example.annotation.Track)")
    public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        Method method = jp.getTarget().getClass()
                .getMethod(methodSignature.getMethod().getName(), methodSignature.getMethod().getParameterTypes());

        Track annotation = method.getAnnotation(Track.class);

        if (annotation != null) {
            long startTs = System.currentTimeMillis();
            Object proceed = jp.proceed();
            logger.info("Time used to execute method {} is {} miliseconds",
                    method.getName(),
                    System.currentTimeMillis() - startTs);
            return proceed;
        }
        return jp.proceed();

    }
}
