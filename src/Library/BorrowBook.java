package Library;

import java.util.Scanner;

public class BorrowBook implements IOOperation {
    
    @Override
    public void oper(Database database, User user) {
        
        System.out.println("ENTER BOOK NAME: ");
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
            System.out.println("BOOK DOESN'T EXIST..!\n");
        } else {
            Book book = database.getBook(i);
            boolean hasBorrowed = false;
            for (Borrowing b : database.getBrws()) {
                if (b.getBook().getName().equalsIgnoreCase(bookname) && b.getUser().getName().equalsIgnoreCase(user.getName())) {
                    hasBorrowed = true;
                    System.out.println("YOU HAVE BORROWED THIS BOOK BEFORE..!\n");
                    break;
                }
            }
            if (!hasBorrowed) {
                if (book.getBrwcopies() > 0) {
                    Borrowing borrowing = new Borrowing(book, user);
                    book.setBrwcopies(book.getBrwcopies() - 1);
                    database.borrowBook(borrowing, book, i);
                    System.out.println("YOU MUST RETURN THE BOOK BEFORE 14 DAYS FROM NOW\n" +
                                       "EXPIRY DATE: " + borrowing.getFinish() + "\nENJOY!\n");
                } else {
                    System.out.println("THIS BOOK ISN'T AVAILABLE FOR BORROWING..!\n");
                }
            }
        }
        user.menu(database, user);
    }
}

