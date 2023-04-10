

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<div class="container" style="height: 1000px;">
    <h3>Xác nhận thông tin của bạn</h3> 
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <c:url value="/nhanvien/pay/add/${currentUser.id}" var="action" />
     <form:form modelAttribute="dontour" action="${action}" method="post" >
        
        
         <div class="form-group">
            <input type="submit" class="btn btn-success" class="form-control" value="Tiếp tục"/>
         
        </div>
     </form:form>
      </c:if>
</div>
