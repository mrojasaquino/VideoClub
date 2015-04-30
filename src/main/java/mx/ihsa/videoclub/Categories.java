/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ihsa.videoclub;

import java.util.List;
import mx.ihsa.videoclub.data.CategoryDao;
import mx.ihsa.videoclub.model.tables.pojos.Category;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Center;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.North;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.South;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Window;

/**
 *
 * @author mrojas
 */
public class Categories extends Window implements EventListener<Event> {
    
    private Borderlayout mainLayout;
    private North northPnl;
    private South southPnl;
    private Center centerPnl;
    
    private Button btnFirst;
    private Button btnPrev;
    private Button btnNext;
    private Button btnLast;
    
    private Intbox categoryId;
    private Textbox categoryName;
    private Datebox lastUpdate;
    
    private Label lblStatus;
    
    private List<Category> lstCategories;
    private int currentPosition;
    private int numRecords;
    
    
    public Categories() {
        init();
        initData();
    }
    
    
    private void init() {
        setWidth("80%");
        setHeight("80%");
        setClosable(true);
        setTitle("Categoría");
        
        mainLayout = new Borderlayout();
        
        buildNorth();
        buildCenter();
        buildSouth();
        
        mainLayout.appendChild(northPnl);
        mainLayout.appendChild(centerPnl);
        mainLayout.appendChild(southPnl);
        
        appendChild(mainLayout);
    }

    private void initData() {
        lstCategories = CategoryDao.getAll();
        currentPosition = 0;
        numRecords = lstCategories.size();

        if(numRecords == 0) {
            btnFirst.setDisabled(true);
            btnPrev.setDisabled(true);
            btnLast.setDisabled(true);
            btnNext.setDisabled(true);
        }
        
        updatePanel(0);
    }
    
    
    public void updatePanel(int step) {
        Category category;
        
        switch (step) {
            case 0:
                currentPosition = step;
                break;
                
            case 99:
                currentPosition = numRecords - 1;
                break;
                
            default:
                currentPosition += step;
        }
        
        

        if(numRecords > 0 && currentPosition > 0 && currentPosition < numRecords - 1) {
            btnFirst.setDisabled(false);
            btnPrev.setDisabled(false);
            btnLast.setDisabled(false);
            btnNext.setDisabled(false);
        } else  if(numRecords > 0 && currentPosition == 0) {
            btnFirst.setDisabled(true);
            btnPrev.setDisabled(true);
            btnNext.setDisabled(false);
            btnLast.setDisabled(false);
        } else if(numRecords > 0 && currentPosition == numRecords - 1) {
            btnLast.setDisabled(true);
            btnNext.setDisabled(true);
            btnFirst.setDisabled(false);
            btnPrev.setDisabled(false);
        }
        
        
        category = lstCategories.get(currentPosition);
        
        categoryId.setValue(category.getCategoryId());
        categoryName.setValue(category.getName());
        lastUpdate.setValue(category.getLastUpdate());
        
        lblStatus.setValue((currentPosition + 1) + " / " + numRecords);
    }
    
    @Override
    public void onEvent(Event event) throws Exception {
        String evtName = event.getName();
        Object evtTarget = event.getTarget();
        
        if(evtTarget instanceof Button && Events.ON_CLICK.equals(evtName)) {
            
            if(evtTarget.equals(btnFirst)) {
                updatePanel(0);
            } else if (evtTarget.equals(btnPrev)) {
                updatePanel(-1);
            } else if (evtTarget.equals(btnNext)) {
                updatePanel(1);
            } else if (evtTarget.equals(btnLast)) {
                updatePanel(99);
            } 
            
        }
    }

    private void buildNorth() {
        northPnl = new North();
        northPnl.setHflex("true");
        
        Toolbar tbNavigation = new Toolbar("horizontal");
        
        btnFirst = new Button("|<");
        btnFirst.setTooltiptext("Inicio");
        btnFirst.addEventListener(Events.ON_CLICK, this);
        
        
        btnPrev = new Button("<");
        btnPrev.setTooltiptext("Anterior");
        btnPrev.addEventListener(Events.ON_CLICK, this);
        
        btnNext = new Button(">");
        btnNext.setTooltiptext("Siguiente");
        btnNext.addEventListener(Events.ON_CLICK, this);
        
        btnLast = new Button(">|");
        btnLast.setTooltiptext("Último");
        btnLast.addEventListener(Events.ON_CLICK, this);
        
        
        tbNavigation.appendChild(btnFirst);
        tbNavigation.appendChild(btnPrev);
        tbNavigation.appendChild(btnNext);
        tbNavigation.appendChild(btnLast);
        
        northPnl.appendChild(tbNavigation);
    }

    private void buildCenter() {
        centerPnl = new Center();
        
        Grid grid = new Grid();
        
        Rows rows = new Rows();
        
        Row row = new Row();
        Cell cell = new Cell();
        
        cell.appendChild(new Label("Id"));
        row.appendChild(cell);
        
        cell = new Cell();
        categoryId = new Intbox();
        cell.appendChild(categoryId);
        row.appendChild(cell);
        
        rows.appendChild(row);
        
        row = new Row();
        cell = new Cell();
        cell.appendChild(new Label("Nombre"));
        row.appendChild(cell);
        
        cell = new Cell();
        categoryName = new Textbox();
        cell.appendChild(categoryName);
        row.appendChild(cell);
        
        rows.appendChild(row);
        
        row = new Row();
        cell = new Cell();
        cell.appendChild(new Label("Actualizado"));
        row.appendChild(cell);
        
        cell = new Cell();
        lastUpdate = new Datebox();
        cell.appendChild(lastUpdate);
        row.appendChild(cell);
        
        rows.appendChild(row);
        
        
        grid.appendChild(rows);
        
        centerPnl.appendChild(grid);
    }

    private void buildSouth() {
        southPnl = new South();
        southPnl.setHeight("30px");
        
        lblStatus = new Label();
        
        southPnl.appendChild(lblStatus);
    }
}