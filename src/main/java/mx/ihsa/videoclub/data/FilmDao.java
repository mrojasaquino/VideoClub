/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ihsa.videoclub.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static mx.ihsa.videoclub.model.Tables.*;
import mx.ihsa.videoclub.model.tables.pojos.Film;
import mx.ihsa.videoclub.util.LabelValueBean;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
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
    
    
    /**
     * Devuelve las 10 películas más rentadas.
     * @return Una lista con el título y número de rentas por título.
     */
    public static List<LabelValueBean>getTop10() {
    	DSLContext create;
        Connection conn = null;
        List<LabelValueBean> retVal = new ArrayList<>();
        String sql = 
        		"SELECT f.title, count(*) AS rentals \n"
        		+"FROM rental r \n"
        		+"	INNER JOIN inventory i ON (r.inventory_id = i.inventory_id) \n"
        		+"	INNER JOIN film f ON (i.film_id = f.film_id) \n"
        		+"GROUP BY f.title \n"
        		+"ORDER BY rentals DESC \n"
        		+"LIMIT 10";
        
        try {
            conn = data.getConnection();
            create = DSL.using(conn, SQLDialect.POSTGRES);
            
            Result<Record> result = create.fetch(sql);
            
            for (Record record : result) {
				LabelValueBean lvb = 
						new LabelValueBean(
								(String)record.getValue(0), 
								((Long)record.getValue(1)).intValue()
						);
				
				retVal.add(lvb);
			}
                                
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL " + sql, e);
        } finally {
            data.closeConnection(conn);
        }
        
        return retVal;
    }
    
    public static List<LabelValueBean> getRentalsByMonth() {
    	DSLContext create;
        Connection conn = null;
        List<LabelValueBean> retVal = new ArrayList<>();
        String sql = 
        		"SELECT date_trunc('month', rental_date) AS rental_date, count(*) AS rentals \n"
				+ "FROM rental \n"
				+ "GROUP BY date_trunc('month', rental_date) \n"
				+ "ORDER BY rental_date";
        
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM");
        
        try {
            conn = data.getConnection();
            create = DSL.using(conn, SQLDialect.POSTGRES);
            
            Result<Record> result = create.fetch(sql);
            
            for (Record record : result) {
				LabelValueBean lvb = 
						new LabelValueBean(
								sdf.format((Timestamp)record.getValue(0)), 
								((Long)record.getValue(1)).intValue()
						);
				
				retVal.add(lvb);
			}
                                
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL : " + sql, e);
        } finally {
            data.closeConnection(conn);
        }
    	
    	return retVal;
    }
}
