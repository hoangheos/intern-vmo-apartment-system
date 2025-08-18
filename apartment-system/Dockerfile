# =================================================================
# GIAI ĐOẠN 1: BUILD JAR (Sử dụng môi trường có đủ công cụ)
# =================================================================
# Sử dụng base image của Maven có chứa JDK 17. Đặt tên giai đoạn này là "build"
FROM maven:3.8.5-openjdk-17 AS build

# Đặt thư mục làm việc bên trong container
WORKDIR /app

# 1. Copy file pom.xml và tải dependency trước
# Điều này tận dụng Docker cache. Bước này chỉ chạy lại khi pom.xml thay đổi
COPY pom.xml .
RUN mvn dependency:go-offline

# 2. Copy toàn bộ source code của bạn vào container
COPY src ./src

# 3. Chạy lệnh build của Maven để tạo file .jar
# Lệnh này sẽ biên dịch code và đóng gói thành file jar trong thư mục /app/target/
RUN mvn package -DskipTests


# =================================================================
# GIAI ĐOẠN 2: RUN APP (Sử dụng môi trường tối giản để chạy)
# =================================================================
# Sử dụng base image chỉ chứa Java Runtime (JRE), rất nhẹ
FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc
WORKDIR /app

# 4. Copy file JAR đã được tạo ở giai đoạn "build" vào image hiện tại
# Đây là bước quan trọng nhất, chỉ lấy sản phẩm cuối cùng
COPY --from=build /app/target/*.jar app.jar

# Cổng mà ứng dụng Spring Boot sẽ lắng nghe
EXPOSE 8080

# Lệnh để khởi chạy ứng dụng khi container bắt đầu
ENTRYPOINT ["java", "-jar", "app.jar"]