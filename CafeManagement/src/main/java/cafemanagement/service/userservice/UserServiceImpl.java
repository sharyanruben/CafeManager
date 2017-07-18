package cafemanagement.service.userservice;

import cafemanagement.dao.user.Userdao;
import cafemanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RuBen on 27.03.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private Userdao userdao;

    public void create(User entity) {
        userdao.create(entity);
    }

    public void update(User entity) {
        userdao.update(entity);
    }

    public void delete(User entity) {
        userdao.delete(entity);
    }

    public User getById(int id) {
        return userdao.getById(id);
    }

    public List<User> getAll() {
        return userdao.getAll();
    }

    public User getUserByUserNamePassword(String userName, String password) {
        return userdao.getUserNamePassword(userName, password);
    }
}
