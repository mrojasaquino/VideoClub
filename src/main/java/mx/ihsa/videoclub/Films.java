package mx.ihsa.videoclub;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import mx.ihsa.videoclub.data.DataEvent;
import mx.ihsa.videoclub.data.DataListener;
import mx.ihsa.videoclub.data.DataPanel;
import mx.ihsa.videoclub.model.Tables;
import mx.ihsa.videoclub.model.tables.Film;

import org.jooq.Record;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Center;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.North;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Window;

/**
 * Ventana de mantenimiento de películas.
 *
 * @author mrojas
 */
public class Films extends Window implements DataListener {

    private static final long serialVersionUID = 1L;
    private final static Logger LOGGER = Logger.getLogger(Films.class.getName());

    private Borderlayout mainLayout;
    private North northPnl;
    private Center centerPnl;
    
    private Decimalbox txtRentalIncrement;
    private Label lblRentalIncrement;

    private DataPanel dataPanel;


    private Record currentFilm;
    
    private Binding binding;
    private GroovyShell groovyShell;
    private GroovyScriptEngine gse;
    String[] roots = new String[]{"Groovy"};
    
    public Films() {
        init();
        
        initGroovy();
        
        processRecord();
    }

    private void initGroovy() {
		binding = new Binding();
		groovyShell = new GroovyShell(binding);
		try {
			gse = new GroovyScriptEngine(roots);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, null, e);
		}
	}

	private void init() {
        setWidth("80%");
        setHeight("80%");
        setClosable(true);
        setTitle("Película");

        mainLayout = new Borderlayout();

        dataPanel = new DataPanel(Tables.FILM.getName());
        dataPanel.addDataListener(this);

        buildNorth();
        buildCenter();

        mainLayout.appendChild(northPnl);
        mainLayout.appendChild(centerPnl);

        appendChild(mainLayout);
    }

	private void buildNorth() {
		northPnl = new North();
		northPnl.setHflex("1");
		
		Grid grid = new Grid();
		grid.setWidth("100%");
		
		Rows rows = new Rows();
		Row row = new Row();
		Cell cell = new Cell();
		
		lblRentalIncrement = new Label("Rental Increment ");
		txtRentalIncrement = new Decimalbox(BigDecimal.ZERO);
		txtRentalIncrement.setFormat("###,###,##0.00");
		txtRentalIncrement.setStyle("text-align : right");
		
		cell.appendChild(lblRentalIncrement);
		cell.setWidth("20%");
		row.appendChild(cell);
		
		cell = new Cell();
		cell.setWidth("25%");
		cell.appendChild(txtRentalIncrement);
		row.appendChild(cell);
		
		cell = new Cell();
		cell.setWidth("10%");
		row.appendChild(cell);
		
		cell = new Cell();
		cell.setWidth("20%");
		row.appendChild(cell);
		
		cell = new Cell();
		cell.setWidth("25%");
		row.appendChild(cell);
		
		
		rows.appendChild(row);
		grid.appendChild(rows);
		
		northPnl.appendChild(grid);
	}
	
    private void buildCenter() {
        centerPnl = new Center();
        centerPnl.appendChild(dataPanel);
    }

    @Override
    public void dataChanged(DataEvent dataEvent) {
        LOGGER.log(Level.SEVERE, "DataEvent : {0}", dataEvent.toString());
        processRecord();
    }

    private void processRecord() {
    	currentFilm = dataPanel.getCurrentRecord();
		
    	binding.setVariable("filmTitle", currentFilm.getValue(Film.FILM.TITLE));
    	
    	Object value = groovyShell.evaluate("return 'La película es ' + filmTitle");
    	LOGGER.log(Level.SEVERE, "Groovy : {0}", value);
    	
    	
    	if(gse != null) {
    		binding.setVariable(
    				"rentalRate", 
    				currentFilm.getValue(Film.FILM.RENTAL_RATE)
			);
    		
    		binding.setVariable(
    				"replacementCost", 
    				currentFilm.getValue(Film.FILM.REPLACEMENT_COST)
			);
    		
    		try {
				gse.run("Films.groovy", binding);
				
				txtRentalIncrement.setValue((BigDecimal)binding.getVariable("rentalIncrement"));
				
				LOGGER.log(Level.SEVERE, "Rental Increment : {0}", binding.getVariable("rentalIncrement"));
			} catch (ResourceException | ScriptException e) {
				LOGGER.log(Level.SEVERE, null, e);
			}
    	}
	}

	@Override
    public void onClose() {
        super.onClose();

        if (dataPanel != null) {
            dataPanel.removeDataListener(this);
        }

        dataPanel = null;
    }
}
