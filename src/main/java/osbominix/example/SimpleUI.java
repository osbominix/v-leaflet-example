/**
 * @author yl
 *
 * create vaadin project with leaflet
 * 
 */
package osbominix.example;

import com.vaadin.annotations.*;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import org.vaadin.addon.leaflet.*;
import org.vaadin.addon.leaflet.shared.Bounds;
import org.vaadin.addon.leaflet.shared.Control;
import org.vaadin.addon.leaflet.shared.Point;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Title("My vaadin project with leaflet")
@Theme("valo")
@Push

public class SimpleUI extends UI {
    static final long serialVersionUID = 511085335415683713L;

    @Override
    protected void init(VaadinRequest request) {
        LMap leafletMap = new LMap();
        leafletMap.setCenter(52.520007, 13.404954);
        leafletMap.setZoomLevel(6);
        leafletMap.addBaseLayer(new LOpenStreetMapLayer(), "OSM");
        setContent(leafletMap);
    }


    /**
     * https://vaadin.com/directory/help/using-vaadin-add-ons/maven
     */
    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(
            productionMode = false,
            ui = SimpleUI.class,
            widgetset="osbominix.example.widgetset.MapWidgetset")
    public static class Servlet extends VaadinServlet {
    }

}
