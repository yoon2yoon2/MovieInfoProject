package kosta.mvc.model.dao;

import kosta.mvc.model.dto.UserDTO;

public interface UserDAO {
  /**
   * �α��� ���
   * */
	UserDTO loginCheck(UserDTO userDTO);
}
