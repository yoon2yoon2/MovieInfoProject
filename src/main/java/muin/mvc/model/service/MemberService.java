package muin.mvc.model.service;

import java.util.List;

import muin.mvc.model.dto.AuthorityVO;
import muin.mvc.model.dto.MemberVO;

public interface MemberService {
	MemberVO findMemberById(String id);

	List<String> getAddressList();

	List<MemberVO> findMemberListByAddress(String address);

	MemberVO login(MemberVO memberVO);

	int getMemberCount();

	void updateMember(MemberVO vo);

	void registerMember(MemberVO vo);

	String idcheck(String id);
	
	List<AuthorityVO> selectAuthorityByUsername(String username);
}
