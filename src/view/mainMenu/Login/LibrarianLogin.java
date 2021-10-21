package view.mainMenu.Login;

import model.account.Librarian;

import java.util.List;

public class LibrarianLogin {
    List<Librarian> librarianList;

    public LibrarianLogin(List<Librarian> librarianList) {
        this.librarianList = librarianList;
    }

    public List<Librarian> getLibrarianList() {
        return librarianList;
    }

    public void setLibrarianList(List<Librarian> librarianList) {
        this.librarianList = librarianList;
    }

    public Librarian checkName(String nameAccount){
        for (int i = 0; i < librarianList.size() ; i++) {
            if(librarianList.get(i).getNameAccount().equals(nameAccount)){
                return librarianList.get(i);
            }
        }
        return null;
    }
    public boolean checkPass(Librarian librarian,String pass){
        if(librarian.getPassword().equals(pass)){
            return true;
        }
        return false;
    }
}
