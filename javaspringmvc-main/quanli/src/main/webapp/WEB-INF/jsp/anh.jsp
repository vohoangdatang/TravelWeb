

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>

<div class="container">
     <c:url value="/admin/khachsan/add" var="action"/>
        <form:form method="post" action="${action}" modelAttribute="khachsan" enctype="multipart/form-data">
            <div class="form-group">
            <label for="tenKS">Tên khách sạn</label>
            <form:input type="text" id="tenKS" class="form-control" path="tenKS"/>
        </div> 
        <div class="form-group">
            <label for="tp">Thành Phố</label>
            <form:input type="text" id="tp" class="form-control" path="thanhPho"/>
            
        </div>
         <div class="form-group">
            <label for="dc">Địa Chỉ</label>
            <form:input type="text" id="dc" class="form-control" path="diachi"/>
            
        </div>
       <div class="form-group">
            <form:input type="file" cssClass="form-control" path="file"/>
            
       </div>     
            <input type="submit" class="btn btn-success" cssClass="form-control" value="submit"/>
        </form:form>
            <br>
             <a class="btn btn-secondary" href="<c:url value="/admin/khachsan"/>">Quay lại</a>
</div>
       
   
