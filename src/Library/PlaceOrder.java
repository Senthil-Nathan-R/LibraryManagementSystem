//package Library;
//
//import java.util.Scanner;
//
//public class PlaceOrder implements IOOperation {
//	
//	@Override
//	public void oper(Database database,User user) {
//		
//		Order order=new Order();
//		System.out.println("\nENTER BOOK NAME :");
//		Scanner s=new Scanner(System.in);
//		String bookname=s.next();
//		
//		int i=database.getBook(bookname);
//		if(i>-1) {
//			System.out.println("BOOK DOESN'T EXIST..!");
//		}else {
//			Book book=database.getBook(i);
//			order.setBook(book);
//			order.setUser(user);
//			System.out.println("ENTER QTY:");
//			int qty=s.nextInt();
//			order.setQty(qty);
//			order.setPrice(book.getPrice()*qty);
//			int bookindex=database.getBook(book.getName());
//			book.setQty(book.getQty()-1);
//			database.addOrder(order,book,bookindex);
//			System.out.println("ORDERE PLACED SUCCESSFULLY..!\n");
//			
//		}
//		user.menu(database, user);
//	}
//
//}
package Library;

import java.util.Scanner;

public class PlaceOrder implements IOOperation {
    
    @Override
    public void oper(Database database, User user) {
        
        Order order = new Order();
        System.out.println("\nENTER BOOK NAME: ");
        Scanner s = new Scanner(System.in);
        String bookname = s.nextLine().trim().toLowerCase();
        
        int i = -1;
        for (Book book : database.getAllBooks()) {
            if (book.getName().toLowerCase().equals(bookname)) {
                i = database.getAllBooks().indexOf(book);
                break;
            }
        }
        
        if (i == -1) {
            System.out.println("BOOK DOESN'T EXIST..!");
        } else {
            Book book = database.getBook(i);
            order.setBook(book);
            order.setUser(user);
            System.out.println("ENTER QTY: ");
            int qty = s.nextInt();
            if (qty > book.getQty()) {
                System.out.println("NOT ENOUGH STOCK AVAILABLE!");
            } else {
                order.setQty(qty);
                order.setPrice(book.getPrice() * qty);
                int bookindex = database.getBook(book.getName());
                book.setQty(book.getQty() - qty);
                database.addOrder(order, book, bookindex);
                System.out.println("ORDER PLACED SUCCESSFULLY..!\n");
            }
        }
        user.menu(database, user);
    }
}
