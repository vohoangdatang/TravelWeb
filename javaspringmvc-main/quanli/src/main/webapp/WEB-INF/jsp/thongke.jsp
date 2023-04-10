

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <ul class="list-group">
  
     <li class="list-group-item">
      <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo2">Doanh Thu Theo Ngày</button>
    </li>
  </ul>
<div class="container">
  <!-- Links -->
 
    
  
     <div id="demo2" class="collapse2">
      <h1>Doanh Thu Theo Ngày</h1>
            <div>
                <canvas id="myChart2"  width="100%" height="50%" style="padding-left: 5%;"></canvas>
            </div>
            <script>



           var ngay =[<c:forEach var="dp" items="${dontour}">
           '${dp[0]}',

                       </c:forEach>
           ];
           var bien = [<c:forEach var="dp" items="${dontour}">
           '${dp[1]}',

                       </c:forEach>];
           var chart =document.getElementById('myChart2').getContext('2d');
           var bieudo = new Chart(chart,{
               type:'bar',
               data:{
                   labels:ngay,
                   datasets:[{
                           label:"Doanh thu",
                           data:bien,
                            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',
              'rgba(255, 159, 64, 0.2)',
              'rgba(255, 205, 86, 0.2)',
              'rgba(75, 192, 192, 0.2)',
              'rgba(54, 162, 235, 0.2)',
              'rgba(153, 102, 255, 0.2)',
              'rgba(201, 203, 207, 0.2)'
            ],
            borderColor: [
              'rgb(255, 99, 132)',
              'rgb(255, 159, 64)',
              'rgb(255, 205, 86)',
              'rgb(75, 192, 192)',
              'rgb(54, 162, 235)',
              'rgb(153, 102, 255)',
              'rgb(201, 203, 207)'
            ],
            borderWidth: 1
                   }]
               }
           })

        </script>
     </div>
      <div>
          <h1>Doanh thu theo tháng</h1>
           <div>
                <canvas id="myChart"  width="100%" height="50%" style="padding-left: 5%;"></canvas>
            </div>
          <script>
                  var thang = [<c:forEach var="i" begin="1" end="12">
                      'Tháng ${i}',

                       </c:forEach>]
           var bien1 = [<c:forEach var="dp" items="${doanhthuthang1}">'${dp[1]}',</c:forEach>];      
           var bien2 = [<c:forEach var="dp" items="${doanhthuthang2}">'${dp[1]}',</c:forEach>];
            var bien3 = [<c:forEach var="dp" items="${doanhthuthang3}">'${dp[1]}',</c:forEach>];      
           var bien4 = [<c:forEach var="dp" items="${doanhthuthang4}">'${dp[1]}',</c:forEach>];
            var bien5 = [<c:forEach var="dp" items="${doanhthuthang5}">'${dp[1]}',</c:forEach>];      
           var bien6 = [<c:forEach var="dp" items="${doanhthuthang6}">'${dp[1]}',</c:forEach>];
            var bien7 = [<c:forEach var="dp" items="${doanhthuthang7}">'${dp[1]}',</c:forEach>];      
           var bien8 = [<c:forEach var="dp" items="${doanhthuthang8}">'${dp[1]}',</c:forEach>];
            var bien9 = [<c:forEach var="dp" items="${doanhthuthang9}">'${dp[1]}',</c:forEach>];      
           var bien10 = [<c:forEach var="dp" items="${doanhthuthang10}">'${dp[1]}',</c:forEach>];
            var bien11 = [<c:forEach var="dp" items="${doanhthuthang11}">'${dp[1]}',</c:forEach>];      
           var bien12 = [<c:forEach var="dp" items="${doanhthuthang12}">'${dp[1]}',</c:forEach>];
               var chart1 =document.getElementById('myChart').getContext('2d');
           var bieudothang = new Chart(chart1,{
               type:'bar',
               data:{
                   labels:thang,
                   datasets:[{
                           label:"Doanh thu",
                           data:[bien1,bien2,bien3,bien4,bien5,bien6,bien7,bien8,bien9,bien10,bien11,bien12],
                            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',
              'rgba(255, 159, 64, 0.2)',
              'rgba(255, 205, 86, 0.2)',
              'rgba(75, 192, 192, 0.2)',
              'rgba(54, 162, 235, 0.2)',
              'rgba(153, 102, 255, 0.2)',
              'rgba(201, 203, 207, 0.2)'
            ],
            borderColor: [
              'rgb(255, 99, 132)',
              'rgb(255, 159, 64)',
              'rgb(255, 205, 86)',
              'rgb(75, 192, 192)',
              'rgb(54, 162, 235)',
              'rgb(153, 102, 255)',
              'rgb(201, 203, 207)'
            ],
            borderWidth: 1
                   }]
               }
           })
          </script>
  </div>
</div>
