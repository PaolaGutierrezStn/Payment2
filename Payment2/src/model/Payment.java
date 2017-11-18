package model;

import java.io.Serializable;

public class Payment implements Serializable{
	private Long id;
	private double subtotal;
	private double tip;
	private double tax;
	
	
	
	public Payment() {
		this(0L,0,0,0);
	}

	public Payment(Long id, double subtotal, double tip, double tax) {
	
		super();
		this.id = id;
		this.subtotal = subtotal;
		this.tip = tip;
		this.tax = tax;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getTip() {
		return tip;
	}
	public void setTip(double tip) {
		this.tip = tip;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", subtotal=" + subtotal + ", tip=" + tip + ", tax=" + tax + "]";
	}

	
	
	
	
	
	



	
	
	
	
	
	
}
