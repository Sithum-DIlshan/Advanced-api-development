import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sithum
 */
@WebServlet(urlPatterns = "/items/*")
public class WildcardMappingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Wild card mapping spec invoked");
        System.out.println("=================================");
        System.out.println("Path Info "+req.getPathInfo());
        System.out.println("Context Path "+req.getContextPath());
        System.out.println("Servlet Path "+req.getServletPath());
        System.out.println("Method "+req.getMethod());
        System.out.println("=================================");
    }
}
