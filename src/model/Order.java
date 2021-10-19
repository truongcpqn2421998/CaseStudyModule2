package model;

import model.account.User;
import model.book.Book;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private User user;
    private LocalDate borrowDate;
    private String code;
    private List<Book> bookList;


    public Order(User user, LocalDate borrowDate, String code, List<Book> bookList) {
        this.user = user;
        this.borrowDate = borrowDate;
        this.code = code;
        this.bookList = bookList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public LocalDate getDeadLine(){
        return borrowDate.plusMonths(2);
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", borrowDate=" + borrowDate +
                ", code='" + code + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
