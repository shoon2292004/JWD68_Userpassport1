<%@page import="model.MajorBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		<%=request.getAttribute("message")%>

	</p>

	<%-- <h3>Major Imformation</h3>
	<%
	List<MajorBean> list = (List<MajorBean>) request.getAttribute("list");
	for (MajorBean major : list) { //Url format
		out.println(major.getMajorName() + "=" + major.getMarks() + " " + "<a href='major-update?id=" + major.getId()
		+ "'>edit</a>" + "," + "<a href='major-delete?id=" + major.getId() + "'>remove</a><br>");
	}
	%>
 --%>
	<table>
		<tr>
			<th>Name</th>
			<th>Marks</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${list}" var="obj">
			<tr>
				<td>${obj.majorName}</td>
				<td>${obj.marks}</td>
				<td>
				<a href="major-update?id=${obj.id}">edit</a>
				<a href="major-delete?id= ${obj.id}">remove</a>
				</td>
			</tr>
		</c:forEach>


	</table>



<p>
		<%=request.getAttribute("message")%>

	</p>



</body>
</html>