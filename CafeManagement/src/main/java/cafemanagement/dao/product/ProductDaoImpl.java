package cafemanagement.dao.product;

import cafemanagement.dao.user.UserDaoImpl;
import cafemanagement.model.Product;
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
public class ProductDaoImpl implements ProductDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void create(Product entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        logger.info("product successfully added to the database, product: " + entity);
    }

    public void update(Product entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
        logger.info("product successfully updated to the database, product: " + entity);
    }

    public void delete(Product entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
        logger.info("product successfully deleted to the database, product: " + entity);
    }

    public Product getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get product by productId from the database");
        return (Product) session.get(Product.class, id);
    }

    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get product List from database");
        return session.createCriteria(Product.class).list();
    }
}
