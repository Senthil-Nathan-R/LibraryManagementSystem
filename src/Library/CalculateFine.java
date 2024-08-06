package Library;

import java.util.Scanner;

public class CalculateFine implements IOOperation {

    @Override
    public void oper(Database database, User user) {
        
        System.out.println("ENTER BOOK NAME :");
        Scanner s = new Scanner(System.in);
        String bookname = s.nextLine().trim().toLowerCase();
        
        boolean bookFound = false;
        
        for (Borrowing b : database.getBrws()) {
            if (b.getBook().getName().toLowerCase().equals(bookname) && b.getUser().getName().equalsIgnoreCase(user.getName())) {
                bookFound = true;
                if (b.getDaysLeft() < 0) {
                    System.out.println("YOU ARE LATE..!\n"
                            + "YOU HAVE TO PAY " + Math.abs(b.getDaysLeft() * 50) + " AS FINE.");
                } else {
                    System.out.println("YOU DON'T HAVE TO PAY A FINE.\n");
                }
                break;
            }
        }

        if (!bookFound) {
            System.out.println("BOOK NOT FOUND IN YOUR BORROWINGS.\n");
        }
        
        user.menu(database, user);
    }
}
