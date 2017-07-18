package cafemanagement.service.productinordersevice;

import cafemanagement.dao.productinorder.ProductInOrderDao;
import cafemanagement.model.ProductInOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RuBen on 27.03.2017.
 */
@Service
@Transactional
public class ProductInOrderServiceImpl implements ProductInOrderService {

    @Autowired
    private ProductInOrderDao productInOrderDao;

    public void create(ProductInOrder entity) {
        productInOrderDao.create(entity);
    }

    public void update(ProductInOrder entity) {
        productInOrderDao.update(entity);
    }

    public void delete(ProductInOrder entity) {
        productInOrderDao.delete(entity);
    }

    public ProductInOrder getById(int id) {
        return productInOrderDao.getById(id);
    }

    public List<ProductInOrder> getAll() {
        return productInOrderDao.getAll();
    }
}
