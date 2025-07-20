Inversion of Control (IoC)

1. Nguyên lý hoạt động

Trong lập trình truyền thống, code của bạn nắm toàn quyền kiểm soát. Nó là trung tâm của vũ trụ.
- Code của bạn (hàm main chẳng hạn) sẽ bắt đầu chạy.
- Nó sẽ chủ động quyết định khi nào cần một đối tượng khác (một thư viện, một lớp tiện ích).
- Nó sẽ chủ động gọi và tạo ra đối tượng đó (new MyService()).

=> Code của bạn nắm quyền kiểm soát các thư viện/framework.

Với IoC, vai trò này bị đảo ngược hoàn toàn. Code của bạn không còn là trung tâm nữa. Thay vào đó, nó trở thành các "plugin" hay "module" được cắm vào một hệ thống lớn hơn (là Framework hoặc Container).
- Framework/Container sẽ khởi động và nắm quyền kiểm soát luồng chính.
- Bạn chỉ viết các lớp và các phương thức chứa logic nghiệp vụ của mình.
- Bạn "đăng ký" các lớp này với Framework.
- Khi có một sự kiện nào đó xảy ra (ví dụ: có một request HTTP đến), Framework sẽ chủ động gọi đến code của bạn.

=> Framework nắm quyền kiểm soát. 

Tóm lại: IoC là một nguyên tắc thiết kế nhằm lấy đi quyền kiểm soát luồng chính từ tay lập trình viên và giao nó cho một framework hoặc container. Mục đích là để lập trình viên chỉ cần tập trung vào việc viết logic nghiệp vụ ("cái gì" cần làm), còn việc khi nào và làm thế nào để thực thi logic đó ("khi nào" và "như thế nào") sẽ do framework quyết định. Điều này giúp giảm sự phụ thuộc và tăng tính module hóa của hệ thống.

2. Cơ chế hoạt động

B1:  Cấu hình và Đăng ký 
B2: Khởi tạo và Lắp ráp
B3: Quản lý Vòng đời


(DI - Dependency Injection)

1. Nguyên lý hoạt động
Nguyên lý của DI tập trung vào việc làm thế nào để một đối tượng có được những thứ mà nó cần để hoạt động. Nó là câu trả lời trực tiếp cho nguyên tắc "Đảo ngược sự phụ thuộc" (Dependency Inversion Principle) trong SOLID.


B1: Xác định phụ thuộc
B2: Tiêm phụ thuộc từ bên ngoài
B3: IoC Container thực hiện DI tự động

VD:
public class MainApp {
    public static void main(String[] args) {
        // --- KỊCH BẢN 1: GỬI BẰNG EMAIL ---

        // 1. Bên ngoài tạo ra đối tượng phụ thuộc cụ thể
        IMessageService emailSender = new EmailService();

        // 2. "Tiêm" đối tượng đó vào OrderService khi tạo nó
        OrderService orderServiceWithEmail = new OrderService(emailSender);

        // 3. Sử dụng
        orderServiceWithEmail.processOrder("khachhang@email.com");


        System.out.println("\n--- YÊU CẦU THAY ĐỔI: GỬI BẰNG SMS ---\n");


        // --- KỊCH BẢN 2: GỬI BẰNG SMS ---

        // 1. Chỉ cần thay đổi đối tượng được tạo ở đây
        IMessageService smsSender = new SmsService();

        // 2. "Tiêm" sự phụ thuộc mới vào. Lớp OrderService không cần sửa đổi gì cả!
        OrderService orderServiceWithSms = new OrderService(smsSender);

        // 3. Sử dụng
        orderServiceWithSms.processOrder("0987654321");
    }
}
