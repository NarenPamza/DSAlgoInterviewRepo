package chainOfResDesign;

public class Dispense50 implements AtmChain {

	AtmChain atmChain;

	Currency amt;
	
	public Dispense50() {
	}

	public Dispense50(Currency amt) {
		this.amt = amt;
	}

	@Override
	public void setNextChain(AtmChain chain) {
		this.atmChain = chain;
	}
	
	@Override
	public void dispense(Currency amt) {
		this.amt = amt;
		int value = amt.getAmount();
		
		if (value >= 50) {
			int notes = value / 50;
			System.out.println(" 50 notes are " + notes);
			int remainder = value % 50;
			
			if(remainder != 0){
				atmChain.dispense(new Currency(remainder));
			}
		} else {
			atmChain.dispense(amt);
		}
	}

}
