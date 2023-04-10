

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>

    <div class="contentright">
    
    <h1>Quản lí người dùng</h1>
    <form class="form-inline" action="">
    <input class="form-control mr-sm-2" type="text" name="name" placeholder="Tìm kiếm">
    <button class="btn btn-success" type="submit">Tìm</button>
    </form><br>
    <table class="table table-bordered" >
        <thead>
          <tr>
            <th>id</th>
            <th>Username</th>
            <th>Họ và tên</th>
            <th>số điện thoại</th>
            <th>email</th>
            <th>Ngày sinh</th>
            <th>Hành Động</th>
          </tr>
        </thead>
    <tbody>
       <c:forEach var="q" items="${mess}">   
            <tr>
                  <td>${q.id}</td>
                  <td>${q.username}</td>
                  <td>${q.hoten}</td>
                  <td>${q.sdt}</td>
                  <td>${q.email}</td>
                  <td>${q.ngaysinh}</td>
                  <td> 
                      <spring:url value="users/profile/${q.id}" var="profile"/>
                       <spring:url value="users/delete/${q.id}" var="delete"/>
                       <spring:url value="users/edit/${q.id}" var="edit"/>
                     <a class="btn btn-info" href="${profile}">Thông tin</a>
                     <a class="btn btn-primary" href="${edit}">Chỉnh sửa</a>
                      <a class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa? ')" href="${delete}">Xóa</a>
                  </td>
            </tr>
        </c:forEach>
    </tbody>
  </table>        
</div>


