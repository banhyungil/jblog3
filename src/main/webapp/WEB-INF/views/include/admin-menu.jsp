<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<ul class="admin-menu">
	<li><a href="${pageContext.servletContext.contextPath }/blog/${blogVo.userId}/admin-basic/">�⺻����</a></li>
	<li class="selected"><a href="${pageContext.servletContext.contextPath }/blog/${blogVo.userId}/admin-category">ī�װ�</a></li>
	<li><a href="${pageContext.servletContext.contextPath }/blog/${blogVo.userId}/admin-write">���ۼ�</a></li>
</ul>