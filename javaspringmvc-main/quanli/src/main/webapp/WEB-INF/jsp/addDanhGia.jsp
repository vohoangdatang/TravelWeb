
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<div class="container" style="height: 1000px;">
   <c:url value = "/danhgia/add/action" var="action"/>
        <form:form method ="post" action="${action}" modelAttribute="danhgia" enctype="multipart/form-data">
            <form:errors path="*" cssClass="alert alert-danger" element="div"/>
            
                        <div class = "form-group">
                        <label for ="nametour">Nội dung</label>
                        <form:input type = "text" id="nametour" path="noidung" value="nhập nội dung ở đây" cssClass="form-control"/>
                        </div>
                         
                        <div class = "form-group" style="display: none;">
                        <label for ="nametour">user</label>
                        <form:input type = "text" id="nametour" path="user" value="${user.id}" cssClass="form-control"/>
                        <form:select id="nametour" path="cx"  cssClass="form-control">
                            <option value="${id}">${id}</option>
                        </form:select>
                       
                        </div>
                         <div class = "form-group">
                        <label for ="nametour">sao</label>
                        <form:select id="nametour" path="sao"  cssClass="form-control">
                            <c:forEach var="i" begin="1" end="5">
                                <option value="${i}">${i}</option>
                            </c:forEach>
                        </form:select>
                        </div>
                                          
                     
                     
                          <div class = "form-group">
                        
                        <input type = "submit" value="Gửi"  class="btn btn-danger"/>
                        </div>
                </form:form>    
    
   <a class="btn btn-secondary" href="<c:url value="/"/>">Bỏ qua</a>
</div>
