

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container" style="height:1000px;">
     <h1>Chỉnh sửa</h1>
 
    <c:url value="/admin/edit" var="action" />
    <form action="${action}" method="post" class="was-validated" >
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
            <label for="ngaysinh">Hình Ảnh</label>
            <input type="text" id="ngaysinh"  name="hinhanh" value="${user.hinhanh}" class="form-control" readonly="true" required/>
        </div>
        <div class="form-group">
            <label for="userRole">Phân quyền</label>
            <select id="userRole"  name="userRole"class="form-control" required >
                <option value="ROLE_USER">Khách Hàng</option>
                <option value="ROLE_ADMIN">ADMIN</option>
                <option value="ROLE_NV">Nhân Viên</option>
                <option value="ROLE_TX">Tài Xế</option>
            </select>
            
        </div>
        <div class="form-group">
            <input type="submit" value="Chỉnh sửa" class="btn btn-primary mb-2"/>
        </div>
        <button type="button" class="btn btn-secondary"><a href="<c:url value="/admin/user" />">Quay lại</a></button>     
    </form>
</div>