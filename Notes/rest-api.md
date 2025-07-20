REST API

Khái niệm
	API là viết tắt của Application Programming Interface (Giao diện Lập trình Ứng dụng).
	REST là viết tắt của REpresentational State Transfer. Đây không phải là một công nghệ, mà là một kiểu kiến trúc hay một tập hợp các quy tắc để thiết kế API. Hầu hết các API trên web ngày nay đều được thiết kế theo kiểu REST này vì nó đơn giản, hiệu quả và dễ mở rộng.
	Vậy REST API là một API tuân theo các quy tắc của kiến trúc REST.

Các thành phần chính của REST API
1.	Resource (Tài nguyên): Là bất cứ thứ gì mà API có thể cung cấp thông tin về nó. Ví dụ: một người dùng, một sản phẩm, một bài viết, một bức ảnh... Mỗi tài nguyên sẽ có một định danh duy nhất, thường là một URL.
	- https://api.example.com/users (tài nguyên là danh sách người dùng)
	- https://api.example.com/users/123 (tài nguyên là người dùng có ID 123)
2. HTTP Methods (Các phương thức HTTP): Đây là những "hành động" mà Client muốn thực hiện trên tài nguyên. Các hành động phổ biến nhất tương ứng với các thao tác CRUD (Create, Read, Update, Delete).
	Phương thức HTTP	Hành động CRUD		Ví dụ sử dụng
	GET			Read (Đọc/Lấy)		Lấy thông tin của một người dùng, xem danh sách sản phẩm.
	POST			Create (Tạo mới)	Đăng ký một tài khoản người dùng mới, đăng một bài viết mới.
	PUT / PATCH		Update (Cập nhật)	Chỉnh sửa thông tin cá nhân, cập nhật số lượng tồn kho.
	DELETE			Delete (Xóa)		Xóa một bài viết, xóa một sản phẩm khỏi giỏ hàng.
3. Request (Yêu cầu): Khi Client muốn thực hiện hành động, nó gửi một Request đến Server. Request này bao gồm:
	- Endpoint (URL): Địa chỉ của tài nguyên. Ví dụ: /users/123.
	- Method (Phương thức): Hành động muốn làm. Ví dụ: GET.
	- Headers: Thông tin bổ sung (ví dụ: định dạng dữ liệu, mã xác thực...).
	- Body (Phần thân): Dữ liệu gửi đi (chỉ dùng với POST, PUT, PATCH). Ví dụ: thông tin người dùng mới cần tạo.
4. Response (Phản hồi): Sau khi xử lý Request, Server sẽ gửi lại một Response. Response này bao gồm:
⦁	Status Code (Mã trạng thái): Cho biết kết quả của Request.
	- 200 OK: Thành công.
	- 201 Created: Tạo mới thành công.
	- 404 Not Found: Không tìm thấy tài nguyên.
	- 400 Bad Request: Yêu cầu không hợp lệ.
	- 500 Internal Server Error: Lỗi từ phía server.
⦁	Body (Phần thân): Dữ liệu mà Client yêu cầu, thường ở định dạng JSON (định dạng phổ biến nhất hiện nay) hoặc XML.

VD: API như một Người Phục Vụ trong Nhà Hàng
	Hãy tưởng tượng bạn đang ở trong một nhà hàng:
⦁	Bạn (Khách hàng): Bạn là Client. Bạn muốn ăn một món gì đó.
⦁	Nhà bếp: Là Server. Nơi này chứa "dữ liệu" (đồ ăn) và có khả năng chế biến chúng.
⦁	Thực đơn (Menu): Đây là danh sách những gì bạn có thể yêu cầu. Trong thế giới lập trình, nó giống như Tài liệu API (API Documentation).
⦁	Người phục vụ: Chính là API.
	Quy trình sẽ được thực hiện như sau:
⦁	Bạn (Client) xem thực đơn và gọi món (gửi một Yêu cầu - Request) cho người phục vụ (API). Ví dụ: "Cho tôi một đĩa bít tết".
⦁	Người phục vụ (API) nhận yêu cầu của bạn, đi vào nhà bếp (Server) và truyền đạt lại yêu cầu đó.
⦁	Nhà bếp (Server) chế biến món ăn (xử lý yêu cầu và lấy dữ liệu).
⦁	Khi món ăn đã sẵn sàng, người phục vụ (API) sẽ mang nó từ nhà bếp ra cho bạn. Món ăn này chính là Phản hồi - Response.

=> API là người trung gian, giúp Client (ứng dụng của bạn) và Server (nơi chứa dữ liệu) có thể "nói chuyện" và trao đổi thông tin với nhau một cách có quy tắc.

VD: Ứng dụng thời tiết
1.	Bạn mở app thời tiết trên điện thoại (Client) và muốn xem thời tiết ở Hà Nội.
2.	App sẽ gửi một Yêu cầu (Request) đến máy chủ thời tiết (Server).
	- Method: GET (vì bạn chỉ muốn lấy thông tin).
	- URL: https://api.thoitiet.com/v1/weather?city=Hanoi
3. Máy chủ thời tiết (Server) nhận được yêu cầu, tìm trong cơ sở dữ liệu của nó thông tin về thời tiết ở Hà Nội.
4. Server trả về một Phản hồi (Response) cho app của bạn.
	- Status Code: 200 OK (thành công).
	- Body (dữ liệu JSON):
	{
	  "city": "Hà Nội",
	  "temperature": 32,
	  "unit": "celsius",
	  "description": "Nắng nhẹ, có mây"
	}
5. App của bạn nhận được dữ liệu JSON này và hiển thị nó lên màn hình một cách đẹp mắt cho bạn xem.