<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<div class="contentright">
    
    <h1>Quản lí Loại Phòng</h1>
    <table class="table table-bordered" >
        <thead>
          <tr>
            <th>id</th>
            <th>Tên loại phòng</th>
            <th>Hành động</th>
            
          </tr>
        </thead>
    <tbody>
       <c:forEach var="q" items="${khachsan}">   
            <tr>
                  <td>${q.idloaiphong}</td>
                  <td>${q.tenLoaiPhong}</td>
                  <td>
                      
                      <button  type="button" class="btn btn-primary"><a href="">Chỉnh sửa</a></button>
                      <button type="button" class="btn btn-danger"><a href="<c:url value="/admin/loaiphong/delete/${q.idloaiphong}"/>">Xóa</a></button>
                  </td>
                  
            </tr>
        </c:forEach>
    </tbody>
  </table>  
  
     <h1>Thêm loại phòng</h1>
 
    <c:url value="/admin/addloaiphong" var="action" />
    <form action="${action}" method="post" style="    float: left">
        <div class="form-group">
            <label for="tenLoaiPhong">Tên Loại Phòng</label>
            <input type="text" id="tenLoaiPhong" class="form-control" name="tenLoaiPhong"/>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-success" class="form-control" value="Gửi"/>
            <button type="button" class="btn btn-secondary"><a href="<c:url value="/admin/khachsan"/>">Quay lại</a></button> 
        </div>
    </form>
          
</div>
