<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<div class="contentright">
     <div style="float: left">   
     <h1>Thêm phòng</h1>
 
 <c:url value="/admin/addphong" var="action" />
  <form:form method="post" action="${action}" modelAttribute="phong"  >
          <div class="form-group">
            <label for="tenPhong">Tên  Phòng</label>
            <form:input type="text" id="tenPhong" class="form-control" path="tenPhong"/>
        </div>      
        <div class="form-group">
            <label for="giaPhong">Giá</label>
            <form:input type="text" id="giaPhong" class="form-control" path="giaPhong"/>
            
        </div>
        <div class="form-group">
            <label for="loaiphong">Loại Phòng</label>
            <form:select id="loaiphong"  cssClass="form-control" path="loaiphong">
               <c:forEach var="p" items="${khachsan}">   
                   <option value="${p.idloaiphong}">${p.tenLoaiPhong}</option>
                 </c:forEach>
            </form:select>
        </div>
         <div class="form-group">
            <label for="khachsan">Loại Phòng</label>
            <form:select id="khachsan"  cssClass="form-control" path="khachsan">
               <c:forEach var="ks" items="${khachsans}">   
                   <option value="${ks.idkhachsan}">${ks.tenKS}</option>
                 </c:forEach>
            </form:select>
        </div>
         
         <div class="form-group">
            <input type="submit" class="btn btn-success" class="form-control" value="Gửi"/>
            <button type="button" class="btn btn-secondary"><a href="<c:url value="/admin/khachsan"/>">Quay lại</a></button> 
        </div>
  </form:form>      
    </div>
    <h1>Quản lí  Phòng</h1>
    <table class="table table-bordered" >
        <thead>
          <tr>
            <th>id</th>
            <th>Tên phòng</th>
            <th>Gía </th>
            <th>Tình trạng</th>
            <th>Loại Phòng</th>
            <th>Khach San</th>
            <th>Hành động</th>
            
          </tr>
        </thead>
    <tbody>
       <c:forEach var="q" items="${getphong}">   
            <tr>
                  <td>${q.idPhong}</td>
                  <td>${q.tenPhong}</td>
                  <td>${q.giaPhong}VND</td>
                  <td>${q.tinhTrang}</td>
                  <td>${q.loaiphong.tenLoaiPhong}</td>
                  <td>${q.khachsan.tenKS}</td>
                  <td>
                      
                      <button  type="button" class="btn btn-primary"><a href="<c:url value="/admin/phong/edit/${q.idPhong}"/>">Chỉnh sửa</a></button>
                      <button type="button" class="btn btn-danger"><a href="<c:url value="/admin/phong/delete/${q.idPhong}"/>">Xóa</a></button>
                  </td>
                 
                  
            </tr>
        </c:forEach>
    </tbody>
  </table>  
   
</div>
