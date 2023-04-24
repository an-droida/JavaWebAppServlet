<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>My Posts</h1>
<hr>
<h2>Create a New Post</h2>
<form method="post" action="<%= request.getContextPath() %>/posts">
    <label for="title">Title:</label><br>
    <input type="text" id="title" name="title"><br>
    <label for="author">Author:</label><br>
    <input type="text" id="author" name="author"><br>
    <label for="content">Content:</label><br>
    <textarea id="content" name="content"></textarea><br>
    <input type="submit" value="Create Post">
</form>
<hr>
<h2>All Posts</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Content</th>
        <th>Created At</th>
    </tr>
    <c:forEach var="post" items="${posts}" >
        <tr>
            <td>${post.id}</td>
            <td>${post.title}</td>
            <td>${post.author}</td>
            <td>${post.content}</td>
            <td>${post.createdAt}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>