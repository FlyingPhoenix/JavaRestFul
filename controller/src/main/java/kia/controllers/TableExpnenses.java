package kia.controllers;

import kia.dbworker.CRUDTableExpnesesDao;
import kia.model.ExpensesRow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by i.kalinnikov on 08.08.2017.
 */
@RestController
public class TableExpnenses {

    @RequestMapping(value = "/exp/readbyid", method = RequestMethod.POST)
    public ExpensesRow message01(@RequestBody String id) {
        ApplicationContext contextXML = new ClassPathXmlApplicationContext("config.xml");
        CRUDTableExpnesesDao crudTableExpnesesDao =
                (CRUDTableExpnesesDao) contextXML.getBean("crudTableExpnesesDao");
        ExpensesRow expensesRow = crudTableExpnesesDao.getRowById(id);
        return expensesRow;
    }

    @RequestMapping(value = "/exp/readall", method = RequestMethod.GET)
    public List<ExpensesRow> message02() {
        ApplicationContext contextXML = new ClassPathXmlApplicationContext("config.xml");
        CRUDTableExpnesesDao crudTableExpnesesDao =
                (CRUDTableExpnesesDao) contextXML.getBean("crudTableExpnesesDao");
        List<ExpensesRow> allRecords = crudTableExpnesesDao.getAllrecords();
        return allRecords;
    }

}
