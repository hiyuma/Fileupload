<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ファイルアップロード</title>
</head>

<body>
<h1>ファイルアップロード</h1>

<p>画像をアップロードしてください</p>
<form action="" method="post" enctype="multipart/form-data">
<!-- enctypeの属性指定が無いとファイルが送信されないので注意 -->
<p>ファイル：<input type="file" name="upfile" /></p>
<p><input type="submit" value="アップロード"></p>
</form>

<h2>画像一覧</h2>
<c:forEach var="file" items="${fileList}">
<img alt="" src="uploads/<c:out value="${file.name}"/>" height="200" />
</c:forEach>

</body>
</html>