<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Citizen Details:</h2>
	<sf:form>
		<h5>UIN:</h5>${citizen.getUIN()}<br/>
		<h5>Name :</h5>${citizen.getF_name()}<br/>
		<h5>Country:</h5>${citizen.getCountry()}<br/>
		<h5>DOB :</h5>${citizen.getDob()}<br/>
		<h5>Height :</h5>${citizen.getHeight()}<br/>
		<h5>Weight :</h5>${citizen.getWeight()}<br/>
		<h5>Skin Color :</h5>${citizen.getSkin_color()}<br/>
		<h5>Email :</h5>${citizen.getSkin_color()}<br/>
		<h5>Photo :</h5>${citizen.getPh()}<br/>
	</sf:form>
	
<!-- 	"UIN :"+citizen.getUIN()+ -->
<!-- 				"\nName :"+citizen.getF_name()+" "+citizen.getL_name()+ -->
<!-- 				"\nCountry :"+citizen.getCountry()+ -->
<!-- 				"\nDOB :"+citizen.getDob()+ -->
<!-- 				"\nHeight :"+citizen.getHeight()+ -->
<!-- 				"\nWeight :"+citizen.getWeight()+ -->
<!-- 				"\nSkin Color :"+citizen.getSkin_color()+ -->
<!-- 				"\nEmail :"+citizen.getEmail() -->
	
	
<!-- 	<sf:form> -->
<%-- 		<h5>Name:</h5>${donor.getName()}<br/> --%>
<%-- 		<h5>Blood Group:</h5>${donor.getBlood_group()}<br/> --%>
<%-- 		<h5>Address:</h5>${donor.getAddress()}<br/> --%>
<%-- 		<h5>Email :</h5>${donor.getEmail()} --%>
<!-- 	</sf:form> -->
</body>
</html>