<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment List</title>
</head>
<body>

	<table border = "1">
		<tr>
			<th>
				<form action="PaymentController">
				<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Subtotal</th>
			 <th>Tip</th>
			 <th>Tax</th>
			
		</tr>
		<c:forEach var="payment" items="${payments}">
		
		<tr>
			<td>
				<form action= "PaymentController">
					<input type = "hidden" name = "id" value= "${payment.id}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
			</td>
			<td> ${payment.id}</td>
			<td> ${payment.subtotal}</td>
			<td> ${payment.tip}</td>
			<td> ${payment.tax}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>
	<form action="reporteNumeros">
				
					<input type = "submit" name = "btn_reporte" value = "Reporte"/>
				</form>

</body>
</html>