package cafemanagement.dao.user;

import cafemanagement.dao.MainDao;
import cafemanagement.model.User;

/**
 * Created by RuBen on 27.03.2017.
 */
public interface Userdao extends MainDao<User> {
    User getUserNamePassword(String userName,String password);
}
