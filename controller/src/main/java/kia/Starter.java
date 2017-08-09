package kia;

import kia.dbworker.CRUDTableExpnesesDao;
import kia.model.ExpensesRow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by i.kalinnikov on 08.08.2017.
 */
public class Starter {
    public static void main(String[] args) {
        ApplicationContext contextXML = new ClassPathXmlApplicationContext("config.xml");
        CRUDTableExpnesesDao crudTableExpnesesDao =
                (CRUDTableExpnesesDao) contextXML.getBean("crudTableExpnesesDao");

        String id="11";
        ExpensesRow expensesRow = crudTableExpnesesDao.getRowById(id);
        System.out.println("id = " + expensesRow.getId());
        System.out.println("login = " + expensesRow.getLogin());
        System.out.println("amount = " + expensesRow.getAmount());

        System.out.println("Program is designed");
    }
}
