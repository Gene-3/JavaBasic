package programing02;

public class Person {
	 String name;
	    int age;

	    // 생성자
	    public Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    // 접근자
	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public String show() {
	        return "사람[" +
	                "이름 : " + name +
	                ", 나이 : " + age +
	                ']';
	    }
	
}