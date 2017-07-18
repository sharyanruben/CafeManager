package cafemanagement.dao.order;

import cafemanagement.dao.user.UserDaoImpl;
import cafemanagement.model.Order;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuBen on 27.03.2017.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void create(Order entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        logger.info("order successfully added to the database, order: " + entity);
    }

    public void update(Order entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
        logger.info("order successfully updated to the database, order: " + entity);
    }

    public void delete(Order entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
        logger.info("order successfully deleted to the database, order: " + entity);
    }

    public Order getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get order by productId from the database");
        return (Order) session.get(Order.class, id);
    }

    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get product List from database");
        return session.createCriteria(Order.class).list();
    }
}
