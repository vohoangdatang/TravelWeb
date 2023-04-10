
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<div class="container">
    <table class="table">
    <thead>
      <tr>
        <th>Tên Tour</th>
        <th>giá</th>
        <th>Số lượng</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach items="${hoadon}" var="ct">
      <tr>
        <td>${ct.chuyenxe.tenCX}</td>
        <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${ct.chuyenxe.giaghe}"/> VND</td>
        <td>${ct.soluong}</td>
      </tr>
      
        </c:forEach>
      <tr>
          <th>Ngày đặt</th>
        <th>Tên người đặt</th>
        <th>Tổng cộng</th>
      </tr>
       <c:forEach items="${hoadon}" var="ct">
       <tr>
           <td>${ct.dontour.ngaytao}</td>
        <td>${ct.dontour.hoten}</td>
        <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${ct.dontour.tongtien}"/> VND</td>
       
      </tr>
      </c:forEach>
     
    </tbody>
  </table>
      
        <sec:authorize access="hasRole('ROLE_NV')">
                      <a class="btn btn-secondary" href="<c:url value="/nhanvien/hoadon"/>">Quay lại</a>
        </sec:authorize>
                      <sec:authorize access="hasRole('ROLE_ADMIN')">
                     <a class="btn btn-secondary" href="<c:url value="/admin/hoadon"/>">Quay lại</a>
        </sec:authorize>
</div>
