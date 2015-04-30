/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ihsa.videoclub;

import mx.ihsa.videoclub.data.CategoryDao;
import mx.ihsa.videoclub.model.tables.pojos.Category;
import org.zkoss.zk.au.out.AuEcho;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.North;
import org.zkoss.zul.South;
import org.zkoss.zul.Window;

/**
 *
 * @author mrojas
 */
public class VentanaCategory extends Window implements EventListener<Event> {
    
    
    private Borderlayout mainLayout;
    private North northPnl;
    private South southPnl;
    private Center centerPnl;
    
    private ListModelList<Category> categoryModel = null;
    
    public VentanaCategory () {
        init();
    }
    
    
    private void init() {
        setWidth("80%");
        setHeight("80%");
        setClosable(true);
        setTitle("Categorías");
        
        categoryModel = new ListModelList<>();
        
        mainLayout = new Borderlayout();
        
        buildNorth();
        buildCenter();
        
        southPnl = new South();
        southPnl.setHeight("30px");
        
        
        mainLayout.appendChild(northPnl);
        mainLayout.appendChild(centerPnl);
        mainLayout.appendChild(southPnl);
        
        appendChild(mainLayout);
     }

    private void buildNorth() {
        northPnl = new North();
        northPnl.setHflex("true");
        
        Button btnCargar = new Button();
        btnCargar.setLabel("Cargar datos");
        btnCargar.addEventListener(Events.ON_CLICK, this);
        
        northPnl.appendChild(btnCargar);
    }

    private void buildCenter() {
        centerPnl = new Center();
        centerPnl.setStyle("overflow : auto");
        
        Listbox categories = new Listbox();
        categories.setModel(categoryModel);
        categories.setMold("paging");
        categories.setPageSize(10);
        
        Listhead header = new Listhead();
        header.appendChild(new Listheader("Nombre"));
        header.appendChild(new Listheader("Actualizada"));
        
        categories.setItemRenderer(new ListitemRenderer<Category>() {
            @Override
            public void render(Listitem item, Category category, int index) throws Exception {
                Listcell cell = new Listcell();
                cell.appendChild(new Label(category.getName()));
                item.appendChild(cell);
                
                cell = new Listcell();
                Datebox lastUpdated = new Datebox(category.getLastUpdate());
                lastUpdated.setReadonly(true);
                lastUpdated.setDisabled(true);
                cell.appendChild(lastUpdated);
                item.appendChild(cell);
            }
        });
        
        categories.appendChild(header);
        
        centerPnl.appendChild(categories);
    }
    
    public void loadData() {
       if(!categoryModel.isEmpty()) {
            categoryModel.clear();
        }
        
        categoryModel.addAll(CategoryDao.getAll());
        
        Clients.clearBusy();
    }

    @Override
    public void onEvent(Event event) throws Exception {
        Clients.showBusy("Loading");
        Clients.response(new AuEcho(this, "loadData", null));
    }
    
}
