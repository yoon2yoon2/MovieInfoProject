package kosta.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.mvc.model.dto.UserDTO;
import kosta.mvc.model.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * �α��� �� ����
	 * */
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	
	/**
	 * �α��� ���
	 * */
	@RequestMapping("/loginCheck")
	public String loginCheck(UserDTO userDTO, HttpSession session) {
		
		UserDTO dbUserDTO = userService.loginCheck(userDTO);
		//���ǿ� ���� ����
		session.setAttribute("loginUser", dbUserDTO.getUserId());
		session.setAttribute("loginName", dbUserDTO.getName());
		
		return "redirect:/";	
	}
	
	/**
	 * �α׾ƿ� ���
	 * */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //��� ���� ���� �����
		return "redirect:/";
	}
}
