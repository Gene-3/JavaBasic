package programing02;

public class ForeignStudent extends Student {
	String nationality;

    public ForeignStudent(String name, int age, int grade, String nationality) {
        super(name, age, grade);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public String show() {
        return "외국학생[" +
                "이름 : " + name +
                ", 나이 : " + age +
                ", 학번 : " + grade +
                ", 국적 : " + nationality +
                ']';
    }
	
}
