package homework1.student;

import java.util.Arrays;

public class GroupOfStudents {
	Student[] groupOfStudents;
	Subjects groupSubject;
	int freePlaces;

	GroupOfStudents() {
		this.groupOfStudents = new Student[5];
		this.freePlaces = 5;
	}

	GroupOfStudents(Subjects subject) {
		this();
		this.groupSubject = subject;
	}

	void addStudent(Student studentToAdd) {
		for (int index = 0; index < groupOfStudents.length; index++) {
			if ((this.freePlaces <= 0) || (this.freePlaces > groupOfStudents.length)) {
				System.out.println("No free spaces");
				return;
			}

			if (groupOfStudents[index] != null) {
				continue;
			}

			if ((groupOfStudents[index] == null) && (studentToAdd.getSubject() == this.groupSubject)) {
				groupOfStudents[index] = studentToAdd;
				this.freePlaces--;
				System.out.println("Added a student");
				break;
			} else {
				System.out.println("We cant add a Student!");
				return;
			}
		}
	}

	void emptyGroup() {
		this.groupOfStudents = new Student[5];
		this.freePlaces = 5;
	}

	Student showMeTheBestStudent() {
		float max = 0;
		int indexToRemmember = 0;
		for (int index = 0; index < groupOfStudents.length; index++) {
			if (groupOfStudents[index] != null) {
				if (groupOfStudents[index].getGrade() > max) {
					max = groupOfStudents[index].getGrade();
					indexToRemmember = index;
				}
			}
		}
		return groupOfStudents[indexToRemmember];
	}

	void printAllStudents() {
		for (int index = 0; index < groupOfStudents.length; index++) {
			if (groupOfStudents[index] != null) {
				System.out.println("Name: " + groupOfStudents[index].getName() +"\n"+
						"Age: " + ((Student) groupOfStudents[index]).getAge() +"\n" +
						"Grade: " + groupOfStudents[index].getGrade() +"\n" +
						"Year: " + groupOfStudents[index].getYearInCollage() +"\n" +
						"Money: " + groupOfStudents[index].getMoney() +"\n");
			}
		}
	}
}
