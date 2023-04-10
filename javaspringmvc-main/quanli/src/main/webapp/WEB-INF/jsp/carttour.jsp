

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container" style="height:900px;">
    <div class="row">
            <h3>Danh sách Tour bạn đã đặt (<c:out value="${sessionScope.slItems}"/>)</h3>
             <table class="table">
                <thead>
                  <tr>
                    <th>id Phòng</th>
                    <th>Hình ảnh</th>
                    <th>Tên Phòng</th>
                    <th>Số lượng</th>
                    <th>Giá Tour</th>
                    <th>Hủy</th>
                  </tr>
                </thead>
                <tbody>
               
                   <c:forEach var="map" items="${sessionScope.myCartItems}">
                  <tr>
                    <td>${map.value.tour.idtour}</td>
                    <td><img style="width: 100px;"src="<c:url value="${map.value.tour.image}"/>"/></td>
                    <td>${map.value.tour.nametour}</td>
                    <td>${map.value.soluong}</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${map.value.tour.price}"/> VND</td>
                    <td><a href="<c:url value="/cart/delete/tour/${map.value.tour.idtour}"/>"><i class="fa fa-remove" style="font-size:24px;color: red;"></i></a></td>
                  </tr>
                </c:forEach>
                  <tr>
                      
                       <th></th>
                        <th></th>
                         <th></th>
                        <th></th>
                     <th>Số lượng</th>
                      <th>${sessionScope.slItems} Tour</th>
                  </tr>
                  <tr>
                      
                       <th></th>
                        <th></th>
                         <th></th>
                        <th></th>
                      <th>Tổng Cộng</th>
                      <th><fmt:formatNumber type="number" maxFractionDigits="3" value="${sessionScope.giaTong}"/>  VND </th>
                  </tr>
                  
                </tbody>
              </table>
                
                      <a href="<c:url value="/tour"/>"class="btn btn-primary" >Quay lại</a>
                  <a class="btn btn-success"style="color: white;margin: 5px;" href="<c:url value="/tour/phuongthucthanhtoan"/>">Chọn Phương Thức Thanh Toán</a>
                  
                  
       </div>              
</div>   

             
 
