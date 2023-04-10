

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="img-fluid" style="background-size: 100% 100%; background-repeat: no-repeat;background-image: url('https://vn.blog.kkday.com/wp-content/uploads/blogcover-1.jpg');">
<div class="container" style="height:860px;">
     <h1>Đăng Ký</h1>
 <form:errors path="*" cssClass="alert alert-danger" element="div"></form:errors>
    <c:url value="/register" var="action" />
     <form action="${action}" method="post" class="was-validated">
        <div class="form-group">
            <label for="username">Tên đăng nhập</label>
            <input type="text" id="username" name="username" class="form-control" required/>
            <form:errors path="username" element="div" cssClass="text-danger"/> 
            <div > <p Class="alert alert-danger">${error}</p></div>
        </div>
        <div class="form-group">
            <label for="password">password</label>
            <input type="password" id="password" name="password" class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="hoten">Họ và tên</label>
            <input type="text" id="hoten" name="hoten" class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="password" name="email"  class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="sdt">Số điện thoại</label>
            <input type="tel" pattern="[0]{1}[0-9]{9}" id="sdt" name="sdt" class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="ngaysinh">Ngày Sinh</label>
            <input type="date" id="ngaysinh"  name="ngaysinh"  class="form-control" required/>
        </div>
        
        <div class="form-group">
            <input type="submit" value="Đăng kí" class="form-control btn btn-primary mb-2"/>
        </div>
        
    </form>
</div>
</div>
