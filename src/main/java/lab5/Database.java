package lab5;

import com.google.gson.Gson;
import lab4.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
/*

    Auth auth = new Auth();
    Gson gson = new Gson();

    class Auth {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "admin";
        String password = "123";
    }

    public int saveToDB(lab4.Shop shop) {
        log("Сохранение в БД");
        String SQL_SELECT1 = "insert into test (json) values ('?" + gson.toJson(shop) +  "') returning id";
        String SQL_SELECT2 = "insert into test (jsonb) values (cast(? as json)) returning id";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
              PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT1)) {

            String object = gson.toJson(shop);

            long start;
            long finish;

            preparedStatement.setString(1, object);

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Time SaveToDB() - JSON:  " + (finish - start) + " нс.");
            while (resultSet.next()) {
                int i = resultSet.getInt("id");
                return i;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT2)) {

            String object = gson.toJson(shop);

            long start;
            long finish;

            preparedStatement.setString(1, object);

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Time SaveToDB() - JSONB:  " + (finish - start) + " нс.");
            while (resultSet.next()) {
                int i = resultSet.getInt("id");
                //return i;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void sortByASC() {
        List<String> json = new ArrayList<>();
        List<String> jsonb = new ArrayList<>();
        long start;
        long finish;
        log("Сортировка по ASC");
        String SQL_SELECT1 = "SELECT (json -> 'name') as json FROM test ORDER by jsonb ASC;";
        String SQL_SELECT2 = "SELECT (jsonb -> 'name') as jsonb FROM test ORDER by jsonb ASC;";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT1)) {

            String example = "";
            lab4.Shop shop = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Time sortByASC() - JSON:  " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("json");
                json.add(example);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT2)) {

            String example = "";
            lab4.Shop shop = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Time sortByASC() - JSONB: " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("jsonb");
                jsonb.add(example);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("\nJSON:");
        for (int i = 0; i < json.size(); i++) {
            System.out.println(json.get(i));
        }
        System.out.println("\nJSONB:");
        for (int i = 0; i < jsonb.size(); i++) {
            System.out.println(jsonb.get(i));
        }
    }

    public void searchInDB() {
        long start;
        long finish;
        log("Поиск в БД");
        String SQL_SELECT1 = "SELECT json -> 'name' as json FROM test";
        String SQL_SELECT2 = "SELECT jsonb -> 'name' as jsonb FROM test";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT1)) {

            String example = "";
            lab4.Shop shop = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Time searchInDB() - JSON:  " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("json");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT2)) {

            String example = "";
            lab4.Shop shop = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Time searchInDB() - JSONB: " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("jsonb");
            }
            System.out.println("Поле 'name' содержит: " + example);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadFromDB() {
        long start;
        long finish;
        log("Считывание из БД");
        String SQL_SELECT1 = "select json from test";
        String SQL_SELECT2 = "select jsonb from test";
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT1)) {

            String example = "";
            lab4.Shop shop = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Time loadFromDB() - JSON:  " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("json");
            }
            shop = gson.fromJson(example, lab4.Shop.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(auth.url, auth.user, auth.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT2)) {

            String example = "";
            lab4.Shop shop = null;

            start = System.nanoTime();
            ResultSet resultSet = preparedStatement.executeQuery();
            finish = System.nanoTime();
            System.out.println("Time loadFromDB() - JSONB: " + (finish - start) + " нс.");

            while (resultSet.next()) {
                example = resultSet.getString("jsonb");
            }
            shop = gson.fromJson(example, Shop.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void log(String str) {
        System.out.println("\n[ " + new Date().toString() + " ] " + str + "\n");
    }

*/



        private Gson gson = new Gson();



        private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
        private final static String USER = "admin";
        private final static String PASSWORD = "123";


        void saveToDB() {
            System.out.println("Сохранение в БД");
            org.postgresql.Driver driver1 = new org.postgresql.Driver();
            try {
                Class.forName(driver1.getClass().getName());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            final String SQL_INPUT1 = "INSERT INTO users2 (users) VALUES (ROW('admin@shop.biz', 'Pa$$w0rD', 'None',true )) returning id";
            final String SQL_INPUT2 = "INSERT INTO users2 (users) VALUES (ROW('danil@shop.biz', '12235443', 'None',true)) returning id";
            final String SQL_INPUT3 = "INSERT INTO shop (shop) VALUES (ROW('Nokia', 144 , 'телефон')) returning id";
            final String SQL_INPUT4 = "INSERT INTO shop (shop) VALUES (ROW('iphone', 244 , 'телефон')) returning id";
            final String SQL_INPUT5 = "INSERT INTO categyes (category) VALUES (ROW('138*67*7', 'blue' , 'phone','2019')) returning id";
            final String SQL_INPUT6 = "INSERT INTO statud (status) VALUES (ROW(true, false , false )) returning id";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT1)) {

                ResultSet resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT2)) {;
                ResultSet resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT3)) {;
                ResultSet resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT4)) {;
                ResultSet resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }



            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
    PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT5)) {;
        ResultSet resultSet = preparedStatement.executeQuery();

    } catch (SQLException e) {
        e.printStackTrace();
    }

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
    PreparedStatement preparedStatement = conn.prepareStatement(SQL_INPUT6)) {;
        ResultSet resultSet = preparedStatement.executeQuery();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

        void update(){
            System.out.println("Обновлeние в БД");
            org.postgresql.Driver driver1 = new org.postgresql.Driver();
            try {
                Class.forName(driver1.getClass().getName());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            final String SQL_UPDATE1 = "UPDATE users2 SET users.email = 'admin@shop.biz' WHERE id=1 returning id";
            final String SQL_UPDATE2 = "UPDATE shop SET shop.names =  'Nokia' WHERE id=2 returning id";

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE2)) {

                ResultSet resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE1)) {

                ResultSet resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        void searchInDB() {
            System.out.println("Поиск в БД");
            final String SQL_SELECT1 = "SELECT (shop.shop).names FROM shop  WHERE (shop.shop).price > 100;";
            final String SQL_SELECT2 = "SELECT * FROM shop";
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT1)) {

                String example = "";


                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    example = resultSet.getString("names");
                    System.out.println("Поле 'name' содержит: " + example);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT2)) {

                String example = "";

                ResultSet resultSet = preparedStatement.executeQuery();
/*

                while (resultSet.next()) {
                    example = resultSet.getString("");
                    System.out.println("Поле 'users' : " + example);
                }
                System.out.println("Поле 'users' : " + example);
*/

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }





}
