package homework1.computer;

public class DemoComputer {
	public static void main(String[] args) {
		Computer computerFirst = new Computer(2011, 121f, 12, 12, "WindowsXP", false);
		Computer computerSecond = new Computer();
		Computer computerThird = new Computer(1994, 1233.23f, 100, 100);

		System.out.println(computerThird.getOperationSystem());
		computerThird.changeOperationSystem("Ios");
		System.out.println("Change to this os " + computerThird.getOperationSystem());

		System.out.println(computerThird.getFreeMemmory());
		computerThird.useMemory(10);
		System.out.println("Eat the ram! " + computerThird.getFreeMemmory() + "\n");

		computerFirst.showMeInfo();
		computerSecond.showMeInfo();

		System.out.println("Resultat comparsm first and second pc " + computerFirst.compare(computerSecond));
		System.out.println("Resultat comparsm first and third pc " + computerFirst.compare(computerThird));

	}
}
