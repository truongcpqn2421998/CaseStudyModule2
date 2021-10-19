package manager;

import model.account.Student;

import java.util.List;

public class StudentManager implements IGeneralManager<Student> {
    private  List<Student> studentList;

    public static StudentManager studentManager;
    private StudentManager(List<Student> studentList){
        this.studentList=studentList;
    }
    public static StudentManager getInstance(List<Student> studentList){
        if(studentManager==null){
            studentManager=new StudentManager(studentList);
        }
        return studentManager;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

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
        for (Student student: studentList
             ) {
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

}
