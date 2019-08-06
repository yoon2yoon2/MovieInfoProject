package kosta.mvc.model.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * �ڷ��(���, �˻�, ��, ����, ����, �ٿ�ε� ���)�� ������ �� 
 * ���������� üũ�� ���� ���
 * */
@Component	//����
@Aspect
public class SessionCheckAdvice {

	@Before("execution(public * kosta.mvc.controller.BoardController.*(..))")
	public void sessionCheck(JoinPoint joinPoint) {
		//���������� üũ
		Object params[] = joinPoint.getArgs();
		HttpSession session =(HttpSession)params[0];
		
		if(session == null || session.getAttribute("loginUser")==null) {
			
			throw new RuntimeException("�α����ϰ� �̿��ϼ���^^");
		}
	}
	
	
}
