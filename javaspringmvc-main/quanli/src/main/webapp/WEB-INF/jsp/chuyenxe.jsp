
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="contentright">
    
    <h1>Quản lí chuyến xe</h1>
    
    <a class="btn btn-primary" href="<c:url value="/admin/add/chuyenxe"/>">Thêm chuyến xe</a>
    <table class="table table-bordered" >
        <thead>
          <tr>
            <th>id</th>
            <th>Tên chuyến </th>
             <th>Điểm đi</th>
             <th>Điểm đến</th>
             <th>Ngày đi</th>
             <th>Giá</th>
             <th>Số lượng</th>
             <th>Tài xế</th>
             <th>Hành Động</th>
          </tr>
        </thead>
    <tbody>
       <c:forEach var="q" items="${chuyenxe}">   
            <tr>
                  <td>${q.idCX}</td>
                  <td>${q.tenCX}</td>
                  <td>${q.diemdi}</td>
                  <td>${q.diemden}</td>
                  <td>${q.ngaydi}</td>
                  <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${q.giaghe}"/> VND</td>
                  <td>${q.soluong}</td>
                   <td>${q.user.hoten}</td>
                  <td>
                      <a class="btn btn-info"href="<c:url value="/chuyenxe/detail/${q.idCX}"/>">Thông tin</a>
                      <a class="btn btn-primary" href="<c:url value="/admin/edit/chuyenxe/${q.idCX}"/>">Chỉnh sửa</a>
                     <a class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa? ')" href="<c:url value="/admin/delete/chuyenxe/${q.idCX}"/>">Xóa</a>
                  </td>
            </tr>
        </c:forEach>
    </tbody>
  </table>  
    
</div>
