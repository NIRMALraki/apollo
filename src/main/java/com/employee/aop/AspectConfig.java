package com.employee.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import com.employee.custom.exception.EmptyInputException;
import com.employee.service.DepartmentService;

@Configuration
@Aspect
public class AspectConfig {

	Logger logger = LogManager.getLogger(DepartmentService.class);
	
	@Before("execution(* com.employee.controller.*.*(..))")
	public void logBefore(JoinPoint j)
	{
			logger.info("Excuting :"+j.getSignature());
	}
	
	@After("execution(* com.employee.controller.*.*(..))")
	public void logAfter(JoinPoint j)
	{
			logger.info("Completed Execution :"+j);
	}
	
	@Around("execution(* com.employee.service.*.*(..))")
	public Object serviceHandler(ProceedingJoinPoint j)
	{
			try {
				return j.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage());
				throw new EmptyInputException("","not found in database");

			}
			
	}
}
