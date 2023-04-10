

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<div class="left">
    <h3 >Tìm kiếm theo</h3> 
  <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Thành Phố
    </button>
    <div class="dropdown-menu">
      <c:forEach var="ks" items="${khachsan}">
          <a class="dropdown-item" href="<c:url value="/khachsan/?kw="/>">${ks.thanhPho}</a>
      </c:forEach>
    </div>
</div>
 <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Loại Phòng
    </button>
    <div class="dropdown-menu">
        <c:forEach items="${loaiphong}" var="lp">
             <a class="dropdown-item" href="<c:url value="/khachsan/${lp.idloaiphong}"/>">${lp.tenLoaiPhong}</a>
        </c:forEach>
    </div>
</div>
</div>
<div class="container">
    <div class="row">
        <c:forEach var="ks" items="${khachsan}">
        <div class="card col-md-4" style="width:400px">
                <img class="card-img-top" src="${ks.hinhanh}"/>
              <div class="card-body">
                <h4 class="card-title">${ks.tenKS}</h4>
                <p class="card-text">mô tả khách sạn</p>

                <a href="#" class="btn btn-primary stretched-link">Xem Chi Tiết</a>
              </div>
        </div>
       </c:forEach>      
       
    </div>
</div>
 <ul>
   
   
 </ul>
