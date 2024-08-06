package Library;

import java.util.Scanner;

public class DeleteAllData implements IOOperation {
	
	@Override
	public void oper(Database database,User user) {
		
		System.out.println("\nARE YOU SURE THAT YOU WANT TO DELETE ALL DATA ?\n"
				+"1. CONTINUE\n2. MAIN MENU");
		Scanner s=new Scanner(System.in);
		int i=s.nextInt();
		if(i==1)
		{
			database.deleteAllData();
		}else {
			user.menu(database, user);
		}
	}


}
