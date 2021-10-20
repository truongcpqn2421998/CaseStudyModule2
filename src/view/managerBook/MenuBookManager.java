package view.managerBook;

import manager.BookManager;
import model.book.Book;
import model.book.BookFactory;
import model.book.BookType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuBookManager {
    private static List<Book> bookList=new ArrayList<>();
    private static BookManager bookManager=BookManager.getInstance(bookList);
    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("|_____BOOK MANAGER_____|");
            System.out.println("1.Add a new Book");
            System.out.println("2.Remove a Book");
            System.out.println("3.Repair a Book");
            System.out.println("4.Display a Book");
            System.out.println("5.Display all book in library");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    addBook();
                    break;
                case 2:

                case 3:
                case 4:
                case 5:
            }
        }while (choice!=0);
    }
    public static void addBook(){
        Scanner scanner=new Scanner(System.in);
        Book book;
        System.out.println("Enter Type Book you want to add:");
        String type=scanner.nextLine();
        if(type.equals("technical")){
            book=createTechnicalBook();
            bookManager.save(book);
        }else if(type.equals("economic")){
            book=createEconomicBook();
            bookManager.save(book);
        }else {
            throw new IllegalArgumentException("Library don't want to take this");
        }
    }
    public static Book createEconomicBook(){
        Scanner str=new Scanner(System.in);
        System.out.println("Enter title of Economic Book:");
        String title=str.nextLine();
        System.out.println("Enter category of Economic Book:");
        String category=str.nextLine();
        System.out.println("Enter code of Economic Book:");
        String code=str.nextLine();
        Book book= BookFactory.getBook(BookType.ECONOMICBOOK,title,category,code);
        return book;
    }
    public static Book createTechnicalBook(){
        Scanner str=new Scanner(System.in);
        System.out.println("Enter title of Economic Book:");
        String title=str.nextLine();
        System.out.println("Enter category of Economic Book:");
        String category=str.nextLine();
        System.out.println("Enter code of Economic Book:");
        String code=str.nextLine();
        Book book= BookFactory.getBook(BookType.TECHNICALBOOK,title,category,code);
        return book;
    }
    public static void removeBook(){
        Scanner str=new Scanner(System.in);
        String code=str.nextLine()
        System.out.println("Enter book's code you want to remove:");
        Book book=bookManager.search(code);
        if(book!=null){
            bookManager.remove(book);
        }else {
            throw new IllegalArgumentException("Not exist");
        }
    }


}
