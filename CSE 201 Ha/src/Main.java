
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống sau dòng chứa số nguyên

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+"); // Tách dữ liệu theo khoảng trắng
            String maKhachHang = parts[0];
            String maSoTaiKhoan = parts[1];
            double soTien = Double.parseDouble(parts[2]);

            // Xử lý thông tin của mỗi cặp dữ liệu ở đây
            System.out.println("Khach hang: " + maKhachHang + ", So tai khoan: " + maSoTaiKhoan + ", So tien: " + soTien);
        }

        scanner.close();
    }
}