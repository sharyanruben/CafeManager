package cafemanagement.validation;

import cafemanagement.model.Tables;
import cafemanagement.model.User;
import cafemanagement.service.tablesevice.TableService;
import cafemanagement.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by RuBen on 27.03.2017.
 */
@Component
public class Validator {

    @Autowired
    private UserService userService;

    @Autowired
    private TableService tableService;

    public boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public boolean isUserExist(String username) {
        List<User> userList = userService.getAll();
        for (User user : userList) {
            if (user.getUsername().equals(username)) return true;
        }
        return false;
    }

    public boolean isTableExist(String tableName) {
        List<Tables> tableList = tableService.getAll();
        for (Tables table : tableList) {
            if (table.getTableName().equals(tableName))
                return true;
        }
        return false;
    }

    public boolean isNegativeInteger(int number) {
        return number < 0;
    }

    public boolean isNegativeDouble(double number) {
        return number < 0.0;
    }
}
