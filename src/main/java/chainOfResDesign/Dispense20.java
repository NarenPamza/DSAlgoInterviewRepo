package chainOfResDesign;

public class Dispense20 implements AtmChain{
	
	Currency amt;
	
	AtmChain atmChain;
	
	public Dispense20() {
	}
	
	public Dispense20(Currency amt) {
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
		
		if (value >= 20) {
			int notes = value / 20;
			System.out.println(" 20 notes are " + notes);
			int remainder = value % 20;
			
			if(remainder != 0){
				atmChain.dispense(new Currency(remainder));
			}
		} else {
			atmChain.dispense(amt);
		}
	}

}
