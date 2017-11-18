<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment form</title>
</head>
<body>
	<form action="PaymentController">
		<label>Subtotal:</label><br>
		<input type = "text" name = "subtotal" value = "${payment.subtotal}"><br>
		
		<label>Tip:</label><br>
		<input type = "text" name = "tip" value = "${payment.tip}"><br>
		
		<label>Tax:</label><br>
		<input type = "text" name = "tax" value = "${payment.tax}"><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/><br> 
	</form>

</body>
</html>