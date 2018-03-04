package orderedStructures;

import interfaces.Combinable;

public class Arithmetic extends Progression implements Combinable {
	private double commonDifference; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
		firstValueT=false;
	}
	
	@Override
	public double nextValue() throws IllegalStateException{
		if (!firstValueT) 
			throw new IllegalStateException("Set first value");
		current = current + commonDifference; 
		return current;
	}
	
	@Override
	public String toString(){
		return "Arith("+(int)firstValue()+","+(int)this.commonDifference+")" ;
	}
	
	@Override
	public double getTerm(int n) throws IndexOutOfBoundsException {
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 

		return firstValue()+commonDifference*(n-1);
	}

	@Override
	public Progression add(Progression p) {
		p = new Arithmetic(this.firstValue()+p.firstValue(),this.commonDifference+(p.nextValue()-p.firstValue()));
		return p;
	}

	@Override
	public Progression substract(Progression p) {
		p = new Arithmetic(this.firstValue()-p.firstValue(),this.commonDifference-(p.nextValue()-p.firstValue()));
		return p;
	}
}
