package member;

import java.io.*;
import java.util.Map;

public class ObjFileHashMapMemberDAO extends HashMapMemberDAO implements FileMemberDB {

    private final String dataFilename = DATA_FILE + ".obj";

    public ObjFileHashMapMemberDAO() {
        loadMembers();
    }

    @Override
    public void saveMembers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFilename))) {
            oos.writeObject(memberDB);
        } catch (IOException e) {
            System.err.println("[저장 실패] 회원 데이터 저장 중 오류 발생");
            e.printStackTrace();
        }
    }

    @Override
    public void loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFilename))) {
            memberDB = (Map<String, MemberVO>) ois.readObject();
            for (MemberVO m : memberDB.values()) {
                if (m.getMemberNo() >= memberSeq) {
                    memberSeq = m.getMemberNo() + 1;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("[DB 로딩] " + dataFilename + " 파일 없음 - 새로 시작합니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[로드 실패] 회원 정보 불러오기 중 오류 발생");
            e.printStackTrace();
        }
    }

    @Override
    public boolean insertMember(MemberVO member) {
        boolean result = super.insertMember(member);
        if (result) saveMembers();
        return result;
    }

    @Override
    public boolean updateMember(MemberVO newMember) {
        boolean result = super.updateMember(newMember);
        if (result) saveMembers();
        return result;
    }

    @Override
    public boolean deleteMember(String id) {
        boolean result = super.deleteMember(id);
        if (result) saveMembers();
        return result;
    }
}
