<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>project Page</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css">

</head>
<body>
	<script>
		$(function() {
			$('.date-picker')
					.datepicker(
							{
								changeMonth : true,
								changeYear : true,
								showButtonPanel : true,
								dateFormat : 'MM yy',
								onClose : function(dateText, inst) {
									var month = $(
											"#ui-datepicker-div .ui-datepicker-month :selected")
											.val();
									var year = $(
											"#ui-datepicker-div .ui-datepicker-year :selected")
											.val();
									$(this).datepicker('setDate',
											new Date(year, month, 1));
								}
							});
		});
	</script>

	<%@ include file="./nav.jsp"%>



	<div class="container">



		<c:url var="addAction" value="/project/add"></c:url>

		<form:form action="${addAction}" modelAttribute="project"
			class="form-horizontal">
			<c:if test="${empty project.projectId}">
				<h2 class="form-signin-heading">Add Project</h2>
			</c:if>

			<c:if test="${not empty project.projectId}">
				<h2 class="form-signin-heading">Edit Project</h2>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-7 control-lable" for="projectId">Id</label>
						<div class="col-md-7">

							<form:input path="projectId" readonly="true" size="8"
								disabled="true" />
							<form:hidden path="projectId" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="projectId" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<div class="row">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="control-label col-sm-2" for="email">Name:</label>
					<div class="col-md-7">
						<form:input type="text" path="projectName" id="projectName"
							class="form-control input-sm" />
						<div class="has-error">

							<form:errors path="projectName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<br>

			<div class="row">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="control-label col-sm-2" for="email">Department:</label>
					<div class="col-md-7">
						<form:input type="text" path="projectDetails.projectOwner"
							id="projectDetails.projectOwner" class="form-control input-sm" />
						<div class="has-error">

							<form:errors path="projectDetails.projectOwner"
								class="help-inline" />
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="control-label col-sm-2" for="email">Start
						Date:</label>
					<div class="col-md-7">
						<form:input type="text" path="projectDetails.startDate" id="date"
							class="date-picker" />
						<div class="has-error">

							<form:errors path="projectDetails.startDate" class="help-inline" />
						</div>
					</div>
				</div>
			</div>




			<div class="row">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="control-label col-sm-2" for="email">End Date:</label>
					<div class="col-md-7">
						<form:input type="text" path="projectDetails.endDate" id="endDate"
							class="date-picker" />
						<div class="has-error">

							<form:errors path="projectDetails.endDate" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group${status.error ? 'has-error' : ''}">
					
					<label class="control-label col-sm-2" for="employees">Employees:</label>
					<div class="col-md-7">
						<form:select path="employee" items="${employees}" multiple="true"
							itemValue="empId" itemLabel="employeeName"
							class="form-control input-sm" />
			
			</div>
			</div>
			</div>
						<div class="row">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label class="control-label col-sm-2" for="email">Status:</label>
								<div class="col-md-7">
									<form:radiobutton path="projectStatus" value="Green" />
									Green
									<form:radiobutton path="projectStatus" value="Yellow" />
									Yellow
									<form:radiobutton path="projectStatus" value="Red" />
									Red
									<div class="has-error">
										<form:errors path="projectStatus" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						<br>



						<div class="form-group ">
							<div class="col-sm-offset-2 col-md-7">
								<c:choose>
									<c:when test="${not empty project.projectId}">
										<input type="submit" value="Update"
											class="btn btn-primary btn-sm" /> or <a
											href="<c:url value='/projects' />">Cancel</a>
									</c:when>
									<c:otherwise>
										<input type="submit" value="Register"
											class="btn btn-primary btn-sm" /> or <a
											href="<c:url value='/projects' />">Cancel</a>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
		</form:form>
		<br>
	</div>

</body>
</html>