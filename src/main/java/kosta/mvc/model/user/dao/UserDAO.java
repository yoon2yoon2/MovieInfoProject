package kosta.mvc.model.user.dao;

import kosta.mvc.model.user.dto.UserDTO;

public interface UserDAO {
  /**
   * 로그인 기능
   * */
	UserDTO loginCheck(UserDTO userDTO);
}
