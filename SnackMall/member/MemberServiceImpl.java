package member;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private MemberDAO memberDAO;

    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public boolean joinMember(MemberVO member) {
        return memberDAO.insertMember(member);
    }

    @Override
    public MemberVO login(String id, String pw) {
        if (id.equals("admin") && pw.equals("admin1234")) {
            MemberVO admin = new MemberVO("admin", "admin1234", "관리자", "010-0000-0000");
            admin.setGrade(1);
            return admin;
        }

        MemberVO member = memberDAO.selectMember(id);
        if (member != null && member.getPw().equals(pw)) {
            return member;
        }
        return null;
    }

    @Override
    public MemberVO searchMember(String id) {
        return memberDAO.selectMember(id);
    }

    @Override
    public List<MemberVO> memberList() {
        return memberDAO.selectAllMembers();
    }

    @Override
    public boolean updateMember(MemberVO member) {
        return memberDAO.updateMember(member);
    }

    @Override
    public boolean deleteMember(String id) {
        return memberDAO.deleteMember(id);
    }
}
