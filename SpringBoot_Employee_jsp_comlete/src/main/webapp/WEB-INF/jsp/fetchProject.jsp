<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>project Page</title>
    <link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body bgcolor="gray">
<%@ include file="./nav.jsp"%>

<div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Projects </span></div>
      <c:if test="${not empty projectList}">
            <table class="table table-hover">
                <thead >
                    <tr>


	
		<th width="80">ID</th>
		<th width="120"> Name</th>
		<th>Status</th>
		<th>Department</th>
		
				<th>Start Date</th>
				<th>End Date</th>
		
				<th width="60">View Employee</th>
		
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${projectList}" var="project">
		<tr>
			<td>${project.projectId}</td>
			<td>${project.projectName}</td>

			<td>${project.projectStatus}</td>
			<td>${project.projectDetails.projectOwner}
</td>			

			<td>${project.projectDetails.startDate}
</td>			
			<td>${project.projectDetails.endDate}</td>
				<td><a href="<c:url value='employee/project/${project.projectId}' />"  class="btn btn-success 
 
custom-width">View Employee</a></td>
			<td><a href="<c:url value='/project/edit/${project.projectId}' />"  class="btn btn-success 
 
custom-width">Edit</a></td>
			<td><a href="<c:url value='project/remove/${project.projectId}' />" class="btn btn-danger 
 
custom-width"  onclick="return confirm('Are you sure you want to delete this item?'); " >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

        </div>
        <div class="well">
            <a href="<c:url value='/project/add' />">Add New Project</a>
        </div>
    </div>
</body>
</html>