
public class Test {
	public static void main(String []args){
		testCost();
		
	}
	
	
	public static void testCost(){
		DecisionTable table=new DecisionTable(3,3,3);

		String[][] myit={
				{"40","N*13.5","N*13","55","N*15.0","N*14.5","65","N*18.5","N*17.5"},
				{"25","N*7.0","N*6.5","35.0","N*8.5","N*7.5","40","N*9","N*8"},
				{"N*4","N*3.5","N*3","N*3","N*2.5","N*2","N*2","N*1.5","FrEe"}
		};
		TableItem[][]innerTable = new TableItem[myit.length][myit[0].length];
		
		for (int i=0;i<myit.length;i++){
			for(int j=0;j<myit[i].length;j++){
				innerTable[i][j]=new TableItem(myit[i][j]);
			}
		}
		table.setInnerTable(innerTable);
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
		
		System.out.println(table.cost(100.0, 3.0, 1.0));
		System.out.println(DecisionTable.costCalculator(100.0,3.0,1.0));
	}
}
