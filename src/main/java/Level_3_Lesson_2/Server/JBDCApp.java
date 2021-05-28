package Level_3_Lesson_2.Server;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class JBDCApp {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Для SQLite регистрация выглядит следующим образом
        Class.forName("org.sqlite.JDBC");


    }
}
