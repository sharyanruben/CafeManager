package cafemanagement.service.orderservice;

import cafemanagement.dao.order.OrderDao;
import cafemanagement.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RuBen on 25.03.2017.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    public void create(Order entity) {
        orderDao.create(entity);
    }

    public void update(Order entity) {
        orderDao.update(entity);
    }

    public void delete(Order entity) {
        orderDao.delete(entity);
    }

    public Order getById(int id) {
        return orderDao.getById(id);
    }

    public List<Order> getAll() {
        return orderDao.getAll();
    }
}
