package homework1.computer;

public class Computer {
	private static final int YEAR_OF_FIRST_COMPUTER = 1938;
	private static final int CURRENT_YEAR = 2016;

	private float price;
	private String[] acceptableOperationSystem = { "windowsxp", "linux", "ios" };
	private int yearOfProduction;
	private boolean isNotebook;
	private int hardDiskMemmory;
	private int freeMemmory;
	private String operationSystem;

	Computer() {
		this.isNotebook = false;
		this.operationSystem = "windowsxp";
	}

	Computer(int year, float price, int hardDiskMemmory, int freeMemmory) {
		this();
		if ((year < YEAR_OF_FIRST_COMPUTER) || (year > CURRENT_YEAR)) {
			System.out.println("Man what kind of year is this?");
			return;
		}

		if (price < 0) {
			System.out.println("What kind of price is this! Must be positive");
			return;
		}

		if (hardDiskMemmory < 0) {
			System.out.println("Hard disk must be positive");
			return;
		}

		if (freeMemmory < 0) {
			System.out.println("Free memmory must be positive");
			return;
		}

		this.freeMemmory = freeMemmory;
		this.hardDiskMemmory = hardDiskMemmory;
		this.price = price;
		this.yearOfProduction = year;
	}

	Computer(int year, float price, int hardDiskMemmory, int freeMemmory, String operationSystem, boolean isNotebook) {
		if ((year < YEAR_OF_FIRST_COMPUTER) || (year > CURRENT_YEAR)) {
			System.out.println("Man what kind of year is this?");
			return;
		}

		if (price < 0) {
			System.out.println("What kind of price is this! Must be positive");
			return;
		}

		if (hardDiskMemmory < 0) {
			System.out.println("Hard disk must be positive");
			return;
		}

		if (freeMemmory < 0) {
			System.out.println("Free memmory must be positive");
			return;
		}

		if ((operationSystem == null) || (operationSystem.equals(""))) {
			System.out.println("Enter non-empty OS, please!");
			this.operationSystem = "Error. Fill it with non- Empty os";
			return;
		}

		boolean isValidOs = false;
		operationSystem = operationSystem.toLowerCase();

		for (int index = 0; index < acceptableOperationSystem.length; index++) {
			if (acceptableOperationSystem[index].equals(operationSystem)) {
				isValidOs = true;
			}
		}

		if (isValidOs) {
			this.operationSystem = operationSystem;
		} else {
			System.out.println("Not valid OS! Valid OS are [windowsxp, linux, ios]");
			return;
		}

		this.isNotebook = isNotebook;
		this.freeMemmory = freeMemmory;
		this.hardDiskMemmory = hardDiskMemmory;
		this.price = price;
		this.yearOfProduction = year;
	}

	int compare(Computer computerForComparison) {
		if (computerForComparison == null) {
			System.out.println("Computer is null?");
			return 1;
		}
		if (this.price > computerForComparison.price) {
			return 1;
		} else {
			if (this.price < computerForComparison.price) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	void showMeInfo() {
		System.out.println("Computer info:\n\t OS " + operationSystem + "\n\t HardDisk " + hardDiskMemmory
				+ "\n\t Is Laptop " + isNotebook + "\n\t Year of production " + yearOfProduction + "\n\t Memmory "
				+ freeMemmory + "\n\t Price " + price);
	}

	void changeOperationSystem(String newOperationSystem) {
		if ((newOperationSystem == null) || (newOperationSystem.equals(""))) {
			System.out.println("Enter non-empty OS, please!");
			return;
		} else {
			boolean isValidOs = false;
			newOperationSystem = newOperationSystem.toLowerCase();
			for (int index = 0; index < acceptableOperationSystem.length; index++) {
				if (acceptableOperationSystem[index].equals(newOperationSystem)) {
					isValidOs = true;
				}
			}
			if (isValidOs) {
				this.operationSystem = newOperationSystem;
			} else {
				System.out.println("Not valid OS! Valid OS are [windowsxp, linux, ios]");
				return;
			}
		}
	}

	void useMemory(int memmoryToTake) {
		if (memmoryToTake <= 0) {
			System.out.println("Must be positive number");
			return;
		}

		if ((freeMemmory - memmoryToTake) < 0) {
			System.out.println("Not enough free memory! No changes made.");
			return;
		} else {
			freeMemmory -= memmoryToTake;
		}
	}

	public float getPrice() {
		return price;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	public boolean isNotebook() {
		return isNotebook;
	}

	public int getFreeMemmory() {
		return freeMemmory;
	}

	public String getOperationSystem() {
		return operationSystem;
	}

}
