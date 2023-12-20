# Sử dụng image JDK 17
FROM adoptopenjdk/openjdk17:latest

# Tạo thư mục app và copy file JAR vào thư mục app
WORKDIR /app
COPY storm-media-management-0.0.1-SNAPSHOT.jar /app

# Expose cổng 8883 (hoặc cổng mà ứng dụng của bạn sử dụng)
EXPOSE 8883

# Chạy ứng dụng khi container được khởi chạy
CMD ["java", "-jar", "storm-media-management-0.0.1-SNAPSHOT.jar"]