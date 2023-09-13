package ru.lkodos.industrial_safety.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.lkodos.industrial_safety.service.Service;

import java.io.IOException;
import java.util.List;

@WebServlet("/select")
public class SelectQuestionServlet extends HttpServlet {

    private final Service service = Service.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String question = service.getQuestionById(id);
        List<String> answerOptions = service.getAnswerOptions(id);
//        req.setAttribute("id", id);
        req.getServletContext().setAttribute("id", id);
        req.setAttribute("numberOfQuestions", id);
//        req.setAttribute("question", question);
        req.getServletContext().setAttribute("question", question);
//        req.setAttribute("answerOptions", answerOptions);
        req.getServletContext().setAttribute("answerOptions", answerOptions);
        req.getRequestDispatcher("WEB-INF/jsp/training.jsp").forward(req, resp);
    }
}