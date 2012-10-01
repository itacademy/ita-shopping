package jp.itacademy.samples.web.shopping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.itacademy.samples.web.BaseServlet;

@WebServlet("/checkout")
public class CheckoutServlet extends BaseServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            req.setAttribute("error", "商品が一件もカートにはいっていません");
            forward("/WEB-INF/error.jsp", req, res);
            return;
        }

        cart.clear();
        session.removeAttribute("cart");

        forward("/WEB-INF/checkout.jsp", req, res);
    }
}
