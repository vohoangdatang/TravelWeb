
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
<div class="col-md-3">
   
    <div>
          <div class="card bg-info text-white">
            <div class="card-body"><i class="fa fa-shopping-cart" style="font-size:25px;color: white;"></i> Số lượng phòng (<c:out value="${sessionScope.slItems}"/>)
                <c:if test="${sessionScope.slItems != null}">
                    <a class="btn btn-outline-info" href="<c:url value="/cart"/>"> Xem chi tiết</a>
                </c:if>
                
            </div>
          </div>
      
       
    </div>
    <h3 >Tìm kiếm theo</h3> 
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
<div class="col-md-8" >
    <div class="row">
        <div class="col-md-3" style="float: left;width:550px;margin: 10px;">
            <h1>${khachsan.tenKS}</h1>
            <h2>Địa Chỉ:<small>${khachsan.diachi}</small></h2>
            <h2>Thành Phố:<small>${khachsan.thanhPho}</small></h2>
        </div>
        <div class="col-md-8" style="float: left;width: 350px;">
        <img  class="img-fluid" src="${khachsan.hinhanh}"/>
    </div>
    </div>
   
    <div style="float: left;margin: 10px;" >
        <h1>Danh Sách Phòng</h1>
        <div class="row">
        <c:forEach items="${phong}" var="p">
            <div class="card col-md-3" style="width:400px;margin: 10px;">
                <img class="card-img-top" src="${p.loaiphong.hinhanh}" alt="Card image" style="width:100%">
                <div class="card-body">
                  <h4 class="card-title">${p.tenPhong}</h4>
                  <p class="card-text"> 
                      <p class="fa fa-bed" style="font-size:20px"> Loại Phòng: ${p.loaiphong.tenLoaiPhong}</p>
                      <p class="fa fa-dollar text-danger" style="font-size:20px;"> Giá phòng:  <fmt:formatNumber type="number" maxFractionDigits="3" value="${p.giaPhong}"/> VND</p><br>
                       <c:if test="${p.tinhTrang == true}">
                        <i class="fa fa-toggle-on" style="font-size:20px;color:green"> Tình trạng: còn trống</i>
                        <br>
                        <a href="<c:url value="/cart/add/${p.idPhong}"/>" class="btn btn-success"> Đặt Phòng</a>
                    </c:if>
                    <c:if test="${p.tinhTrang != true}">
                        <i class="fa fa-toggle-off" style="font-size:20px;color:green"> Tình trạng: Phòng đã thuê</i>
                    </c:if>
                  </p>
               
                </div>
            </div>
        </c:forEach>
         </div>
    </div>
</div>
</div>
