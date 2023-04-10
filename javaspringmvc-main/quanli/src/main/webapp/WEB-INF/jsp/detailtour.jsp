
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
<div class="col-md-3">
   
    <div>
          <div class="card bg-info text-white">
            <div class="card-body"><i class="fa fa-shopping-cart" style="font-size:25px;color: white;"></i> Số lượng phòng (<c:out value="${sessionScope.slItems}"/>)
                <c:if test="${sessionScope.slItems != null}">
                    <a class="btn btn-outline-info" href="<c:url value="/carttour"/>"> Xem chi tiết</a>
                </c:if>
                
            </div>
          </div>
      
       
    </div>
    <h3 >Tìm kiếm theo</h3> 
  <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Thành Phố
    </button>
    <div class="dropdown-menu">
      <c:forEach var="tp" items="${thanhpho}">
          <a class="dropdown-item" href="<c:url value="/khachsanparam/?name=${tp.tentp}"/>"> ${tp.tentp}</a>
      </c:forEach>
    </div>
</div>
 <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Loại Phòng
    </button>
    <div class="dropdown-menu">
        <c:forEach items="${loaiphong}" var="lp">
             <a class="dropdown-item" href="<c:url value="/khachsanparamlp/?name=${lp.tenLoaiPhong}"/>">${lp.tenLoaiPhong}</a>
        </c:forEach>
    </div>
</div>
</div>
<div class="col-md-8" >
    <div class="row">
        <div class="card" style="width:1600px">
            <img class="card-img-top" src="${tour.image}" alt="Card image">
            <div class="card-body">
             <h1>${tour.nametour}</h1>
            <h2>Thành Phố:<small>${tour.place}</small></h2>
            <h2>Ngày bắt đầu:<small>${tour.start}</small></h2>
            <h2>Ngày kết thúc:<small>${tour.finish}</small></h2>
            <c:set var="tien" value="${tour.price}" />
            <h2>Giá:<small> <fmt:formatNumber type="number" maxFractionDigits="3" value="${tien}"/> VND</small></h2>
            <h2>Số lượng còn lại:<small>${tour.quantity}</small></h2>
            <h2>Phương tiện:<small>${tour.phuongtien} </small></h2>
            <a href="<c:url value="/cart/add/tour/${tour.idtour}"/>" class="btn btn-success">Đặt Tour</a>
            <h2>Mô tả:<small>${tour.description} </small></h2>
            <p>
                GIÁ TOUR BAO GỒM: 

Xe ô tô đời mới đưa đón theo chương trình: Nội Bài – Mộc Châu – Sơn La – Điện Biên – Lai Châu – Sapa – Lào Cai – Nội Bài
Ăn chính: 09 bữa. Thực đơn áp dụng: 150.000đ/ 1 bữa. Thưởng thức Ẩm thực theo vùng miền, được đổi món thường xuyên.
Ăn nhẹ ngày 5 trước khi lên sân bay
Ăn sáng: Bữa sáng ngày 1 ăn trên máy  bay & các bữa khác ăn tại khách sạn.
04 đêm ngủ khách sạn 3 sao, tiêu chuẩn 02 người/phòng (trường hợp lẻ ghép ngủ 3): 
1 đêm tại Mộc Châu: Khách sạn Sao Xanh hoặc tương đương
2 đêm Điện Biên: Khách sạn A1, Pha Đin hoặc tương đương
1 đêm Sapa: Khách sạn Sapa Panorama, Vista hoặc tương đương
Vé thắng cảnh tại các điểm thăm quan được đề cập dưới đây:
+ Mộc Châu: Mộc Châu Happy Land
+ Sơn La: Nhà Tù – Bảo tàng Sơn La
+ Điện Biên: Bảo Tàng, Mường Phăng, Đồi A1, Hầm tướng Đờ Cát
+ Sapa: KDL Swing Sapa
Hướng dẫn viên phục vụ nhiệt tình, thành thạo, chu đáo xuyên suốt tuyến du lịch
Chương trình giao lưu văn nghệ tại bản Mến – Điện Biên.
Nước uống phục vụ trên xe, mỗi ngày 01 chai 500ml
Bảo hiểm du lịch trọn tour mức đền bù tối đa 20.000.000đ/người/vụ
Mũ du lịch

GIÁ TOUR KHÔNG BAO GỒM: 

Hóa đơn thuế GTGT 10%
Vé cáp treo + vé xe điện leo núi tại Fansipan 
Phụ thu tăng giá vé nếu có sự thay đổi giá vé của các khu du lịch khi chúng tôi chưa kịp điều chỉnh giá dịch vụ trong chương trình và thông báo kịp thời đến Quý khách.
Đồ uống trong các bữa ăn, trong khách sạn và các chi phí cá nhân khác
Tiền típ cho lái xe và hướng dẫn viên.

CHÍNH SÁCH TRẺ EM:

Trẻ em từ 1-4 tuổi miễn phí (bố mẹ tự lo mọi chi phí cho trẻ, không chiếm chỗ trên xe)
Trẻ em từ 5-9 tuổi tính 75% giá tour (ăn suất riêng, chỗ ngồi trên xe riêng nhưng phải ngủ chung giường với bố mẹ). Chúng tôi không chịu trách nhiệm nếu như gia đình có mang theo nhiều trẻ em và yêu cầu thêm giường vì cảm thấy chật chội.  
Trẻ em từ 10 tuổi trở lên tính như người lớn.

CÁC QUY ĐỊNH ÁP DỤNG CHO CHƯƠNG TRÌNH:

Dưới đây là mức phạt hủy tour theo quy định của công ty. Chúng tôi sẽ linh động giải quyết từng trường hợp cụ thể trong khả năng cho phép.

Nếu quý khách hủy tour sau khi đăng ký và trước 30 ngày khởi hành: mất phí cọc tour
Nếu quý khách hủy tour từ 20-30 ngày trước ngày khởi hành: phí hủy 50% giá trị tour.
Nếu quý khách hủy tour từ 15-20 ngày trước ngày khởi hành: phí hủy 70% giá trị tour.
Nếu quý khách hủy tour trong vòng 15 ngày trước ngày khởi hành: phí hủy 100% giá trị tour.
Lưu ý : Tùy theo điều kiện nào đến trước chúng tôi sẽ áp dụng điều kiện đó.

ĐIỀU KIỆN QUY ĐỊNH VÉ MÁY BAY: 

VietNam Airlines: Không hoàn hủy, đổi tên, đổi hành trình, tách chặng trong bất cứ trường hợp nào 
Giờ bay có thể thay đổi theo giờ bay của Hãng Hàng Không VietNam Airlines.
Hành lý bao gồm: 12kg xách tay + 23kg ký gửi.
Khi đi máy bay Quý khách nên mang theo một trong các giấy tờ sau: (Chứng minh thư nhân dân còn hạn dưới 15 năm, hoặc hộ chiếu, giấy khai sinh (đối với trẻ em dưới 14 tuổi).
Với trẻ em 14 tuổi (Yêu cầu phải có CMTND, nếu trường hợp chưa có phải có giấy xác nhận nhân thân theo mẫu và đóng dấu của địa phương nơi cư trú).
Với trẻ em không đi cùng bố mẹ phải có giấy xác nhận ủy quyền của bố mẹ có xác nhận của địa phương nơi cư trú cho người đi cùng, để làm thủ tục lên máy bay.

CÁC QUY ĐỊNH CHUNG: 

Nếu bên A hủy tour do bị từ chối làm thủ tục tại sân bay do nhân thân / giấy tờ tùy thân Công ty chúng tôi không chịu trách nhiệm cho sự việc trên. Các chi phí cho chương trình sẽ không được chúng tôi hoàn lại trong trường hợp này.
Do tính chất đoàn ghép khách lẻ, nếu đoàn có từ 10 người lớn trở lên, đoàn sẽ khởi hành đúng ngày. Nếu đoàn không đủ 10 khách, bên B sẽ sắp xếp ngày khởi hành mới và thông báo cho bên A biết trước 15 ngày làm việc. Trường hợp bên A không đi theo lịch khởi hành mới được, bên B sẽ hoàn lại tiền cọc cho bên A.
Nếu Bên B không tổ chức cho đoàn đi đúng thời gian dự kiến do các nguyên nhân bất khả kháng như: Thiên tai, bão lụt, chiến tranh…. Bên B sẽ thu xếp ngày khởi hành mới, mọi chi phí phát sinh do hai bên thỏa thuận.
            </p>
            </div>
        </div>
       
    </div>
    </div>
   
   
         </div>
   


