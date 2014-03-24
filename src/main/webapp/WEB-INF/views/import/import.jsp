<%@ include file="../common/header.jsp" %>
<html>
<body>
	<head>  
		<script type="text/javascript" src="jquery-1.2.6.min.js"></script>  
		<title>Import a File</title>  
	</head>  
	
	<h2>Upload a file to import.</h2>
	<form:form modelAttribute="importFile" action="/music/importfile.htm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td colspan="2"><form:input path="file" type="file" /></td>
			</tr>
			<tr>
				<td>
					<form:label path="fileType">File Type:</form:label>
				</td>
				<td>
					<form:select path="fileType">
						<form:option value="0" label="Choose File Type" />
						<form:options items="${fileTypes}" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit" id="upload">Upload File</button>
				</td>
				<td>
					<a href="/music/home.htm">Home Page</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>