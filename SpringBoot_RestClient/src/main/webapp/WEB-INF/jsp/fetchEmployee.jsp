<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee Page</title>
    <link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
	
</head>
<body bgcolor="gray">
<%@ include file="./nav.jsp"%>
<div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Employees </span></div>
      <c:if test="${not empty employeeList}">
            <table class="table table-hover">
                <thead >
                    <tr>


	
		<th width="80">ID</th>
		<th width="120"> Name</th>
		<th>Email</th>
		<th width="120">Experience</th>
		<th width="120">Role</th>
				<th width="120">Skills</th>
		
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${employeeList}" var="employee">
		<tr>
			<td>${employee.empId}</td>
			<td>${employee.employeeName}</td>
			<td>${employee.email}</td>
			<td>${employee.experience}</td>
			<td>${employee.employeeRole}</td>
		   <td>${employee.skills}</td>
			<td><a href="<c:url value='/employee/edit/${employee.empId}' />"  class="btn btn-success 
 
custom-width">Edit</a></td>
			<td><a href="<c:url value='employee/remove/${employee.empId}' />" class="btn btn-danger 
 
custom-width"  onclick="return confirm('Are you sure you want to delete this item?'); " >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

        </div>
        <div class="well">
            <a href="<c:url value='/employee/add' />">Add New Employee</a>
        </div>
    </div>
</body>
</html>