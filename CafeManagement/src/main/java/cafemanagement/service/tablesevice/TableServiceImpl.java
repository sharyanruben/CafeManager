package cafemanagement.service.tablesevice;

import cafemanagement.dao.table.TableDao;
import cafemanagement.model.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RuBen on 27.03.2017.
 */
@Service
@Transactional
public class TableServiceImpl implements TableService {

    @Autowired
    private TableDao tableDao;

    public void create(Tables entity) {
        tableDao.create(entity);
    }

    public void update(Tables entity) {
        tableDao.update(entity);
    }

    public void delete(Tables entity) {
        tableDao.delete(entity);
    }

    public Tables getById(int id) {
        return tableDao.getById(id);
    }

    public List<Tables> getAll() {
        return tableDao.getAll();
    }
}
