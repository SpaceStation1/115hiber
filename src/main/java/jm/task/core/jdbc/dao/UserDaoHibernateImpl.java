package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT AUTO_INCREMENT , " +
                " name VARCHAR(255), " +
                " lastName VARCHAR(255), " +
                " age TINYINT, " +
                " PRIMARY KEY ( id ))").executeUpdate();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(new User(name, lastName, age));
        tx1.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        User user = (User) session.load(User.class, id);
        session.delete(user);
        tx.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        List<User> users = session.createQuery("FROM  User").list();
        session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.createSQLQuery("DELETE FROM users").executeUpdate();
        session.close();
    }
}
