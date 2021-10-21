package view.StudentView;

import java.util.Scanner;

public class MenuStudent {
    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("|______MENU STUDENT______|");
            System.out.println("1.Manage Books");
            System.out.println("2.Manage Account");
            System.out.println("0.Back");
            System.out.println("Enter choice:");
            choice=scanner.nextInt();
            switch (choice){
                case 1:

                    break;
            }
        }while (choice!=0);
    }
}
