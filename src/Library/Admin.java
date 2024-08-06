package Library;

import java.util.Scanner;

public class Admin extends User {
	
	public Admin(String name) {
		super(name);
		this.operations=new IOOperation[] {
				new ViewBooks(),
				new AddBook(),
				new DeleteBook(),
				new Search(),
				new DeleteAllData(),
				new ViewOrders(),
				new Exit()
				
		};
	}
	public Admin(String name,String email,String phonenumber) {
		super(name,email,phonenumber);
		this.operations=new IOOperation[] {
				new ViewBooks(),
				new AddBook(),
				new DeleteBook(),
				new Search(),
				new DeleteAllData(),
				new ViewOrders(),
				new Exit()
		};
	}
	
	@Override
	public void menu(Database database,User user) {
	       System.out.println("\n1. VIEW BOOKS");
	       System.out.println("2. ADD BOOKS");
	       System.out.println("3. DELETE BOOKS");
	       System.out.println("4. SEARCH");
	       System.out.println("5. DELETE ALL DATA");
	       System.out.println("6. VIEW ORDERS");
	       System.out.println("7. EXIT");
	       
	       Scanner s = new Scanner(System.in);
	       int n=s.nextInt();
	       this.operations[n-1].oper(database,user);
	       s.close();


}
	public String toString() {
		return name+"<N/>"+email+"<N/>"+phonenumber+"<N/>"+"Admin";
	}
}
