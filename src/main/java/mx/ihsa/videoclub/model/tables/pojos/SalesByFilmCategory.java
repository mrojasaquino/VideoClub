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
public class SalesByFilmCategory implements Serializable {

	private static final long serialVersionUID = 1766098361;

	private String     category;
	private BigDecimal totalSales;

	public SalesByFilmCategory() {}

	public SalesByFilmCategory(SalesByFilmCategory value) {
		this.category = value.category;
		this.totalSales = value.totalSales;
	}

	public SalesByFilmCategory(
		String     category,
		BigDecimal totalSales
	) {
		this.category = category;
		this.totalSales = totalSales;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getTotalSales() {
		return this.totalSales;
	}

	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}
}
