/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables.records;


import javax.annotation.Generated;

import mx.ihsa.videoclub.model.tables.StaffList;

import org.jooq.Field;
import org.jooq.Record8;
import org.jooq.Row;
import org.jooq.Row8;
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
public class StaffListRecord extends TableRecordImpl<StaffListRecord> implements Record8<Integer, String, String, String, String, String, String, Short> {

	private static final long serialVersionUID = -1017847244;

	/**
	 * Setter for <code>public.staff_list.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.staff_list.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.staff_list.name</code>.
	 */
	public void setName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.staff_list.name</code>.
	 */
	public String getName() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>public.staff_list.address</code>.
	 */
	public void setAddress(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.staff_list.address</code>.
	 */
	public String getAddress() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>public.staff_list.zip code</code>.
	 */
	public void setZip_code(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.staff_list.zip code</code>.
	 */
	public String getZip_code() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>public.staff_list.phone</code>.
	 */
	public void setPhone(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.staff_list.phone</code>.
	 */
	public String getPhone() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>public.staff_list.city</code>.
	 */
	public void setCity(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.staff_list.city</code>.
	 */
	public String getCity() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>public.staff_list.country</code>.
	 */
	public void setCountry(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.staff_list.country</code>.
	 */
	public String getCountry() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>public.staff_list.sid</code>.
	 */
	public void setSid(Short value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>public.staff_list.sid</code>.
	 */
	public Short getSid() {
		return (Short) getValue(7);
	}

	// -------------------------------------------------------------------------
	// Record8 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, String, String, String, Short> fieldsRow() {
		return (Row8) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, String, String, String, Short> valuesRow() {
		return (Row8) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return StaffList.STAFF_LIST.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return StaffList.STAFF_LIST.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return StaffList.STAFF_LIST.ADDRESS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return StaffList.STAFF_LIST.ZIP_CODE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return StaffList.STAFF_LIST.PHONE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field6() {
		return StaffList.STAFF_LIST.CITY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return StaffList.STAFF_LIST.COUNTRY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Short> field8() {
		return StaffList.STAFF_LIST.SID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getAddress();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getZip_code();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getPhone();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value6() {
		return getCity();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getCountry();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Short value8() {
		return getSid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StaffListRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StaffListRecord value2(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StaffListRecord value3(String value) {
		setAddress(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StaffListRecord value4(String value) {
		setZip_code(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StaffListRecord value5(String value) {
		setPhone(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StaffListRecord value6(String value) {
		setCity(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StaffListRecord value7(String value) {
		setCountry(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StaffListRecord value8(Short value) {
		setSid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StaffListRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, String value7, Short value8) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached StaffListRecord
	 */
	public StaffListRecord() {
		super(StaffList.STAFF_LIST);
	}

	/**
	 * Create a detached, initialised StaffListRecord
	 */
	public StaffListRecord(Integer id, String name, String address, String zip_code, String phone, String city, String country, Short sid) {
		super(StaffList.STAFF_LIST);

		setValue(0, id);
		setValue(1, name);
		setValue(2, address);
		setValue(3, zip_code);
		setValue(4, phone);
		setValue(5, city);
		setValue(6, country);
		setValue(7, sid);
	}
}
