package Library;

import java.util.Scanner;

public class DeleteBook implements IOOperation {
    
    @Override
    public void oper(Database database, User user) {
        
        Scanner s = new Scanner(System.in);
        System.out.print("ENTER BOOK NAME: ");
        String bookname = s.nextLine().trim().toLowerCase();
        
        int i = -1;
        for (Book book : database.getAllBooks()) {
            if (book.getName().toLowerCase().equals(bookname)) {
                i = database.getAllBooks().indexOf(book);
                break;
            }
        }
        
        if (i > -1) {
            database.deleteBook(i);
            System.out.println("\nBOOK DELETED SUCCESSFULLY..!\n");
        } else {
            System.out.println("BOOK DOESN'T EXIST..!\n");
        }
        user.menu(database, user);
    }
}
