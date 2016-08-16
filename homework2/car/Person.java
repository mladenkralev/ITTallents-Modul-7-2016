package homework2.car;

public class Person {
	private final float DEFAULT_WEIGHT = 4.0f;
	private final float INDEX_FOR_SCRAP = 2.42f;

	private int age;
	private String name;
	private Person[] friends;
	private float weight;
	private long personalNumber;
	private Gender pol;
	private float money;
	private Car myCurrentCar;
	private Garage myGarrage;

	Person() {
		this.friends = new Person[3];
		this.weight = DEFAULT_WEIGHT;
		this.myGarrage = new Garage(3);
	}

	Person(String name, long personalNumber, Gender pol) {
		this();
		if ((name != null) && (name.length() >= 2)) {
			this.name = name;
		} else {
			this.name = "No name here";
		}

		if ((personalNumber > 0) && ("" + personalNumber).length() == 10) {
			this.personalNumber = personalNumber;
		} else {
			System.out.println("Not cool personal number");
		}

		this.pol = pol;
	}

	double sellCarForScarp() {
		if (this.myCurrentCar == null) {
			System.out.println("I dont have car to sell");
			return this.money;
		}
		return this.money + (this.myCurrentCar.getPrice() / INDEX_FOR_SCRAP);

	}

	// i made this boolean so i can check
	// the result
	boolean buyCar(Car carToBeBought) {
		if (carToBeBought == null) {
			System.out.println("Cant buy an unexisting car");
			return false;
		}

		if (this.getMyCar() != null) {
			myGarrage.addCarInGarage(this.getMyCar());
			this.myCurrentCar = null;
		}

		if (carToBeBought.getPrice() <= this.money) {
			this.money -= carToBeBought.getPrice();
			this.myCurrentCar = carToBeBought;
			carToBeBought.changeOwner(this);
			return true;
		} else {
			System.out.println("Not enought money!");
			return false;
		}
	}

	void peekIntoInGarage() {
		myGarrage.printAllCarsInfo();
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		} else {
			System.out.println("Not valid age");
		}
	}

	public void setFriends(Person[] friends) {
		if (friends != null) {
			this.friends = friends;
		} else {
			System.out.println("Passing empty friends");
			return;
		}
	}

	public void setWeight(float weight) {
		if (weight > 0) {
			this.weight = weight;
		} else {
			System.out.println("Not valid weight");
		}
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public Person[] getFriends() {
		return friends;
	}

	public float getWeight() {
		return weight;
	}

	public long getPersonalNumber() {
		return personalNumber;
	}

	public Gender getPol() {
		return pol;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		if (money > 0) {
			this.money = money;
		} else {
			System.out.println("Money must be positive");
			return;
		}
	}

	public Car getMyCar() {
		return myCurrentCar;
	}
}
