<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body style="background-color:yellow;">
<h1 style="text-align:center;width:100%;">Product Details</h1>
<form name="frmLogin"  method="POST"  action="ProductDetails">
<p style="text-align:center;width:100%">
	Product ID       :  <input type="text"  name="pid" placeholder="Enter Product ID" required />
	<br /><br />
	Product Name     :  <input type="text"  name="pname" placeholder="Enter Product Name" required />
	<br /><br />
	<label for="Vehicles">Choose a Category     :</label>
  	<select name="Vehicles" id="Vehicles">
  	<option value="Choose">Choose a Category</option>
    <option value="CAR">CAR</option>
    <option value="BIKE">BIKE</option>
    <option value="BUS">BUS</option>
    <option value="LORRY">LORRY</option>
  	</select>
  	<br><br>
	Product Price    :  <input type="text"  name="pprice" placeholder="Enter Product Price" required />
	<br /><br />
	<input type="submit"  value="Submit" />
</p>
</form>
</body>
</html>