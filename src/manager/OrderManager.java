package manager;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.Order;
import model.account.Student;
import model.book.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderManager implements IGeneralManager<Order> {
    private static List<Order> orderList;
    private static List<Student> studentList;
    private static List<Book> bookList;
    public static OrderManager orderManager;
    private OrderManager(List<Order> orderList,List<Student> studentList,List<Book> bookList) {
    }

    public static OrderManager getInstance(List<Order> orderList,List<Student>studentList,List<Book>bookList) {
        if (orderManager == null) {
            orderManager = new OrderManager(orderList,studentList,bookList);
        }
        return orderManager;
    }


    @Override
    public void save(Order order) {
        orderList.add(order);
    }

    @Override
    public void remove(Order order) {
        orderList.remove(order);
    }

    @Override
    public void update(int index, Order order) {
        orderList.remove(index);
        orderList.add(index, order);
    }

    @Override
    public Order search(String code) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getCode().equals(code)) {
                return orderList.get(i);
            }
        }
        return null;
    }

    public Order createOrder(Student student,LocalDate borrowDate,String code,List<Book> bookList){
        Order order= new Order(student,borrowDate,code,bookList);
        save(order);
        return order;
    }
    public Book getABook(String code){
        for (Book book: bookList
             ) {
            if(book.getCode().equals(code)&& book.isStatus()==true){
                book.setStatus(false);
                return book;
            }
        }
        return null;
    }

    public Student checkIdStudent(String id){
        for (Student student: studentList
             ) {
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    public void giveBookBack(Book book){
        Order order=findOrderToGiveBack(book);
        book.setStatus(true);
        order.getBookList().remove(book);
    }
    public Order findOrderToGiveBack(Book book){
        for (Order order: orderList
             ) {
            if(checkBookInOrder(order.getBookList(),book)){
                return order;
            }
        }
        return null;
    }
    public boolean checkBookInOrder(List<Book>list,Book book){
        for (Book bookTest:list
             ) {
            if(bookTest.getCode().equals(book.getCode())){
                return true;
            }
        }
        return false;
    }
    public Book checkCodeBook(String code){
        for (Book book: bookList
             ) {
            if(book.getCode().equals(code)){
                return book;
            }
        }
        return null;
    }




}
