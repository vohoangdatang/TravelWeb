
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<div class="container"  style="
    height: 900px;
    padding: 10px;">
    
    <div class="card bg-secondary text-white">
     <c:if test="${pageContext.request.userPrincipal.name == null}">
        <a class="card-body"style="color: white;margin: 5px;" href="<c:url value="/don"/>">Thanh toán Tại Chi Nhánh</a>
     </c:if>
     <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a class="card-body" style="color: white;margin: 5px;" href="<c:url value="/don/${pageContext.request.userPrincipal.name}"/>">Thanh toán Tại Chi Nhánh</a>         
     </c:if>
  </div>
    <br>
    <div class="card bg-secondary text-white">
         <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a class="card-body" style="color: white;margin: 5px;" href="<c:url value="/checkout/paypal"/>">Thanh toán qua PayPal <img  src="https://balancepayout.paypal.com/hw2web/javax.faces.resource/244013801687/en/login_logo.png.xhtml?ln=img" width="100px"/></a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a class="card-body" style="color: white;margin: 5px;" href="<c:url value="/checkout/paypal/${pageContext.request.userPrincipal.name}"/>">Thanh toán qua PayPal <img  src="https://balancepayout.paypal.com/hw2web/javax.faces.resource/244013801687/en/login_logo.png.xhtml?ln=img" width="100px"/></a>
        </c:if>
     </div>
    
</div>