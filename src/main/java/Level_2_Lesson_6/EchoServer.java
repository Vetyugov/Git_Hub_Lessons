package Level_2_Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        Socket socket; //Создаём сокет

        try (ServerSocket serverSocket = new ServerSocket(8189)) { //
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            //Поток, который принимает сообщение от клиента
            new Thread(() -> {
                while (true) {
                    String str = null;
                    try {
                        str = in.readUTF();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (str.equals("/end")) {
                        break;
                    }
                    System.out.println("Клиент прислал: "+ str);
                }
            }).start();

            //Поток, который принимает сообщение из консоли и передает клиенту
            new Thread(() -> {
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
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
