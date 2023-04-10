
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
      <c:url value = "/admin/tours" var="action"/>
        <form:form method ="post" action="${action}" modelAttribute="tours" enctype="multipart/form-data">
            <form:errors path="*" cssClass="alert alert-danger" element="div"/>
            
                        <div class = "form-group">
                        <label for ="nametour">Name Tour</label>
                        <form:input type = "text" id="nametour" path="nametour"  cssClass="form-control"/>
                        <form:errors path="nametour" cssClass="alert alert-danger" element="div"/>
                        </div>
                        
                        <div class = "form-group">
                        <label for ="place">Place</label>
                        <form:input type="text"  id="place" path="place"  cssClass="form-control"/>
                        <form:errors path="place" cssClass="alert alert-danger" element="div"/>
                        </div>
                        
                        <div class = "form-group">
                        <label for ="start">Start</label>                   
                        <form:input type="date" id="start" path="start" cssClass="form-control" value ="${start}"/>
                        </div>
                        
                         <div class = "form-group">
                        <label for ="finish">Finish</label>
                        <form:input type="date" id="finish" path="finish" cssClass="form-control" value ="${finish}"/>
                        </div>
                        
                        <div class = "form-group">
                        <label for ="description">Description</label>
                        <form:textarea  id="description" path="description"  cssClass="form-control"/>
                        <form:errors path="description" cssClass="alert alert-danger" element="div"/>
                        </div>
                        
                        <div class = "form-group">
                        <label for ="price">Price</label>
                        <form:input type = "text" id="price" path="price"  cssClass="form-control"/>
                        <form:errors path="price" cssClass="alert alert-danger" element="div"/>
                        </div>
                        <div class = "form-group">
                            <label for ="phuongtien">Phương Tiện</label>
                            <form:select id="phuongtien" path="phuongtien"  cssClass="form-control">
                                <option value="Xe Khách">Xe Khách</option>
                                 <option value="Máy Bay">Máy Bay</option>
                                 <option value="Tàu Hỏa">Tàu Hỏa</option>
                            </form:select>
                        <form:errors path="phuongtien" cssClass="alert alert-danger" element="div"/>
                        </div>
                        
                        <div class = "form-group">
                        <label for ="file"> Tour Image</label>
                        <form:input type = "file" id="file" path="file"  cssClass="form-control"/>
                        </div>
                        
                          <div class = "form-group">
                        
                        <input type = "submit" value="Add Tour"  class="btn btn-danger"/>
                        </div>
                </form:form>    

    
</div>
  