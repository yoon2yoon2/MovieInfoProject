package kosta.mvc.model.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 자료실(등록, 검색, 상세, 수정, 삭제, 다운로드 등등)을 접근할 때 
 * 세션유무를 체크할 공통 기능
 * */
@Component	//생성
@Aspect
public class SessionCheckAdvice {

	@Before("execution(public * kosta.mvc.controller.BoardController.*(..))")
	public void sessionCheck(JoinPoint joinPoint) {
		//세션유무를 체크
		Object params[] = joinPoint.getArgs();
		HttpSession session =(HttpSession)params[0];
		
		if(session == null || session.getAttribute("loginUser")==null) {
			
			throw new RuntimeException("로그인하고 이용하세요^^");
		}
	}
	
	
}
