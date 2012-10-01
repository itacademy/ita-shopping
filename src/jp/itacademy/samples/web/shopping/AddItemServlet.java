package jp.itacademy.samples.web.shopping;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.itacademy.samples.web.BaseServlet;

@WebServlet("/addItem")
public class AddItemServlet extends BaseServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception ignore) {
        }

        Item item = getItemById(id);
        if (item == null) {
            req.setAttribute("error", "商品IDが正しくありません");
            forward("/WEB-INF/error.jsp", req, res);
            return;
        }

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.addItem(item);

        redirect("/cart", req, res);
    }

    @SuppressWarnings("unchecked")
    private Item getItemById(int id) {
        ServletContext context = getServletContext();
        List<Item> items = (List<Item>) context.getAttribute("items");
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
