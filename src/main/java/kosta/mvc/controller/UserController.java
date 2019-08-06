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
	 * 로그인 폼 띄우기
	 * */
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	
	/**
	 * 로그인 기능
	 * */
	@RequestMapping("/loginCheck")
	public String loginCheck(UserDTO userDTO, HttpSession session) {
		
		UserDTO dbUserDTO = userService.loginCheck(userDTO);
		//세션에 정보 저장
		session.setAttribute("loginUser", dbUserDTO.getUserId());
		session.setAttribute("loginName", dbUserDTO.getName());
		
		return "redirect:/";	
	}
	
	/**
	 * 로그아웃 기능
	 * */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //모든 세션 정보 지우기
		return "redirect:/";
	}
}
