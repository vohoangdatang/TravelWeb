
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container" style="height: 100%">
         <div>
        <div class="mid-title">
            <h1 class="title-main">${chuyenxe.tenCX}</h1>
        </div>
        <div class="box" style="width: 100%; height: 550px;background-color: white ;" >
            <div style=" height: 100%;background-color: white;float: left;padding: 10px;">
                <img class="card-img-top" src="${chuyenxe.hinhanh}" alt="Card image" style="height:300px; width: 300px;">
            </div>
            <div style="width: 40%; height: 100%;background-color: white; float: left">
                <div class="box-detail-tour">
                        <table class="table table-bordered">
                        <tbody>
                          <tr>
                              <td><strong>Mã chuyến xe </strong></td>
                            <td>${chuyenxe.idCX}</td>
                          </tr>
                          <tr>
                            <td><strong>Điểm đi : </strong></td>
                            <td>${chuyenxe.diemdi}</td>
                          </tr>
                          <tr>
                            <td><strong>Điểm đến: </strong></td>
                            <td>${chuyenxe.diemden}</td>
                          </tr>
                         <tr>
                            <td><strong>Ngày đi: </strong></td>
                            <td>${chuyenxe.ngaydi}</td>
                          </tr>
                          <tr>
                            <td><strong>Số lượng: </strong></td>
                            <td>${chuyenxe.soluong}</td>
                          </tr>
                          <tr>
                            <td><strong>Tài xế: </strong></td>
                            <td>${chuyenxe.user.hoten}</td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                          
              
            </div>
              <div class="box-gia-tour">
                    <table class="table table-bordered">
                        <tbody>
                          <tr>
                              <td><strong>Giá Vé/Khách từ:</strong> <strong class="text-danger"><fmt:formatNumber type="number" maxFractionDigits="3" value="${chuyenxe.giaghe}"/> VND</strong></td>
                            
                          </tr>
                          <tr>
                              <c:if test="${chuyenxe.soluong == 0}">
                                  <td><a class="book-tour"href="<c:url value="#"/>" class="btn btn-success">Hết Chỗ</a></td>
                              </c:if>
                              <c:if test="${chuyenxe.soluong != 0}">
                                  <td><a class="book-tour"href="#" onclick="addItems(${chuyenxe.idCX},'${chuyenxe.tenCX}',${chuyenxe.giaghe})" >Đặt Xe</a></td>
                              </c:if>
                          
                          </tr>
                           <tr>
                              <td><strong><a style="text-decoration: none;color: black" href="<c:url value="/chuyenxe/cart"/>"> Giỏ hàng:</a></strong> <strong class="text-danger" id="cartcounter">${cartCounter}</strong></td>
                            
                          </tr>
                        </tbody>
                        
                      </table>
                </div>
               
                        
                     
  
      
        
    </div>
                              <div style="width: 100%;height: 100%;float: left;padding: 5px;">
                                  <h3>Đánh Giá</h3>
                                  <c:forEach var="dg" items="${danhgia}">
                                      <div class="media border p-2" style="padding-top: 5px;">
                                    <img src="${dg.user.hinhanh}" class="mr-3 mt-3 rounded-circle" style="width:80px;">
                                    <div class="media-body">
                                        <h4>${dg.user.hoten}<small> ${dg.ngaytao}</small></h4>
                                      <h4>Nội dung: <small>${dg.noidung}</small></h4>
                                      <c:forEach var="i" begin="1" end="${dg.sao}">
                                          <i class='fas fa-star' style="color: #e6e600"></i>
                                      </c:forEach>
                                    </div>
                                    </div>
                                  </c:forEach>
                              </div>
   
   
</div>
</div>

<script>
   function addItems(id,name,gia)
   {
     fetch("/quanli/api/cart",{
         method:'post',
         body:JSON.stringify({
             "id":id,
             "name":name,
             "gia":gia,
             "soluong":1
         }),
         headers:{
             "Content-Type":"application/json"
         }
     }).then(function(res){
         return res.json()
     }).then(function(data){
         let counter = document.getElementById("cartcounter")
         counter.innerText=data
     })
     
   }
</script>