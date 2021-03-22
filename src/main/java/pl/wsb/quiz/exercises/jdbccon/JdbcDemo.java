package pl.wsb.quiz.exercises.jdbccon;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver").getConstructor().newInstance();
        try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:c:/data/quizbase", "sa", "")){
            Statement statement = connection.createStatement();
            statement.execute("drop table if exists quiz");
            statement.execute("create table quiz(id int primary key, question varchar(200), options varchar(2000), answers varchar(2000))");
            int insertCount = 0;
            insertCount += statement.executeUpdate("insert into quiz values(1,'W którym roku powstała Java?', '1995\n2000\n1993\n2004', '1993')");
            insertCount += statement.executeUpdate("insert into quiz values(2,'Podaj operator tworzenia obiektów?', 'throws\nnew\n++\n->', 'new')");
            insertCount += statement.executeUpdate("insert into quiz values(3,'Wskaż typy całkowite', 'int\ndouble\nboolean\nshort', 'short\nint')");
            System.out.println("Wstawiono wierszy: " + insertCount);
            ResultSet resultSet = statement.executeQuery("select * from QUIZ");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String question = resultSet.getString("question");
                String[] options = resultSet.getString("options").split("\n");
                String[] answers = resultSet.getString("answers").split("\n");
                System.out.println("Wiersz " + id + " " + question +" " + Arrays.toString(options) + " " + Arrays.toString(answers));
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj id szukanego quizu:");
            int id = scanner.nextInt();
            String query = "select * from QUIZ where id = ?";
            PreparedStatement queryStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            queryStatement.setInt(1, id);
            resultSet = queryStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id") +" " + resultSet.getString("question"));
            }
            resultSet.previous();
            if (resultSet.isFirst()) {
                System.out.println(resultSet.getString("question"));
            }


        } catch (SQLException throwables) {
            System.out.println("Bład podczas połączenia lub wykonywania poleceń SQL: " + throwables.getMessage());
        }
    }
}
