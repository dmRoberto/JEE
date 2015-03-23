package es.art83.persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.art83.persistence.models.daos.CategoryDao;
import es.art83.persistence.models.entities.Category;

public class CategoryDaoJdbc extends GenericDaoJdbc<Category, Integer> implements CategoryDao {
    private Logger log = LogManager.getLogger(CategoryDaoJdbc.class);

    private Category create(ResultSet resultSet) {
        try {
            if (resultSet != null && resultSet.next()) {
                return new Category(resultSet.getInt(Category.ID),
                        resultSet.getString(Category.NAME),
                        resultSet.getString(Category.DESCRIPTION));
            }
        } catch (SQLException e) {
            log.error("read: " + e.getMessage());
        }
        return null;
    }

    private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s VARCHAR(255), "
            + "%s VARCHAR(255), PRIMARY KEY (%s))";

    public static String sqlToCreateTable() {
        return String.format(SQL_CREATE_TABLE, Category.TABLE, Category.ID, Category.DESCRIPTION,
                Category.NAME, Category.ID);
    }

    private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s) VALUES (%d,'%s','%s')";

    @Override
    public void create(Category category) {
        this.updateSql(String.format(SQL_INSERT, Category.TABLE, Category.ID, Category.DESCRIPTION,
                Category.NAME, category.getId(), category.getDescription(), category.getName()));
    }

    @Override
    public Category read(Integer id) {
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Category.TABLE, id));
        return this.create(resultSet);
    }

    private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s' WHERE ID=%d";

    @Override
    public void update(Category category) {
        this.updateSql(String.format(SQL_UPDATE, Category.TABLE, Category.NAME, category.getName(),
                Category.DESCRIPTION, category.getDescription(), category.getId()));
    }

    @Override
    public void deleteById(Integer id) {
        this.updateSql(String.format(SQL_DELETE_ID, Category.TABLE, id));
    }

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<Category>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Category.TABLE));
        Category category = this.create(resultSet);
        while (category != null) {
            list.add(category);
            category = this.create(resultSet);
        }
        return list;
    }

}
