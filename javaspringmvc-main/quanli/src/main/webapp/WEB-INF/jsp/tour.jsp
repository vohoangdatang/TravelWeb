

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
          <a class="dropdown-item" href="<c:url value="/tour/?name=${tp.tentp}"/>"> ${tp.tentp}</a>
      </c:forEach>
    </div>
</div>
    <br>

</div>
<div class="col-md-8">
    <div class="row" style="margin: 10px;">
        <c:forEach var="t" items="${tour}">
        <div class="card col-md-3" style="width:400px;">
                <img class="card-img-top rounded" src="${t.image}"/>
              <div class="card-body">
                <h4 class="card-title">${t.nametour}</h4>
                <p class="card-text"><b>Thành Phố: </b>${t.place}</p>
                <p class="card-text "><b>Giá: </b><p class="text-danger"><fmt:formatNumber type="number" maxFractionDigits="3" value="${t.price}"/> VND</p></p>
                <a href="<c:url value="/tour/detail/${t.idtour}"/>" class="btn btn-primary stretched-link">Xem Chi Tiết</a>
              </div>
        </div>
       </c:forEach>      
    </div>
</div>
</div>    