<%-- 
    Document   : updateHoaDon
    Created on : Oct 1, 2021, 3:26:39 PM
    Author     : AD
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container">
    <c:url value="/admin/hoadon/update" var ="action"/>
    <form:form method="post" modelAttribute="hoadon" action="${action}">
        <div class="form-group">
            <label for="id">Id hóa đơn</label>
            <form:input type="text" id="id" readonly="true" class="form-control" path="id"/>
        </div> 
        <div class="form-group">
            <label for="iduser">Id người dùng</label>
            <form:input type="text" id="iduser" readonly="true" class="form-control" path="user"/>
        </div> 
        <div class="form-group">
            <label for="ngaytao">Ngày đặt</label>
            <form:input type="date" id="ngaytao" class="form-control" path="ngaytao"/>
        </div> 
        <div class="form-group">
            <label for="email">Họ và tên</label>
            <form:input type="text" id="email" class="form-control" path="hoten"/>
        </div>
         <div class="form-group">
            <label for="email">Email</label>
            <form:input type="text" id="email" class="form-control" path="email"/>
        </div> 
        <div class="form-group">
            <label for="sdt">Số điện thoại</label>
            <form:input type="text" id="sdt" class="form-control" path="sdt"/>
        </div> 
        <div class="form-group">
            <label for="ngaynhan">Ngày nhận phòng</label>
            <form:input type="date" id="ngaynhan" class="form-control" path="ngaynhan"/>
        </div> 
         <div class="form-group">
            <label for="ngaytra">Ngày trả phòng</label>
            <form:input type="date" id="ngaytra" class="form-control" path="ngaytra"/>
        </div> 
        <div class="form-group">
            <label for="tongtien">Tổng tiền</label>
            <form:input type="text" id="tongtien"  readonly="true" class="form-control" path="tongtien"/>
        </div> 
        <div class="form-group">
            <label for="phuongthuc">Phương thức thanh toán</label>
            <form:input type="text" id="phuongthuc" readonly="true" class="form-control" path="phuongthuc"/>
        </div> 
        <div class="form-group">
            <label for="tinhtrang">Tình trạng</label>
           
            <form:select  id="tinhtrang" class="form-control" path="tinhtrang">
                <option value="chưa thanh toán">chưa thanh toán</option>
                <option value="đã thanh toán">đã thanh toán</option>
            </form:select>
        </div> 
        <div class="form-group">
           <input type="submit" class="btn btn-success" cssClass="form-control" value="submit"/>
           </div> 
         
    </form:form>
     <sec:authorize access="hasRole('ROLE_NV')">
                    <a class="btn btn-secondary" href="<c:url value="/nhanvien/hoadon"/>">Quay lại1</a>
      </sec:authorize>
                      <sec:authorize access="hasRole('ROLE_ADMIN')">
                     <a class="btn btn-secondary" href="<c:url value="/admin/hoadon"/>">Quay lại</a>
        </sec:authorize>
</div>
