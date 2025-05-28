package member;

public interface FileMemberDB {
	String DATA_FILE = "./member/member";
	void saveMembers();
	void loadMembers();
}
