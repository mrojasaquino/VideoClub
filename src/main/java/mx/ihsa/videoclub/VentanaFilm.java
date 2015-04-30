/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ihsa.videoclub;

import java.util.List;
import mx.ihsa.videoclub.data.CategoryDao;
import mx.ihsa.videoclub.data.FilmDao;
import mx.ihsa.videoclub.element.ComboItem;
import mx.ihsa.videoclub.model.tables.pojos.Category;
import mx.ihsa.videoclub.model.tables.pojos.Film;
import org.zkoss.zk.au.out.AuEcho;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Hbox;
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
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 *
 * @author mrojas
 */
public class VentanaFilm extends Window implements EventListener<Event> {
    
    private Borderlayout mainLayout;
    private North northPnl;
    private Center centerPnl;
    private South southPnl;
    
    private Combobox cbCategories;
    private final ListModelList<Film> filmsModel  = new ListModelList<>();
    
    public VentanaFilm() {
        init();
        
        initData();
    }
    
    
    private void init() {
        
        setWidth("80%");
        setHeight("80%");
        setClosable(true);
        setTitle("Películas");
        
        mainLayout = new Borderlayout();
        
        buildNorth();
        buildCenter();
        buildSouth();
        
        
        mainLayout.appendChild(northPnl);
        mainLayout.appendChild(centerPnl);
        mainLayout.appendChild(southPnl);
        
        appendChild(mainLayout);
    }
    
    
    private void buildNorth() {
        northPnl = new North();
        northPnl.setHflex("1");
        
        Hbox container = new Hbox();
        
        Label lblCatego = new Label("Categorías");
        cbCategories = new Combobox();
        cbCategories.addEventListener(Events.ON_CHANGE, this);
        
        
        container.appendChild(lblCatego);
        container.appendChild(cbCategories);
        
        northPnl.appendChild(container);
    }
    
    private void buildCenter() {
        centerPnl = new Center();
        
        Listbox listFilms = new Listbox();
        listFilms.setModel(filmsModel);
        listFilms.setMold("paging");
        listFilms.setPageSize(5);
        
        Listhead header = new Listhead();
        
        Listheader listHeader = new Listheader("Título");
        listHeader.setWidth("30%");
        header.appendChild(listHeader);
        
        listHeader = new Listheader("Resumen");
        listHeader.setWidth("50%");
        header.appendChild(listHeader);
        
        listHeader = new Listheader("Año");
        header.appendChild(listHeader);
        
        listHeader = new Listheader("Duración");
        header.appendChild(listHeader);
        
        listFilms.appendChild(header);
        
        listFilms.setItemRenderer(new ListitemRenderer<Film>() {
            @Override
            public void render(Listitem item, Film film, int index) throws Exception {
                Listcell cell = new Listcell();
                cell.appendChild(new Label(film.getTitle()));
                item.appendChild(cell);
                
                cell = new Listcell();
                Textbox txtDescription = new Textbox(film.getDescription());
                txtDescription.setRows(2);
                txtDescription.setWidth("95%");
                cell.appendChild(txtDescription);
                item.appendChild(cell);
                
                cell = new Listcell();
                cell.appendChild(new Label(film.getReleaseYear().toString()));
                item.appendChild(cell);
                
                cell = new Listcell();
                cell.appendChild(new Label(film.getLength().toString()));
                item.appendChild(cell);
            }
        });
        
        
        centerPnl.appendChild(listFilms);
    }
    
    private void buildSouth() {
        southPnl = new South();
        southPnl.setHeight("30px");
    }

    private void initData() {
        Clients.showBusy("Loading ...");
        List<Category> lstCatego = CategoryDao.getAll();
        
        for (Category category : lstCatego) {
            ComboItem cb = 
                    new ComboItem(category.getName(), category.getCategoryId());
            cbCategories.appendChild(cb);
        }
        
        cbCategories.setSelectedIndex(0);
        
        updateFilms();
    }

    public void updateFilms() {
        
        if(!filmsModel.isEmpty()) {
            filmsModel.clear();
        }
        
        filmsModel.addAll(
                FilmDao.getAllByCategory(
                        (Integer)cbCategories.getSelectedItem().getValue()
                )
        );
        
        Clients.clearBusy();
    }

    @Override
    public void onEvent(Event event) throws Exception {
        Clients.showBusy("Loading ...");
        Clients.response(new AuEcho(this, "updateFilms", null));
    }
}