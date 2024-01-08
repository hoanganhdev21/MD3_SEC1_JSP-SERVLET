package org.example.md3_sec1_jsp_servlet;

import org.example.md3_sec1_jsp_servlet.model.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet",value = "/student")
public class StudentServlet extends HttpServlet {
    private List<student> students = new ArrayList<>(); // Khai báo

    // Khởi tạo
    // Khi servlet kích hoạt nó sẽ nhảy vào init đầu tiên
    @Override
    public void init() throws ServletException {
        // khoi tao List<Student> để duyệt
        students.add(new student("B01","Nguyễn Văn A",19,true));
        students.add(new student("B02","Nguyễn Thị B",20,false));
        students.add(new student("B03","Nguyễn Văn D",20,true));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Nhiệm vụ chuyển về trang chứa danh sách gồm các table
        req.setAttribute("students",students);
        req.getRequestDispatcher("student.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Đã nhận dữ liệu từ form method POST");
        req.setCharacterEncoding("UTF-8");
        // Bước 1: lấy từ form
        String studentCode = req.getParameter("studentCode");
        String studentName = req.getParameter("studentName");
        int age = Integer.parseInt(req.getParameter("age"));
        boolean sex = Boolean.parseBoolean(req.getParameter("sex"));
        // Bước 2: đẩy vào list student
        student student = new student(studentCode,studentName,age,sex);
        students.add(student);
        doGet(req,resp);
    }
}
