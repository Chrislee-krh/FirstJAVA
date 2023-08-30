package day09.polymorphism;

public class PolymorphismExample2 {

	public static void main(String[] args) {
		
		Person p;
		
		p = new Teacher("홍선생", 22, "자바");
		System.out.println(p instanceof Person);
		System.out.println(p instanceof Teacher);
		System.out.println(p.getDetail());
		
		p = new Employee("홍사원", 23, "교무처");
		System.out.println(p instanceof Person);
		System.out.println(p instanceof Teacher);
		System.out.println(p instanceof Employee);
		System.out.println(p.getDetail());
		
		p = new Student("홍학생", 17, "20230001", "도술");
		System.out.println(p instanceof Person);
		System.out.println(p instanceof Student);
		System.out.println(p instanceof Employee);
		System.out.println(p.getDetail());
		p.walk();
//		p.study();
		Student s = (Student) p;
		s.study();
		
		
	}

}
