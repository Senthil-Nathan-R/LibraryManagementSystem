package Library;

import java.util.ArrayList;

public class ViewBooks implements IOOperation {
	
	@Override
	public void oper(Database database,User user) {
		
		ArrayList<Book> books=database.getAllBooks();
		int count=1;
		for(Book b:books) {
			System.out.println("\n\nBOOK :"+count);
			
			System.out.println("NAME               :"+b.getName());
			System.out.println("AUTHOR             :"+b.getAuthor());
			System.out.println("PUBLISHER          :"+b.getPublisher());
			System.out.println("COLLECTION ADDRESS :"+b.getAddress());
			System.out.println("STATUS             :"+b.getStatus());
			System.out.println("QTY                :"+b.getQty());
			System.out.println("PRICE              :"+b.getPrice());
			System.out.println("BORROWING COPIES   :"+b.getBrwcopies());
			count++;
		}
		System.out.println();
		user.menu(database, user);
	}

}
