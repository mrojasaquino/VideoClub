/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ihsa.videoclub.data;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.AbstractTableModel;

import org.jooq.Field;
import org.jooq.Record;

/**
 * 
 * @author mrojas
 */
public class DataModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Record> dataRows;
    private final String tableName;
    private final Datasource dataSource = Datasource.INSTANCE;
    
    private final static Logger LOGGER = Logger.getLogger(DataModel.class.getName());
    
    private String[] columnNames;
    private Class<?>[] columnTypes;
    
    private int rowCount;
    private int columnCount;
    
    public DataModel(String tableName) {
        this.tableName = tableName;
        init();
    }
    
    
    private void init() {
        load();
        
        if(!dataRows.isEmpty()) {
            
            Field<?>[] fields = dataRows.get(0).fields();
            
            rowCount = dataRows.size();
            columnCount = fields.length;
            
            columnNames = new String[fields.length];
            columnTypes = new Class[fields.length];
            
            int i = 0;
            
            for (Field<?> field : fields) {
                columnNames[i] = field.getName();
                columnTypes[i] = field.getType();
                
                i++;
            }
        }
    }
    
    
    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Object retVal = null;
        
        if(dataRows != null) {
            Record record = dataRows.get(rowIndex);
            
            retVal = record.getValue(columnIndex);
        }
        
        return retVal;
    }
    
    public String[] getColumnNames() {
        return columnNames;
    }
    
    public Class<?>[] getColumnTypes() {
        return columnTypes;
    }

    
    
    private void load() {
    	LOGGER.log(Level.SEVERE, "Loading data for table {0}", tableName);
    	
        dataRows = dataSource.getRecordsFor(tableName);
        
        
        LOGGER.log(
        		Level.SEVERE, 
        		"Loaded {0} records for table {1}", 
        		new Object[]{dataRows.size(), tableName}
		);
    }
}
