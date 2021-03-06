/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import mx.ihsa.videoclub.model.tables.HistoricoRentas;

import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row;
import org.jooq.Row5;
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
public class HistoricoRentasRecord extends TableRecordImpl<HistoricoRentasRecord> implements Record5<Short, Timestamp, Timestamp, Long, Timestamp> {

	private static final long serialVersionUID = -2071412746;

	/**
	 * Setter for <code>public.historico_rentas.customer_id</code>.
	 */
	public void setCustomerId(Short value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.historico_rentas.customer_id</code>.
	 */
	public Short getCustomerId() {
		return (Short) getValue(0);
	}

	/**
	 * Setter for <code>public.historico_rentas.previous_date</code>.
	 */
	public void setPreviousDate(Timestamp value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.historico_rentas.previous_date</code>.
	 */
	public Timestamp getPreviousDate() {
		return (Timestamp) getValue(1);
	}

	/**
	 * Setter for <code>public.historico_rentas.rental_date</code>.
	 */
	public void setRentalDate(Timestamp value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.historico_rentas.rental_date</code>.
	 */
	public Timestamp getRentalDate() {
		return (Timestamp) getValue(2);
	}

	/**
	 * Setter for <code>public.historico_rentas.how_many</code>.
	 */
	public void setHowMany(Long value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.historico_rentas.how_many</code>.
	 */
	public Long getHowMany() {
		return (Long) getValue(3);
	}

	/**
	 * Setter for <code>public.historico_rentas.next_date</code>.
	 */
	public void setNextDate(Timestamp value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.historico_rentas.next_date</code>.
	 */
	public Timestamp getNextDate() {
		return (Timestamp) getValue(4);
	}

	// -------------------------------------------------------------------------
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Short, Timestamp, Timestamp, Long, Timestamp> fieldsRow() {
		return (Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Short, Timestamp, Timestamp, Long, Timestamp> valuesRow() {
		return (Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Short> field1() {
		return HistoricoRentas.HISTORICO_RENTAS.CUSTOMER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field2() {
		return HistoricoRentas.HISTORICO_RENTAS.PREVIOUS_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field3() {
		return HistoricoRentas.HISTORICO_RENTAS.RENTAL_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field4() {
		return HistoricoRentas.HISTORICO_RENTAS.HOW_MANY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field5() {
		return HistoricoRentas.HISTORICO_RENTAS.NEXT_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Short value1() {
		return getCustomerId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value2() {
		return getPreviousDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value3() {
		return getRentalDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value4() {
		return getHowMany();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value5() {
		return getNextDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HistoricoRentasRecord value1(Short value) {
		setCustomerId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HistoricoRentasRecord value2(Timestamp value) {
		setPreviousDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HistoricoRentasRecord value3(Timestamp value) {
		setRentalDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HistoricoRentasRecord value4(Long value) {
		setHowMany(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HistoricoRentasRecord value5(Timestamp value) {
		setNextDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HistoricoRentasRecord values(Short value1, Timestamp value2, Timestamp value3, Long value4, Timestamp value5) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached HistoricoRentasRecord
	 */
	public HistoricoRentasRecord() {
		super(HistoricoRentas.HISTORICO_RENTAS);
	}

	/**
	 * Create a detached, initialised HistoricoRentasRecord
	 */
	public HistoricoRentasRecord(Short customerId, Timestamp previousDate, Timestamp rentalDate, Long howMany, Timestamp nextDate) {
		super(HistoricoRentas.HISTORICO_RENTAS);

		setValue(0, customerId);
		setValue(1, previousDate);
		setValue(2, rentalDate);
		setValue(3, howMany);
		setValue(4, nextDate);
	}
}
