package kia.dbworker;

import kia.model.ExpensesRow;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by i.kalinnikov on 08.08.2017.
 */
public interface TableExpensesDao {

    public void setDataSource(DataSource ds);
    public ExpensesRow getRowById(String id);
    public List<ExpensesRow> getAllrecords();
}
