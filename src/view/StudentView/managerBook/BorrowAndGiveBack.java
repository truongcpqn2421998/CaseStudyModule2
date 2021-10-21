package view.StudentView.managerBook;

import manager.OrderManager;
import model.Order;
import model.account.Student;
import model.book.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BorrowAndGiveBack {
    private static List<Order> orderList=new ArrayList<>();
    private static List<Student> studentList=new ArrayList<>();
    private static List<Book> bookList=new ArrayList<>();
    private static OrderManager orderManager=OrderManager.getInstance(orderList,studentList,bookList);
    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("|_____MENU ORDER_____|");
            System.out.println("1.Borrow Book");
            System.out.println("2.Give Book Back");
            System.out.println("0.Exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    borrow();
                    break;
                case 2:
                    giveBookBack();
                    break;
            }

        }while (choice!=0);
    }
    public static Book getABook(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter code you want to borrow");
        String code=scanner.nextLine();
        Book book=null;
        book=orderManager.getABook(code);
        if(book==null){
            throw new IllegalArgumentException("Book is not exist");
        }
        return book;

    }
    public static List<Book> getBookList(){
        List<Book> books=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number book you  want to borrow");
        int number =scanner.nextInt();
        int count=0;
        while(count<number){
            Book book=getABook();
            if(book!=null){
                books.add(book);
                count++;
            }
        }
        return books;
    }
    public static void borrow(){
        Scanner str=new Scanner(System.in);
        Scanner num=new Scanner(System.in);
        System.out.println("Enter your id");
        String id=str.nextLine();
        Student student =orderManager.checkIdStudent(id);
        System.out.println("Enter borrow day:");
        System.out.println("Enter day");
        int day=num.nextInt();
        System.out.println("Enter month");
        int month=num.nextInt();
        System.out.println("Enter year");
        int year=num.nextInt();
        System.out.println("Enter code:");
        String code=str.nextLine();
        List<Book> books=getBookList();
        orderManager.createOrder(student, LocalDate.of(year,month,day),code,books);
    }
    public static void giveBookBack(){
        Scanner str=new Scanner(System.in);
        System.out.println("Enter code Book you want to give back:");
        String code=str.nextLine();
        Book book=orderManager.checkCodeBook(code);
        orderManager.giveBookBack(book);
    }


}
