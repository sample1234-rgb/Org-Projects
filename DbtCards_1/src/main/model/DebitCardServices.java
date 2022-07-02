package main.model;

import java.time.LocalDateTime;
import java.util.List;

public class DebitCardServices{
	private Integer serviceId;
	private Long contactNumber;
	private LocalDateTime timeOfRequest;
	private Float amount;
	private Status status;
	private int CVV;
	private Type type; 
	private Long CardNumber;
	
	public DebitCardServices(Long contactNumber,Long CardNumber,int cvv) {
		super();
		this.contactNumber = contactNumber;
		this.CardNumber = CardNumber;
		this.CVV = cvv;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public LocalDateTime getTimeOfRequest() {
		return timeOfRequest;
	}

	public void setTimeOfRequest(LocalDateTime timeOfRequest) {
		this.timeOfRequest = timeOfRequest;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getCardNumber() {
		return CardNumber;
	}

	public void setiMEINumber(Long CardNumber) {
		this.CardNumber = CardNumber;
	}
	
}