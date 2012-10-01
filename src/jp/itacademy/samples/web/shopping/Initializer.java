package jp.itacademy.samples.web.shopping;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent e) {
        ServletContext ctx = e.getServletContext();
        ctx.removeAttribute("items");
    }

    @Override
    public void contextInitialized(ServletContextEvent e) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "やくそう", 8));
        items.add(new Item(2, "どくけしそう", 10));
        items.add(new Item(3, "せいすい", 20));
        items.add(new Item(4, "まんげつそう", 30));
        items.add(new Item(5, "鹿せんべい", 4980000));
        ServletContext ctx = e.getServletContext();
        ctx.setAttribute("items", items);
    }

}
