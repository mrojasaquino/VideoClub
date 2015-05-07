/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ihsa.videoclub.data;

import java.util.EventObject;

/**
 *
 * @author mrojas
 */
public class DataEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int currentRow;
	private int totalRows;
	private int recordId;
	private String tableName;
	
	
	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	
    public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public DataEvent(Object source) {
        super(source);
    }

	@Override
	public String toString() {
		return "DataEvent [currentRow=" + currentRow + ", totalRows="
				+ totalRows + ", recordId=" + recordId + ", tableName="
				+ tableName + "]";
	}
    
    
    
}
