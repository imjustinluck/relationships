<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>

<body>
	<div class="container">

		<h1>New License</h1>
		<div>
			<form:form action="/licenses/new" method="POST"
				modelAttribute="license">
				<p>
					<form:label path="person">Person: </form:label>
					<form:errors path="person" />
					<form:select path="person">
						<c:forEach items="${persons }" var="p">
							<form:option value="${p.id }">
							${p.firstName }
							</form:option>
						
						</c:forEach>
					</form:select>
				</p>
				<p>
					<form:label path="state">State: </form:label>
					<form:errors path="state" />
					<form:input path="state" />
				</p>
				<p>
					<form:label path="expirationDate">Date: </form:label>
					<form:errors path="expirationDate" />
					<form:input path="expirationDate" type="date" />
				</p>
				<input type="submit" value="Create" />
			</form:form>
		</div>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>

</html>