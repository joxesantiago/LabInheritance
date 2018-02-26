package orderedStructures;

public class Geometric extends Progression {

	private double commonFactor; 
	
	public Geometric(double firstValue, double commonFactor) { 
		super(firstValue); 
		this.commonFactor = commonFactor; 
		firstValueT=false;
	}
	
	@Override
	public double nextValue() throws IllegalStateException {
		if (!firstValueT) 
			throw new IllegalStateException("Set first value");
		current = current * commonFactor; 
		return current;
	}
	
	@Override
	public String toString(){
		return "Geom("+(int)firstValue()+","+(int)this.commonFactor+")" ;
	}
	
	@Override
	public double getTerm(int n) throws IndexOutOfBoundsException {
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 

		return firstValue()*Math.pow(commonFactor, n-1);
	}

}
