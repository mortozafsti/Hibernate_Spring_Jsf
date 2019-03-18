<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<h1>
<a href="http://localhost:8008/crud6/list">Student List</a>
</h1>
  <h2>Horizontal form</h2>
  <form:form class="form-horizontal" action="login" method="POST" modelAttribute="student">
    
    
    <div class="form-group">
      <label class="control-label col-sm-2">Username:</label>
      <div class="col-sm-10">
      <form:input path="userName"/>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Password:</label>
      <div class="col-sm-10">
       <form:password path="password" />

      </div>
    </div>
    
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <form:button type="submit" class="btn btn-default">Submit</form:button>
      </div>
    </div>
  </form:form>
</div>

</body>
</html>