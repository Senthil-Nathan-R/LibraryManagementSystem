package Library;

import java.util.Scanner;

public class ReturnBook implements IOOperation {

    @Override
    public void oper(Database database, User user) {
        System.out.println("ENTER BOOK NAME:");
        Scanner s = new Scanner(System.in);
        String bookname = s.nextLine().trim().toLowerCase();

        boolean foundBorrowing = false;

        for (Borrowing b : database.getBrws()) {
            if (b.getBook().getName().toLowerCase().equals(bookname) &&
                b.getUser().getName().equalsIgnoreCase(user.getName())) {
                
                Book book = b.getBook();
                int i = database.getAllBooks().indexOf(book);
                
                if (b.getDaysLeft() < 0) {
                    System.out.println("YOU ARE LATE..!"
                            + " YOU HAVE TO PAY " + Math.abs(b.getDaysLeft() * 50) + " AS FINE.");
                }

                book.setBrwcopies(book.getBrwcopies() + 1);
                database.returnBook(b, book, i);
                System.out.println("BOOK RETURNED...!\nTHANK YOU..!");
                
                foundBorrowing = true;
                break;
            }
        }

        if (!foundBorrowing) {
            System.out.println("YOU DIDN'T BORROW THIS BOOK..!");
        }

        user.menu(database, user);
    }
}
