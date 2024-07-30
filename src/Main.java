import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ArrayList<User> users = new ArrayList<>();

    private static IAuthenticationService  authService = new IAuthenticationService()
    {
        @Override
        public  User signUp(String username, String password)
        {
            return null;
        }

        @Override
        public User logIn(String username, String password)
        {
            return users.get(0);
        }
    };
    private  static boolean isRunning = true;

    public static void  main(String[] args)
    {
        users.add(new User("test","test"));
        while (isRunning){
            showMenu();
        }
    }

    public static void showMenu()
    {
        System.out.println("Welcome");
        System.out.println("1. Log in");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    public static void handleMenu(int choice)
    {
        switch(choice)
        {
            case 1:
                onLogIn();
                break;
            case 2:
                onSignUp();
                break;
            case 3:
                onExit();
                break;
            default:
                System.out.println("Invalid choice");
                showMenu();
        }
    }

    public static void onLogIn()
    {
        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        User user = authService.logIn(username, password);
        System.out.println("welcome," + user.getUsername() + "!");
    }

    public static void onSignUp()
    {
        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        User user = authService.logIn(username, password);
    }

    public static void onExit()
    {
        isRunning = false;
    }
}