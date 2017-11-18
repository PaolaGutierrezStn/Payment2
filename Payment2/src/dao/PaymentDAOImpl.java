package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Payment;



public class PaymentDAOImpl implements PaymentDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public PaymentDAOImpl() {
		getConnection();
	}
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/paymentdb", "postgres", "lobomalo7");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	@Override
	public void createPayment(Payment payment) {
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("INSERT INTO payments (subtotal, tip, tax) VALUES (?,?,?);");
				preparedStatement.setDouble(1,payment.getSubtotal());
				preparedStatement.setDouble(2,payment.getTip());
				preparedStatement.setDouble(3,payment.getTax());
				preparedStatement.execute();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Payment readPayment(Long id) {
		Payment payment = null;
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("SELECT id, subtotal, tip, tax FROM payments WHERE id=?");
				
				preparedStatement.setLong(1, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					payment = new Payment(resultSet.getLong(1), resultSet.getDouble(2), resultSet.getDouble(3),
											resultSet.getDouble(4));
				}
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return payment;
	}
	
	@Override
	public List<Payment> readAllPayments() {
		List<Payment> payments = new ArrayList<Payment>();
		try {
		
				preparedStatement = connection.prepareStatement("SELECT id, subtotal, tip, tax FROM payments");
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Payment payment = new Payment(
									resultSet.getLong(1), 
									resultSet.getDouble(2), 
									resultSet.getDouble(3),
									resultSet.getDouble(4));
					payments.add(payment);
				}
				
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return payments;
	}
	
	@Override
	public void updatePayment(Payment payment) {
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("UPDATE payments SET subtotal=?, "
											+ "tip=?,"
										+ "tax=? WHERE id=?;");
				preparedStatement.setDouble(1,payment.getSubtotal() );
				preparedStatement.setDouble(2,payment.getTip() );
				preparedStatement.setDouble(3,payment.getTax());
				preparedStatement.setLong(4,payment.getId());
				preparedStatement.execute();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	@Override
	public void deletePayment(Long id) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM payments WHERE id=?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
	}
	
	

}