

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<div class="container">
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
                    <a class="btn btn-info"href="<c:url value="/nhanvien/hoadon/tour/detail/${t.id}"/>">Thông tin</a>
                      <a class="btn btn-primary" href="<c:url value="/nhanvien/hoadon/tour/update/${t.id}"/>">Chỉnh sửa</a>
                     <a class="btn btn-danger" href="<c:url value="/nhanvien/hoadon/tour/xoa/${t.id}"/>">Xóa</a>
                  </td>
            </tr>
        </c:forEach>
     </tbody>
     </table>  
</div>
