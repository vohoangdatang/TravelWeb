
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
     <h1>Chỉnh sửa chuyến xe</h1>
   <c:url value="/admin/update/chuyenxe" var="action"/>
        <form:form method="post" action="${action}" modelAttribute="chuyenxe" enctype="multipart/form-data">
             <div class="form-group">
            <label for="tenCX">Id chuyến </label>
            <form:input type="text" id="tenCX" class="form-control" path="idCX" readonly="true"/>
        </div> 
            <div class="form-group">
            <label for="tenCX">Tên chuyến </label>
            <form:input type="text" id="tenCX" class="form-control" path="tenCX"/>
        </div> 
        <div class="form-group">
            <label for="mota">Mô tả</label>
            <form:input type="text" id="mota" class="form-control" path="mota"/>
            
        </div>
         <div class="form-group">
            <label for="dc">Điểm đi</label>
             <form:select id="phuongtien" path="diemdi"  cssClass="form-control">
                 <c:forEach var="tp" items="${thanhpho}">
                      <option value="${tp.tentp}">${tp.tentp}</option>
                 </c:forEach>
             </form:select>
        </div>
        <div class="form-group">
            <label for="dc">Điểm đến</label>
             <form:select id="phuongtien" path="diemden"  cssClass="form-control">
                 <c:forEach var="tp" items="${thanhpho}">
                      <option value="${tp.tentp}">${tp.tentp}</option>
                 </c:forEach>
             </form:select>
        </div>
             <div class = "form-group">
                        <label for ="start">Giá vé</label>                   
                        <form:input type="text" id="start" path="giaghe" cssClass="form-control" value ="${giaghe}"/>
          </div>
          <div class = "form-group">
                        <label for ="start">Số lượng</label>                   
                        <form:input type="number" id="start" path="soluong" cssClass="form-control" value ="${soluong}"/>
          </div>
         <div class = "form-group" id="ngaydi1">
             <label for ="start">Ngày đi</label>                   
             <form:input type="text" id="start" path="ngaydi" cssClass="form-control" value ="${ngaydi}" readonly="true"/><input type="button" class="btn btn-danger" id="ngaydi1" value="Sửa"/>
        </div>
         <div class = "form-group" id="ngaydi2" style="display: none">
             <label for ="start">Ngày đi</label>                   
             <form:input type="date" id="start" path="ngaydi" cssClass="form-control" value ="${ngaydi}"/><input type="button" class="btn btn-danger" id="ngaydi2" value="Sửa"/>
        </div>
       <div class="form-group"id="hinhanh1">
             <label for ="start">Hình ảnh</label>  
             <form:input type="text" cssClass="form-control" path="hinhanh" value="${hinhanh}" readonly="true"/><input type="button" class="btn btn-danger" id="btn1" value="Sửa"/>
       </div>  
        
       <div class="form-group" id="hinhanh2" style="display: none">
             <label for ="start">Hình ảnh</label>  
             <form:input type="file" cssClass="form-control" path="file" /><input type="button" class="btn btn-danger" id="btn2" value="Sửa"/>
       </div>   
            <div class="form-group">
            <label for="dc">Tài Xế</label>
             <form:select id="phuongtien" path="user"  cssClass="form-control">
                 <c:forEach var="tp" items="${taixe}">
                      <option value="${tp.id}">${tp.hoten}</option>
                 </c:forEach>
             </form:select>
        </div>
            <input type="submit" class="btn btn-success" cssClass="form-control" value="submit"/>
        </form:form>
            <br>
             <a class="btn btn-secondary" href="<c:url value="/admin/chuyenxe"/>">Quay lại</a>
</div>
<script language="javascript">

            document.getElementById("btn1").onclick = function () {
                document.getElementById("hinhanh1").style.display = 'none';
                document.getElementById("hinhanh2").style.display = 'block';
            };
             document.getElementById("btn2").onclick = function () {
                document.getElementById("hinhanh2").style.display = 'none';
                document.getElementById("hinhanh1").style.display = 'block';
            };
             document.getElementById("ngaydi1").onclick = function () {
                document.getElementById("ngaydi1").style.display = 'none';
                document.getElementById("ngaydi2").style.display = 'block';
            };
             document.getElementById("ngaydi2").onclick = function () {
                document.getElementById("ngaydi2").style.display = 'none';
                document.getElementById("ngaydi1").style.display = 'block';
            };

          

</script>

   

