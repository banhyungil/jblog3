<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>${blogVo.title }</h1>
			<ul>
			<c:choose>
				<c:when test="${empty authUser }">
					<li><a href="${pageContext.servletContext.contextPath }/user/auth">로그인</a></li>				
				</c:when>
				<c:otherwise>	
					<li><a href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
					<c:if test="${isBlogOwner }">
						<li><a href="${pageContext.servletContext.contextPath }/blog/admin-basic/${blogVo.userId}">블로그 관리</a></li>
					</c:if>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${postVo.title }</h4>
					<p>${postVo.contents }<p>
				</div>
				<ul class="blog-list">
				<c:forEach items='${postList }' var='vo'>
					<li><a href="${pageContext.servletContext.contextPath }/blog/main/${blogVo.userId }/${vo.categoryNo }/${vo.no }">${vo.title }</a> <span>${vo.regDate}</span>	</li>
				</c:forEach>
					
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/images/${blogVo.logo}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items='${categoryList }' var='vo'>
					<li><a href="${pageContext.servletContext.contextPath }/blog/main/${vo.userId}/${vo.no}">${vo.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>