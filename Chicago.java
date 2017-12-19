package SavingsAc;

// Class use for inheritance, it's own data is "interest" rate
// but it will use Company Name from EmployeeSavings Super class

public class Chicago extends EmployeeSavings {
	            
	private double[] interest;
	 private static double intRate;
     
     public Chicago()   //constructor
 	{
 		
 		intRate = 0.01;
 		
 		
 	}
	
	
	public double getIntRate() {
		return intRate;
	}

 public double  getInterest(int number )
	
{
	return interest[number];
	
}
}
