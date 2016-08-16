
package homework1.student;

public class Student {
	private final static float AVARAGE_GRADE = 4.0f;
	private String name;
	private Subjects subject;
	private float grade;
	private int yearInCollage;
	private int age;
	private boolean isDegree;
	private double money;

	Student() {
		this.grade = AVARAGE_GRADE;
		this.yearInCollage = 1;
		this.isDegree = false;
		this.money = 0;
	}

	Student(String name, Subjects subject, int age) {
		this();

		if ((name == null) || (name.equals(""))) {
			System.out.println("Name must have non-empty value");
			this.name = "Unknown";
			return;
		}

		if ((subject == null) || (subject.equals(""))) {
			System.out.println("Subject must have non-empty value");
			this.subject = Subjects.IT;
			return;
		}

		for (int index = 0; index < name.length(); index++) {
			char singleChar = name.charAt(index);
			if (Character.isDigit(singleChar)) {
				System.out.println("No digits");
				return;
			}
		}

		if (age < 0) {
			System.out.println("Not valid year for human being");
			return;
		} else {
			if (age < 18) {
				System.out.println("Oy, a prodigy!");
			}
		}

		this.age = age;
		this.subject = subject;
		this.name = name;
	}

	void upYear() {
		if (isDegree) {
			System.out.println("Already has his degree");
			return;
		}

		if ((yearInCollage) > 0 && (yearInCollage <= 4)) {
			if (yearInCollage == 4) {
				isDegree = true;
				System.out.println("Has a degree");
			} else {
				yearInCollage++;
			}
		} else {
			System.out.println("Year in collage is invalid.Check? FIX IT");
		}
	}

	double receiveScholarship(double min, double amount) {
		if ((this.grade >= min) && (this.age < 30)) {
			this.money += amount;
		}
		return this.money;
	}

	public void setGrade(float grade) {
		if ((grade >= 2) && (grade <= 6)) {
			this.grade = grade;
		} else {
			System.out.println("Grade must be between 2 and 6");
			this.grade = 2;
			return;
		}
	}

	public float getGrade() {
		return grade;
	}

	public Subjects getSubject() {
		return subject;
	}

	public String getName() {
		return name;
	}

	public int getYearInCollage() {
		return yearInCollage;
	}

	public int getAge() {
		return age;
	}

	public boolean isDegree() {
		return isDegree;
	}

	public double getMoney() {
		return money;
	}
}
