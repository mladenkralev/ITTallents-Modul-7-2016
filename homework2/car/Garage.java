package homework2.car;

public class Garage {
	private Car[] arrayOfCars;

	Garage(int capacity) {
		if (capacity > 0) {
			arrayOfCars = new Car[capacity];
		} else {
			System.out.println("Capacity must be positive");
			return;
		}
	}

	boolean addCarInGarage(Car car) {
		if (car == null) {
			System.out.println("Cant add unexisting car into the garage");
			return false;
		}

		for (int index = 0; index < arrayOfCars.length; index++) {
			if (arrayOfCars[index] == null) {
				arrayOfCars[index] = car;
				return true;
			}
		}
		return false;
	}

	void printAllCarsInfo() {
		System.out.println("\n\tYOUR GARRAGE HAS:");
		for (int index = 0; index < arrayOfCars.length; index++) {
			if (arrayOfCars[index] != null) {
				System.out.println("Model " + arrayOfCars[index].getModel() + "\nPrice " + arrayOfCars[index].getPrice()
						+ "\nMax Speed " + arrayOfCars[index].getMaxSpeed() + "\nColor "
						+ arrayOfCars[index].getMaxSpeed() + "\n");
			}
		}
	}
}
