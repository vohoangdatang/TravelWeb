

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
    <h1>Thông tin người dùng</h1>
    <div class="card" style="width:500px">
    <img class="card-img-top" src="${user.hinhanh}" alt="Card image">
    <div class="card-body">
        <h2>ID: <small>${user.id}</small></h2>
        <h2>Username: <small>${user.username}</small></h2>
        <h2>Password: <small>${user.password}</small></h2>
        <h2>Họ và tên:<small>${user.hoten}</small></h2>
        <h2>Ngày sinh:<small>${user.ngaysinh}</small></h2>
        <h2>Số điện thoại:<small>${user.sdt}</small></h2>
        <h2>Email: <small>${user.email}</small></h2>
    </div>
    </div>
        <button type="button" class="btn btn-secondary"><a href="<c:url value="/admin/user"/>">Quay lại</a></button>   
</div>
       