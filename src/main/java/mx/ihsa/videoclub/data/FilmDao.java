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
import static mx.ihsa.videoclub.model.Tables.*;
import mx.ihsa.videoclub.model.tables.pojos.Film;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/**
 *
 * @author mrojas
 */
public class FilmDao {
    
    private static final Datasource data = Datasource.INSTANCE;
    private static final Logger LOGGER = Logger.getLogger(FilmDao.class.getName());
    
    public static List<Film> getAll() {
        
        DSLContext create;
        Connection conn = null;
        List<Film> retVal = new ArrayList<>();
        
        try {
            conn = data.getConnection();
            create = DSL.using(conn, SQLDialect.POSTGRES);
            
            retVal = create.select().from(FILM).fetch().into(Film.class);
            
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            data.closeConnection(conn);
        }
        
        return retVal;
    }
    
    
    public static List<Film> getAllByCategory(int categoryId) {
        DSLContext create;
        Connection conn = null;
        List<Film> retVal = new ArrayList<>();
        
        try {
            conn = data.getConnection();
            create = DSL.using(conn, SQLDialect.POSTGRES);
            
            retVal = 
                create.select()
                    .from(FILM).join(FILM_CATEGORY).using(FILM.FILM_ID)
                    .where(FILM_CATEGORY.CATEGORY_ID.equal((short)categoryId))
                        .fetchInto(Film.class);
                                
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, null, e);
        } finally {
            data.closeConnection(conn);
        }
        
        return retVal;
    }
    
}
