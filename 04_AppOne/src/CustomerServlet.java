import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * @author sithum
 */
@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ThogaKade",
                    "root",
                    "password"
            );

            ResultSet rst = connection.prepareStatement("SELECT * FROM Customer").executeQuery();
            String allRecords="";
            while (rst.next()){
                String id = rst.getString(1);
                String name = rst.getString(2);
                String address = rst.getString(3);
                double salary = rst.getDouble(4);
                System.out.println(id+" "+name+" "+address+" "+salary);

                String customer = "{\"id\":\""+id+"\",\"name\":\""+name+"\",\"address\":\""+address+"\",\"salary\":\""+salary+"\"},";
                allRecords=allRecords+customer;

            }

            String finalJson = "["+allRecords.substring(0,allRecords.length()-1)+"]";
            resp.getWriter().write(finalJson);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
