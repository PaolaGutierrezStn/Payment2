package dao;

import java.util.List;

import model.Payment;

public class TestConnection {
	public static void main(Double[] args) {
		PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();
		paymentDAOImpl.createPayment(new Payment(6L, 5, 89, 25));
		
		List<Payment> payments = paymentDAOImpl.readAllPayments();
		for (Payment payment : payments) {
			System.out.println(payment);
			
		}
	}

}