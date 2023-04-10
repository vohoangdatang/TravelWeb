
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<div class="row" style="height: 890px;">
<div class="container">
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
       </div>              
    <h3>Xác nhận thông tin của bạn</h3> 
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <c:url value="/checkout/tour" var="action" />
     <form:form modelAttribute="dontour" action="${action}" method="post" >
         <div class="form-group">
            <label for="hoten">Họ và tên</label>
            <form:input type="text" id="hoten" class="form-control" path="hoten" />
        </div> 
        <div class="form-group">
            <label for="email">Email</label>
            <form:input type="email" id="email" class="form-control" path="email" />
        </div> 
        <div class="form-group">
            <label for="sdt">Số điện thoại</label>
            <form:input type="tel" id="sdt" pattern="[0]{1}[1-9]{9}" class="form-control" path="sdt" />
        </div> 
         <div class="form-group">
            <input type="submit" class="btn btn-success" class="form-control" value="Gửi"/>
         
        </div>
     </form:form>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <c:url value="/checkout/tour" var="action" />
        <c:forEach items="${user}" var="u">
             <form:form modelAttribute="dontour" action="${action}" method="post" >
        <div class="form-group">
            <label for="user">Thông tin khách hàng</label>
            <form:input type="text" id="user" value="${u.id}" readonly="true" class="form-control" path="user" />
        </div> 
         <div class="form-group">
            <label for="hoten">Họ và tên</label>
            <form:input type="text" id="hoten" value="${u.hoten}" class="form-control" path="hoten" />
        </div> 
        <div class="form-group">
            <label for="email">Email</label>
            <form:input type="email" id="email" value="${u.email}" class="form-control" path="email" />
        </div> 
        <div class="form-group">
            <label for="sdt">Số điện thoại</label>
            <form:input type="tel" id="sdt" pattern="[0]{1}[1-9]{9}" value="${u.sdt}" class="form-control" path="sdt" />
        </div> 
         <div class="form-group">
            <input type="submit" class="btn btn-success" class="form-control" value="Gửi"/>
            
        </div>
     </form:form>
          
        </c:forEach>
    
    </c:if>
     

</div>
</div>
