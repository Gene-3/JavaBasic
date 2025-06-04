package test;

import member.HashMapMemberDAO;
import member.KJMemberService;
import member.MemberService;
import member.MemberVO;

public class MemberServiceTest {
	
	public static void main(String[] args) {
		MemberService ms = new KJMemberService(new HashMapMemberDAO());
		
		// 회원 등록
		ms.registMember(new MemberVO("uesr1", "1234", "user1"));
		ms.registMember(new MemberVO("uesr2", "1234", "user2"));
		ms.registMember(new MemberVO("uesr3", "1234", "user3"));
		
		// 회원 목록
		System.out.println(ms.listMembers());
		
		// 회원 상세 정보
		System.out.println(ms.detailMemberInfo("user2"));
		
		// 회원 정보 수정
		ms.updatePassword("user2", "1234", "1111");
		System.out.println(ms.listMembers());
		
		// 회원 삭제
		ms.removeMember("user3", "1111");
		System.out.println(ms.listMembers());
		
		// 로그인
		MemberVO loggedMember = ms.login("user1", "1234");
		System.out.println(loggedMember);
		
		// 정보 추가
		ms.addMemberInfo(loggedMember.getId(), "010-1234", "user1@kopo", "서울시 송파구");
		System.out.println(ms.listMembers());
	}
}
