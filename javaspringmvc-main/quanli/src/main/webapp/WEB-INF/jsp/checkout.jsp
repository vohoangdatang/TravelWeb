

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<div class="row">
<div class="container">
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
                    <td>${map.value.phong.giaPhong} VND</td>
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
                      <th>${sessionScope.giaTong} VND (Cho 1 ngày)</th>
                  </tr>
                  
                </tbody>
              </table>
       </div>              
    <h3>Xác nhận thông tin của bạn</h3> 
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <c:url value="/checkout" var="action" />
     <form:form modelAttribute="donphong" action="${action}" method="post" >
          <form:errors path="*" cssClass="alert alert-danger" element="div"/>
           <div class="form-group">
            <label for="ngaynhan">Ngay nhan phong</label>
            <form:input type="date" id="ngaynhan" class="form-control" path="ngaynhan" />
           
        </div>
        <div class="form-group">
            <label for="ngaytra">Ngay Tra</label>
            <form:input type="date" id="ngaytra" class="form-control" path="ngaytra" />
            
        </div>
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
        <c:url value="/checkout" var="action" />
        <c:forEach items="${user}" var="u">
             <form:form modelAttribute="donphong" action="${action}" method="post" >
                          <form:errors path="*" cssClass="alert alert-danger" element="div"/>
         <div class="form-group">
            <label for="ngaynhan">Ngay nhan phong</label>
            <form:input type="date" id="ngaynhan" class="form-control" path="ngaynhan" />
           
        </div>
        <div class="form-group">
            <label for="ngaytra">Ngay Tra</label>
            <form:input type="date" id="ngaytra" class="form-control" path="ngaytra" />
           
        </div>
        <div class="form-group">
            <label for="user">Thong tin khach hang</label>
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