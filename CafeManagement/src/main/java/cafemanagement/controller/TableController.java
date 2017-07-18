package cafemanagement.controller;

import cafemanagement.model.Tables;
import cafemanagement.service.tablesevice.TableService;
import cafemanagement.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by RuBen on 27.03.2017.
 */
@Controller
@RequestMapping("/table")
public class TableController {

    @Autowired
    private Validator validator;
    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/createTable", method = RequestMethod.POST)
    public String createTable(@ModelAttribute(value = "tables") @Valid Tables table,
                              Model model) {
        if (validator.isEmpty(table.getTableName())) {
            model.addAttribute("message", "table name is required , place input table name");
            return "forward:/managerPage/createTablePage";
        }
        if (validator.isTableExist(table.getTableName())) {
            model.addAttribute("message", "table is already exist, place input another name");
            return "forward:/managerPage/createTablePage";
        }
        table.setTableStatus(1);
        tableService.create(table);
        model.addAttribute("message", "create table is success");
        return "forward:/managerPage/createTablePage";
    }
}
