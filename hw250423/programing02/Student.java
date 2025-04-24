package programing02;

public class Student extends Person{
	int grade;
	
	public Student(String name, int age, int grade) {
		super(name, age);
		this.grade = grade;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public String show() {
		return "학생[" +
	"이름 : " + name +
	", 나이 : " + age +
	", 학번 : " + grade +
	']';
		
	}
}