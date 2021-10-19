package manager;

import model.book.Book;
import model.book.BookFactory;
import model.book.BookType;

import java.util.ArrayList;
import java.util.List;

public class BookManager implements IGeneralManager<Book> {
    public static BookManager bookManager;
    private BookManager(){
    }
    public static BookManager getInstance(){
        if(bookManager==null){
            bookManager=new BookManager();
        }
        return bookManager;
    }
    private List<Book> bookList=new ArrayList<>();

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
        for (int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).getCode().equals(code)){
                return bookList.get(i);
            }
        }
        return null;
    }

    public Book createBook(BookType bookType,String title, String category, String code, boolean status){
        return BookFactory.getBook(bookType,title,category,code);
    }
}
