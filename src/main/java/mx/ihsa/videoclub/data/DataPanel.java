package mx.ihsa.videoclub.data;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.event.EventListenerList;

import mx.ihsa.videoclub.element.NavToolBar;
import mx.ihsa.videoclub.element.ToolbarListener;

import org.apache.commons.lang3.StringUtils;
import org.jooq.Record;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;

/**
 * Contenedor para mostrar un panel de navegación de datos. Muestra los
 * elementos contenidos en el modelo de datos subyacente ({@link DataModel}),
 * una barra de navegación superior y una barra de estatus inferior.
 *
 * @author mrojas
 */
public class DataPanel extends Panel implements ToolbarListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private DataModel dataModel;
    private Panelchildren child;
    private Label statusLabel;

    private final String tableName;
    private int currentRow;
    private int recordId;

    private NavToolBar toolBar;

    private Component[] editors;

    private EventListenerList eventListenerList;

    private final static Logger LOGGER = Logger.getLogger(DataPanel.class.getName());
    
    private Record currentRecord;
    
    public DataPanel(String tableName) {
        super();

        this.tableName = tableName;

        init();
    }

    private void init() {
        setWidth("100%");
        setHeight("100%");
        
        eventListenerList = new EventListenerList();

        toolBar = new NavToolBar();
        toolBar.setOrient("horizontal");
        toolBar.enableNavigation(true);
        toolBar.addListener(this);

        // ver http://books.zkoss.org/wiki/ZK%20Component%20Reference/Containers/Panel
        addToolbar("tbar", toolBar);

        dataModel = new DataModel(tableName);

        child = new Panelchildren();
        child.setStyle("overflow : auto");
        appendChild(child);

        if (dataModel.getRowCount() > 0) {
            currentRow = 0;

            buildDataGrid();

            toolBar.enableLastNavigation(true);
            toolBar.enableFirstNavigation(false);
        } else {
            toolBar.enableNavigation(false);
        }

        statusLabel = new Label();
        updateStatusLabel();

        Toolbar footer = new Toolbar();
        footer.setAlign("end");
        footer.appendChild(statusLabel);
        footer.setMold("panel");

        // ver http://books.zkoss.org/wiki/ZK%20Component%20Reference/Containers/Panel
        addToolbar("fbar", footer);

    }

    private void buildDataGrid() {

        LOGGER.log(Level.SEVERE, "Building data grid for table {0}", tableName);

        Grid dataGrid = new Grid();
        dataGrid.setWidth("100%");

        editors = new Component[dataModel.getColumnCount()];

        Rows rows = new Rows();

        for (int i = 0; i < dataModel.getColumnCount(); i++) {
            Row row = new Row();
            row.setStyle("background-color : #FAFAFA;");

            Cell cell = new Cell();
            Label label = new Label(Labels.getLabel(dataModel.getColumnNames()[i]));
            cell.appendChild(label);
            row.appendChild(cell);

            Component editor = null;

            if (dataModel.getColumnTypes()[i].equals(Integer.class)
                    || dataModel.getColumnTypes()[i].equals(Short.class)) {
                editor = new Intbox();
            } else if (dataModel.getColumnTypes()[i].equals(Timestamp.class)
                    || dataModel.getColumnTypes()[i].equals(Date.class)) {
                editor = new Datebox();
            } else if (dataModel.getColumnTypes()[i].equals(BigDecimal.class)) {
                editor = new Decimalbox();
            } else if (dataModel.getColumnTypes()[i].equals(String[].class)) {
                editor = new Textbox();
                ((Textbox) editor).setRows(3);
            } else {
                editor = new Textbox();
            }

            cell = new Cell();
            cell.appendChild(editor);

            editors[i] = editor;

            row.appendChild(cell);
            rows.appendChild(row);
        }

        updateData();

        dataGrid.appendChild(rows);

        child.appendChild(dataGrid);
    }

    /**
     * La convención utilizada es :
     * <ul>
     * <li>-1 indica desplazarse de la posición actual hacia la inmediata
     * anterior</li>
     * <li>1 indica desplazarse de la posición actual hacia la inmediata subsecuente</li>
     * <li>Cualquier otro valor indica desplazarse desde la posición actual a la indicada</li>
     * </ul>
     *
     * @param position la posición o desplazamiento a utilizar.
     */
    private void navigate(int position) {

        switch (position) {
            case -1:
                if (currentRow > 0) {
                    currentRow--;
                }
                break;

            case 1:
                if (currentRow < dataModel.getRowCount()) {
                    currentRow++;
                }
                break;

            default:
                currentRow = position;
                break;
        }

        if (currentRow == 0 && dataModel.getRowCount() > 0) {
            toolBar.enableFirstNavigation(false);
            toolBar.enableLastNavigation(true);
        } else if (currentRow > 0
                && currentRow < dataModel.getRowCount() - 1) {
            toolBar.enableNavigation(true);
        } else if (currentRow == dataModel.getRowCount() - 1) {
            toolBar.enableFirstNavigation(true);
            toolBar.enableLastNavigation(false);
        }

        updateData();
        updateStatusLabel();

    }

    /**
     * Actualizar los datos mostrados en los editores.
     */
    private void updateData() {

        LOGGER.log(Level.SEVERE, "Updating data ...");

        for (int i = 0; i < dataModel.getColumnCount(); i++) {
            if (dataModel.getColumnTypes()[i].equals(Integer.class)
                    || dataModel.getColumnTypes()[i].equals(Short.class)) {
                if (dataModel.getValueAt(currentRow, i) == null) {
                    ((Intbox) editors[i]).setValue(0);
                } else {
                    ((Intbox) editors[i]).setValue(Integer.valueOf(dataModel.getValueAt(currentRow, i).toString()));
                }
            } else if (dataModel.getColumnTypes()[i].equals(Timestamp.class)) {
                if (dataModel.getValueAt(currentRow, i) == null) {
                    ((Datebox) editors[i]).setValue(new java.util.Date());
                } else {
                    ((Datebox) editors[i]).setValue((Timestamp) dataModel.getValueAt(currentRow, i));
                }
            } else if (dataModel.getColumnTypes()[i].equals(Date.class)) {
                if (dataModel.getValueAt(currentRow, i) == null) {
                    ((Datebox) editors[i]).setValue(new java.util.Date());
                } else {
                    ((Datebox) editors[i]).setValue((Date) dataModel.getValueAt(currentRow, i));
                }
            } else if (dataModel.getColumnTypes()[i].equals(BigDecimal.class)) {
                if (dataModel.getValueAt(currentRow, i) == null) {
                    ((Decimalbox) editors[i]).setValue(BigDecimal.ZERO);
                } else {
                    ((Decimalbox) editors[i]).setValue((BigDecimal) dataModel.getValueAt(currentRow, i));
                }
            } else if (dataModel.getColumnTypes()[i].equals(String[].class)) {
                if (dataModel.getValueAt(currentRow, i) != null) {
                    String[] text = (String[]) dataModel.getValueAt(currentRow, i);

                    ((Textbox) editors[i]).setValue(StringUtils.join(text, ", "));
                }
            } else {
                if (dataModel.getValueAt(currentRow, i) == null) {
                    ((Textbox) editors[i]).setValue(null);
                } else {
                    ((Textbox) editors[i]).setValue(dataModel.getValueAt(currentRow, i).toString());
                }
            }
        }

        recordId = (Integer) dataModel.getValueAt(currentRow, 0);

        currentRecord = dataModel.getValueAt(currentRow);
        
        DataEvent dataEvent = new DataEvent(this);
        dataEvent.setCurrentRow(currentRow);
        dataEvent.setTableName(tableName);
        dataEvent.setRecordId(recordId);
        dataEvent.setTotalRows(dataModel.getRowCount());

        fireDataChanged(dataEvent);
    }

    private void updateStatusLabel() {
        statusLabel.setValue((currentRow + 1) + " / " + dataModel.getRowCount());
    }

    /**
     * Notificar a los subscriptores del evento generado
     *
     * @param dataEvent
     */
    private void fireDataChanged(DataEvent dataEvent) {
        DataListener[] listeners
                = eventListenerList.getListeners(DataListener.class);

        if (listeners.length > 0) {
            for (int i = 0; i < listeners.length; i++) {
                listeners[i].dataChanged(dataEvent);
            }
        }
    }

    
    public Record getCurrentRecord() {
    	return currentRecord;
    }
    
    
    /**
     * Agregar un subscriptor de eventos
     *
     * @param dataListener
     */
    public void addDataListener(DataListener dataListener) {
        eventListenerList.add(DataListener.class, dataListener);
    }

    /**
     * Remover a un subscriptor
     *
     * @param dataListener
     */
    public void removeDataListener(DataListener dataListener) {
        eventListenerList.remove(DataListener.class, dataListener);
    }

    @Override
    public void onIgnore() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onNew() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onFirst() {
        navigate(0);
    }

    @Override
    public void onLast() {
        navigate(dataModel.getRowCount() - 1);
    }

    @Override
    public void onNext() {
        navigate(+1);
    }

    @Override
    public void onPrevious() {
        navigate(-1);
    }

    @Override
    public void onRefresh() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onPrint() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onReport() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onHelp() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onDelete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onSave() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onFind() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onAttachment() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
