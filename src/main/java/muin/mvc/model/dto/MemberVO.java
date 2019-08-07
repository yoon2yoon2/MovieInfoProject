package muin.mvc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	private long memberId;            //회원 아이디
	private String memberPwd;         //회원 비밀번호
	private String memberName;        //회원 이름
	private String memberEmail;       //회원 이메일
}
