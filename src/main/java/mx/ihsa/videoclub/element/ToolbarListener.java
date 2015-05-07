package mx.ihsa.videoclub.element;

/**
 * Interfaz para recibir eventos de la barra de navegación.
 * @author mrojas
 */
public interface ToolbarListener {

    /**
	 * Ignore user changes
	 */
    public void onIgnore();
    
    /**
     * Create new record
     */
    public void onNew();
    
    /**
     * Navigate to first record
     */
    public void onFirst();
    
    /**
     * Navigate to last record
     */
    public void onLast();
    
    /**
     * Navigate to next record
     */
    public void onNext();
    
    /**
     * Navigate to previous record
     */
    public void onPrevious();
    
    /**
     * Refresh current record
     */
    public void onRefresh();
    
    /**
     * Print document
     */
    public void onPrint();
    
    /**
     * View available report for current table
     */
    public void onReport();
    
    /**
     * Open the help window
     */
    public void onHelp();
    
    /**
     * Delete current record
     */
    public void onDelete();
    
    /**
     * Save current record
     */
    public void onSave();
    
    /**
     * Open the find/search dialog
     */
    public void onFind();
    
    /**
     * Open the attachment dialog
     */
    public void onAttachment();
}
