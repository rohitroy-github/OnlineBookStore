// Simple Book Store Program in Java

import java.util.*;

// class > Books 
// Storing all the attributes of a particular book ! 

class Books {
  public String title;
  public String author;
  public int isbn;
  public double price;
  public double discount;
  public double total;

  public Books() {
  }

  public Books(
      String title,
      String author,
      int isbn,
      double price,
      double discount,
      double total) {
    super();
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.price = price;
    this.discount = discount;
    this.total = total;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getIsbn() {
    return isbn;
  }

  public double getPrice() {
    return price;
  }

  public double getDiscount() {
    return discount;
  }

  public double getTotal() {
    return total;
  }
}

// class > BookStore
// The main working program class

public class BookStore {

  /**
   * @param args
   * @throws Exception
   */

  public static void main(String[] args) throws Exception {
    double amount = 0.0;
    double sum = 0.0;
    int count = 1;
    List<Books> list = new ArrayList<Books>();
    Scanner scan = new Scanner(System.in);
    int menu = 0;
    System.out.println("Welcome To Our Book Store");
    System.out.println();

    System.out.println("1. Buy A Book ?");
    System.out.println("2. View Bucket ?");
    System.out.println("3. Remove A Book ?");
    System.out.println("4. Generate Receipt ?");
    System.out.println("5. Make Payment ?");
    System.out.println("6. Exit");

    boolean quit = false;
    do {
      if (count > 5) {
        System.out.println("You cannot buy more than 5 books at a time !");
      }
      System.out.println();
      System.out.print("Please enter your choice ? ");
      menu = scan.nextInt();
      System.out.println();
      switch (menu) {

        // Buy A Book ?
        case 1:
          count++;
          System.out.println("Book Title: ");
          String booktitle = scan.next();
          System.out.println("Author: ");
          String auth = scan.next();
          System.out.println("ISBN: ");
          int no = scan.nextInt();
          System.out.println("Price: ");
          double p = scan.nextDouble();
          System.out.println("Discount: ");
          double dis = scan.nextDouble();

          // Calculating discount ?
          double total = p - ((p * dis) / 100);

          // Adding new book to list !
          list.add(new Books(booktitle, auth, no, p, dis, total));
          break;

        case 2:

          // View books in cart ?
          System.out.println("ID\tTitle\tAuthor\tISBN\tPrice\tDiscount\tTotal");
          int idCounter = 0;
          for (Books s : list) {
            System.out.println(
                idCounter++ +
                    "\t" +
                    s.getTitle() +
                    "\t" +
                    s.getAuthor() +
                    "\t" +
                    s.getIsbn() +
                    "\t" +
                    s.getPrice() +
                    "\t" +
                    s.getDiscount() +
                    "\t" +
                    s.getTotal());
          }
          // System.out.println();
          break;

        case 3:

          // Remove a book from the bucket list !
          System.out.println("ID\tTitle\tAuthor\tISBN\tPrice\tDiscount\tTotal");
          int id = 0;
          for (Books s : list) {
            System.out.println(
                id++ +
                    "\t" +
                    s.getTitle() +
                    "\t" +
                    s.getAuthor() +
                    "\t" +
                    s.getIsbn() +
                    "\t" +
                    s.getPrice() +
                    "\t" +
                    s.getDiscount() +
                    "\t" +
                    s.getTotal());
          }

          System.out.println("Please select an ID for removal ?");
          int removalID = scan.nextInt();

          if (removalID <= id) {
            // Removal
            list.remove(removalID);
          }
          System.out.println();
          System.out.println("Selected book has been removed !");
          count--;
          break;

        case 4:

          // Printing store reciept !
          System.out.println("ID\tTitle\tAuthor\tISBN\tPrice\tDiscount\tTotal");

          for (Books s : list) {
            System.out.println(
                s.getTitle() +
                    "\t" +
                    s.getAuthor() +
                    "\t" +
                    s.getIsbn() +
                    "\t" +
                    s.getPrice() +
                    "\t" +
                    s.getDiscount() +
                    "\t" +
                    s.getTotal());
            sum += s.getTotal();
          }
          System.out.println();
          System.out.print("Total Price > " + sum);
          System.out.println();
          break;

        case 5:

          for (Books s : list) {
            sum += s.getTotal();
          }

          System.out.println("Amount To Be Paid > " + sum);
          System.out.print("Customer Pays > ");
          amount = scan.nextDouble();
          System.out.println();
          double balance = amount - sum;
          System.out.println("Please Collect Your Balance > " + balance);
          System.out.println();
          System.out.println("Thank You, Please Visit Again !");
          quit = true;

          System.out.println();

        case 6:
          quit = true;
          break;

        // Default case !
        default:
          System.out.println("Invalid Entry!");
      }
    } while (!quit);
  }
}

// End