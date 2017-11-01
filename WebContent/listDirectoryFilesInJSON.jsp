<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
[
	<c:forEach var="iEntry" items="${sessionScope.CurrentDirectoryFiles}" varStatus="status">
		<c:set var="fileType" value="file" />
		<c:if test="${iEntry.getAttrs().isDir()}">
			<c:set var="fileType" value="folder" />
		</c:if>
		<c:if test="${iEntry.getAttrs().isLink()}">
			<c:set var="fileType" value="link" />
		</c:if>
		<c:if test="${status.count > 1}">
			,
		</c:if>
		{
			"filename":"${iEntry.getFilename()}",
			"type":"${fileType}",
			"lastMTime":"${iEntry.getAttrs().getMtimeString()}",
			"size":"${iEntry.getAttrs().getSize()}"
		}
	</c:forEach>
]