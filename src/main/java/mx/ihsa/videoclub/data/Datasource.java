/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ihsa.videoclub.data;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/**
 *
 * @author mrojas
 */
public enum Datasource {
    
    INSTANCE;
    
    private final static Logger LOGGER = Logger.getLogger(Datasource.class.getName());

    private final static String JDBC_DRIVER = "jdbc.driver";
    private final static String JDBC_URL = "jdbc.url";
    private final static String JDBC_USER = "jdbc.user";
    private final static String JDBC_PASSWD = "jdbc.password";
    private final static String JDBC_MIN_SZ = "jdbc.pool_min_size";
    private final static String JDBC_MAX_SZ = "jdbc.pool_max_size";

    private final Properties props = new Properties();
    
    private ComboPooledDataSource dataSource;

    private void init() {
        loadConnectionData();

        dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass(props.getProperty(JDBC_DRIVER));
            dataSource.setDataSourceName("Pagila-DS");
            dataSource.setJdbcUrl(props.getProperty(JDBC_URL));
            dataSource.setUser(props.getProperty(JDBC_USER));
            dataSource.setPassword(props.getProperty(JDBC_PASSWD));
            dataSource.setMinPoolSize(Integer.valueOf(props.getProperty(JDBC_MIN_SZ)));
            dataSource.setMaxPoolSize(Integer.valueOf(props.getProperty(JDBC_MAX_SZ)));
            dataSource.setMaxIdleTime(10);
            dataSource.setUnreturnedConnectionTimeout(5);
            dataSource.setDebugUnreturnedConnectionStackTraces(true);
            
        } catch (PropertyVetoException e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    //TODO must load from a properties file
    private void loadConnectionData() {
        props.setProperty(JDBC_DRIVER, "org.postgresql.Driver");
        props.setProperty(JDBC_URL, "jdbc:postgresql://192.168.254.59/pagila");
        props.setProperty(JDBC_USER, "ihsa");
        props.setProperty(JDBC_PASSWD, "ihsa");
        props.setProperty(JDBC_MIN_SZ, "10");
        props.setProperty(JDBC_MAX_SZ, "50");

    }

    public Connection getConnection() throws SQLException {

        Connection conn = null;

        if (dataSource == null) {
            init();
        }

        conn = dataSource.getConnection();

        LOGGER.info(getStatus());

        return conn;
    }

    public PreparedStatement getPreparedStatement(String sql)
            throws SQLException {
        return getConnection().prepareStatement(sql);
    }

    public void stop() {
        dataSource.close();
    }

    public String getStatus() {
        StringBuilder retVal = new StringBuilder();
        try {
            retVal.append("Busy connections : ")
                    .append(dataSource.getNumBusyConnections()).toString();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, null, e);
        }

        return retVal.toString();
    }

    public void closeResources(PreparedStatement pstmt, ResultSet rs) {
        try {
            Connection con = null;
            if (pstmt != null) {
                con = pstmt.getConnection();
                pstmt.close();
            }

            if (rs != null) {
                rs.close();
            }

            closeConnection(con);
            
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }
    
    public void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, null, e);
            }
        }
    }
    
    
    public List<Record> getRecordsFor(String table) {
        List<Record> retVal = null;
        Connection conn = null;
        
        try {
            conn = getConnection();
            
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES_9_4);
            retVal = create.select().from(table).fetch();
            
        } catch (SQLException ex) {
            Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection(conn);
        }
        
        return retVal;
    }
}
