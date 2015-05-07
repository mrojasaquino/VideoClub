package mx.ihsa.videoclub.data;

import java.util.EventListener;

/**
 * Interfaz para notificaciones de eventos de datos.
 * @author mrojas
 */
public interface DataListener extends EventListener {
    public void dataChanged(DataEvent dataEvent);
}
