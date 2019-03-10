package kr.ayukawa.springaop.aspect;

import kr.ayukawa.springaop.model.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DaoAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Before("execution (* kr.ayukawa.springaop.dao.*.*(..))")
	public void before(JoinPoint jp) {
		logger.info("*** {} 메서드 시작됨", jp.toShortString());
	}

	@After("execution (* kr.ayukawa.springaop.dao.*.*(*))")
	public void after(JoinPoint jp) {
		logger.info("*** {} 메서드 종료됨", jp.toShortString());
	}

	@AfterReturning(value="execution (* kr.ayukawa.springaop.dao.*.findByName(*))", returning="product")
	public void afterReturning(JoinPoint jp, Product product) {
		logger.info("*** {} 메서드 정상 종료됨: {}", jp.toShortString(), product.toString());
	}

	@Around("execution (* kr.ayukawa.springaop.dao.*.*(*))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("*** {} 메서드 실행 전", pjp.toShortString());
		pjp.proceed();
		logger.info("*** {} 메서드 실행 종료", pjp.toShortString());
	}

	@AfterThrowing(value="execution (* kr.ayukawa.springaop.dao.*.*(*))", throwing="ex")
	public void afterThrowing(JoinPoint jp, Throwable ex) {
		logger.info("*** {} 메서드 실행 중 예외 발생", jp.toShortString());
		logger.error(ex.getLocalizedMessage(), ex);
	}
}
