package view.mainMenu.Login;

import model.account.Student;

import java.util.List;

public class StudentLogin {
    List<Student> studentList;

    public StudentLogin(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public Student checkName(String nameAccount){
        for (Student student : studentList) {
            if (student.getNameAccount().equals(nameAccount)) {
                return student;
            }
        }
        return null;
    }
    public boolean checkPass(Student student,String pass){
        if(student.getPassword().equals(pass)){
            return true;
        }
        return false;
    }
}
