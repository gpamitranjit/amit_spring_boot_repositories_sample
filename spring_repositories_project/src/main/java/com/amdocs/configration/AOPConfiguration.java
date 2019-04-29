package com.amdocs.configration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;

@Configuration
@EnableLoadTimeWeaving(aspectjWeaving=AspectJWeaving.ENABLED)
@Aspect
public class AOPConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(AOPConfiguration.class);
	
	@Before("execution(* com.amdocs.service.*.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		LOGGER.info("Before advice applied by AspectJ weaver!");
	}
}
