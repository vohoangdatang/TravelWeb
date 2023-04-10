

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="width: 100%;height:10%">
    <div class="container-fluid">
        <a class="nav-link" href="<c:url value="/"/>" style="color: white;">Trang chủ</a>
          <a class="nav-link" href="<c:url value="/chuyenxe"/>" style="color: white;">Xe Khách</a>
          <form class="form-inline" action="">
                    <input class="form-control mr-sm-2" type="text" name="name" placeholder="Tìm kiếm">
                    <button class="btn btn-success" type="submit">Tìm</button>
                    
                    </form><br>
         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarReponsive">
	  	<span class="navbar-toggler-icon"></span>
	  </button>
         <div class="collapse navbar-collapse" id="navbarReponsive">
            <ul class="navbar-nav ml-auto">
              
                <c:if test="${pageContext.request.userPrincipal.name==null}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/login"/>">Đăng Nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/register"/>">Đăng Ký</a>
                    </li>
                </c:if>
                 <c:if test="${pageContext.request.userPrincipal.name!=null}">
                 <li class="nav-item dropdown dropleft">
                     <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">${pageContext.request.userPrincipal.name}</a>

                    <div class="dropdown-menu">
                     <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a class="dropdown-item" href=" <c:url value="/admin/thongke"/>">Quản lí</a>   
                        <a class="dropdown-item" href=" <c:url value="/admin/taixe"/>">Quản lí tài xế</a>  
                        <a class="dropdown-item" href=" <c:url value="/admin/chuyenxe"/>">Quản lí chuyến xe</a>  
                        <a class="dropdown-item" href=" <c:url value="/admin/thongke"/>">Quản lí doanh thu</a>  
                        <a class="dropdown-item" href=" <c:url value="/admin/user"/>">Quản lí người dùng</a>  
                        <a class="dropdown-item" href=" <c:url value="/admin/hoadon"/>">Quản lí hóa đơn</a> 
                        <a class="dropdown-item" href=" <c:url value="/admin/phong"/>">Quản lí phòng</a> 
                        <a class="dropdown-item" href=" <c:url value="/admin/khachsan"/>">Quản lí khách sạn</a> 
                        <a class="dropdown-item" href=" <c:url value="/admin/tour"/>">Quản lí tour</a> 
                        
                        
                              
                              
                     </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_NV')">
                        <a class="dropdown-item" href=" <c:url value="/nhanvien/index"/>">Quản lí chuyến xe</a>     
                        <a class="dropdown-item" href=" <c:url value="/nhanvien/hoadon"/>">Quản lí hóa đơn</a>     
                     </sec:authorize>
                         <sec:authorize access="hasRole('ROLE_TX')">
                        <a class="dropdown-item" href=" <c:url value="/taixe/info/${currentUser.id}"/>">Tài Xế</a>     
                     </sec:authorize>
                        <a class="dropdown-item" href=" <c:url value="/profile/${pageContext.request.userPrincipal.name}"/>">Thông tin</a>    
                        <a class="dropdown-item" href="<c:url value="/logout"/>">Logout</a>
                  </div>
                </li>

                </c:if>
            </ul>
         </div>
    </div>
</nav>
