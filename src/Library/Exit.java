package Library;

import java.util.Scanner;

public class Exit implements IOOperation{
	Scanner s;
	Database database;
	User user;
	@Override
	public void oper(Database database,User user) {
		this.database=database;
		this.user=user;
		System.out.println("\nARE YOU SURE THAT YOU WANT TO QUIT ?\n"
				+"1. YES\n2. MAIN MENU");
		s=new Scanner(System.in);
		int i=s.nextInt();
		if(i==1)
		{
			System.out.println("0.EXIT\n"+"1.LOGIN\n2.NEW USER");
					System.out.print("ENTER A NUMBER :");
							s=new Scanner(System.in);
							int num=s.nextInt();
							
							switch (num) {
							case 1:login(); break;
							case 2:newUser(); break;
							case 0:System.err.println("THANK YOU"); break;
							}
		}else {
			user.menu(database, user);
		}
 }	private void login() {
		System.out.print("ENTER PHONE NUMBER :");
		String phonenumber=s.next();
		System.out.print("ENTER EMAIL :");
		String email=s.next();
		int n=database.login(phonenumber,email);
		if(n!= -1) {
			User user=database.getUser(n);
			user.menu(database,user);
		}else {
			System.out.println("User doesn't exist");
		}
	}
	
	private void newUser() {
		System.out.print("ENTER NAME :");
		String name=s.next();
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
