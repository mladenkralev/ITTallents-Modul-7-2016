package homework2.car;

public class DemoCars {
	public static void main(String[] args) {
		Car carFirst = new Car("Mazda", true, "white");
		carFirst.setCurrentSpeed(100);
		carFirst.setPrice(123);

		Car carSecond = new Car("Pejo", false, "red");
		carSecond.setCurrentSpeed(102);
		carSecond.setPrice(140);

		Car carThird = new Car("Moskvich", false, "black");
		carThird.setCurrentSpeed(12);
		carThird.setPrice(80);

		Person mladen = new Person("mladen", 1234567890, Gender.MELE);
		mladen.setWeight(10);
		mladen.setMoney(222);

		CarShop shop = new CarShop(3);
		System.out.println(shop.addCar(carFirst));
		System.out.println(shop.addCar(carSecond));
		System.out.println(shop.addCar(carThird));

		shop.printAllCarsInTheShop();
		shop.sellCar(mladen);
		shop.sellCar(mladen);
		shop.sellCar(mladen);
		shop.sellCar(mladen);

		Car carFourth = new Car("BMW", false, "pink");
		carFourth.setCurrentSpeed(12);
		carFourth.setPrice(15);
		System.out.println(shop.addCar(carFourth));
		shop.sellCar(mladen);
		mladen.peekIntoInGarage();

	}
}
