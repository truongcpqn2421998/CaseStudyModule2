package manager;

import model.account.Student;
import model.account.Librarian;

import java.util.List;

public class UserManager {
    private List<Student> studentList;
    private List<Librarian> librarianList;
    public static UserManager userManager;

    private UserManager(List<Student> studentList,List<Librarian> librarianList) {
        this.studentList=studentList;
        this.librarianList = librarianList;
    }

    public static UserManager getInstance(List<Student> studentList,List<Librarian> librarianList) {
        if (userManager == null) {
            userManager = new UserManager(studentList, librarianList);
        }
        return userManager;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void removeStudent(Student student){
        studentList.remove(student);
    }
    public Student findStudent(String id){
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    public void update(int index,Student student){
        studentList.remove(index);
        studentList.add(index,student);
    }
    public void addLibrarian(Librarian librarian){
        librarianList.add(librarian);
    }

    public void removeLibrarian(Librarian librarian){
        studentList.remove(librarian);
    }
    public Librarian findLibrarian(String id){
        for (Librarian librarian : librarianList) {
            if (librarian.getId().equals(id)) {
                return librarian;
            }
        }
        return null;
    }
    public void updateLibrarian(int index,Librarian librarian){
        librarianList.remove(index);
        librarianList.add(index,librarian);
    }





}
