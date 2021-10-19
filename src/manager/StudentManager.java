package manager;

import model.account.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentManager implements IGeneralManager<Student> {
    public static StudentManager studentManager;
    private StudentManager(){
    }
    public static StudentManager getInstance(){
        if(studentManager==null){
            studentManager=new StudentManager();
        }
        return studentManager;
    }
    List<Student> studentList=new ArrayList<>();

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public void remove(Student student) {
        studentList.remove(student);
    }

    @Override
    public void update(int index, Student student) {
        studentList.remove(index);
        studentList.add(index,student);
    }

    @Override
    public Student search(String id) {
        for (int i = 0; i <studentList.size() ; i++) {
            if(studentList.get(i).getId().equals(id)){
                return studentList.get(i);
            }
        }
        return null;
    }
}