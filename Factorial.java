package testPackage;


public class Factorial {
	static int num = 5;
	static int fact =1;
	int localNum=5;
	int localFact=1;
	int localVar;
	
	public int localFact(){
		num =6;
		System.out.println("Local Staic num is ::  "  +num);
       for(int i=1;i<=num;i++){         //We can use static variable in nonStatic method directly without making object of the class
    	   localFact = localFact*i;
		}
      int call = factMethod();  //We can call static method in nonStatic method directly without making object of the class
      localMethod1();      // We can call local method directly inside local method without creating object of class
      System.out.println("Static method Call::"+call);
		return localFact;
	}
	public void localMethod1(){
		
		System.out.println("I am local method1");
		System.out.println("I am local method1 with variable"+localVar);//No run time error bcoz obj is used to call the local method
	}
	
	public void localMethod(){
		localMethod1();      // We can call local method directly inside local method without creating object of class
		System.out.println("I am local method");
	}
	
	public static int factMethod(){
		
		
		for(int i=1;i<=num;i++){
	//		localFact = localFact*i;   //We cannot use local variable in Static method
			fact = fact*i;
		}
	
		Factorial fac1 = new Factorial();
		//We can call local method/variable in Static method by creating object of class we cannot call it directly
		fac1.localMethod();                //We can call local method in Static method
	    //	 System.out.println("Call for local"+call);
		System.out.println("Calling localNum in Static method"+fac1.localNum);
		return fact;
	}
	
	// Main Method
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		num =8;
		
		System.out.println("Staic num is ::  "  +num);
		//Calling static Method
		int f =factMethod();
		System.out.println("Fact of num is::"+f);
		
		//Calling local Method
		
	//	int lFact = localFact();// Cannot call directly we have to create object as shown below
		
		Factorial fac = new Factorial();
		int lFact = fac.localFact();
		System.out.println("Local fat is::"+lFact);
		
		Factorial fac1 = new Factorial();
		fac1.localMethod(); 
		
		System.out.println("Local Staic num is ::  "  +num);

	}
	
}
