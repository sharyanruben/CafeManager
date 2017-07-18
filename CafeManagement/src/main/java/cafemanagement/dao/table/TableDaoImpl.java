package cafemanagement.dao.table;

import cafemanagement.dao.user.UserDaoImpl;
import cafemanagement.model.Tables;
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
public class TableDaoImpl implements TableDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;


    public void create(Tables entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        logger.info("table successfully added to the database, table: " + entity);
    }

    public void update(Tables entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
        logger.info("table successfully updated to the database, table: " + entity);
    }

    public void delete(Tables entity) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
        logger.info("table successfully deleted to the database, table: " + entity);
    }

    public Tables getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get table by tableId from the database");
        return (Tables) session.get(Tables.class, id);
    }

    public List<Tables> getAll() {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get table List from database");
        return session.createCriteria(Tables.class).add(Restrictions.eq("tableStatus", 1)).list();
    }
}
