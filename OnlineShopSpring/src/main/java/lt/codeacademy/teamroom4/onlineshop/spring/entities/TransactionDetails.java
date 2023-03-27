package lt.codeacademy.teamroom4.onlineshop.spring.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TRANSACTION_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDetails {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;

	    @Column(name = "ORDER_ID")
	    private long orderId;

	    @Column(name = "MODE")
	    private String paymentMode;

	    @Column(name = "REFERENCE_NUMBER")
	    private String referenceNumber;

	    @Column(name = "PAYMENT_DATE")
	    private Instant paymentDate;

	    @Column(name = "STATUS")
	    private String paymentStatus;

	    @Column(name = "AMOUNT")
	    private long amount;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public long getOrderId() {
			return orderId;
		}

		public void setOrderId(long orderId) {
			this.orderId = orderId;
		}

		public String getPaymentMode() {
			return paymentMode;
		}

		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}

		public String getReferenceNumber() {
			return referenceNumber;
		}

		public void setReferenceNumber(String referenceNumber) {
			this.referenceNumber = referenceNumber;
		}

		public Instant getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(Instant paymentDate) {
			this.paymentDate = paymentDate;
		}

		public String getPaymentStatus() {
			return paymentStatus;
		}

		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}

		public long getAmount() {
			return amount;
		}

		public void setAmount(long amount) {
			this.amount = amount;
		}
	
}
