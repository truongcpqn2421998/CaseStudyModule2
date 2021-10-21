package view.mainMenu;

import view.mainMenu.Login.LibrarianLogin;
import view.mainMenu.Login.StudentLogin;
import model.account.Librarian;
import model.account.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuLogin {
    private static List<Librarian> librarianList=new ArrayList<>();
    private static List<Student> studentList=new ArrayList<>();


    public static void Login(){
        librarianList.add(new Librarian("truong","tu",23,"truong1998","2421998"));
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("-----MENU-----");
            System.out.println("1.Login with Librarian's account");
            System.out.println("2.Login with Student's account");
            System.out.println("0.exit");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                loginLibrarianAccount();
                break;
                case 2:
                loginStudentAccount();
                break;
            }
        }while (choice!=0);

    }
    public static void loginLibrarianAccount(){
        Scanner scanner=new Scanner(System.in);
        LibrarianLogin librarianLogin=new LibrarianLogin(librarianList);
        String accountName;
        Librarian checkName=null;
        do{
            System.out.println("Login account name:");
            accountName=scanner.nextLine();
            checkName= librarianLogin.checkName(accountName);
            if(checkName==null){
                System.out.println("Account name not exist");
            }
        }while (checkName==null);
        String accountPassword;
        boolean checkPass=false;
        do{
            System.out.println("Enter Account password");
            accountPassword=scanner.nextLine();
            checkPass=librarianLogin.checkPass(checkName,accountPassword);
            if(checkPass==false){
                System.out.println("Incorrect password");
            }
        }while (checkPass==false);
        MenuLibrarian.menu();
    }
    public static void loginStudentAccount(){
        Scanner scanner=new Scanner(System.in);
        StudentLogin studentLogin=new StudentLogin(studentList);
        String accountName;
        Student checkName=null;
        do{
            System.out.println("Login account name:");
            accountName=scanner.nextLine();
            checkName=studentLogin.checkName(accountName);
            if(checkName==null){
                System.out.println("Account name not exist");
            }
        }while (checkName==null);
        String accountPassword;
        boolean checkPass=false;
        do{
            System.out.println("Enter account password");
            accountPassword=scanner.nextLine();
            checkPass=studentLogin.checkPass(checkName,accountPassword);
            if(checkPass==false){
                System.out.println("Incorrect password");
            }
        }while (checkPass==false);
    }
}
