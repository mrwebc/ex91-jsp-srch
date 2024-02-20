
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<body>
    <div id="wrap">
        <%@include file="./fragment/header.jsp" %>
    	
    	<section>
    		<h2>Home Page</h2>
            <ul>
                <li><a href="${contextPath}/board/write.jsp">게시글 등록</a></li>
                <li><a href="${contextPath}/board/list.do">리스트(검색+페이징)</a></li>
            </ul>
    	</section>

        <%@include file="./fragment/footer.jsp" %>
    </div>
</body>
</html>