package mx.ihsa.videoclub;

import java.util.ArrayList;
import java.util.List;

import mx.ihsa.videoclub.data.FilmDao;
import mx.ihsa.videoclub.util.LabelValueBean;

import org.matica.zkdata.ChartAxis;
import org.matica.zkdata.ChartData;
import org.matica.zkdata.MaPoint;
import org.matica.zkflot.MaChart;
import org.zkoss.zul.Div;
import org.zkoss.zul.Image;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Vbox;

public class MainArea extends Div {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private MaChart lineChart;
	
	private Tabbox tabBox;
	private Tabs tabs;
	private Tabpanels tabPanels;
	
	private Tab mainTab;
	private Tabpanel mainTabPanel;
	
	private Tab top10Tab;
	private Tabpanel top10TabPanel;
	
	private Tab monthlyRentalsTab;
	private Tabpanel monthlyRentalsPanel;

	public MainArea() {
		super();

		init();
	}


	private void init() {
		setWidth("100%");
		setHeight("100%");

		tabBox = new Tabbox();
		tabBox.setHeight("100%");
		tabs = new Tabs();
		tabPanels = new Tabpanels();
		
		tabBox.appendChild(tabs);
		tabBox.appendChild(tabPanels);

		buildMainTab();
		buildTop10ChartTab();
		buildMontlhyRentals();
		
		appendChild(tabBox);
	}
	
	private void buildMainTab() {
		Vbox contenedor = new Vbox();
		contenedor.setAlign("center");
		contenedor.setPack("center");
		contenedor.setWidth("100%");
		contenedor.setHeight("100%");

		Image logo = new Image("http://howtofilmschool.com/wp-content/uploads/2012/10/25Movies.jpg");
		contenedor.appendChild(logo);
		
		mainTab = new Tab();
		mainTab.setClosable(false);
		mainTab.setLabel("Inicio");
		tabs.appendChild(mainTab);
		
		mainTabPanel = new Tabpanel();
		mainTabPanel.appendChild(contenedor);
		tabPanels.appendChild(mainTabPanel);
		
	}

	private void buildTop10ChartTab() {

		List<LabelValueBean> top10Films = FilmDao.getTop10();

		if(!top10Films.isEmpty()) {

			List<MaPoint> puntos = new ArrayList<>();
			for (int i = 0; i < top10Films.size(); i++) {
				puntos.add(
						new MaPoint(i, Double.valueOf(top10Films.get(i).getValue()))
						);
			}


			List<ChartData> dataset = new ArrayList<ChartData>();
			dataset.add(new ChartData("Rentas", puntos));

			ChartAxis xaxis = new ChartAxis();
			xaxis.setPosition(ChartAxis.axe_position.BOTTOM);

			for(int i = 0; i < top10Films.size(); i++) {
				xaxis.addTick(top10Films.get(i).getLabel(), (double) i);
			}

			lineChart = new MaChart();

			lineChart.setDataset(dataset);
			lineChart.setLines("{show: false}");	
			lineChart.setBars("{show: true, zero: true, barWidth: 0.5, align: 'center'}");
			lineChart.setStacked(false);
			lineChart.setWidth("940px");
			lineChart.setHeight("460px");
			lineChart.setXaxis(xaxis);
			lineChart.setTitle("Top 10 en Rentas");
		}
		
		top10Tab = new Tab();
		top10Tab.setClosable(false);
		top10Tab.setLabel("Top 10");
		tabs.appendChild(top10Tab);
		
		top10TabPanel = new Tabpanel();
		top10TabPanel.appendChild(lineChart);
		tabPanels.appendChild(top10TabPanel);

	}
	
	private void buildMontlhyRentals() {
		List<LabelValueBean> rentalsByMonth = FilmDao.getRentalsByMonth();

		if(!rentalsByMonth.isEmpty()) {

			List<MaPoint> puntos = new ArrayList<>();
			for (int i = 0; i < rentalsByMonth.size(); i++) {
				puntos.add(
						new MaPoint(i, Double.valueOf(rentalsByMonth.get(i).getValue()))
						);
			}


			List<ChartData> dataset = new ArrayList<ChartData>();
			dataset.add(new ChartData("Rentas", puntos));

			ChartAxis xaxis = new ChartAxis();
			xaxis.setPosition(ChartAxis.axe_position.BOTTOM);

			for(int i = 0; i < rentalsByMonth.size(); i++) {
				xaxis.addTick(rentalsByMonth.get(i).getLabel(), (double) i);
			}

			lineChart = new MaChart();

			lineChart.setDataset(dataset);
			lineChart.setLines("{show: true}");	
			lineChart.setBars("{show: false}");
			lineChart.setStacked(false);
			lineChart.setWidth("940px");
			lineChart.setHeight("460px");
			lineChart.setXaxis(xaxis);
			lineChart.setTitle("Rentas por Mes");
		}
		
		monthlyRentalsTab = new Tab();
		monthlyRentalsTab.setClosable(false);
		monthlyRentalsTab.setLabel("Rentas por Mes");
		tabs.appendChild(monthlyRentalsTab);
		
		monthlyRentalsPanel = new Tabpanel();
		monthlyRentalsPanel.appendChild(lineChart);
		tabPanels.appendChild(monthlyRentalsPanel);
	}
}
