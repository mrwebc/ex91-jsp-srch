<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>a.on{color:red}</style>
</head>

  <c:set var="contextPath" value="${pageContext.request.contextPath}" />

  <c:set var="page" value="${pagiMaker.cri.page}" />
  <c:set var="spp" value="${pagiMaker.cri.spp}" />
  <c:set var="startPage" value="${pagiMaker.startPage}" />
  <c:set var="endPage" value="${pagiMaker.endPage}" />
  <c:set var="prev" value="${pagiMaker.prev}" />
  <c:set var="next" value="${pagiMaker.next}" />
        
<body>

    <%@include file="../fragment/header.jsp"  %>
    
    <h1>검색기능 리스트</h1>
    <p>
    
        <select class="srchType">
            <option <c:out value="${s_cri.srchType==null?'selected':''}" /> value="none">---</option>
            <option <c:out value="${s_cri.srchType eq 'title'?'selected':''}" /> value="title">제목</option>
            <option <c:out value="${s_cri.srchType eq 'content'?'selected':''}" /> value="content">내용</option>
            <option <c:out value="${s_cri.srchType eq 'writer'?'selected':''}" /> value="writer">작성자</option>
            <option <c:out value="${s_cri.srchType eq 'titleContent'?'selected':''}" /> value="titleContent">제목+컨텐츠</option>
            <option <c:out value="${s_cri.srchType eq 'contentWriter'?'selected':''}" /> value="contentWriter">컨텐츠+작성자</option>
            <option <c:out value="${s_cri.srchType eq 'titleContentWriter'?'selected':''}" /> value="titleContentWriter">제목+컨텐츠+작성자</option>
        </select>
        <input type="text" name="keyword" value="${s_cri.keyword}" />
        <select name="spp" class="spp">
            <option value="3">3</option>
            <option value="5">5</option>
            <option value="10">10</option>
        </select>
        <button type="button" class="btnSrch">조회</button>
        <button type="button" class="btnRegist">등록</button>
    </p>
    
    <script>
    const $btnSrch = document.querySelector(".btnSrch");
    const $btnRegist = document.querySelector(".btnRegist");
    const $srchType = document.querySelector(".srchType");
    const $keyword = document.querySelector("input[name='keyword']");
    const $spp = document.querySelector('.spp');
    
    $btnSrch.addEventListener("click", function(){
    	
    	const srchType = $srchType.value;
    	const keyword = $keyword.value;
    	const spp = $spp.value;
    	
        location.href = "./list.do?" 
               + 'spp='+spp+'&'
               + 'srchType='+srchType+'&'
               + 'keyword='+keyword;             
    });
    
    $btnRegist.addEventListener("click", function(){
        location.href = "./write.jsp";       
    });
    </script>
   
    <table>
        <thead>
            <tr>
                <th>No</th>
                <th>제목</th>
                <th>작성자</th>
                <th>등록일</th>
                <th>조회수</th>
            </tr>
        </thead>
        
  
        <tbody>
           <c:forEach items="${list}" var="dto">
            <tr>
                <th>${dto.bno}</th>
                <th>
                    <a href="${contextPath}/board/read.do?bno=${dto.bno}&page=${page}&spp=${spp}&srchType=${s_cri.srchType}&keyword=${s_cri.keyword}">${dto.title}</a>
                </th>
                <th>${dto.writer}</th>
                <th><fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd" /></th>
                <th>${dto.viewcnt}</th>
            </tr>
           </c:forEach>
        </tbody>
    </table>
    

    <div>
      <c:if test="${prev}">
           <a href="list.do?page=${startPage-1}&spp=${spp}&srchType=${s_cri.srchType}&keyword=${s_cri.keyword}">◀◀</a>
      </c:if>
      <c:if test="${!prev}">
           <span>◀◀</span>
      </c:if>
      
      <c:if test="${page gt startPage}">
           <a href="list.do?page=${page-1}&spp=${spp}&srchType=${s_cri.srchType}&keyword=${s_cri.keyword}">◀</a>
      </c:if>      
      
      <c:if test="${page le startPage}">
           <span>◀</span>
      </c:if>
      
      
      
      <c:forEach var="idx" begin="${startPage}" end="${endPage}">
        <a 
         <c:out value="${idx==page ? 'class=on' : ''}" />
         href="list.do?page=${idx}&spp=${spp}&srchType=${s_cri.srchType}&keyword=${s_cri.keyword}">${idx}</a>
      </c:forEach>
      

      
      <c:if test="${page ge endPage}">
           <span>▶</span>
      </c:if>
    
      <c:if test="${page lt endPage}">
           <a href="list.do?page=${page+1}&spp=${spp}&srchType=${s_cri.srchType}&keyword=${s_cri.keyword}">▶</a>           
      </c:if>      
                
      <c:if test="${next}">
           <a href="list.do?page=${endPage+1}&spp=${spp}&srchType=${s_cri.srchType}&keyword=${s_cri.keyword}">▶▶</a>
      </c:if>
      <c:if test="${!next}">
           <span>▶▶</span>
      </c:if>

    </div>
    
    <p><a href="${contextPath}/board/list.do">목록보기</a></p>
    
    
    <%@include file="../fragment/footer.jsp"  %>

</body>
</html>