package com.exam.assignment;

import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.exam.assignment.models.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "posts", value = "/posts")
public class PostsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String content = request.getParameter("content");
        LocalDateTime now = LocalDateTime.now();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "password");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO posts (title, author, content, created_at) VALUES (?, ?, ?, ?)");
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, content);
            stmt.setTimestamp(4, Timestamp.valueOf(now));
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/posts");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> posts = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "password");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM posts");
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                Post post = new Post(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("author"),
                        result.getString("content"),
                        result.getTimestamp("created_at")
                );
                posts.add(post);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }



}