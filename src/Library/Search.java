package Library;

import java.util.Scanner;

public class Search implements IOOperation {

    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nENTER BOOK NAME :");
        String name = s.nextLine().trim().toLowerCase();
        
        int i = -1;
        for (Book book : database.getAllBooks()) {
            if (book.getName().toLowerCase().equals(name)) {
                i = database.getAllBooks().indexOf(book);
                break;
            }
        }
        
        if (i > -1) {
            System.out.println("\n" + database.getBook(i).toString());
        } else {
            System.out.println("BOOK DOESN'T EXIST..!\n");
        }
        user.menu(database, user);
    }
}
