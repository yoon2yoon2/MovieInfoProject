package muin.mvc.model.dao;

import java.util.List;

import muin.mvc.model.dto.MemberDTO;

public interface MemberDAO {

	MemberDTO findMemberById(String id);

	List<String> getAddressList();

	List<MemberDTO> findMemberListByAddress(String address);

	MemberDTO login(MemberDTO memberVO);

	int getMemberCount();

	void updateMember(MemberDTO vo);

	void registerMember(MemberDTO vo);

	int idcheck(String id);


}