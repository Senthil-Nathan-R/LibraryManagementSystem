package Library;

import java.util.Scanner;

public class AddBook implements IOOperation {
    
    @Override
    public void oper(Database database, User user) {
        
        Scanner s = new Scanner(System.in);
        Book book = new Book();
        System.out.print("\nENTER BOOK NAME: ");
        String name = s.nextLine().trim().toLowerCase();
        
        // Check if the book already exists
        boolean bookExists = false;
        for (Book b : database.getAllBooks()) {
            if (b.getName().toLowerCase().equals(name)) {
                bookExists = true;
                break;
            }
        }
        
        if (bookExists) {
            System.out.println("THERE IS A BOOK WITH THIS NAME..!\n");
            user.menu(database, user);
        } else {
            book.setName(name);
            System.out.print("ENTER BOOK AUTHOR: ");
            book.setAuthor(s.nextLine().trim());
            System.out.print("ENTER BOOK PUBLISHER: ");
            book.setPublisher(s.nextLine().trim());
            System.out.print("ENTER BOOK COLLECTION ADDRESS: ");
            book.setAddress(s.nextLine().trim());
            System.out.print("ENTER QTY: ");
            book.setQty(s.nextInt());
            System.out.print("ENTER PRICE: ");
            book.setPrice(s.nextDouble());
            System.out.print("ENTER BORROWING COPIES: ");
            book.setBrwcopies(s.nextInt());
            
            database.AddBook(book);
            System.out.println("\nBook Added Successfully...\n");
            
            user.menu(database, user);
        }
    }
}
