package homework2.car;

public class CarShop {
	private static final int DEFAULT_CAPACITY_OF_CARS = 10;
	private Car[] arrayOfCars;
	private static int indexOfCurrentCar = -1;

	CarShop(int capacity) {
		if (capacity > 0) {
			arrayOfCars = new Car[capacity];
		} else {
			System.out.println("Capacity must be positive");
			arrayOfCars = new Car[DEFAULT_CAPACITY_OF_CARS];
			return;
		}
	}

	boolean addCar(Car car) {
		if (car == null) {
			return false;
		}

		for (int index = 0; index < arrayOfCars.length; index++) {
			if (arrayOfCars[index] == null) {
				indexOfCurrentCar = -1;
				arrayOfCars[index] = car;
				return true;
			}
		}
		return false;
	}

	private Car getNextCar() {
		if (indexOfCurrentCar + 1 == arrayOfCars.length) {
			indexOfCurrentCar = -1;
		}

		for (int index = 0; index < arrayOfCars.length; index++) {
			if ((arrayOfCars[index] != null) && (indexOfCurrentCar < index)) {
				indexOfCurrentCar = index;
				return arrayOfCars[index];
			}
		}
		return null;
	}

	void sellCar(Person buyer) {
		if (buyer == null) {
			System.out.println("This person doesn't exist");
			return;
		}

		Car tempCar = getNextCar();

		if (indexOfCurrentCar == -1) {
			System.out.println("No cars are left in the shop");
			return;
		}

		if (tempCar == null) {
			System.out.println("No car can be found in the shop");
			return;
		}

		if (buyer.getMoney() < tempCar.getPrice()) {
			System.out.println(buyer.getName() + " has no money! He needs " + (tempCar.getPrice() - buyer.getMoney())
					+ " to buy the car " + tempCar.getModel());
			return;
		}

		if (buyer.buyCar(tempCar)) {
			tempCar.changeOwner(buyer);
			arrayOfCars[indexOfCurrentCar] = null;
			System.out.println((buyer.getName()) + " bought " + (tempCar.getModel()));
		}
	}

	void printAllCarsInTheShop() {
		for (int index = 0; index < arrayOfCars.length; index++) {
			if (arrayOfCars[index] != null) {
				System.out.println("Model " + arrayOfCars[index].getModel() + "\nPrice " + arrayOfCars[index].getPrice()
						+ "\nMax Speed " + arrayOfCars[index].getMaxSpeed() + "\nColor "
						+ arrayOfCars[index].getMaxSpeed() + "\n");
			}
		}
	}

}
