package member;

import java.util.List;

public interface MemberService {
    boolean joinMember(MemberVO member);
    MemberVO login(String id, String pw);
    MemberVO searchMember(String id);
    List<MemberVO> memberList();
    boolean updateMember(MemberVO member);
    boolean deleteMember(String id);
}
