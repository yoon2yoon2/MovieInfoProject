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
	private long memberId;            //ȸ�� ���̵�
	private String memberPwd;         //ȸ�� ��й�ȣ
	private String memberName;        //ȸ�� �̸�
	private String memberEmail;       //ȸ�� �̸���
}
