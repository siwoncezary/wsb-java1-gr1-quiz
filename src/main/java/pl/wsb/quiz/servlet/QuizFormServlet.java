package pl.wsb.quiz.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import pl.wsb.quiz.service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuizFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/quiz-form.jsp").forward(req, resp);
    }
}
