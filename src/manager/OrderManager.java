package manager;

import model.Order;
import model.account.User;
import model.book.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderManager implements IGeneralManager<Order> {
    private BookManager bookManager=BookManager.getInstance();
    public static OrderManager orderManager;
    private OrderManager(){
    }
    public static OrderManager getInstance(){
        if(orderManager==null){
            orderManager=new OrderManager();
        }
        return orderManager;
    }
    List<Order> orderList=new ArrayList<>();
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
        orderList.add(index,order);
    }

    @Override
    public Order search(String code) {
        for (int i = 0; i < orderList.size(); i++) {
            if(orderList.get(i).getCode().equals(code)){
                return orderList.get(i);
            }
        }
        return null;
    }

    public Book borrowABook(String code){
        Book book=bookManager.search(code);
        book.setStatus(false);
        return book;
    }
// bạn muốn mượn mấy cuốn:
    // cuốn đầu có
//
    public List<Book> createBorrowListBook(int number){
        List<Book> borrowList;
        for (int i = 0; i < number; i++) {
            borrowABook()
        }
    }
    public void createOrder(User user, LocalDate borrowDate,String code,List<Book> bookList){

    }



}
