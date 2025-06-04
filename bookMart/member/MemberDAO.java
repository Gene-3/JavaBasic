package member;
import java.util.List;
public interface MemberDAO {
	boolean insertMember(MemberVO member);
	MemberVO selectMember(String id);
	List<MemberVO> selectAllMember();
	boolean updateMember(MemberVO newMember);
	boolean deleteMember(String id);
}