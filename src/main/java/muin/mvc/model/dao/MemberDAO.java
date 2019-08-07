package muin.mvc.model.dao;

import java.util.List;

import muin.mvc.model.dto.MemberVO;

public interface MemberDAO {

	MemberVO findMemberById(String id);

	List<String> getAddressList();

	List<MemberVO> findMemberListByAddress(String address);

	MemberVO login(MemberVO memberVO);

	int getMemberCount();

	void updateMember(MemberVO vo);

	void registerMember(MemberVO vo);

	int idcheck(String id);


}