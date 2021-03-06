/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.0"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SalesByStore implements Serializable {

	private static final long serialVersionUID = -182667995;

	private String     store;
	private String     manager;
	private BigDecimal totalSales;

	public SalesByStore() {}

	public SalesByStore(SalesByStore value) {
		this.store = value.store;
		this.manager = value.manager;
		this.totalSales = value.totalSales;
	}

	public SalesByStore(
		String     store,
		String     manager,
		BigDecimal totalSales
	) {
		this.store = store;
		this.manager = manager;
		this.totalSales = totalSales;
	}

	public String getStore() {
		return this.store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public BigDecimal getTotalSales() {
		return this.totalSales;
	}

	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}
}
