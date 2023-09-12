package ru.lkodos.industrial_safety.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.lkodos.industrial_safety.service.Service;

import java.io.IOException;

@WebServlet("/runtraining")
public class RunTrainingServlet extends HttpServlet {

    private final Service service = Service.getINSTANCE();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numberOfQuestions = service.getNumberOfQuestions();
        req.getServletContext().setAttribute("numberOfQuestions", numberOfQuestions);
        req.getRequestDispatcher("WEB-INF/jsp/training.jsp").forward(req, resp);
    }
}
