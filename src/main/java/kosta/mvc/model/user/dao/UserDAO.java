package kosta.mvc.model.user.dao;

import kosta.mvc.model.user.dto.UserDTO;

public interface UserDAO {
  /**
   * �α��� ���
   * */
	UserDTO loginCheck(UserDTO userDTO);
}
