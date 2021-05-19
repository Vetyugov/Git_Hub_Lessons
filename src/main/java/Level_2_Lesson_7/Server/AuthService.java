package Level_2_Lesson_7.Server;
//Интерфейс аунтентификации

public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();
}
