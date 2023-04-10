

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<div class="contentright">
    
    <h1>Quản lí Khách Sạn</h1>
    <form class="form-inline" action="">
    <input class="form-control mr-sm-2" type="text" name="name" placeholder="Tìm kiếm">
    <button class="btn btn-success" type="submit">Tìm</button>
    </form><br>
    <button type="button" class="btn btn-primary"><a href="<c:url value="/admin/phong"/>">Thêm Phòng</a></button>
    <button type="button" class="btn btn-primary"><a href="<c:url value="/admin/loaiphong"/>">Thêm Loại Phòng</a></button>
    <a class="btn btn-primary" href="<c:url value="/admin/khachsan/add"/>">Thêm Khách Sạn</a>
    <table class="table table-bordered" >
        <thead>
          <tr>
            <th>id</th>
            <th>Tên Khách Sạn</th>
            <th>Thành Phố</th>
             <th>Địa chỉ</th>
             <th>Hành Động</th>
            
          </tr>
        </thead>
    <tbody>
       <c:forEach var="q" items="${khachsan}">   
            <tr>
                  <td>${q.idkhachsan}</td>
                  <td>${q.tenKS}</td>
                  <td>${q.thanhPho}</td>
                  <td>${q.diachi}</td>
                  <td>
                      <a class="btn btn-info"href="<c:url value="/khachsan/detail/${q.idkhachsan}"/>">Thông tin</a>
                      <a class="btn btn-primary" href="<c:url value="/admin/khachsan/update/${q.idkhachsan}"/>">Chỉnh sửa</a>
                     <a class="btn btn-danger" href="<c:url value="/admin/khachsan/delete/${q.idkhachsan}"/>">Xóa</a>
                  </td>
            </tr>
        </c:forEach>
    </tbody>
  </table>  
    
</div>
