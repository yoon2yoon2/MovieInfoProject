package muin.mvc.model.dao;
/*
 * insertAuthority
 * selectAuthorityByUserName
 */

import java.util.List;

import muin.mvc.model.dto.AuthorityVO;

public interface AuthoritiesDAO {
	int insertAuthority(AuthorityVO authority);
	List<AuthorityVO> selectAuthorityByUserName(String username);
}
