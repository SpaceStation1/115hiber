//package jm.task.core.jdbc.dao;
//
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//
////    private Connection conn = null;
////    private Statement stmt = null;
//
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        try (Connection conn = Util.getMySQLConnection(); Statement stmt = conn.createStatement();){
//            String sql = "CREATE TABLE IF NOT EXISTS users " +
//                    "(id BIGINT AUTO_INCREMENT , " +
//                    " name VARCHAR(255), " +
//                    " lastName VARCHAR(255), " +
//                    " age TINYINT, " +
//                    " PRIMARY KEY ( id ))";
//            stmt.executeUpdate(sql);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        try (Connection conn = Util.getMySQLConnection(); Statement stmt = conn.createStatement();){
//            String sql = "DROP TABLE IF EXISTS users";
//            stmt.executeUpdate(sql);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser( String name, String lastName, byte age) {
//        String sql = "INSERT INTO users " + " VALUES (?, ?, ?, ?)";
//        try (Connection conn = Util.getMySQLConnection(); PreparedStatement statement = conn.prepareStatement(sql);){
//            statement.setString(1, null);
//            statement.setString(2, name);
//            statement.setString(3, lastName);
//            statement.setByte(4, age);
//            int rowsAffected = statement.executeUpdate();
//            System.out.println("User с именем – " + name + " добавлен в базу данных");
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        String sql = "DELETE FROM users WHERE id = ?";
//        try (Connection conn = Util.getMySQLConnection(); PreparedStatement statement = conn.prepareStatement(sql);){
//            statement.setLong(1, id);
//            int rowsAffected = statement.executeUpdate();
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        ArrayList<User> users = new ArrayList<User>();
//        String sql = "SELECT * FROM users";
//        try (Connection conn = Util.getMySQLConnection(); Statement stmt = conn.createStatement();) {
//            ResultSet result = stmt.executeQuery(sql);
//            while (result.next()) {
//                User user = new User();
//                user.setId(result.getLong(1));
//                user.setName(result.getString(2));
//                user.setLastName(result.getString(  3));
//                user.setAge(result.getByte(4));
//                users.add(user);
//            }
//            for (User user : users){
//                System.out.println(user.toString());
//            }
//        }catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//            return users;
//    }
//
//    public void cleanUsersTable() {
//        String sql = "DELETE FROM users";
//        try (Connection conn = Util.getMySQLConnection(); Statement stmt = conn.createStatement();){
//            stmt.executeUpdate(sql);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}

