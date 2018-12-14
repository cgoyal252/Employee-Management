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



		<c:url var="addAction" value="/skill/add"></c:url>

		<form:form action="${addAction}" modelAttribute="skill"
			class="form-horizontal">
			<c:if test="${empty skill.skillId}">
				<h2 class="form-signin-heading">Add Skill</h2>
			</c:if>

			<c:if test="${not empty skill.skillId}">
				<h2 class="form-signin-heading">Edit Skill</h2>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="skillId">Id</label>
						<div class="col-md-7">

							<form:input path="skillId" readonly="true" size="8" disabled="true" />
							<form:hidden path="skillId" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="skillId" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<div class="row">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="control-label col-sm-2" for="email">Name:</label>
					<div class="col-md-7">
						<form:input type="text" path="skillName" id="employeeName"
							class="form-control input-sm" />
						<div class="has-error">

						<form:errors path="skillName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<br>
			
		
						<div class="form-group ">
							<div class="col-sm-offset-2 col-md-7">
								<c:choose>
									<c:when test="${not empty skill.skillId}">
										<input type="submit" value="Update"
											class="btn btn-primary btn-sm" /> or <a
											href="<c:url value='/skill' />">Cancel</a>
									</c:when>
									<c:otherwise>
										<input type="submit" value="Register"
											class="btn btn-primary btn-sm" /> or <a
											href="<c:url value='/skill' />">Cancel</a>
									</c:otherwise>
								</c:choose>
							</div>
						</div>	
			
			
			</form:form>
		<br>
	</div>
</div>
			
			
			
			
			
			
		

	<div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Skill </span></div>
      <c:if test="${not empty skillList}">
            <table class="table table-hover">
                <thead >
                    <tr>


	
		<th width="80">ID</th>
		<th width="120"> Name</th>
		
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${skillList}" var="skill">
		<tr>
			<td>${skill.skillId}</td>
			<td>${skill.skillName}</td>
			
			<td><a href="<c:url value='/skill/edit/${skill.skillId}' />"  class="btn btn-success 
 
custom-width">Edit</a></td>
			<td><a href="<c:url value='skill/remove/${skill.skillId}' />" class="btn btn-danger 
 
custom-width"  onclick="return confirm('Are you sure you want to delete this item?'); " >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>

        </div>
        <div class="well">
            <a href="<c:url value='/employee/add'/>">Add New Employee</a>
        </div>
    </div>
		
</body>
</html>