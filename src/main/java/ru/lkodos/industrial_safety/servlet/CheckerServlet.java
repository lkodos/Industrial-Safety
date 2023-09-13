package ru.lkodos.industrial_safety.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.lkodos.industrial_safety.service.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/checker")
public class CheckerServlet extends HttpServlet {
    private final Service service = Service.getINSTANCE();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> answers = Arrays.asList(req.getParameterValues("answer"));
        int id = (int) req.getServletContext().getAttribute("id");
        List<String> correctAnswer = service.getCorrectAnswer(id);

        if (answers.equals(correctAnswer)) {
            req.setAttribute("isRight", true);
        } else {
            req.setAttribute("isRight", false);
        }
        req.getRequestDispatcher("WEB-INF/jsp/training.jsp").forward(req, resp);
    }
}