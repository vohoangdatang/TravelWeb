

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="img-fluid" style="background-size: 100% 100%; background-repeat: no-repeat;background-image: url('https://vn.blog.kkday.com/wp-content/uploads/blogcover-1.jpg');">
    <div class="container" style="height:860px;">
   
    <c:if test="${param.error !=null}">
    <div class="alert alert-danger">
    <strong>Warning!</strong>Đã có lỗi xảy ra!!!
  </div>
    </c:if>
    <c:if test="${param.accessDeined !=null}">
    <div class="alert alert-danger">
        <p>Ban khong du quyen truy cap</p>
    </div>
    </c:if>
    <h1>Đăng Nhập</h1>
     
    <c:url value="/login" var="action" />
    <form action="${action}" method="post">
        <div class="form-group">
            <label for="username">username</label>
            <input type="text" id="username"class="form-control" name="username"/>
        </div>
        <div class="form-group">
            <label for="password">password</label>
            <input type="password" id="password" class="form-control"name="password"/>
        </div>
        <div class="form-group">

            <input type="submit" class="form-control btn-success" value="Đăng Nhập"/>
        </div>
    </form>
   
</div>
</div>
