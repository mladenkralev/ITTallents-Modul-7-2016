package homework1.student;

public class CollageDemo {
	public static void main(String[] args) {
		GroupOfStudents group = new GroupOfStudents(Subjects.driftadjiq);
		Student student = new Student("Mladen", Subjects.driftadjiq, 20);
		student.setGrade(3f);
		Student student1 = new Student("Krasimir", Subjects.driftadjiq, 12);
		student1.setGrade(6f);

		group.addStudent(student1);
		group.addStudent(student);

		System.out.println("Best grade is " + group.showMeTheBestStudent().getGrade());

		System.out.println(
				student.getName() + " has " + student.receiveScholarship(3.0, 300) + " after recieving schollarship");
		System.out.println(
				student1.getName() + " has " + student.receiveScholarship(5.0, 300) + " after recieving schollarship");

		group.printAllStudents();
		student.upYear();
		student.upYear();
		student.upYear();
		student.upYear();
		student.receiveScholarship(3.00f, 2000);
		group.printAllStudents();

		group.emptyGroup();
		group.printAllStudents();

		group.addStudent(student);
		group.printAllStudents();

	}
}
