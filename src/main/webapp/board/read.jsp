<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<body>
    <h1>게시글 상세내용</h1>
    
    <ul>
        <li>제목 : ${dto.title}</li>
        <li>내용 : ${dto.content}</li>
        <li>작성자 : ${dto.writer}</li>
        <li>등록일 : <fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm"/></li>
        <li>조회수 : ${dto.viewcnt}</li>
    </ul>
    
    <p>
        <a href="${contextPath}/board/update.do?bno=${dto.bno}&page=${page}&spp=${spp}&srchType=${srchType}&keyword=${keyword}">수정</a> <br />
        <a href="${contextPath}/board/delete.do?bno=${dto.bno}&page=${page}&spp=${spp}&srchType=${srchType}&keyword=${keyword}">삭제</a> <br />
        <a href="${contextPath}/board/list.do?page=${page}&spp=${spp}&srchType=${srchType}&keyword=${keyword}">목록보기</a>
    </p>
</body>
</html>