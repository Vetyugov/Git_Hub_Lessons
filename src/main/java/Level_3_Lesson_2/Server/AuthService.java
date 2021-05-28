package Level_3_Lesson_2.Server;
//Интерфейс аунтентификации

public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();
}
