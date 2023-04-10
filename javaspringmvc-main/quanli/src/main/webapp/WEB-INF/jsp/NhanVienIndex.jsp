

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<div class="container" style="height: 1000px;">
    <br>
  <h2 id="danhsach">Quản lí chuyến xe </h2></a>
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>Mã Chuyến</th>
        <th>Tên Chuyến</th>
        <th>Điểm Đi</th>
        <th>Điểm Đến</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Đặt cho khách</th>
        
      </tr>
    </thead>
    <tbody>
        <c:forEach var="cx" items="${chuyenxe}">
            <c:if test="${cx.soluong == 0}">
                <tr class="table-danger">
                    <td>${cx.idCX}</td>
                    <td>${cx.tenCX}</td>
                    <td>${cx.diemdi}</td>
                    <td>${cx.diemden}</td>
                    <td>${cx.giaghe}</td>
                    <td>${cx.soluong}</td>
                    <td><a class="btn btn-info"href="<c:url value="/chuyenxe/detail/${cx.idCX}"/>">Hết vé</a></td>
                </tr>
            </c:if>
            <c:if test="${cx.soluong != 0}">
                <tr >
                    <td>${cx.idCX}</td>
                    <td>${cx.tenCX}</td>
                    <td>${cx.diemdi}</td>
                    <td>${cx.diemden}</td>
                    <td>${cx.giaghe}</td>
                    <td>${cx.soluong}</td>
                    <td><a class="btn btn-info"href="<c:url value="/chuyenxe/detail/${cx.idCX}"/>">Đặt</a></td>
                </tr>
            </c:if>
        </c:forEach>
      
      
    </tbody>
  </table>
 
  </table>
</div>
