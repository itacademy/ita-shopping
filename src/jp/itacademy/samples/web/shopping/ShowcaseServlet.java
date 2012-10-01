package jp.itacademy.samples.web.shopping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.itacademy.samples.web.BaseServlet;

@WebServlet("/showcase")
public class ShowcaseServlet extends BaseServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        forward("/WEB-INF/showcase.jsp", req, res);
    }
}
