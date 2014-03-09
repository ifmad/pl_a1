public class DecisionTable{
	
	TableItem[][]innerTable;
	Equity[][]equityTable;
	Double[] timeBreakPoints;
	
	DecisionTable(int priceCoulmnCount, int itemsCoulmnCount,int daysRowCount){
		equityTable=new Equity[3][];
			equityTable[0]=new Equity[priceCoulmnCount-1];
			equityTable[1]=new Equity[itemsCoulmnCount-1];
		innerTable=new TableItem[daysRowCount][priceCoulmnCount*itemsCoulmnCount];
	}
	
	public void setTimes(Double[] breakPoints){
		timeBreakPoints=breakPoints;
	}
	public void setCountEquities (Equity[] equities){
		equityTable[1]=equities;
	}
	public void setPriceEquities ( Equity[] equities){
		equityTable[0]=equities;
	}
	
	public void setInnerTable(TableItem[][] table){
		for(int i=0;i<table.length;i++){
			for(int j=0;j<table[i].length;j++){
				innerTable[i][j]=table[i][j];
			}
		}
	}
	
	public TableItem bring(double... params){return null;}
	
	public double cost(Double price, Double itemsCount, Double days){
		Integer e[]= {equityTable[0].length,equityTable[1].length};
		int f=0;
		for(int j=0;j<equityTable[1].length;j++){
				if(equityTable[0][j].result(price)){
					e[0]=j;break;
				}
				
			}
			for(int j=0;j<equityTable[1].length;j++){
				if(equityTable[1][j].result(itemsCount)){
					e[1]=j;break;
				}
			}
		for(int i=0;i<timeBreakPoints.length;i++){
			f=timeBreakPoints.length;
			if(days.equals(timeBreakPoints[i])){
				f=i;
				break;
			}
		}
		TableItem result=innerTable[f][e[0]*3+e[1]];
		return result.co1*itemsCount+result.co0;
	}
	
	public static double costCalculator(Double price, Double itemsCount, Double days){
		DecisionTable table=new DecisionTable(3,3,3);

		Double[][][] myit={
				{{0.0,40.0},{13.5,0.0},{13.0,0.0},{0.0,55.0},{15.0,0.0},{14.5,0.0},{0.0,65.0},{18.5,0.0},{17.5,0.0}},
				{{0.0,25.0},{7.0,0.0},{6.5,0.0},{0.0,35.0},{8.5,0.0},{7.5,0.0},{0.0,40.0},{9.0,0.0},{8.0,0.0}},
				{{4.0,0.0},{3.5,0.0},{3.0,0.0},{3.0,0.0},{2.5,0.0},{2.0,0.0},{2.0,0.0},{1.5,0.0},{0.0,0.0}}
		};
		
		TableItem[][]innerTable = new TableItem[myit.length][myit[0].length];
		
		for (int i=0;i<myit.length;i++){
			for(int j=0;j<myit[i].length;j++){
				innerTable[i][j]=new TableItem(myit[i][j][0],myit[i][j][1]);
			}
		}
		
		Double[][] breakPoints ={
				{100.0,250.0},
				{3.0,6.0},
				{1.0,2.0,7.0}
		}; 
		Boolean[][] bval={
				{true,false},
				{true,false}
		};
		Equity [][] equities= new Equity[2][2];
		
		table.setInnerTable(innerTable);
		
		for(int i=0;i<bval.length;i++){
			for(int j=0;j<bval[i].length;j++){
				equities[i][j]=new Equity(breakPoints[i][j],bval[i][j]);
			}
		}
		table.setPriceEquities(equities[0]);
		table.setCountEquities(equities[1]);
		table.setTimes(breakPoints[2]);
		
		return table.cost(price, itemsCount, days);
	}

	public String toString(){
		String result="";
		for(int i=0;i<innerTable.length;i++){
			for(int j=0;j<innerTable[i].length;j++){
				result+=innerTable[i][j]+"\t";
			}
			result+="\n";
		}
		return result;
	}
}
