
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="contentright" style="float: left">
<c:url value="/admin/phong/edit" var="action" />
  <form:form method="post" action="${action}" modelAttribute="phong"  >
      <div class="form-group">
            <label for="idphong">id Phòng</label>
            <form:input type="text" id="idphong" class="form-control" path="idPhong" value="${p.idPhong}" readonly="true"/>
        </div>  
          <div class="form-group">
            <label for="tenPhong">Tên Phòng</label>
            <form:input type="text" id="tenPhong" class="form-control" path="tenPhong" value="${p.tenPhong}"/>
        </div>      
        <div class="form-group">
            <label for="giaPhong">Giá</label>
            <form:input type="text" id="giaPhong" class="form-control" path="giaPhong" value="${p.giaPhong}"/>
            
        </div>
        <div class="form-group">
            <label for="loaiphong">Loại Phòng</label>
            <form:select id="loaiphong"  cssClass="form-control" path="loaiphong">
               <c:forEach var="lp" items="${khachsan}">   
                   <option value="${lp.idloaiphong}">${lp.tenLoaiPhong}</option>
                 </c:forEach>
            </form:select>
        </div>
         <div class="form-group">
            <label for="khachsan">Loại Phòng</label>
            <form:select id="khachsan"  cssClass="form-control" path="khachsan">
               <c:forEach var="ks" items="${khachsans}">   
                   <option value="${ks.idkhachsan}">${ks.tenKS}</option>
                 </c:forEach>
            </form:select>
        </div>
         
         <div class="form-group">
            <input type="submit" class="btn btn-success" class="form-control" value="Gửi"/>
            <button type="button" class="btn btn-secondary"><a href="<c:url value="/admin/phong"/>">Quay lại</a></button> 
        </div>
  </form:form>    
</div>  