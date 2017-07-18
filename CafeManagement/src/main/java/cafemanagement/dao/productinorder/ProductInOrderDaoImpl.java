package cafemanagement.dao.productinorder;

import cafemanagement.dao.user.UserDaoImpl;
import cafemanagement.model.ProductInOrder;
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
public class ProductInOrderDaoImpl implements ProductInOrderDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void create(ProductInOrder entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        logger.info("product successfully added in order list to the database, productInOrder: " + entity);
    }

    public void update(ProductInOrder entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
        logger.info("product successfully updated in order to the database, productInOrder: " + entity);
    }

    public void delete(ProductInOrder entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
        logger.info("product successfully deleted in order to the database, productInOrder: " + entity);
    }

    public ProductInOrder getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get product in order by id");
        return (ProductInOrder) session.get(ProductInOrder.class, id);
    }

    public List<ProductInOrder> getAll() {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get product in order list");
        return session.createCriteria(ProductInOrder.class).list();
    }
}
