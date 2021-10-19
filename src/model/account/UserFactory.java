package model.account;

public class UserFactory {
    public static User getUser(UserType userType,String name,String id,int age,String userName,String passWord) {
        switch (userType) {
            case STUDENT:
                return new Student(name, id, age, userName, passWord);
            case TEACHER:
                return new Librarian(name, id, age, userName, passWord);
            default:
                throw new IllegalArgumentException("ERROR");
        }
    }
}
