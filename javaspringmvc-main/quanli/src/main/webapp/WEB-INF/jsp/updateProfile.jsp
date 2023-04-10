
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<div class="container">
    <c:forEach var="user" items="${user}">
        
        <form action="<c:url value="/profile/update"/>" method="post" enctype="multipart/form-data" class="was-validated" >
         <div class="form-group">
            <label for="id">id   </label>
            <input type="text" id="id" name="id" readonly="true" value="${user.id}" class="form-control" required/>
           
        </div>
        <div class="form-group">
            <label for="username">username</label>
            <input type="text" id="username" name="username" readonly="true" value="${user.username}" class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="password">password</label>
            <input type="password" id="password" name="password" value="${user.password}" class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="hoten">Họ và tên</label>
            <input type="text" id="hoten" name="hoten" value="${user.hoten}" class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" id="password" name="email" value="${user.email}" class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="sdt">Số điện thoại</label>
            <input type="text" id="sdt" name="sdt" value="${user.sdt}" class="form-control" required/>
        </div>
        <div class="form-group">
            <label for="ngaysinh">Ngày Sinh</label>
            <input type="date" id="ngaysinh"  name="ngaysinh" value="${user.ngaysinh}" class="form-control" required/>
            
        </div>
            <div class="form-group">
            <label for="ngaysinh">Ảnh đại diện</label>
            <br>
            <input type="file" cssClass="form-control" name="file" required/>
        </div>
            
        <div class="form-group">
            <input type="submit" value="Chỉnh sửa" class="btn btn-primary mb-2"/>
        </div>
        <a class="btn btn-secondary" href="<c:url value="/profile/${pageContext.request.userPrincipal.name}"/>">Quay lại</a>   
    </form>
    </c:forEach>
</div>
