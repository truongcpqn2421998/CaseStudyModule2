package view;


import manager.BookManager;
import manager.LibrarianManager;
import manager.OrderManager;
import manager.StudentManager;
import model.Order;
import model.account.Librarian;
import model.account.Student;
import model.book.Book;
import view.mainMenu.MenuLogin;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Librarian> librarianList=new ArrayList<>();
        List<Student> studentList=new ArrayList<>();
        List<Book> bookList=new ArrayList<>();
        List<Order> orderList=new ArrayList<>();
        LibrarianManager librarianManager=LibrarianManager.getInstance(librarianList);
        StudentManager studentManager=StudentManager.getInstance(studentList);
        BookManager bookManager=BookManager.getInstance(bookList);
        OrderManager  orderManager=OrderManager.getInstance(orderList,studentList,bookList);
        MenuLogin.Login();

    }
}
