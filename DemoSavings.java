package SavingsAc;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.Math;
public class DemoSavings {
	 
	 
    
	public static void main(String[] args) {
		final int THREE = 3;
		Scanner input = new Scanner(System.in);
	    int num = 0,  i, trans;
	    String pyn;
	    double depo,without;
	    boolean stop = false;
	    double[] currentAmount = new double[THREE];
		
		
	 	EmployeeSavings chicagoRegion = new EmployeeSavings(); //Employee Object
		Chicago chicagoCompany = new Chicago();  //   Chicago Object extends Employee Class
		Chicago interest = new Chicago(); // Chicago Object
		 
	
		chicagoCompany.setCompName("Chicago Solutions");  // Company Name in Chicago Region
				     
	// Employee Names and pins, initial deposit in banking system using setters and getters
    //  Names, pins, initial deposit are arrays.
		
		chicagoRegion.setEmpNams(0,"Witt Hawkins");
		chicagoRegion.setEmpNams(1,"John Smith");
		chicagoRegion.setEmpNams(2,"Mary Wilson");
		
		chicagoRegion.setInitAmount(0, 10000);
		chicagoRegion.setInitAmount(1, 8000);
		chicagoRegion.setInitAmount(2, 12000);
		
		chicagoRegion.setEmpPin(0, "6502");
		chicagoRegion.setEmpPin(1, "1324");
		chicagoRegion.setEmpPin(2, "4132");
		
	
	/***************************************************************************************************** */
		
		
		// For loop for initial value calculated with .01 interest for 9 months, when accounts were opened
		// called currentAmount (array)
		
	 	 for( i =0; i <THREE; ++i) {
			 			
	 		currentAmount[i]  = chicagoRegion.getInitAmount(i) * Math.pow( (1.0 + interest.getIntRate()), 9);
	 		currentAmount[i]  = Math.floor((currentAmount[i] * 100)/100);
		 
	 	 }  
	 	
	 	//  Company name and Employee name getters
	 	 
	 	 System.out.println("The Company name for this region is called " + chicagoCompany.getCompName() +
				" There are 3 Employees\n");
		System.out.println("\nThe names of the employees at " + chicagoCompany.getCompName() + 
				" are\n ");
	    for  (i =0; i < THREE; ++i)
		 System.out.println(chicagoRegion.getEmpNams(i));
		   
		 System.out.println("\nPlease enter 1 if you are " + chicagoRegion.getEmpNams(0) );
		 System.out.println("Please enter 2 if you are " + chicagoRegion.getEmpNams(1) );
		 System.out.println("Please enter 3 if you are " + chicagoRegion.getEmpNams(2) );
		 System.out.println("Please enter 0 to quit"); 
		 num = input.nextInt();
		 	 
		 		 
			 while (num < 0 || num >= 4)  // invalid  Employee/quit number validation
				 
			 {  System.out.println("Invalid entry try again, enter a number, 1-4 or 0 to stop");
		 	 
			 num = input.nextInt();
		     }  // end invalid  Employee/quit number validation
		 
			 
			while(stop == false)	{       // Outer while loop to halt all when stop is equal to true
			 
			 
				 switch(num) //Outer Switch statement for each of the 3  Employees
				 {
				 case 1:
					 System.out.println("Hello " + chicagoRegion.getEmpNams(0));  //greeting employee in array, 1st of 3
                	 JOptionPane.showMessageDialog(null, "Hello " + chicagoRegion.getEmpNams(0));
                	 System.out.println("Please enter a valid 4 digit pin");
					 input.nextLine();
					 pyn = input.nextLine();
					 int count = 0;
					   
					    while(!pyn.equals(chicagoRegion.getEmpPin(0)) && count <= 1) //while loop invalid pin (repeated for each employee)
					    {
					    	System.out.println(" invalid Pin. Please re-enter your pin");
					    	++count;
					    	pyn = input.nextLine();
					    }                                                                   // end while loop for invalid pin
					    	if(count > 1 && !pyn.equals(chicagoRegion.getEmpPin(0))) 
					    	{	
						    	 
					    	    System.out.println("3 invalid trys.\n You are locked out. See the Admin");
							    stop=true;     
							      
					    	} else {
					    	
					        System.out.println("Pin Validated");
					        JOptionPane.showMessageDialog(null, " Pin Validated");
					       	System.out.println("your Initial balance is $" + chicagoRegion.getInitAmount(0)); 
					    	System.out.println("your interest to date is $" + (currentAmount[0] - chicagoRegion.getInitAmount(0)));
					    	System.out.println("Your total with interest since initial balance $" + currentAmount[0]);
					    	
					    	while(stop == false) { //transaction loop
					    	trans = displayTransactions();   //transaction method for each of the 3 employees
					    	
					    	switch(trans)
					    	{
					    	case 1:  //inner switch for Employee 1 transactions (repeated for each employee)
					    		
					    		 if(currentAmount[0] < 0)
						    		{
						    			System.out.print("Your balance is $" + currentAmount[0] + "\nPlease contact Admin");
						    			stop = true;
						    		}else
						    		System.out.println("your current balance is $" + currentAmount[0]);
					    		    JOptionPane.showMessageDialog(null,"your current balance is $" + currentAmount[0]);
					    		break;
					    	case 2:
					    	 
					    		depo = deposit(); // deposit method passes array content and index(repeats for each employee)
					    	   
					    		chicagoRegion.setdepAmount(0,depo);
					    		if (chicagoRegion.getdepAmount(0) < 0 ) {  //if statement check for negative input (repeat for each employee)
					    			System.out.println("Negative numbers not allowed!");
					    		    stop = true;
					    		} else {
					    		currentAmount[0] =  currentAmount[0] + chicagoRegion.getdepAmount(0);
					    		if(currentAmount[0] < 0)
					    		{
					    			System.out.print("You have a negative balance, $" + currentAmount[0] + " \nPlease contact Admin");
					    			stop = true;
					    		}else {
					    		System.out.println("your current balance is $" + currentAmount[0]);
					    		JOptionPane.showMessageDialog(null,"your current balance is " + currentAmount[0]);
					    		}
					    		}
					    		break;
					    	case 3:
					    	 
					    		without = with_draw(); // withdrawal method passes array content and index(repeats for each employee)
					    	    chicagoRegion.setwithdrawAmount(0,without);
					    	    if (chicagoRegion.getwithdrawAmount(0) < 0 ) {  //if statement check for negative input (repeat for each employee)
					    			System.out.println("Negative numbers not allowed!");
					    		    stop = true;
					    		} else {
					    	    
					    	    currentAmount[0] =   currentAmount[0]  - chicagoRegion.getwithdrawAmount(0);   // sum total withdrawal to total amount
					    	    
					    	    if(currentAmount[0] < 0)  //check for check for negative balance
					    		{
					    			System.out.print("Your balance is $" + currentAmount[0] + " Please contact Admin");
					    			JOptionPane.showMessageDialog(null,"You have a negative balance of $" + currentAmount[0] + " \nPlease contact Admin");
					    			stop = true;
					    		}else {
					    		System.out.println("your current balance is $" + currentAmount[0] );
					    	    JOptionPane.showMessageDialog(null,"your current balance is $" + currentAmount[0]);
					    		}
					    		}
					    	    break;
					    	case 4:
					    		System.out.println("Total balance is: $" + currentAmount[0]);  // total balance and end transaction part of switch statement
					    		System.out.println("End All transactions. \nHave a good day.");
					    		stop=true;
					    	}
					   	} //end transaction inner while loop
					
				  	}  
				 
			
					 break;
				 case 2:
					 System.out.println("Hello " + chicagoRegion.getEmpNams(1));
					 JOptionPane.showMessageDialog(null, "Hello " + chicagoRegion.getEmpNams(1));
					 System.out.println("Please enter a valid 4 digit pin");
					 input.nextLine();
					 pyn = input.nextLine();
					 int count1 =0;
					    while(!pyn.equals(chicagoRegion.getEmpPin(1)) && count1 <= 1) //while loop invalid pin
					    {
					    	System.out.println("invalid Pin. Please re-enter your pin");
					    
					    	++count1;				    	
					    	pyn = input.nextLine();
				         }  // end while loop invalid pin
					    if(count1 > 1 && !pyn.equals(chicagoRegion.getEmpPin(1))) 
					    {
					     
					       System.out.println("3 invalid trys.\n You are locked out. See the Admin");
					       stop=true;
					    }
					    else {
					    	System.out.println("Pin Validated");
					    	JOptionPane.showMessageDialog(null, " Pin Validated");
					    	System.out.println("your initial balance is $" + chicagoRegion.getInitAmount(1)); 
					        System.out.println("your interest to date is $" + (currentAmount[1] - chicagoRegion.getInitAmount(1)));
					        System.out.println("Your total with interest since initial balance $" + currentAmount[1]);
					       while(stop == false) { //transaction while loop
					        trans = displayTransactions();
					     
					        switch(trans)
					    	{
					    	case 1: // inner switch for Employee transactions
					    		 
					    		 if(currentAmount[1] < 0)
						    		{
						    			System.out.print("Your balance is $" + currentAmount[1] + "\nPlease contact Admin");
						    			stop=true;
						    		}else
						    		System.out.println("your current balance is $" + currentAmount[1]);
					    		 JOptionPane.showMessageDialog(null,"your current balance is $" + currentAmount[1]);
					    		break;
					    	case 2:
					    		depo = deposit();
					    		chicagoRegion.setdepAmount(1,depo);
					    		if (chicagoRegion.getdepAmount(1) < 0 ) { //check for negative input
					    			System.out.println("Negative numbers not allowed!");
					    		    stop = true;
					    		} else {
					    		currentAmount[1] = currentAmount[1] + chicagoRegion.getdepAmount(1);
					    		if(currentAmount[1] < 0)
					    		{
					    			System.out.print("You have a negative balance $" + currentAmount[1] + " \nPlease contact Admin");
					    			stop=true;
					    		}else {
					    		System.out.println("your current balance is " + currentAmount[1]);
					    		JOptionPane.showMessageDialog(null,"your current balance is $" + currentAmount[1]);
					    		}
					    	}	
					    		break;
					    	case 3:
					    	    without = with_draw();
					    	    chicagoRegion.setwithdrawAmount(1,without);
					    	    if (chicagoRegion.getwithdrawAmount(1) < 0 ) { //check for negative input
					    			System.out.println("Negative numbers not allowed!");
					    		    stop = true;
					    		} else {
					    	    currentAmount[1] = currentAmount[1]  - chicagoRegion.getwithdrawAmount(1);
					    	    if(currentAmount[1] < 0)
					    		{
					    			System.out.print("Your balance is " + currentAmount[1] + " Please contact Admin");
					    			JOptionPane.showMessageDialog(null,"You have a negative balance of $ " + currentAmount[1] + " \nPlease contact Admin");
					    			stop=true;
					    		}else {
					    		System.out.println("your current balance is $" + currentAmount[1] );
					    	    JOptionPane.showMessageDialog(null,"your current balance is $" + currentAmount[1]);
					    		}
					    	} 
					    	    break;
					    	case 4:
					    		System.out.println("Total balance is: $" + currentAmount[1]);
					    		System.out.println("End All transactions. \nHave a good day.");
					    		stop=true;
					    		break;
					    	 
					    	}
					    } // end inner case while stop
					 					        
					    } 
				break;  
				 case 3:
					 System.out.println("Hello " + chicagoRegion.getEmpNams(2));
					 JOptionPane.showMessageDialog(null, "Hello " + chicagoRegion.getEmpNams(2));
					 System.out.println("Please enter a valid 4 digit pin");
					 input.nextLine();
					 pyn = input.nextLine();
					 int counter =0;
					    while(!pyn.equals(chicagoRegion.getEmpPin(2)) && counter <= 1) // while loop pin validation
					    {
					    	System.out.println("invalid Pin. Please re-enter your pin");
					    	++counter;
					    	pyn = input.nextLine();
				         } 
					    if(counter > 1 && !pyn.equals(chicagoRegion.getEmpPin(2))) 
					    {
					       System.out.println("3 invalid trys.\3You are locked out. See the Admin");
					      stop=true;
					    } 
					  
					    else {
					    	System.out.println("Pin Validated");
					    	JOptionPane.showMessageDialog(null, " Pin Validated");
					    	System.out.println("your initial balance is $" + chicagoRegion.getInitAmount(2)); 
					        System.out.println("your interest to date is $" + (currentAmount[2] - chicagoRegion.getInitAmount(2)));
					        System.out.println("Your total with interest since initial balance $" + currentAmount[2]);
					        while(stop == false) {  //transaction loop employee 3
					        trans = displayTransactions();
					    	switch(trans)
					    	{
					    	case 1:  // inner switch employee 3
					    		 
					    		 if(currentAmount[2] < 0)
						    		{
						    			System.out.print("Your balance is $" + currentAmount[2] + "\nPlease contact Admin");
						    			stop = true;
						    		}else {
						    		System.out.println("your current balance is $" + currentAmount[2]);
					    		 JOptionPane.showMessageDialog(null,"your current balance is $" + currentAmount[2]);
						    	}
					    		break;
					    	case 2:
					    		depo = deposit();
					    		chicagoRegion.setdepAmount(2,depo);
					    		if (chicagoRegion.getdepAmount(2) < 0 ) { //check for negative input
					    			System.out.println("Negative numbers not allowed!");
					    		    stop = true;
					    		} else {
					    		currentAmount[2] = currentAmount[2]  + chicagoRegion.getdepAmount(2);
					    		if(currentAmount[2] < 0)
					    		{
					    			System.out.print("\nYou have a negative balance of  $" + currentAmount[2] + " \nPlease contact Admin");
					    			stop = true;
					    		}else {
					    		System.out.println("your current balance is $" + currentAmount[2]);
					    		JOptionPane.showMessageDialog(null,"your current balance is $" + currentAmount[2]);
					    		}
					    	}
					    		break;
					    	case 3:
					    	    without = with_draw();
					    	    chicagoRegion.setwithdrawAmount(2,without);
					    	    if (chicagoRegion.getwithdrawAmount(2) < 0 ) { //check for negative input
					    			System.out.println("Negative numbers not allowed!");
					    		    stop = true;
					    		} else {
					    	    currentAmount[2] =   currentAmount[2]  - chicagoRegion.getwithdrawAmount(2);
					    	    if(currentAmount[2] < 0)
					    		{
					    			System.out.print("\nYour balance is $" + currentAmount[2] + " \nPlease contact Admin");
					    			JOptionPane.showMessageDialog(null,"You have a negative balance of  $" + currentAmount[2] + " \nPlease contact Admin");
					    			stop = true;
					    		}else {
					    		System.out.println("your current balance is  $" + currentAmount[2]);
					    		JOptionPane.showMessageDialog(null,"your current balance is $" + currentAmount[2]);
					    		}
					    		}
					    	    break;
					    	case 4:
					    		System.out.println("\nTotal balance is: $" + currentAmount[2]);
					    		System.out.println("End transactions. \nHave a nice day.");
					    		stop=true;
					    		break;
					      	} //end inner case
					    	
					       }  // end transaction inner  while loop
					    }
			 
					 break;
		           case 0:
					  System.out.println("End Transactions. \nHave a nice day.");   //end all transactions if choice is 0 for any of 3 employees
					  stop = true;
					  break;
	        	}
				
				 }  // end Outer while loop to halt all when stop is equal to true
				 
			 System.out.println("\nSession over");  
	
	}
			 

			 	 
			
		

	/********************************** End of main ***********************************************/
	
	//Display method
	
	 public static int displayTransactions()
	 { 
	     int number=0;		 
		 Scanner input = new Scanner(System.in);
		 System.out.println("******************************");
		 System.out.println(" Please Enter Transaction ");
		 System.out.println("\nAvailable Transactions");
		 System.out.println("1. Current Balance");
		 System.out.println("2. Deposit");
		 System.out.println("3. Withdrawal");
		 System.out.println("4. End All transactions");
		 System.out.println("******************************");
		 number = input.nextInt();
		 return number;
	 
	 
 }
	// deposit method
	 
	 public static double deposit()
	 {
	 Scanner input = new Scanner(System.in);
	 double deposit = 0.0;
	//  System.out.println("Enter a deposit amount: XX.XX ");
	 JOptionPane.showMessageDialog(null, "Enter a deposit amount: XX.XX ");
	  deposit = Double.parseDouble(JOptionPane.showInputDialog(null, "Deposit is " + deposit));
	 // deposit = input.nextDouble();
	 return deposit;
	 }
	 
	 
	 // withdrawal method
	 
	 public static double with_draw ()
	 {
	 double withdraW;
	// System.out.println("Enter a withdrawal amount: XX.XX ");
	 JOptionPane.showMessageDialog(null, "Enter a withdrawal amount: XX.XX ");
	 withdraW = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter withdrawal amount"));
	 return withdraW;
	 }

	
}
	
	  
 
	 
	
 

