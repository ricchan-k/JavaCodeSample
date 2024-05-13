<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>

<% if (request.getParameter("error") != null) { %>
    <p>ユーザ名またはパスワードが違います</p>
<% } %>

<form action="LoginServlet" method="post">
    <div>
        <label for="userId">ユーザーID:</label>
        <input type="text" id="userId" name="userId" required>
    </div>
    <div>
        <label for="password">パスワード:</label>
        <input type="password" id="password" name="password" required>
    </div>
    <div>
        <button type="submit">ログイン</button>
    </div>
</form>
</body>
</html>