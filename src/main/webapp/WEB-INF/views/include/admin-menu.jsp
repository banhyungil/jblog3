<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<ul class="admin-menu">
	<li><a href="${pageContext.servletContext.contextPath }/blog/admin-basic/${blogVo.userId}">�⺻����</a></li>
	<li class="selected"><a href="${pageContext.servletContext.contextPath }/blog/admin-category/${blogVo.userId}">ī�װ�</a></li>
	<li><a href="${pageContext.servletContext.contextPath }/blog/admin-write/${blogVo.userId}">���ۼ�</a></li>
</ul>