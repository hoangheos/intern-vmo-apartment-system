Nhìn vào thế giới thực. Xung quanh bạn là vô số các đối tượng: cái bàn, chiếc điện thoại, con người, chiếc xe hơi...
	Mỗi đối tượng này đều có 2 đặc điểm chính:
	- Thuộc tính (Properties/Attributes): Là những thông tin, đặc điểm của đối tượng đó:
	Chiếc xe hơi: có màu sắc, có thương hiệu, có số bánh, có tốc độ hiện tại.
	- Hành vi (Behaviors/Methods): Là những hành động mà đối tượng đó có thể thực hiện.
	Chiếc xe hơi: có thể chạy, có thể phanh, có thể bật đèn.
Lập trình Hướng đối tượng (Object-Oriented Programming - OOP) chính là việc chúng ta mang tư duy này vào trong lập trình. Thay vì viết code dưới dạng một loạt các lệnh tuần tự, chúng ta sẽ tổ chức code xoay quanh các "đối tượng" ảo này.

Trong OOP cần quan tâm hai khái niệm cơ bản nhất cần phân biệt:

- Lớp (Class): Là một bản thiết kế hoặc một khuôn mẫu. Nó định nghĩa các thuộc tính và hành vi chung cho một loại đối tượng.
	Ví dụ: Bản thiết kế của một chiếc xe hơi sẽ định nghĩa rằng "xe hơi phải có màu sắc, có bánh xe" và "phải có khả năng chạy, phanh".
- Đối tượng (Object): Là một thể hiện cụ thể được tạo ra từ một Lớp.
	Ví dụ: Từ bản thiết kế xe hơi, ta có thể tạo ra các đối tượng cụ thể: một chiếc Vinfast màu đỏ, một chiếc Toyota màu đen. Cả hai đều là đối tượng của Lớp "Xe hơi".
=> Lớp là bản thiết kế, đối tượng là sản phẩm thực tế được tạo ra từ bản thiết kế đó.

4 đặc tính quan trọng định hình nên phương pháp OOP:

	Đặc tính 		Ý tưởng chính			
Tính đóng gói			Gói gọn dữ liệu và các phương thức xử lý dữ liệu đó vào chung một đối 
				tượng, và che giấu những chi tiết xử lý phức tạp bên trong.

Tính trừu tượng			Tổng quát hóa sự phức tạp, chỉ đưa ra các chức năng cần thiết cho người 
				dùng. Tập trung vào "cái gì" đối tượng làm, thay vì "như thế nào".

Tính kế thừa			Cho phép một lớp (lớp con) có thể thừa hưởng lại các thuộc tính và phương
				thức từ một lớp khác (lớp cha).	

Tính đa hình			Cho phép một hành động được thực hiện theo nhiều cách khác nhau tùy vào đối
				tượng nào đang thực hiện nó.	

Ưu điểm:
- Tái sử dụng mã (Reusability): Nhờ tính kế thừa, bạn không phải viết lại code đã có.
- Dễ bảo trì và nâng cấp (Maintainability): Nhờ tính đóng gói, khi bạn sửa code bên trong một đối tượng, nó sẽ không làm ảnh hưởng đến các phần khác của chương trình.
- An toàn và bảo mật (Security): Tính đóng gói giúp che giấu dữ liệu quan trọng, ngăn chặn các truy cập không hợp lệ.
- Tổ chức code rõ ràng (Organization): OOP giúp mô hình hóa các bài toán phức tạp trong thế giới thực một cách tự nhiên, làm cho cấu trúc dự án trở nên logic và dễ hiểu hơn.

Nhược điểm:
- Cần tư duy trừu tượng và thiết kế tốt ban đầu.
- Phức tạp hơn nếu dùng sai cách hoặc cho các bài toán đơn giản.

VD:

// Lớp cha
class Animal {
    public void eat() {
        System.out.println("Đối tượng này đang ăn...");
    }
}

// Lớp con Dog kế thừa Animal
class Dog extends Animal {
    public void bark() {
        System.out.println("Gâu gâu!");
    }
}