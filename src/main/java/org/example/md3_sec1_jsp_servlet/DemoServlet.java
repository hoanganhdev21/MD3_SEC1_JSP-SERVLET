package org.example.md3_sec1_jsp_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Yêu cầu
// localhost:8080/home => Chuyển về trang home
// Bước 1: Định nghĩa servlet class
// doGet()
// Chuyển về trang JSP
// Giao diện Home

// Excercise CRUD
// C-CREATE
// R-READ
// U-UPDATE
// D-DELETE

// localhost:8080/student => Hiển thị danh sách sinh viên


@WebServlet(name = "demoServlet", value = "/home") // => Alutation đánh dấu 1 web servlet.
// name = "demoServlet" => Tên của servlet thường lấy tên của class luôn.
// value = "/demo-servlet" => Thành phần xuất hiện trên URL => Mỗi URL sẽ khớp với 1 Servlet nào đấy.
public class DemoServlet extends HttpServlet {
// kế thừa extends HttpServlet

    // doGet: => Nhận các yêu cầu gửi lên từ phương thức get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // HttpServletRequest req, HttpServletResponse resp => Gọi là kỹ thuật DI
//        super.doGet(req, resp);
        // Xử lý và điều hướng
        String fullName = "Nguễn Văn A";
        req.setAttribute("fullName", fullName); // fullName đẩy biến này vào đối tượng HttpServletRequest
        // => Mnag biến này dang trang JSP để hiển thị
        req.getRequestDispatcher("home.jsp").forward(req,resp);  // forward(req,resp) => mang đối tượng của req theo
    }

    // doPost: => Nhận các yêu cầu gửi lên từ phương thức post
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
