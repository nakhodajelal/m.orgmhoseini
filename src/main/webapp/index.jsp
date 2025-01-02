<%@ page import="ir.maktab.filtertraning.model.dto.CreateUserResponse" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>filter training </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
</html>
<body>
<div class="container">
    <h1>Welcome To User Management System</h1>
    <% for (Cookie cookie : request.getCookies()) {
        if (cookie.getName().equals("admin") && cookie.getValue().equals("true")){
            System.out.println("test");
        }}%>
    <a href="./view/createNewUser.jsp">for create new user click here!</a>
    <a href="./view/login.jsp">Login</a>
    <br>


</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script>
    <%
      CreateUserResponse createUserResponse =(CreateUserResponse) request.getAttribute("createUserResponse");
      if(createUserResponse !=null){
  %>
    alert("user saved successfully!")
    <%}%>
</script>
</body>
