<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	<div>총 건수 : <span value="${ boards.getTotalElements }"></span></div>
	 <div id="app" style='font-size:0.5em; '>
	 		<form action="list" method="GET">
            <table class="fqa_tbl" id='lists' style='width:1000px; align=center;text-align:center; '>
	            <tr style='text-align:left;font-size:2em'>
	            <td><p style='margin:0 auto; font-size:2em;text-align:left;'>Notice</p></td>
	            <td>
	            <div class="flt_l">
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
	            <c:forEach items="${list}" var="item" varStatus="status" begin="0" end="40" step="1" >
<!-- 	            <tr v-for="(item,idx) in list" :key=idx> -->
	                <td>${ status.index+1 }</td>
	                <td>${ item.writer }</td>
	                <td><a href="/detail/${item.idx}">${ item.title }</a></td>
	            </tr>
	            </c:forEach>
	            <tr>
	                <td style='text-align:right;'></td>
	              <td style='align:right;font-size:2em'>
	                  <c:if test="${startyes eq 1}">
	                  <a  style='color:black;' href=list?pageNum=${back}">[이전]</a>
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
					</form>
	                <td style='float:right; width:71px'>
<!-- 	                <button @click="write">글쓰기</button> -->
 						<a class=a href="write.do">글쓰기</a>
	                </td>
	            </tr>

            </table>
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