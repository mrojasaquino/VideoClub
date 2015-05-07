package mx.ihsa.videoclub;

import java.util.logging.Level;
import java.util.logging.Logger;

import mx.ihsa.videoclub.data.DataEvent;
import mx.ihsa.videoclub.data.DataListener;
import mx.ihsa.videoclub.data.DataPanel;
import mx.ihsa.videoclub.model.Tables;

import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.Window;

/**
 * Ventana de mantenimiento de películas.
 *
 * @author mrojas
 */
public class Films extends Window implements DataListener {

    private static final long serialVersionUID = 1L;

    private Borderlayout mainLayout;
    private Center centerPnl;

    private DataPanel dataPanel;

    private final static Logger LOGGER = Logger.getLogger(Films.class.getName());

    public Films() {
        init();
    }

    private void init() {
        setWidth("80%");
        setHeight("80%");
        setClosable(true);
        setTitle("Película");

        mainLayout = new Borderlayout();

        dataPanel = new DataPanel(Tables.FILM.getName());
        dataPanel.addDataListener(this);

        buildCenter();

        mainLayout.appendChild(centerPnl);

        appendChild(mainLayout);
    }

    private void buildCenter() {
        centerPnl = new Center();
        centerPnl.appendChild(dataPanel);
    }

    @Override
    public void dataChanged(DataEvent dataEvent) {
        LOGGER.log(Level.SEVERE, "DataEvent : {0}", dataEvent.toString());
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
