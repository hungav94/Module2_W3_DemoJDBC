import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "MyServlet", urlPatterns = "/insert")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        System.out.println(id);
        try {
            Connection connection = DBConnection.initializeDatabase();
            PreparedStatement st = connection.prepareStatement("insert into demo values(?,?)");
            st.setInt(1, id);
            st.setString(2,name);
            st.executeUpdate();
            st.close();
            connection.close();

            PrintWriter writer = response.getWriter();
            writer.println("<html><body><b>Successfully Inserted</b>");
            writer.println("<p>id: " + id + "</p>" );
            writer.println("<p>name: " + name + "</p>" );
            writer.println("</body></html>" );


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
