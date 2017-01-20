<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="kr" >
<head>
<link rel="icon" type="image/png" href="/images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><t:insertAttribute name="title" /></title>

<t:insertAttribute name="template"/>

</head>

<body id="mimin" class="dashboard">
		<t:insertAttribute name="header"/>
		 <div class="container-fluid mimin-wrapper">
		<t:insertAttribute name="left"/>
  		<t:insertAttribute name="body"/>
  		</div>
</body>
</html>

