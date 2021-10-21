package view.orderManager;

import manager.OrderManager;
import model.Order;
import model.account.Student;
import model.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOrderManager {
    private static List<Order> orderList=new ArrayList<>();
    private static List<Student> studentList=new ArrayList<>();
    private static List<Book> bookList=new ArrayList<>();
    private static OrderManager orderManager=OrderManager.getInstance(orderList,studentList,bookList);
    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("|_____MENU ORDER_____|");

        }
    }
}
