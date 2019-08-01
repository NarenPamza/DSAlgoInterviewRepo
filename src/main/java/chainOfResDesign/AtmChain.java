package chainOfResDesign;

public interface AtmChain {

	public void setNextChain(AtmChain chain);

	public void dispense(Currency cur);

}
