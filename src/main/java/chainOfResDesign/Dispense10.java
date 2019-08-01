package chainOfResDesign;

public class Dispense10 implements AtmChain {

	Currency amt;

	@Override
	public void setNextChain(AtmChain chain) {
		// TODO Auto-generated method stub

	}

	public Dispense10() {
	}

	public Dispense10(Currency amt) {
		this.amt = amt;
	}

	@Override
	public void dispense(Currency amt) {
		this.amt = amt;
		int value = amt.getAmount();
		if (value >= 10) {
			int notes = value / 10;
			System.out.println(" 10 notes are " + notes);
		}
	}
}
