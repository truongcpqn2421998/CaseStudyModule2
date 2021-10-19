package manager;

import model.account.Librarian;

import java.util.ArrayList;
import java.util.List;

public class TeacherManager implements IGeneralManager<Librarian> {
    public static TeacherManager teacherManager;
    private TeacherManager(){
    }
    public static TeacherManager getInstance(){
        if(teacherManager==null){
            teacherManager=new TeacherManager();
        }
        return teacherManager;
    }
    List<Librarian> librarianList =new ArrayList<>();
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
        librarianList.add(index, librarian);
    }

    @Override
    public Librarian search(String id) {
        for (int i = 0; i < librarianList.size(); i++) {
            if(librarianList.get(i).getId().equals(id)){
                return librarianList.get(i);
            }
        }
        return null;
    }
}
