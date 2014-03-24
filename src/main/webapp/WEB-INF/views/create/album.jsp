<%@ include file="../common/header.jsp" %>
<html>
<body>
	<h2>Album Manager</h2>
	<form:form method="post" action="/music/create-album.htm" commandName="album">
		<table>
			<tr>
				<td><form:label path="albumName">Album Name:</form:label></td>
				<td><form:input path="albumName"/></td>
				<td><form:errors path="albumName" /></td>
			</tr>
			<tr>
				<td>
					<form:label path="singer">Singer:</form:label>
				</td>
				<td>
					<form:select path="singer.singerId">
						<form:option value="0" label="Choose Singer" />
						<form:options items="${singerList}" itemLabel="name" itemValue="singerId"/>
					</form:select>
				</td>
				<td>
					<a href="/music/singer.htm">New Singer</a>
				</td>
				<td><form:errors path="singer" class="error" /></td>
			</tr>
			<tr>
				<td><form:label path="releaseYear">Album Release Year:</form:label></td>
				<td><form:input path="releaseYear"/></td>
				<td><form:errors path="releaseYear" class="error" /></td>
			</tr>
			<tr>
				<td>
					<form:label path="recordCompany">Record Company:</form:label>
				</td>
				<td>
					<form:select path="recordCompany.recordCompanyId">
						<form:option value="0" label="Choose RecordCompany" />
						<form:options items="${recordCompanyList}" itemLabel="recordCompanyName" itemValue="recordCompanyId" />
					</form:select>
				</td>
				<td>
					<a href="/music/record-company.htm">New Record Company</a>
				</td>
				<td><form:errors path="recordCompany" class="error" /></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Create Album">
				</td>
				<td>
					<a href="/music/home.htm">Home Page</a>
				</td>
			</tr>
		</table>
	</form:form>
	

	<c:if test="${!empty albumList}">
		<h3>Albums on Record</h3>
		<table>
			<tr>
				<th>Album Name</th>
				<th>Singer</th>
				<th>Release Year</th>
				<th>Company</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${albumList}" var="album">
				<tr>
					<td>${album.albumName}</td>
					<td>${album.singer.name}</td>
					<td>${album.releaseYear}</td>
					<td>${album.recordCompany.recordCompanyName}</td>
					<td><a href="delete-album/${album.albumId}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>