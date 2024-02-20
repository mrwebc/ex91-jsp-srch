<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
    <%@include file="./../fragment/header.jsp"%>
    <form action="${pageContext.request.contextPath}/board/writer.do" method="post">
    	<fieldset>
    		<legend>내용입력</legend>
    		<ul>
    			<li>
	                <label for="title">제목</label>
	                <input type="text" id="title" name="title" placeholder="제목을 입력하세요" />
    			</li>
    			<li>
	                <label for="content">본문내용</label>
	                <textarea name="content" id="content" cols="30" rows="3"></textarea>
    			</li>
    			<li>
	                <label for="writer">작성자</label>
	                <input type="text" name="writer" placeholder="작성자를 입력하세요" />
    			</li>
    		</ul>
    	</fieldset>
    	<p><button>등록</button></p>
    </form>
    <%@include file="./../fragment/footer.jsp"%>
</body>
</html>