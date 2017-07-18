package cafemanagement.service.userservice;

import cafemanagement.model.User;
import cafemanagement.service.MainService;

/**
 * Created by RuBen on 27.03.2017.
 */
public interface UserService extends MainService<User> {
    User getUserByUserNamePassword(String userName, String password);
}
