package Library;

import java.util.Scanner;

public class NormalUser extends User {
	public NormalUser(String name) {
		super(name);
		this.operations=new IOOperation[] {
				new ViewBooks(),
				new Search(),
				new PlaceOrder(),
				new BorrowBook(),
				new CalculateFine(),
				new ReturnBook(),
				new Exit()
				
		};
	}
	public NormalUser(String name,String email,String phonenumber) {
		super(name,email,phonenumber);
		this.operations=new IOOperation[] {
				new ViewBooks(),
				new Search(),
				new PlaceOrder(),
				new BorrowBook(),
				new CalculateFine(),
				new ReturnBook(),
				new Exit()
				
		};
	}
	
	@Override
	public void menu(Database database,User user) {
       System.out.println("1.VIEW BOOKS");
       System.out.println("2.SEARCH");
       System.out.println("3.PLACE ORDER");
       System.out.println("4.BORROW BOOK");
       System.out.println("5.CALCULATE FINE");
       System.out.println("6.RETURN BOOK");
       System.out.println("7.EXIT");
       
       Scanner s = new Scanner(System.in);
       int n=s.nextInt();
       this.operations[n-1].oper(database, user);
       s.close();
   }
	public String toString() {
		return name+"<N/>"+email+"<N/>"+phonenumber+"<N/>"+"Normal";
	}
}
