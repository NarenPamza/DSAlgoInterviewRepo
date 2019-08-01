package chainOfResDesign;

public class ATMMachine {

	public static void main(String[] args) {
		int currency = 85;

		if (currency % 10 == 0) {
			Dispense50 fifty = new Dispense50();
			Dispense20 dispense20 = new Dispense20();
			Dispense10 dispense10 = new Dispense10();
			
			fifty.setNextChain(dispense20);
			dispense20.setNextChain(dispense10);

			fifty.dispense(new Currency(currency));

		} else {
			System.out.println("Enter amount in multiple of 10");
		}
	}
}
