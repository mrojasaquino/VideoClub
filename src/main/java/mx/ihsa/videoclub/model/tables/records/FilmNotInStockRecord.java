/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables.records;


import javax.annotation.Generated;

import mx.ihsa.videoclub.model.tables.FilmNotInStock;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row;
import org.jooq.Row1;
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
public class FilmNotInStockRecord extends TableRecordImpl<FilmNotInStockRecord> implements Record1<Integer> {

	private static final long serialVersionUID = 1782639725;

	/**
	 * Setter for <code>public.film_not_in_stock.p_film_count</code>.
	 */
	public void setPFilmCount(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.film_not_in_stock.p_film_count</code>.
	 */
	public Integer getPFilmCount() {
		return (Integer) getValue(0);
	}

	// -------------------------------------------------------------------------
	// Record1 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row1<Integer> fieldsRow() {
		return (Row1) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row1<Integer> valuesRow() {
		return (Row1) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return FilmNotInStock.FILM_NOT_IN_STOCK.P_FILM_COUNT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getPFilmCount();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FilmNotInStockRecord value1(Integer value) {
		setPFilmCount(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FilmNotInStockRecord values(Integer value1) {
		value1(value1);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached FilmNotInStockRecord
	 */
	public FilmNotInStockRecord() {
		super(FilmNotInStock.FILM_NOT_IN_STOCK);
	}

	/**
	 * Create a detached, initialised FilmNotInStockRecord
	 */
	public FilmNotInStockRecord(Integer pFilmCount) {
		super(FilmNotInStock.FILM_NOT_IN_STOCK);

		setValue(0, pFilmCount);
	}
}
