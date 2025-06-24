package member;

import java.io.Serializable;

public class MemberVO implements Serializable {

    private String id;
    private String pw;
    private String name;
    private String mobile;
    private int memberNo;
    private int grade = 0; // 기본값: 일반회원

    public MemberVO(String id, String pw, String name, String mobile) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "[" + memberNo + ", " + id + ", " + name + ", " + mobile + ", " + (grade == 1 ? "관리자" : "일반회원") + "]";
    }

    // Getter / Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPw() { return pw; }
    public void setPw(String pw) { this.pw = pw; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public int getMemberNo() { return memberNo; }
    public void setMemberNo(int memberNo) { this.memberNo = memberNo; }

    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }
}
