import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Socket client = new Socket("134.249.152.126", 51001)) {
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            oos.writeObject(" ");
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            System.out.println(ois.readObject());
            ois.close();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            String msg = new Scanner(System.in).nextLine();
            try (Socket client = new Socket("134.249.152.126", 51001)) {
                ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());

                oos.writeObject(msg);
                ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
                System.out.println(ois.readObject());


                ois.close();
                oos.close();
                if ("exit".equals(msg)) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
