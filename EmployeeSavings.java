package SavingsAc;

// EmployeeSavings class superClass

public class EmployeeSavings  {
	
	//private data
	
	  private String[] empNams = new String[3];
	  private String[] empPin = new String[3];
	  private double[] initAmount = new double[3];
 	  private double[] FV = new double[3];
 	  private double[] depAmount = new double[3];
      private double[]withdrawAmount = new double[3];
      private String compName; 
      
     	 
 // Getters and Setters mostly Arrays

	public void setEmpNams (int number, String name) 
	  
	    {
		  
			empNams[number] = name;
		}
	  
	  public String getEmpNams(int number)
	  {
		  return empNams[number];
	  }
	  
		public void setEmpPin(int number, String pin) {
			empPin[number] = pin;
		}

	public String getEmpPin(int number) {
		return empPin[number];
	}
    
	

    public void setInitAmount(int number, double amount)
    {
    	initAmount[number] = amount;
    }
    
    public double getInitAmount(int number)
    {
    	return initAmount[number];
    }
    
 
    
    public void setdepAmount(int numbr, double Amount)
	 {
    	depAmount[numbr] = Amount;
	 }
	 
	 public double getdepAmount(int num)
	 {
		 return depAmount[num];
	 }
	 
	 public void setwithdrawAmount(int numberr, double withAmount)
	 {
		 withdrawAmount [numberr] = withAmount;
	 }
	 
	 
	 public double getwithdrawAmount(int numberr)
	 {
		 return withdrawAmount[numberr];
	 }

	 

		  public String getCompName() {
			return compName;
		}

		public void setCompName(String compName) {
			this.compName = compName;
		}
}
