<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<h1 class="logo">JBlog</h1>
<ul class="menu">
	<c:choose>
		<c:when test="${empty authUser }">
			<li><a href="${pageContext.servletContext.contextPath }/user/login">�α���</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/user/join">ȸ������</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${pageContext.servletContext.contextPath }/user/logout">�α׾ƿ�</a></li>
			<li><a href="${pageContext.servletContext.contextPath }/blog/${authUser.id}/main/">����α�</a></li>
		</c:otherwise>
	</c:choose>


</ul>
