<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<h2>�۾��� ����</h2>
		<form action="/update" method="post">
		<input type="hidden" name="idx" value="${list.idx} ">
		���� : <input type="text" name="title" value="${list.title}">
		���� : <textarea cols=30 rows=5 name=contents>${list.contents}</textarea>
	    <input type="hidden" value="${list.writer} ">
		
		<button type="submit">Ȯ��</button>
</body>
</html>