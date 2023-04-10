
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<div class="row">
<div class="col-md-2">
    
    <h3 >Tìm kiếm theo</h3> 
    <form class="form-inline" action="">
    <input class="form-control mr-sm-2" type="text" name="name" placeholder="Tìm kiếm">
    <button class="btn btn-success" type="submit">Tìm</button>
    </form><br>
  <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Thành Phố
    </button>
    <div class="dropdown-menu">
      <c:forEach var="tp" items="${thanhpho}">
          <a class="dropdown-item" href="<c:url value="/khachsanparam/?name=${tp.tentp}"/>"> ${tp.tentp}</a>
      </c:forEach>
    </div>
</div>
    <br>
 <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Loại Phòng
    </button>
    <div class="dropdown-menu">
        <c:forEach items="${loaiphong}" var="lp">
             <a class="dropdown-item" href="<c:url value="/khachsanparamlp/?name=${lp.tenLoaiPhong}"/>">${lp.tenLoaiPhong}</a>
        </c:forEach>
    </div>
</div>
</div>
<div class="col-md-8">
    <div class="row" style="margin: 10px;">
        <c:forEach var="ks" items="${khachsan}">
        <div class="card col-md-3" style="width:400px;">
                <img class="card-img-top rounded" src="${ks.hinhanh}"/>
              <div class="card-body">
                <h4 class="card-title">${ks.tenKS}</h4>
                <p class="card-text"><b>Địa chỉ: </b>${ks.diachi}</p>
                <p class="card-text"><b>Thành Phố: </b>${ks.thanhPho}</p>
                <a href="<c:url value="/khachsan/detail/${ks.idkhachsan}"/>" class="btn btn-primary stretched-link">Xem Chi Tiết</a>
              </div>
        </div>
       </c:forEach>      
        <c:forEach var="p" items="${phong}">
        <div class="card col-md-3" style="width:400px;">
                <img class="card-img-top" src="${p.khachsan.hinhanh}"/>
              <div class="card-body">
                <h4 class="card-title">${p.khachsan.tenKS}</h4>
                <p class="card-text"><b>Địa chỉ: </b>${p.khachsan.diachi}</p>
                <p class="card-text"><b>Thành Phố: </b>${p.khachsan.thanhPho}</p>
                <p class="card-text"><b>Loại Phòng: </b>${p.loaiphong.tenLoaiPhong}</p>
                <a href="<c:url value="/khachsan/detail/${p.khachsan.idkhachsan}"/>" class="btn btn-primary stretched-link">Xem Chi Tiết</a>
              </div>
        </div>
       </c:forEach>    
    </div>
</div>
</div>    

