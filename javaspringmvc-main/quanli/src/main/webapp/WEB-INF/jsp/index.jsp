
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
 <div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner" style="width: 100%;height: 800px;">
    <div class="carousel-item active">
      <img class="img-fluid" style="width: 100%;height: 800px;"src="https://vn.blog.kkday.com/wp-content/uploads/blogcover-1.jpg" alt="quanliluhanh">
    </div>
    <div class="carousel-item">
      <img class="img-fluid" style="width: 100%;height: 800px;"src="https://transviet.com.vn/images/Khuyen-Mai/Pictures/cam_nang_du_lich/LUU-Y-KHI-DI-DU-LICH/dulichtheotour-transviet00.jpg" alt="quanliluhanh">
    </div>
    <div class="carousel-item">
      <img class="img-fluid" style="width: 100%;height: 800px;"src="https://media.baodautu.vn/Images/duyhuu/2018/09/19/viet-nam-to-chuc-dien-dan-du-lich-cap-cao1537329493.jpg" alt="quanliluhanh">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
<div class="container">
       <div class="col-md-20" >
        <br>
        <a href="<c:url value="/chuyenxe"/>" ><h2 id="danhsach">Danh Sách Chuyến Xe</h2></a>
     
    <div class="row" style="margin: 10px;">
        <c:forEach var="q" items="${chuyenxe}">
        <div class="card col-md-3" style="width:400px;">
                <img class="card-img-top rounded" src="${q.hinhanh}"/>
              <div class="card-body">
                <h4 class="card-title">${q.tenCX}</h4>
                <p class="card-text"><b>Điểm đi: </b>${q.diemdi}</p>
                <p class="card-text"><b>Điểm đến: </b>${q.diemden}</p>
                <a href="<c:url value="/chuyenxe/detail/${q.idCX}"/>" class="btn btn-primary stretched-link">Xem Chi Tiết</a>
              </div>
        </div>
       </c:forEach>      
       
    </div>
</div>
    <div class="col-md-20" >
        <br>
        <a href="<c:url value="/khachsan"/>" ><h2 id="danhsach">Danh Sách Khách Sạn</h2></a>
     
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
       
    </div>
</div>
    <div class="col-md-20">
        <br>
       <a href="<c:url value="/tour"/>" ><h2 id="danhsach">Danh Sách Tour</h2></a>
    <div class="row" style="margin: 10px;">
        <c:forEach var="t" items="${tour}">
        <div class="card col-md-3" style="width:400px;">
                <img class="card-img-top rounded" src="${t.image}"/>
              <div class="card-body">
                <h4 class="card-title">${t.nametour}</h4>
                <p class="card-text"><b>Thành Phố: </b>${t.place}</p>
                  <b>Giá: </b><p class="text-danger"><fmt:formatNumber type="number" maxFractionDigits="3" value="${t.price}"/> VND</p>
                <a href="<c:url value="/tour/detail/${t.idtour}"/>" class="btn btn-primary stretched-link">Xem Chi Tiết</a>
              </div>
        </div>
       </c:forEach>      
    </div>
</div>
</div>

        

