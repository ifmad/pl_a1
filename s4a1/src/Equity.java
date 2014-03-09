
public class Equity {
	Double breakpoint;
	Boolean equity;
	public Equity(Double breakpoint, Boolean equity){
		this.breakpoint=breakpoint;
		this.equity=equity;
	}
	public boolean result(Double d){		
		return breakpoint.compareTo(d)>0||(d.equals(breakpoint) && equity);
	}
}
