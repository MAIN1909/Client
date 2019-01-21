import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter message:");
        String msg = new Scanner(System.in).nextLine();
        try(Socket client = new Socket("10.11.0.173", 8899)){
            ObjectOutputStream oos = new ObjectOutputStream(
                    client.getOutputStream());
            oos.writeObject(msg);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
