<%@ include file="../common/header.jsp" %>
<html>
<body>
	<h2>User Manager</h2>
	<form:form method="post" action="/music/user/create.htm" commandName="user">
		<table>
			<tr>
				<td><form:label path="username">Name:</form:label></td>
				<td><form:input path="username"/></td>
				<td><form:errors path="username" class="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:input path="password" placeholder="******" /></td>
				<td><form:errors path="password" class="error" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Create User">
				</td>
				<td>
					<a href="/music/home.htm">Home Page</a>
				</td>
			</tr>
		</table>
	</form:form>
	

	<c:if test="${!empty userList}">
		<h3>Users on Record</h3>
		<table>
			<tr>
				<th>User Name</th>
				<th>Password (showing for educational purposes)</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td><c:out value="${user.username}" /></td>
					<td>${user.password}</td>
					<td><a href="/music/user/delete/${user.userId}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>