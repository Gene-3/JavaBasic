package member;

import java.util.List;

public interface MemberDAO {
    boolean insertMember(MemberVO member);
    MemberVO selectMember(String id);
    List<MemberVO> selectAllMembers();
    boolean updateMember(MemberVO member);
    boolean deleteMember(String id);
}
