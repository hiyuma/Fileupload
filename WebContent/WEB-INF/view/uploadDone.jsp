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

<p>「<c:out value="${filename}" />」を保存しました。</p>
<a href="UploadServlet">戻る</a>
</body>
</html>