package manager;

import model.book.Book;
import model.book.BookFactory;
import model.book.BookType;

import java.util.ArrayList;
import java.util.List;

public class BookManager implements IGeneralManager<Book> {
    private List<Book> bookList;
    public static BookManager bookManager;
    private BookManager(List<Book> bookList){
        this.bookList=bookList;
    }
    public static BookManager getInstance(List<Book> bookList){
        if(bookManager==null){
            bookManager=new BookManager(bookList);
        }
        return bookManager;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public void save(Book book) {
        bookList.add(book);
    }

    @Override
    public void remove(Book book) {
        bookList.remove(book);
    }

    @Override
    public void update(int index, Book book) {
        bookList.add(index,book);
    }

    @Override
    public Book search(String code) {
        for (Book book : bookList) {
            if (book.getCode().equals(code)) {
                return book;
            }
        }
        return null;
    }

    public Book createBook(BookType bookType,String title, String category, String code, boolean status){
        return BookFactory.getBook(bookType,title,category,code);
    }
}
