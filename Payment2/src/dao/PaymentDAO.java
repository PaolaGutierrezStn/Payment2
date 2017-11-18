package dao;

import java.util.List;

import model.Payment;

public interface PaymentDAO {
	void createPayment(Payment payment);
	Payment readPayment(Long id);
	List<Payment> readAllPayments();
	void updatePayment(Payment payment);
	void deletePayment(Long id);

}
