<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판목록</title>
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/base/base.css?after">
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href=css/style.css>
<<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.5.0.js"></script> -->
<body>
	<div>총 건수 : <span value="${ Page.getTotalElements }"></span></div>
	 	<div id="app" style='font-size:0.5em; '>
	 		<form action="list" method="GET">
            <table class="fqa_tbl" id='lists' style='width:1000px; align=center;text-align:center; '>
	            <tr style='text-align:left;font-size:2em'>
	            <td><p style='margin:0 auto; font-size:2em;text-align:left;'>Notice</p></td>
	            <td>
	            <div>
                      <select id="searchType1" name="searchType">
                         <option value="01">제목</option>
                         <option value="02">작성자</option>
                      </select>
             	</div>
	            	<input type=text name="keyWord" id="keyWord1" ></td>
	            <td><input type=button name="goSearch" onclick="Search()" value="검색"></td>
	            </tr>
	            <tr>
	                <tr class=table_tr>
	                <th class='fqa_tbl_title1' align=center style='width:50px'>번호</th>
	                <th style='width:100px'>작성자</th>
	                <th style='width:1000px'>제목</th>
	            </tr>
	             <c:forEach items="${list}" var="dao" varStatus="status" begin="0" end="20" step="1" >
                        <tr >
                            <td align=center>${status.index+1}</td>
                            <td>${dao.writer}</td>
                            <td><a style='color:black' href="/detail/${dao.idx}">${dao.title}</a></td>
                        </tr>
                        </c:forEach>
<%-- 	            <c:forEach items="${list}" var="item" varStatus="status" begin="0" end="20" step="1" > --%>
<!-- <!-- 	            <tr v-for="(item,idx) in list" :key=idx> --> -->
<!-- 				<tr> -->
<%-- 	                <td>${ status.index+1 }</td> --%>
<%-- 	                <td>${ item.writer }</td> --%>
<%-- 	                <td><a href="/detail/${item.idx}">${ item.title }</a></td> --%>
<!-- 	            </tr> -->
<%-- 	            </c:forEach> --%>


	            <tr>
		            <td style='float:right; width:71px'>
	<!-- 	            <button @click="write">글쓰기</button> -->
						<a href="write.do">글쓰기</a>
						<div>

 				<tr >
	                <td style='text-align:right;'></td>
		            <td style='align:right;font-size:2em'>
	                <c:if test="${startyes eq 1}">
	                <a  style='color:black;' href="list?pageNum=${back}">[이전]</a>
	                </c:if>
	                <ul class=pageNum>
	             	<c:forEach items='${num}' var='n'>
	                	<li><a href='list?pageNum=${n}' id="${n}">${n}</a></li>
	                </c:forEach>
               		 </ul>
                	<c:if test="${endno eq 1}">
               			 <a  style='color:black;' href="list?pageNum=${nexts}">[다음]</a>
              		 </c:if>
              		 </td>
         	     </tr>
<%-- 				            <c:if test="${0 ne Page.totalPages}"> --%>
<!-- 				            <a onClick="goPaging(0)">처음</a> -->
<%-- 				            </c:if> --%>
<%-- 				            <c:if test="${!Page.first}"> --%>
<%-- 				               <a onClick="goPaging(${Page.number-1})">이전</a> --%>
<%-- 				            </c:if> --%>
<%-- 				            <c:if test="${Page.totalPages >= 1 }"> --%>
<%-- 				            <c:forEach var="i" begin="0" end="${Page.totalPages-1}"> --%>
<%-- 				               <c:if test="${i eq Page.number}"> --%>
<%-- 				                  <a>${i+1}</a> --%>
<%-- 				               </c:if> --%>
<%-- 				               <c:if test="${i ne Page.number}"> --%>
<%-- 				                  <a onClick="goPaging(${i})" >${i+1}</a> --%>
<%-- 				               </c:if> --%>
<%-- 				            </c:forEach> --%>
<%-- 				            </c:if> --%>
<%-- 				            <c:if test="${!Page.last}"> --%>
<%-- 				               <a onClick="goPaging(${Page.number+1})">다음</a> --%>
<%-- 				            </c:if> --%>
<%-- 				            <c:if test="${Page.totalPages >= 1 }"> --%>
<%-- 				               <a onClick="goPaging(${Page.totalPages-1})">마지막</a> --%>
<%-- 				            </c:if> --%>
				        </div>
	                </td>
                </tr>
            </table>
            </form>
        </div>

<%-- /<%@ include file="/WEB-INF/views/list.jspf" %> --%>
<script>
$(function() {




});

// var searchType = "${searchType}";
// var searchKeyWord = "${keyWord}";
// console.log("searchType"+searchType)
// console.log("searchKeyWord"+searchKeyWord)



function Search(){
    var searchType = $("#searchType1 option:selected").val();
    var keyWord = $("#keyWord1").val();
    var getUrlParameter = "";
     console.log(keyWord);


//     if(keyWord == ''){
//        alert("검색어를 입력해주세요.");
//        return false;
//     }


//      location.href = "/list_test?keyWord="+keyWord+"&searchType="searchType;
        location.href = "/list_test?searchType=" + searchType + "&keyWord=" + keyWord;
 }

function abc(){
	alert("hello")
}

</script>
</body>
</html>