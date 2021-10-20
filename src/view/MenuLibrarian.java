package view;
import view.managerUser.MenuManagerUser;
import java.util.Scanner;

public class MenuLibrarian {
    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        int choice=-1;
        do{
            System.out.println("|-----LIBRARIAN MENU-----|");
            System.out.println("1.Menu User Manager");
            System.out.println("2.Menu Book Manager ");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    MenuManagerUser.Menu();
                    break;
                case 2:

            }
        }while(choice!=0);

    }

}
