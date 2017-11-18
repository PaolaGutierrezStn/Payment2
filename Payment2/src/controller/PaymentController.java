package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PaymentDAOImpl;
import model.Payment;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Payment payment;
	private List<Payment> payments;
	private PaymentDAOImpl paymentDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentController() {
		super();
		payment = new Payment();
		payments = new ArrayList<Payment>();
		paymentDAO = new PaymentDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btn_save") != null) {

			payment.setSubtotal(Double.parseDouble(request.getParameter("subtotal")));
			payment.setTip(Double.parseDouble(request.getParameter("tip")));
			payment.setTax(Double.parseDouble(request.getParameter("tax")));

			if (payment.getId() == 0L) {
				paymentDAO.createPayment(payment);
			} else {
				paymentDAO.updatePayment(payment);
			}

			payments = paymentDAO.readAllPayments();
			/**
			 * for(int i =0; i< payments.size(); i++) {
			 * System.out.println(payments.get(i).getId()); }
			 **/
			request.setAttribute("payments", payments);
			request.getRequestDispatcher("payment_list.jsp").forward(request, response);

		} else if (request.getParameter("btn_new") != null) {
			payment = new Payment();
			request.getRequestDispatcher("payment_form.jsp").forward(request, response);

		} else if (request.getParameter("btn_edit") != null) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				payment = paymentDAO.readPayment(id);

			} catch (Exception e) {

				payment = new Payment();
			}
			request.setAttribute("payment", payment);

			request.getRequestDispatcher("payment_form.jsp").forward(request, response);

		} else if (request.getParameter("btn_delete") != null) {

			try {
				Long id = Long.parseLong(request.getParameter("id"));
				paymentDAO.deletePayment(id);
				payments = paymentDAO.readAllPayments();

			} catch (Exception e) {
				e.printStackTrace();

			}
			request.setAttribute("payments", payments);
			request.getRequestDispatcher("payment_list.jsp").forward(request, response);
		} else {
			//payments = paymentDAO.readAllPayments();
			//request.setAttribute("payments", payments);
			request.getRequestDispatcher("payment_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
