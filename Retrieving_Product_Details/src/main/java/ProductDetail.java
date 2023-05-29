

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.DBConnection;
/**
* Servlet implementation class ProductDetails
*/
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public ProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        try {
                 PrintWriter out = response.getWriter();
                 out.println("<html><body>");
                 
                InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
                Properties props = new Properties();
                props.load(in);
                
                DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
                Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                
                int id = Integer.parseInt(request.getParameter("pname"));
				ResultSet rst = stmt.executeQuery("select * from product");
				boolean bn = false;
				out.print("<table width='100%' border='1'>");
				out.println("<tr><th>Product ID</th><th>Product Name</th><th>Product Price</th><th>Date Added</th></tr>");
				while (rst.next()) {
					if (rst.getInt("ID") == id) {
						out.print("<h1>Hi, The Details for the Entered Product " +rst.getInt("ID") + " is :</h1>");
						bn = true;
						out.println("<tr>");
						out.print("<td>" + rst.getInt("ID") + "</td>");
						out.print("<td>"+ rst.getString("name")+ "</td>");
						out.print("<td>" + rst.getBigDecimal("product_price") + "</td>");
						out.print("<td>" + rst.getString("date_added") + "</td>");
						out.println("</tr>");
						}
							
					}
					if(bn==false)
						out.println("<h2>No Details Found!!!</h2>");
				out.println("</table>");
				
				
				//boolean b = false;
                //while (rst.next()) 
                	 //{
                	//if (rst.getInt("ID") == id) 
         				//{
         				//out.println("<h1>Hi, The Details for the Entered Product " +rst.getInt("ID") + " is: </h1>");
                        //out.println("<h3>PRODUCT ID: "+rst.getInt("ID")+"</h3>");
                        //out.println("<h3>PRODUCT NAME: " + rst.getString("name")+"</h3>");
                        //out.println("<h3>PRODUCT PRICE: " + rst.getBigDecimal("product_price")+"</h3>"); 
                        //out.println("<h3>DATE ADDED: " +  rst.getString("date_added")+"</h3>" +"<Br>");
         				//b = true;
         				//}
                	 //}
                
                	 
                
                stmt.close();
                
                
                
                out.println("</body></html>");
                conn.closeConnection();
                  
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (SQLException e) {
                e.printStackTrace();
        }
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
}

}
