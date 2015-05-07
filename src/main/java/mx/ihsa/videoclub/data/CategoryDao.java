/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ihsa.videoclub.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mx.ihsa.videoclub.model.Tables;
import mx.ihsa.videoclub.model.tables.pojos.Category;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/**
 *
 * @author mrojas
 */
public class CategoryDao {
    private static final Datasource data = Datasource.INSTANCE;
    private static final Logger LOGGER = Logger.getLogger(CategoryDao.class.getName());
    
    public static List<Category> getAll() {
        
        DSLContext create;
        Connection conn = null;
        List<Category> retVal = new ArrayList<>();
        
        try {
            conn = data.getConnection();
            create = DSL.using(conn, SQLDialect.POSTGRES);
            
            retVal = create.select().from(Tables.CATEGORY).fetch().into(Category.class);
            
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            data.closeConnection(conn);
        }
        
        return retVal;
    }
}
