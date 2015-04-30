/**
 * This class is generated by jOOQ
 */
package mx.ihsa.videoclub.model.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
public class PaymentP2007_02 implements Serializable {

	private static final long serialVersionUID = -924789546;

	private Integer    paymentId;
	private Short      customerId;
	private Short      staffId;
	private Integer    rentalId;
	private BigDecimal amount;
	private Timestamp  paymentDate;

	public PaymentP2007_02() {}

	public PaymentP2007_02(PaymentP2007_02 value) {
		this.paymentId = value.paymentId;
		this.customerId = value.customerId;
		this.staffId = value.staffId;
		this.rentalId = value.rentalId;
		this.amount = value.amount;
		this.paymentDate = value.paymentDate;
	}

	public PaymentP2007_02(
		Integer    paymentId,
		Short      customerId,
		Short      staffId,
		Integer    rentalId,
		BigDecimal amount,
		Timestamp  paymentDate
	) {
		this.paymentId = paymentId;
		this.customerId = customerId;
		this.staffId = staffId;
		this.rentalId = rentalId;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public Integer getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Short getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Short customerId) {
		this.customerId = customerId;
	}

	public Short getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Short staffId) {
		this.staffId = staffId;
	}

	public Integer getRentalId() {
		return this.rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Timestamp getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
}
