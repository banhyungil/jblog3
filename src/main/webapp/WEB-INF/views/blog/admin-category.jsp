<%@page import="kr.co.itcen.jblog.vo.BlogVo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<%pageContext.setAttribute("contextPath", request.getContextPath());
  pageContext.setAttribute("userId", ((BlogVo)request.getAttribute("blogVo")).getUserId());%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="${contextPath }/assets/js/admin-category.js?ver=14"></script>
</head>
<body>
	<!-- 비동기 통신을 위한 데이터 -->
	<input type="hidden" id="catListLength" value="${fn:length(categoryList) }">
	<input type="hidden" id=contextPath value="${contextPath }">
	<input type="hidden" id=userId value="${userId }">
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/head.jsp"/>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/include/admin-menu.jsp"/>
		      	<table class="admin-cat" id="category-list">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		<c:forEach items='${categoryList }' var='vo' varStatus='status'>
		      			<tr>
							<td>${status.count }</td>
							<td>${vo.name }</td>
							<td>${vo.postCount }</td>
							<td>${vo.description }</td>
							<td>
							<img src="${pageContext.request.contextPath}/assets/images/delete.jpg" 
							id="${vo.no }" onclick="deleteCategory()">													
							</td>
						</tr>  
		      		</c:forEach>		  
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
      			<form id="form-cat-add">
      				<table id="admin-cat-add">
			      		<tr>
			      			<td class="t">카테고리명</td>
			      			<td><input type="text" name="name"></td>
			      		</tr>
			      		<tr>
			      			<td class="t">설명</td>
			      			<td><input type="text" name="description"></td>
			      		</tr>
			      		<tr>
			      			<td class="s">&nbsp;</td>
			      			<td><input type="button" value="카테고리 추가" onclick="addCategory()"></td>
			      		</tr>      		      		
			      	</table> 
      			</form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>