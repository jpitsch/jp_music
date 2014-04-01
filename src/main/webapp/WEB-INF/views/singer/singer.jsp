<%@ include file="../common/header.jsp" %>
<html>
<body>
	<h2>Singer Manager</h2>
	<form:form method="post" action="/music/singer/create.htm" commandName="singer">
		<table>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name" class="error" /></td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Date of Birth:</form:label></td>
				<td><form:input path="dateOfBirth" placeholder="MM/DD/YYYY" /></td>
				<td><form:errors path="dateOfBirth" class="error" /></td>
			</tr>
			<tr>
				<td><form:label path="sex">Gender:</form:label></td>
				<td>
					<form:select path="sex">
						<form:option value="0" label="Choose Gender" />
						<form:options items="${genderList}" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Create Singer">
				</td>
				<td>
					<a href="/music/home.htm">Home Page</a>
				</td>
			</tr>
		</table>
	</form:form>
	
	<c:if test="${!empty singersList}">
		<h3>Singers on Record</h3>
		<table>
			<tr>
				<th>Singer Name</th>
				<th>Date of Birth</th>
				<th>Gender</th>
			</tr>
			<c:forEach items="${singersList}" var="singer">
				<tr>
					<td>${singer.name}</td>
					<td>"${singer.dateOfBirth}"</td>
					<td>${singer.sex}</td>
					<td><a href="/singer/delete/${singer.singerId}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>