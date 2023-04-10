
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<div class="row">
    <div class="col-md-2">
         <div class="box-gia-tour">
                    <table class="table table-bordered">
                        <tbody>
                          <tr>
                              <td><strong><a style="text-decoration: none;color: black" href="<c:url value="/chuyenxe/cart"/>"> Giỏ hàng:</a></strong> <strong class="text-danger" id="cartCounter">${cartCounter}</strong></td>
                            
                          </tr>
                        </tbody>
                       
                      </table>
                </div>

    </div>
    <div class="col-md-8" style="padding: 5px;">
   
        <div class="dropdown col-md-2">
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Điểm đi</button>
            <div class="dropdown-menu">
              <c:forEach var="tp" items="${thanhpho}">
                  <a class="dropdown-item" href="<c:url value="/chuyenxe/?name=${tp.tentp}"/>"> ${tp.tentp}</a>
              </c:forEach>
            </div>
        </div>
        <br>
        <div>
             <div class="row" style="margin: 10px;">
                <c:forEach var="cx" items="${chuyenxe}">
                <div class="card col-md-3" style="width:250px;">
                        <img class="card-img-top rounded" src="${cx.hinhanh}"/>
                      <div class="card-body">
                        <h4 class="card-title">${cx.tenCX}</h4>
                        <p class="card-text"><b>Điểm đi: </b>${cx.diemdi}</p>
                         <p class="card-text"><b>Điểm đến </b>${cx.diemden}</p>
                        <b class="card-text text-danger">Giá: <fmt:formatNumber type="number" maxFractionDigits="3" value="${cx.giaghe}"/> VND</b>
                        <a href="<c:url value="/chuyenxe/detail/${cx.idCX}"/>" class="btn btn-primary stretched-link">Xem Chi Tiết</a>
                      </div>
                </div>
                </c:forEach>      
             </div>
        </div>
    </div>
</div>
