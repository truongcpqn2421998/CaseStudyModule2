package view;

import model.account.Librarian;
import model.account.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("-----MENU-----");
            System.out.println("1.Login with Librarian's account");
            System.out.println("2.Login with Student's account");
            choice=scanner.nextInt();
            switch (choice){
                case 1:MenuLogin
            }

        }
    }
}
