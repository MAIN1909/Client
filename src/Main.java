import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Are you registered? (Yes or no)");
        String msg = new Scanner(System.in).nextLine();
        try (Socket client = new Socket("localhost", 8899)) {
            ObjectOutputStream oos = new ObjectOutputStream(
                    client.getOutputStream());
            switch (msg) {
                case "yes":
                    System.out.println("Enter your name:");
                    String name = new Scanner(System.in).nextLine();
                    oos.writeObject(name);
                    System.out.println("Enter your message");
                    String message = new Scanner(System.in).nextLine();
                    oos.writeObject(message);
                    break;
                case "no":
                    System.out.println("Enter 'registration'");
                    String registration = new Scanner(System.in).nextLine();
                    oos.writeObject(registration);
                    System.out.println("Enter your name:");
                    String namE = new Scanner(System.in).nextLine();
                    oos.writeObject(namE);
                    System.out.println("Enter your message");
                    String messagE = new Scanner(System.in).nextLine();
                    oos.writeObject(messagE);

            }
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
