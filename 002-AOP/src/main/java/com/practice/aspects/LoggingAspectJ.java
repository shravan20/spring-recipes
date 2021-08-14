package com.practice.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspectJ {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspectJ.class);
	
	@Pointcut("execution( * com.practice.services.EmployeeService.cre*(...))")
	public void myPointCut() {
		
	}
	
	@Before(value="myPointCut()")
	public void beforeAdvice(JoinPoint joinPoint) {
		logger.info("Before Advice --> Before Method =>"  + joinPoint.getSignature());
	}
	
	@After(value="myPointCut()")
	public void afterAdvice(JoinPoint joinPoint) {
		logger.info("Before Advice --> Before Method =>"  + joinPoint.getSignature());
	}
	
	@Around(value="myPointCut()")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object object = null;
		logger.info("Around Advice --> Before Method =>"  + joinPoint.getSignature());
		
		try {
			object  = joinPoint.proceed();
			logger.info("Around Advice --> After Method =>"  + joinPoint.getSignature());
		}catch (Throwable t) {
			// TODO: handle exception
			throw t;
		}
		return object;
	}
	
}