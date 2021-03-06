/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables.pojos;


import java.io.Serializable;

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
public class StaffList implements Serializable {

	private static final long serialVersionUID = 2009752943;

	private Integer id;
	private String  name;
	private String  address;
	private String  zip_code;
	private String  phone;
	private String  city;
	private String  country;
	private Short   sid;

	public StaffList() {}

	public StaffList(StaffList value) {
		this.id = value.id;
		this.name = value.name;
		this.address = value.address;
		this.zip_code = value.zip_code;
		this.phone = value.phone;
		this.city = value.city;
		this.country = value.country;
		this.sid = value.sid;
	}

	public StaffList(
		Integer id,
		String  name,
		String  address,
		String  zip_code,
		String  phone,
		String  city,
		String  country,
		Short   sid
	) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.zip_code = zip_code;
		this.phone = phone;
		this.city = city;
		this.country = country;
		this.sid = sid;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip_code() {
		return this.zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Short getSid() {
		return this.sid;
	}

	public void setSid(Short sid) {
		this.sid = sid;
	}
}
