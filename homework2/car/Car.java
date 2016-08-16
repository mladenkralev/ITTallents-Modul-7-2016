package homework2.car;

public class Car {
	private String model;
	private float maxSpeed;

	private float currentSpeed;
	private String color;
	private char currentGear;
	private Person owner;
	private float price;
	private boolean isSportCar;

	Car() {

	}

	Car(String model, boolean isSportCar, String color) {
		if ((model != null) && (!model.equals(""))) {
			this.model = model;
		} else {
			this.model = "";
			System.out.println("model must be non-empty");
		}

		this.isSportCar = isSportCar;

		if ((color != null) && (!color.equals(""))) {
			this.color = color;
		} else {
			this.color = "white";
			System.out.println("Color must be not null");
		}

		this.maxSpeed = 200;
		this.currentGear = 'N';
		this.price = 2000;
	}

	boolean isMoreExpensive(Car otherCar) {
		return (otherCar == null) ? true : (this.price > otherCar.price);
	}

	void accelerate() {
		currentSpeed += 20;

		if (currentSpeed > maxSpeed) {
			currentSpeed = maxSpeed;
			System.out.println("Cant be faster than " + maxSpeed);
		}
	}

	void changeGearUp() {
		if ((currentGear >= '1') && (currentGear <= '4')) {
			this.currentGear++;
		} else {
			System.out.println("5 is the max gear");
		}
	}

	void changeGearDown() {
		if ((currentGear >= '2') && (currentGear <= '5'))
			this.currentGear--;
		else
			System.out.println("1 is the min gear");
	}

	void changeGear(char newGear) {
		if (((newGear >= '1') && (newGear <= '5')) || (newGear == 'R') || (newGear == 'N')) {
			this.currentGear = newGear;
		} else {
			System.out.println("Not valid gear");
			return;
		}
	}

	void changeColor(String newColor) {
		if ((newColor != null) && (!newColor.equals(""))) {
			this.color = newColor;
		} else {
			System.out.println("Color must be non- empty");
			this.color = "white";
			return;
		}
	}

	public void changeOwner(Person owner) {
		if (owner != null) {
			this.owner = owner;
		} else {
			System.out.println("Null person reference is not allowed");
			return;
		}
	}

	public void setMaxSpeed(float maxSpeed) {
		if (maxSpeed > 0) {
			this.maxSpeed = maxSpeed;
		} else {
			System.out.println("Invalid speed");
			return;
		}
	}

	public void setCurrentSpeed(float currentSpeed) {
		if (currentSpeed > 0) {
			this.currentSpeed = currentSpeed;
		} else {
			System.out.println("Invalid speed");
			return;
		}
	}

	public void setPrice(float price) {
		if (price > 0) {
			this.price = price;
		} else {
			System.out.println("Invalid price");
			return;
		}
	}

	public Person getOwner() {
		return owner;
	}

	public String getModel() {
		return model;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public float getCurrentSpeed() {
		return currentSpeed;
	}

	public String getColor() {
		return color;
	}

	public char getCurrentGear() {
		return currentGear;
	}

	public float getPrice() {
		return price;
	}

	public boolean isSportCar() {
		return isSportCar;
	}
}
