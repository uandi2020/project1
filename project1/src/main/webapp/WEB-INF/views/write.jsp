<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>글쓰기 등록</h2>
	<form action="/write.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="writer" value="test">
		제목 : <input type="text" name="title">
		내용 : <textarea cols=30 rows=5 name=contents></textarea>
		    <div class="container">
			<input type="file" name="files">
			<!-- 여기서 files는 controller에 @RequestPart MultipartFile files -->
		<button type="submit">확인</button>
	</form>
</body>
</html>