package Library;

import java.util.*;

public class Main {
	static Database database;
    static Scanner s;

	public static void main(String[] args) {
		
	    database=new Database();
	    System.out.println("WELCOME TO LIBRARY MANAGEMENT SYSTEM!");
		
		int num;  
			System.out.println("0.EXIT\n"+"1.LOGIN\n2.NEW USER");
			System.out.print("ENTER A NUMBER :");
					s=new Scanner(System.in);
					num=s.nextInt();
					
					switch (num) {
					case 1:login(); break;
					case 2:newUser(); break;
					case 0:System.err.println("THANK YOU"); break;
					} 

	}
	private static void login() {
	    System.out.print("ENTER PHONE NUMBER :");
	    String phonenumber = s.next();
	    System.out.print("ENTER EMAIL :");
	    String email = s.next();
	    
	    System.out.println("Debug: Phone Number: " + phonenumber + ", Email: " + email); // Debugging line
	    
	    int n = database.login(phonenumber, email);
	    if (n != -1) {
	        User user = database.getUser(n);
	        user.menu(database, user);
	    } else {
	        System.out.println("User doesn't exist");
	    }
	}



	private static void newUser() {
		System.out.print("ENTER NAME :");
		String name=s.next();
		if(database.userExists(name)) {
			System.out.println("USER EXISTS..!");
		    newUser();
		}
		System.out.print("ENTER PHONE NUMBER :");
		String phonenumber=s.next();
		System.out.print("ENTER EMAIL :");
		String email=s.next();
		System.out.println("\n\n1.ADMIN\n2.NORMAL USER");
		int n2=s.nextInt();
		User user;
		if(n2==1) {
			user=new Admin(name,email,phonenumber);
		}
		else {
			user=new NormalUser(name,email,phonenumber);
		}
		database.AddUser(user);
		user.menu(database,user);
	}
}
