
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container" style="height:900px;">
    <div class="row">
            <h3>Danh sách phòng bạn đã đặt (<c:out value="${sessionScope.slItems}"/>)</h3>
             <table class="table">
                <thead>
                  <tr>
                    <th>id Phòng</th>
                    <th>Hình ảnh</th>
                    <th>Tên Phòng</th>
                    <th>id Khách Sạn</th>
                    <th>Tên Khách Sạn</th>
                    <th>Giá Phòng</th>
                    <th>Hủy</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="map" items="${sessionScope.myCartItems}">
                  <tr>
                    <td>${map.value.phong.idPhong}</td>
                    <td><img style="width: 100px;"src="<c:url value="${map.value.phong.khachsan.hinhanh}"/>"/></td>
                    <td>${map.value.phong.tenPhong}</td>
                    <td id="idks">${map.value.phong.khachsan.idkhachsan}</td>
                    <td>${map.value.phong.khachsan.tenKS}</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${map.value.phong.giaPhong}"/> VND</td>
                    <td><a href="<c:url value="/cart/delete/${map.value.phong.idPhong}"/>"><i class="fa fa-remove" style="font-size:24px;color: red;"></i></a></td>
                  </tr>
                </c:forEach>
                 
                  <tr>
                      <th></th>
                      <th></th>
                       <th></th>
                        <th></th>
                     <th>Số lượng</th>
                      <th>${sessionScope.slItems} Phòng</th>
                  </tr>
                  <tr>
                      <th></th>
                      <th></th>
                       <th></th>
                        <th></th>
                      <th>Tổng Cộng</th>
                      <th><fmt:formatNumber type="number" maxFractionDigits="3" value="${sessionScope.giaTong}"/>  VND (Cho 1 ngày)</th>
                  </tr>
                  
                </tbody>
              </table>
                  <script>
                      function layidks()
                      {
                        var id = document.getElementById("idks").innerHTML;
                        if(id == null)
                        {
                            window.location="khachsan";
                        }
                        else{
                            window.location="khachsan/detail/"+id;
                        }
                        
                      }
                  </script>    
                  <button class="btn btn-primary" onclick="layidks()">Quay lại</button>
                  <a class="btn btn-success"style="color: white;margin: 5px;" href="<c:url value="/khachsan/phuongthucthanhtoan"/>">Chọn Phương Thức Thanh Toán</a>
                  
                  
       </div>              
</div>   

             
 
