<%@page import="model.MajorBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Edit Major Form </h3>
<form action="major-update" method="post">
<input type="hidden" name ="mid" value="<%= ((MajorBean)request.getAttribute("majorObj")).getId() %>"> <br>
Name <input type="text" name="mname" value = "<%= ((MajorBean)request.getAttribute("majorObj")).getMajorName() %> "> <br>
Marks <input type="number" name="mmarks" value="<%= ((MajorBean)request.getAttribute("majorObj")).getMarks() %>"> <br>
<input type="submit" value="update">


</form>



</body>
</html>