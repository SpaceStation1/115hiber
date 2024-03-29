package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class Util {
    private static SessionFactory sessionFactory;
    private Util() {}
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mysql?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//                settings.put(Environment.HBM2DDL_AUTO, "none");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

//    public static Connection getMySQLConnection() throws SQLException,
//            ClassNotFoundException {
//        String hostName = "localhost";
//
//        String dbName = "mysql";
//        String userName = "root";
//        String password = "root";
//
//        return getMySQLConnection(hostName, dbName, userName, password);
//    }
//
//    public static Connection getMySQLConnection(String hostName, String dbName,
//                                                String userName, String password) throws SQLException,
//            ClassNotFoundException {
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
//
//        Connection conn = DriverManager.getConnection(connectionURL, userName,
//                password);
//        return conn;
//    }

}