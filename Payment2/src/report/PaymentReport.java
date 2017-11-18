package report;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PaymentDAOImpl;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class PaymentReport
 */
@WebServlet("/PaymentReport")
public class PaymentReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaymentDAOImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentReport() {
        super();
        // TODO Auto-generated constructor stub
        dao = new PaymentDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "F:\\4C-GSI1342\\Aplicaciones 2 - Tacho\\workspace\\Payment2\\src\\report\\paymentReport.jrxml";
		try {
			JasperReport report = JasperCompileManager.compileReport(reportPath);
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("paymentReport", this.getServletContext().getRealPath("/")+"images/paymentReport.png");
			
			JasperPrint print = JasperFillManager.fillReport(report, data, dao.getConnection());
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
