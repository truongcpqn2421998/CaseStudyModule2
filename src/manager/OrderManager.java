package manager;

import model.Order;
import model.account.Student;
import model.account.User;
import model.book.Book;

import java.time.LocalDate;
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

    public Book borrowABook(String code) {
        Book book = bookManager.search(code);
        book.setStatus(false);
        return book;
    }
    public Order createOrder(User user,LocalDate borrowDate,String code,List<Book> bookList){
        Order order= new Order(user,borrowDate,code,bookList);
        save(order);
        return order;
    }

}
