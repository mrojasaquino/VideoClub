/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables.records;


import java.math.BigDecimal;

import javax.annotation.Generated;

import mx.ihsa.videoclub.model.tables.SalesByFilmCategory;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


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
public class SalesByFilmCategoryRecord extends TableRecordImpl<SalesByFilmCategoryRecord> implements Record2<String, BigDecimal> {

	private static final long serialVersionUID = 542437703;

	/**
	 * Setter for <code>public.sales_by_film_category.category</code>.
	 */
	public void setCategory(String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.sales_by_film_category.category</code>.
	 */
	public String getCategory() {
		return (String) getValue(0);
	}

	/**
	 * Setter for <code>public.sales_by_film_category.total_sales</code>.
	 */
	public void setTotalSales(BigDecimal value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.sales_by_film_category.total_sales</code>.
	 */
	public BigDecimal getTotalSales() {
		return (BigDecimal) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<String, BigDecimal> fieldsRow() {
		return (Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<String, BigDecimal> valuesRow() {
		return (Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field1() {
		return SalesByFilmCategory.SALES_BY_FILM_CATEGORY.CATEGORY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<BigDecimal> field2() {
		return SalesByFilmCategory.SALES_BY_FILM_CATEGORY.TOTAL_SALES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value1() {
		return getCategory();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal value2() {
		return getTotalSales();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SalesByFilmCategoryRecord value1(String value) {
		setCategory(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SalesByFilmCategoryRecord value2(BigDecimal value) {
		setTotalSales(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SalesByFilmCategoryRecord values(String value1, BigDecimal value2) {
		value1(value1);
		value2(value2);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached SalesByFilmCategoryRecord
	 */
	public SalesByFilmCategoryRecord() {
		super(SalesByFilmCategory.SALES_BY_FILM_CATEGORY);
	}

	/**
	 * Create a detached, initialised SalesByFilmCategoryRecord
	 */
	public SalesByFilmCategoryRecord(String category, BigDecimal totalSales) {
		super(SalesByFilmCategory.SALES_BY_FILM_CATEGORY);

		setValue(0, category);
		setValue(1, totalSales);
	}
}
