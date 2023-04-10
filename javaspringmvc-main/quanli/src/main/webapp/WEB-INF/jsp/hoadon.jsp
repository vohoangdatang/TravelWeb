

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<div class="contentright">
       <ul class="list-group">
    <li class="list-group-item">
      <button class="btn btn-primary" data-toggle="collapse" data-target="#demo">Hóa đơn Khách Sạn</button>
      <br>
    </li>
    <li class="list-group-item">
    <button class="btn btn-primary" data-toggle="collapse" data-target="#demo1">Hóa đơn Tour</button>
    </li>
   
  </ul>
  
    <div id="demo" class="collapse">
    <h1>Quản lí Hóa Đơn Khách Sạn</h1>
    <table class="table table-bordered" >
        <thead>
          <tr>
            <th>id</th>
            <th>Tên người đặt</th>
             <th>Email</th>
             <th>SĐT</th>
             <th>Ngày đặt</th>
             <th>Tổng Tiền</th>
              <th>Phương Thức</th>
              <th>Tình trạng</th>
             <th>Hành động</th>
            
          </tr>
        </thead>
    <tbody>
       <c:forEach var="t" items="${hoadon}">   
            <tr>
                 <td>${t.id}</td>
                  <td>${t.hoten}</td>
                  <td>${t.email}</td>
                  <td>${t.sdt}</td>
                  <td>${t.ngaytao}</td>
                  <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${t.tongtien}"/></td>
                  <td>${t.phuongthuc}</td>
                  <td>${t.tinhtrang}</td>
                  <td>
                    <a class="btn btn-info"href="<c:url value="/admin/hoadon/detail/${t.id}"/>">Thông tin</a>
                      <a class="btn btn-primary" href="<c:url value="/admin/hoadon/update/${t.id}"/>">Chỉnh sửa</a>
                     <a class="btn btn-danger" href="<c:url value="/admin/hoadon/xoa/${t.id}"/>">Xóa</a>
                  </td>
            </tr>
        </c:forEach>
     </tbody>
     </table>  
    </div>
 <div id="demo1" class="collapse">
    <h1>Quản lí Hóa Đơn Tour</h1>
    <table class="table table-bordered" >
        <thead>
          <tr>
            <th>id</th>
            <th>Tên người đặt</th>
             <th>Email</th>
             <th>SĐT</th>
             <th>Ngày đặt</th>
             <th>Tổng Tiền</th>
              <th>Phương Thức</th>
              <th>Tình trạng</th>
             <th>Hành động</th>
            
          </tr>
        </thead>
    <tbody>
       <c:forEach var="t" items="${dontour}">   
            <tr>
                 <td>${t.id}</td>
                  <td>${t.hoten}</td>
                  <td>${t.email}</td>
                  <td>${t.sdt}</td>
                  <td>${t.ngaytao}</td>
                  <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${t.tongtien}"/></td>
                  <td>${t.phuongthuc}</td>
                  <td>${t.tinhtrang}</td>
                  <td>
                    <a class="btn btn-info"href="<c:url value="/admin/hoadon/tour/detail/${t.id}"/>">Thông tin</a>
                      <a class="btn btn-primary" href="<c:url value="/admin/hoadon/tour/update/${t.id}"/>">Chỉnh sửa</a>
                     <a class="btn btn-danger" href="<c:url value="/admin/hoadon/tour/xoa/${t.id}"/>">Xóa</a>
                  </td>
            </tr>
        </c:forEach>
     </tbody>
     </table>  
    </div>
</div>