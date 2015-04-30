/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables.records;


import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;

import mx.ihsa.videoclub.model.tables.PaymentP2007_05;

import org.jooq.Field;
import org.jooq.Record6;
import org.jooq.Row;
import org.jooq.Row6;
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
public class PaymentP2007_05Record extends TableRecordImpl<PaymentP2007_05Record> implements Record6<Integer, Short, Short, Integer, BigDecimal, Timestamp> {

	private static final long serialVersionUID = 447991000;

	/**
	 * Setter for <code>public.payment_p2007_05.payment_id</code>.
	 */
	public void setPaymentId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.payment_p2007_05.payment_id</code>.
	 */
	public Integer getPaymentId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.payment_p2007_05.customer_id</code>.
	 */
	public void setCustomerId(Short value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.payment_p2007_05.customer_id</code>.
	 */
	public Short getCustomerId() {
		return (Short) getValue(1);
	}

	/**
	 * Setter for <code>public.payment_p2007_05.staff_id</code>.
	 */
	public void setStaffId(Short value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.payment_p2007_05.staff_id</code>.
	 */
	public Short getStaffId() {
		return (Short) getValue(2);
	}

	/**
	 * Setter for <code>public.payment_p2007_05.rental_id</code>.
	 */
	public void setRentalId(Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.payment_p2007_05.rental_id</code>.
	 */
	public Integer getRentalId() {
		return (Integer) getValue(3);
	}

	/**
	 * Setter for <code>public.payment_p2007_05.amount</code>.
	 */
	public void setAmount(BigDecimal value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.payment_p2007_05.amount</code>.
	 */
	public BigDecimal getAmount() {
		return (BigDecimal) getValue(4);
	}

	/**
	 * Setter for <code>public.payment_p2007_05.payment_date</code>.
	 */
	public void setPaymentDate(Timestamp value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.payment_p2007_05.payment_date</code>.
	 */
	public Timestamp getPaymentDate() {
		return (Timestamp) getValue(5);
	}

	// -------------------------------------------------------------------------
	// Record6 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Integer, Short, Short, Integer, BigDecimal, Timestamp> fieldsRow() {
		return (Row6) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Integer, Short, Short, Integer, BigDecimal, Timestamp> valuesRow() {
		return (Row6) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return PaymentP2007_05.PAYMENT_P2007_05.PAYMENT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Short> field2() {
		return PaymentP2007_05.PAYMENT_P2007_05.CUSTOMER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Short> field3() {
		return PaymentP2007_05.PAYMENT_P2007_05.STAFF_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field4() {
		return PaymentP2007_05.PAYMENT_P2007_05.RENTAL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<BigDecimal> field5() {
		return PaymentP2007_05.PAYMENT_P2007_05.AMOUNT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field6() {
		return PaymentP2007_05.PAYMENT_P2007_05.PAYMENT_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getPaymentId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Short value2() {
		return getCustomerId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Short value3() {
		return getStaffId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value4() {
		return getRentalId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal value5() {
		return getAmount();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value6() {
		return getPaymentDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentP2007_05Record value1(Integer value) {
		setPaymentId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentP2007_05Record value2(Short value) {
		setCustomerId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentP2007_05Record value3(Short value) {
		setStaffId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentP2007_05Record value4(Integer value) {
		setRentalId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentP2007_05Record value5(BigDecimal value) {
		setAmount(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentP2007_05Record value6(Timestamp value) {
		setPaymentDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentP2007_05Record values(Integer value1, Short value2, Short value3, Integer value4, BigDecimal value5, Timestamp value6) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached PaymentP2007_05Record
	 */
	public PaymentP2007_05Record() {
		super(PaymentP2007_05.PAYMENT_P2007_05);
	}

	/**
	 * Create a detached, initialised PaymentP2007_05Record
	 */
	public PaymentP2007_05Record(Integer paymentId, Short customerId, Short staffId, Integer rentalId, BigDecimal amount, Timestamp paymentDate) {
		super(PaymentP2007_05.PAYMENT_P2007_05);

		setValue(0, paymentId);
		setValue(1, customerId);
		setValue(2, staffId);
		setValue(3, rentalId);
		setValue(4, amount);
		setValue(5, paymentDate);
	}
}
