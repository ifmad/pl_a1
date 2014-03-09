public class TableItem{
	public TableItem(double c1,double c0){
		co1=c1;
		co0=c0;
	}
	public TableItem(String s){
		if(s.equalsIgnoreCase("free")){co0=co1=0;return;}
		if(s.substring(0, 2).equalsIgnoreCase("N*")){
			if(s.indexOf('+')!=-1){
				co1=Double.parseDouble(s.substring(2, s.indexOf('+')));
				co0=Double.parseDouble(s.substring(s.indexOf('+')));
				}
			else{
				co1=Double.parseDouble(s.substring(2));
			}
		}
		else{
			co0=Double.parseDouble(s);
		}
	}
	double co1;
	double co0;
	public String toString(){
	String result="";
	    if(co1==0&&co0==0){return "Free";}
		if(co1!=0){
			result += "N*"+co1;
			if(co0!=0){result+="+"+co0;}
		}
		else{
			result+=co0;
		}
		
		return result;
	}
}