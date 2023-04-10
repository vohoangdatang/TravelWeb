

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<div class="container" style="height: 1000px">
    <h1 class="text-center "> Giỏ hàng</h1>
    <c:if test="${cart == null}">
        <h1 class="text-center text-danger ">Không có sản phẩm nào trong giỏ</h1>
    </c:if>
        <c:if test="${cart != null}">
            <table class="table">
                <thead>
                    <tr>
                        <th>Mã chuyến</th>
                        <th>Tên chuyến</th>
                        <th>Giá </th>
                        <th>Số lượng</th>
                         <th>Xóa</th>
                    </tr>
                </thead>
                <tbody>
               
                  <c:forEach var="c" items="${carts}">
                  <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${c.gia}"/> VND</td>
                    <td>${c.soluong}</td>
                    
                    <td><a href="" onclick="deleteCart(${c.id})"><i class="fa fa-remove" style="font-size:24px;color: red;"></i></a></td>
                  </tr>
                </c:forEach>
                  <tr>
                      <td></td>
                      <td></td>
                       <td><b>Tổng cộng: </b</td>
                      <td><span><fmt:formatNumber type="number" maxFractionDigits="3" value="${amount}"/>VND</span></td>
                  </tr>
                </tbody>
            </table>
                      <c:if test="${currentUser.id == null}">
                          <div class="alert alert-danger">
                              Hãy đăng nhập để thanh toán
                          </div>
                      </c:if>
                  <a type="button"  class="btn btn-danger" onclick="offlinePay()" style="color: white;">Thanh Toán<a/>
                      <a type="button"  class="btn btn-danger" href="<c:url value="/momo/pay"/>" style="color: white;">Thanh Toán Bằng Momo<a/>
                   <sec:authorize access="hasRole('ROLE_NV')">
                       <a type="button"  href="<c:url value="/nhanvien/pay"/>" class="btn btn-danger" >Nhân Viên Đặt Xe<a/>    
                     </sec:authorize>
        </c:if>
</div>
<script>
    function deleteCart(id)
    {
        fetch("/quanli/api/chuyenxe/delete/"+id,{
            method:"delete",
        }).then(function(res){
         return res.json()
     }).then(function(data){
         let counter = document.getElementById("cartcounter")
         counter.innerText=data
     })
    }
    function offlinePay()
    {
         fetch("/quanli/api/chuyenxe/pay/${currentUser.id}",{
            method:"post",
        }).then(function(res){
            return res.json();
        }).then(function(code){
            console.info(code);
            window.location="/quanli/lichsu/?id=${currentUser.id}";
        });
    }
    
    
  
</script>


