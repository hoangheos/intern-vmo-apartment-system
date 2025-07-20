SOLID không phải là một công nghệ hay một framework. Nó là tên viết tắt của 5 nguyên tắc thiết kế phần mềm hướng đối tượng được đưa ra bởi Robert C. Martin (Uncle Bob).

Mục tiêu của SOLID là giúp chúng ta viết ra những phần mềm linh hoạt, dễ bảo trì, dễ mở rộng và dễ hiểu hơn. Hãy tưởng tượng việc xây một tòa nhà:

- Không có SOLID: Giống như xây một tòa nhà Jenga. Rút một thanh gỗ ra (sửa một chức năng nhỏ) có thể làm sụp đổ cả tòa nhà.
- Có SOLID: Giống như xây nhà bằng các khối LEGO. Mỗi khối được thiết kế tốt, độc lập. Bạn có thể dễ dàng thay thế một khối hoặc lắp thêm các khối mới mà không ảnh hưởng đến toàn bộ công trình.

5 nguyên tắc của SOLID:
1. S - Single Responsibility Principle (Nguyên tắc Đơn trách nhiệm)
- Tư tưởng: Một lớp chỉ nên có một và chỉ một lý do để thay đổi.
- Nghĩa là: Mỗi lớp chỉ nên chịu trách nhiệm cho một chức năng duy nhất của phần mềm.

2. O - Open/Closed Principle (Nguyên tắc Đóng/Mở)
- Tư tưởng: Có thể thoải mái mở rộng (Open for extension), nhưng phải đóng với việc sửa đổi (Closed for modification).
- Nghĩa là: Bạn nên có thể thêm chức năng mới mà không cần phải sửa đổi code cũ đã tồn tại và đã được kiểm thử.

3. L - Liskov Substitution Principle (Nguyên tắc Thay thế Liskov)
- Tư tưởng: Trong một chương trình, các đối tượng của lớp con phải có thể thay thế cho đối tượng của lớp cha mà không làm thay đổi tính đúng đắn của chương trình.
- Nghĩa là: Lớp con không được phá vỡ hành vi hoặc logic của lớp cha.

4. I - Interface Segregation Principle (Nguyên tắc Phân tách Interface)
- Tư tưởng: Thà có nhiều interface nhỏ và chuyên biệt còn hơn một interface lớn và tổng hợp.
- Nghĩa là: Một client không nên bị buộc phải phụ thuộc vào những phương thức mà nó không sử dụng.

5. D - Dependency Inversion Principle (Nguyên tắc Đảo ngược Phụ thuộc)
- Tư tưởng:
     + Các module cấp cao không nên phụ thuộc vào các module cấp thấp. Cả hai nên phụ thuộc vào một sự trừu tượng (abstraction, thường là interface).
     + Sự trừu tượng không nên phụ thuộc vào chi tiết. Chi tiết nên phụ thuộc vào sự trừu tượng.
- Nghĩa là: Thay vì phụ thuộc vào một lớp cụ thể, hãy phụ thuộc vào một interface.

VD: mỗi lớp có một trách nghiệm khác nhau từ nguyên tắc 1

class User {
    // Chỉ chịu trách nhiệm về dữ liệu người dùng
    void getInfo() { /* ... */ }
}

class UserRepository {
    // Chỉ chịu trách nhiệm về việc lưu/lấy User từ DB
    void save(User user) { /* ... */ }
}

class EmailService {
    // Chỉ chịu trách nhiệm về việc gửi email
    void sendWelcomeEmail(User user) { /* ... */ }
}
	