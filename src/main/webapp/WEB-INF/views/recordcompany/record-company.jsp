<%@ include file="../common/header.jsp" %>
<html>
<body>
	<h2>Record Company Manager</h2>
	<form:form method="post" action="/music/recordcompany/create.htm" commandName="recordCompany">
		<table>
			<tr>
				<td><form:label path="recordCompanyName">Company Name:</form:label></td>
				<td><form:input path="recordCompanyName"/></td>
				<td><form:errors path="recordCompanyName" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Create Company">
				</td>
				<td>
					<a href="/music/home.htm">Home Page</a>
				</td>				
			</tr>
		</table>
	</form:form>
	

	<c:if test="${!empty recordCompanyList}">
		<h3>Record Companies on Record</h3>
		<table>
			<tr>
				<th>Company Name</th>
				<th>Albums</th>
				<th colspan="2"></th>	
			</tr>
			<c:forEach items="${recordCompanyList}" var="company">
				<tr>
					<td>${company.recordCompanyName}</td>
					<td><a href="/music/recordcompany/delete/${company.recordCompanyId}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>