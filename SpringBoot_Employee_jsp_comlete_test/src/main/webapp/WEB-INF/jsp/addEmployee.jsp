<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Employee Page</title>

 <link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/common.css" />

</head>
<body>
<%@ include file="./nav.jsp"%>

	<div class="container">
<div class="row">



		<c:url var="addAction" value="/employee/add"></c:url>

		<form:form action="${addAction}" modelAttribute="employee"
			class="form-horizontal">
			<c:if test="${empty employee.empId}">
				<h2 class="form-signin-heading">Add Employee</h2>
			</c:if>

			<c:if test="${not empty employee.empId}">
				<h2 class="form-signin-heading">Edit Employee</h2>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="empId">Id</label>
						<div class="col-md-7">

							<form:input path="empId" readonly="true" size="8" disabled="true" />
							<form:hidden path="empId" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="empId" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<div class="row">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="control-label col-sm-2" for="email">Name:</label>
					<div class="col-md-7">
						<form:input type="text" path="employeeName" id="employeeName"
							class="form-control input-sm" />
						<div class="has-error">

						<form:errors path="employeeName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<br>

			<div class="row">
<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="control-label col-sm-2" for="email">Email:</label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="empail"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="email" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<br>

			<div class="row"><div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="control-label col-sm-2" for="email">Skills:</label>
					<div class="col-md-7">
						<form:select path="skills" items="${skills}" multiple="true"
							itemValue="skillId" itemLabel="skillName"
							class="form-control input-sm" />
				<%-- 			<a href="<c:url value='/project/add' />"  class="btn btn-success 
 
custom-width">Add Skills</a> --%>
						<div class="has-error">
							<form:errors path="skills" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
						<br>
			
<%-- 			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="employeeRole">Role</label>
					<div class="col-md-7">
						<form:input type="text" path="employeeRole" id="employeeRole"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="employeeRole" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
 --%>
 	<div class="row">
							<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="control-label col-sm-2" for="email">Role:</label>
								<div class="col-md-7">
									<form:radiobutton path="employeeRole" value="Developer" />
										Developer
									<form:radiobutton path="employeeRole" value="Manager" />
						
										Manager<div class="has-error">
										<form:errors path="employeeRole" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
 
			<br>
	<div class="row">
			<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="control-label col-sm-2" for="email">Experience:</label>
					<div class="col-md-7">
						<form:input type="text" path="experience" id="experience"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="experience" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<br>

		<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
					<c:choose>
						<c:when test="${not empty employee.empId}">
							<input type="submit" value="Update"
								class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/employees' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"
								class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/employees' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
		<br>
	</div>
</div>
</body>
</html>