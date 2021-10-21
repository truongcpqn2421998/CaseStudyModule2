package manager;

import model.account.Librarian;

import java.util.List;

public class LibrarianManager implements IGeneralManager<Librarian> {
    public static List<Librarian> librarianList;
    public static LibrarianManager librarianManager;
    private LibrarianManager(List<Librarian> librarianList){
        this.librarianList=librarianList;
    }
    public static LibrarianManager getInstance(List<Librarian> librarianList){
        if(librarianManager==null){
            librarianManager=new LibrarianManager(librarianList);
        }
        return librarianManager;
    }

    public List<Librarian> getLibrarianList() {
        return librarianList;
    }

    public void setLibrarianList(List<Librarian> librarianList) {
        this.librarianList = librarianList;
    }

    @Override
    public void save(Librarian librarian) {
        librarianList.add(librarian);
    }

    @Override
    public void remove(Librarian librarian) {
        librarianList.remove(librarian);
    }

    @Override
    public void update(int index, Librarian librarian) {
        librarianList.remove(index);
        librarianList.add(index,librarian);
    }

    @Override
    public Librarian search(String id) {
        for (Librarian librarian: librarianList
             ) {
            if(librarian.getId().equals(id)){
                return librarian;
            }
        }
        return null;
    }
    public int findIndex(String id){
        for (int i = 0; i < librarianList.size(); i++) {
            if(librarianList.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
