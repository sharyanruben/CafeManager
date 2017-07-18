package cafemanagement.service.productservice;

import cafemanagement.dao.product.ProductDao;
import cafemanagement.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by RuBen on 27.03.2017.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public void create(Product entity) {
        productDao.create(entity);
    }

    public void update(Product entity) {
        productDao.update(entity);
    }

    public void delete(Product entity) {
        productDao.delete(entity);
    }

    public Product getById(int id) {
        return productDao.getById(id);
    }

    public List<Product> getAll() {
        return productDao.getAll();
    }
}
