Stateful (Có trạng thái)
Trong kiến trúc stateful, server sẽ lưu trữ thông tin về phiên làm việc (session) của client. Server "nhớ" những gì client đã làm trước đó.

1.	Cách hoạt động:

⦁	Client gửi yêu cầu đầu tiên (ví dụ: đăng nhập).
⦁	Server xác thực client, tạo một phiên làm việc (session) và lưu lại thông tin trên bộ nhớ hoặc cơ sở dữ liệu của server (ví dụ: userId=123, trangThai=DaDangNhap, hangTrongGio=['sach', 'but']).
⦁	Server gửi lại cho client một session ID.
⦁	Trong các yêu cầu tiếp theo, client chỉ cần gửi kèm session ID. Server sẽ dùng ID này để tra cứu lại toàn bộ thông tin đã lưu và biết client là ai, đang làm gì.

2. Ưu điểm:

⦁	Hiệu năng tốt: Không cần gửi lại toàn bộ thông tin xác thực/bối cảnh trong mỗi yêu cầu.
⦁	Mạch lạc: Luồng làm việc tự nhiên, giống như một cuộc hội thoại liên tục.

3. Nhược điểm:

⦁	Khó mở rộng (Scalability): Nếu có nhiều server (load balancing), làm sao để server B biết được thông tin phiên làm việc mà server A đã tạo? (Phải dùng các kỹ thuật phức tạp như "sticky sessions" - bắt client luôn phải kết nối tới cùng một server, hoặc đồng bộ session giữa các server - rất tốn kém).
⦁	Độ tin cậy thấp: Nếu server đang lưu phiên làm việc bị sập, toàn bộ thông tin trạng thái của client sẽ mất (ví dụ: giỏ hàng đang mua sắm bị xóa sạch).

4. Ví dụ:

⦁	Các ứng dụng web truyền thống (ASP.NET Web Forms, JSF).
⦁	Giao thức FTP (File Transfer Protocol).
⦁	Các server game online (cần liên tục lưu trạng thái của người chơi).



Stateless (Phi trạng thái)
Trong kiến trúc stateless, server không lưu trữ bất kỳ thông tin phiên làm việc nào của client. Mỗi yêu cầu từ client phải chứa tất cả thông tin cần thiết để server có thể xử lý nó.

1.	Cách hoạt động:
⦁	Client gửi yêu cầu đăng nhập.
⦁	Server xác thực, sau đó tạo ra một "tấm thẻ" (thường là một token, ví dụ: JWT - JSON Web Token) chứa tất cả thông tin cần thiết (userId, quyền hạn...). Tấm thẻ này được mã hóa và gửi lại cho client.
⦁	Client có trách nhiệm tự lưu trữ tấm thẻ này.
⦁	Trong mọi yêu cầu tiếp theo, client phải tự "đeo thẻ" (gửi kèm token trong header của request).
⦁	Server nhận yêu cầu, xem "thẻ", xác thực nó và xử lý yêu cầu. Server không cần phải nhớ bất cứ điều gì.

2. Ưu điểm:

⦁	Dễ mở rộng (High Scalability): Bất kỳ server nào cũng có thể xử lý yêu cầu của client, miễn là client gửi kèm token hợp lệ. Rất phù hợp với môi trường cloud và microservices.
⦁	Độ tin cậy cao: Nếu một server bị sập, yêu cầu có thể được chuyển ngay sang một server khác mà không có vấn đề gì.
⦁	Đơn giản phía server: Server không cần lo về việc quản lý, lưu trữ, đồng bộ session.

3. Nhược điểm:

⦁	Tốn băng thông hơn: Mỗi yêu cầu phải mang thêm dữ liệu (token), có thể làm tăng kích thước request.
⦁	Client phức tạp hơn: Client phải tự quản lý trạng thái (lưu trữ và gửi token).

4. Ví dụ:

⦁	REST API (đây là một trong những ràng buộc cốt lõi của REST).
⦁	Giao thức HTTP (về bản chất là stateless).
⦁	Kiến trúc Microservices.







So sánh nhanh
	Tiêu trí			Stateful (Có trạng thái)		Stateless (Phi trạng thái)
	Lưu trữ trạng thái		Trên Server				Trên Client (hoặc trong chính request)
	Bối cảnh mỗi yêu cầu		Server "nhớ" bối cảnh từ trước		Mỗi yêu cầu là độc lập, phải chứa đủ thông tin
	Khả năng mở rộng		Thấp, phức tạp				Cao, dễ dàng
	Độ tin cậy			Thấp (phụ thuộc vào một server)		Cao (không phụ thuộc server nào)
	Ví dụ điển hình			FTP, Game Server, Web App cũ		REST API, HTTP, Microservices

=> Không có kiến trúc nào là "tốt hơn" tuyệt đối. Sự lựa chọn phụ thuộc vào bài toán cụ thể.
