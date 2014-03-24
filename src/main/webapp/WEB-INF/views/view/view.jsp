<%@ include file="../common/header.jsp" %>
<h1>View Results</h1>

<div>
	<c:if test=${type == 'album'}>
		<c:forEach items="${albums}" var="album">
			<display:table name="">
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
			</display:table>
		</c:forEach>
	</c:if>
	
	<c:if test=${type == 'singer'}>
		<c:forEach items="${singers}" var="singer">
			<display:table name="">
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
			</display:table>		
		</c:forEach>
	</c:if>
	
	<c:if test=${type == 'company'}>
		<c:forEach items="${companies}" var="company">
			<display:table name="">
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
			</display:table>		
		</c:forEach>
	</c:if>
	
	<c:if test=${type == 'user'}>
		<c:forEach items="${users}" var="user">
			<display:table name="">
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
				<display:column property="" title="" />
			</display:table>		
		</c:forEach>
	</c:if>
</div>