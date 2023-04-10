<%-- 
    Document   : lichsu
    Created on : Sep 28, 2021, 12:29:16 PM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<div class="contentright">
    
    
  
    <div id="demo1" >
        <h1>Lịch Sử Đặt Hàng Của Bạn</h1>
    <table class="table table-bordered" >
        <thead>
          <tr>
            <th>id</th>
            <th>Ngày đặt</th>
             <th>Tên Tour</th>
             <th>Số lượng</th>
            <th>Tổng tiền</th>
            <th>Đánh giá</th>
          </tr>
        </thead>
    <tbody>
       <c:forEach var="t" items="${dontour}">   
            <tr>
                 <td>${t.dontour.id}</td>
                  <td>${t.dontour.ngaytao}</td>
                  <td>${t.chuyenxe.tenCX}</td>
                  <td>${t.soluong}</td>
                  <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${t.dontour.tongtien}"/> VND</td>
                  <td><a class="btn btn-success" href="<c:url value="/danhgia/${t.chuyenxe.idCX}"/>">Đánh Giá</a></td>
                  
            </tr>
        </c:forEach>
    </tbody>
  </table>  
    </div>
</div>