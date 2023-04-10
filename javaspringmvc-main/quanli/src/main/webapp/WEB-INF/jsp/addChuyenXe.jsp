

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <h1>Thêm Chuyến Xe</h1>
    <c:if test="${loi!=null}">
        <div class="alert alert-danger">
            <p>${loi}</p>
            <a class="btn-success" href="<c:url value="/admin/add/chuyenxe"/>">Reload</a>
        </div>
    </c:if>
   <c:url value="/admin/add/chuyenxe/action" var="action"/>
        <form:form method="post" action="${action}" modelAttribute="chuyenxe" enctype="multipart/form-data">
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
                        <label for ="start">Ngày đi</label>                   
                        <form:input type="date" id="start" path="ngaydi" cssClass="form-control" value ="${start}"/>
          </div>
          <div class = "form-group">
                        <label for ="start">Giá vé</label>                   
                        <form:input type="text" id="start" path="giaghe" cssClass="form-control" value ="300000"/>
          </div>
          <div class = "form-group">
                        <label for ="start">Số lượng</label>                   
                        <form:input type="number" id="start" path="soluong" cssClass="form-control" value ="6"/>
          </div>
          
       <div class="custom-file">
             <label for ="start">Hình ảnh</label>  
            <form:input type="file"   cssClass="form-control" path="file"/>
            
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
