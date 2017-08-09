package kia.dbworker;

import kia.dbworker.TableExpensesDao;
import kia.model.ExpensesRow;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by i.kalinnikov on 08.08.2017.
 */
public class CRUDTableExpnesesDao implements TableExpensesDao {

   public NamedParameterJdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public ExpensesRow getRowById(String id) {
        String sql="select * from expenses where id=:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",id);
        return jdbcTemplate.queryForObject(sql,params, new ExpensesRowMapper());
    }

    @Override
    public List<ExpensesRow> getAllrecords() {
        String sql="select * from expenses";
        return jdbcTemplate.query(sql, new ExpensesRowMapper());
    }


    private static final class ExpensesRowMapper implements RowMapper<ExpensesRow> {
        @Override
        public ExpensesRow mapRow(ResultSet rs, int rowNum) throws SQLException {
            ExpensesRow expensesRow = new ExpensesRow();
            expensesRow.setId(rs.getInt("id"));
            expensesRow.setLogin(rs.getString("login"));
            expensesRow.setDd(rs.getString("dd"));
            expensesRow.setTime(rs.getString("time"));
            expensesRow.setDesc(rs.getString("description"));
            expensesRow.setAmount(rs.getInt("amount"));
            expensesRow.setComment(rs.getString("comment"));
            return expensesRow;
        }
    }
}
