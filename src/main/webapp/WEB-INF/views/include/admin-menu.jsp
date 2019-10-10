<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<ul class="admin-menu">
	<li><a href="${pageContext.servletContext.contextPath }/blog/admin-basic">기본설정</a></li>
	<li class="selected"><a href="${pageContext.servletContext.contextPath }/blog/admin-category">카테고리</a></li>
	<li><a href="${pageContext.servletContext.contextPath }/blog/admin-write">글작성</a></li>
</ul>