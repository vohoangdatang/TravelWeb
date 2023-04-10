<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="contentright">
    <c:forEach var="user" items="${user}">
        <h1>Thông tin người dùng</h1>
    <div>
        <h2>ID: <small>${user.id}</small></h2>
        <h2>Username: <small>${user.username}</small></h2>
        <h2>Password: <small>${user.password}</small></h2>
        <h2>Họ và tên:<small>${user.hoten}</small></h2>
  
        <h2>Ngày sinh:<small>${user.ngaysinh}</small></h2>
        <h2>Số điện thoại:<small>${user.sdt}</small></h2>
        <h2>Email: <small>${user.email}</small></h2>
    </div>
    </c:forEach>
     
</div>