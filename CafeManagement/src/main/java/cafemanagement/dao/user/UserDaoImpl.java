package cafemanagement.dao.user;

import cafemanagement.model.User;
import cafemanagement.model.enums.Role;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuBen on 27.03.2017.
 */
@Repository
public class UserDaoImpl implements Userdao {
    private static Logger logger = Logger.getLogger(UserDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;


    public void create(User entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        logger.info("user successfully added to the database, user: " + entity);
    }

    public void update(User entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
        logger.info("user successfully updated in the database, user: " + entity);
    }

    public void delete(User entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
        logger.info("user successfully deleted from the database, user: " + entity);
    }

    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get user by userId from the database");
        return (User) session.get(User.class, id);
    }

    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get user List from database");
        return session.createCriteria(User.class).add(Restrictions.eq("role", Role.WAITER)).list();
    }

    public User getUserNamePassword(String userName, String password) {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get user by " + userName + " and password from the database");
        return (User) session.createCriteria(User.class).add(Restrictions.eq("username", userName)).
                add(Restrictions.eq("password", password)).uniqueResult();
    }
}
