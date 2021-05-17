package Level_2_Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        try {
            openConnection();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    public void openConnection() throws IOException, InterruptedException {
        String SERVER_ADDR = "localhost";
        int SERVER_PORT = 8189;
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        System.out.println("Сокет запущен");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        //Поток, который читает, что пришло с сервера и пишет в консоль
        Thread thread1 = new Thread(() -> {
            try {
                while (true) {
                    String strFromServer = in.readUTF();
                    if (strFromServer.equalsIgnoreCase("/end")) {
                        break;
                    }
                    System.out.println("Сервер прислал:" + strFromServer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        //Поток, который отправляет на сервер сообщение из консоли
        Thread thread2 = new Thread(() -> {
            while (true){
                String str;
                Scanner scanner = new Scanner(System.in);
                str = scanner.nextLine();
                try {
                    out.writeUTF(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (str.equals("/end")) {
                    scanner.close();
                    break;
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public void closeConnection() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }

}
