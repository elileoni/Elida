package controller.users;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;
import model.Usuario;
import services.HistorialService;

@WebServlet("/users/historial.do")

public class HistorialUserServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 3455721046062278592L;
	private HistorialService historialService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.historialService = new HistorialService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Producto> itinerario = null;
		HttpSession miSession = (HttpSession) req.getSession();
		Usuario user = (Usuario) miSession.getAttribute("user");
		
			try {
				itinerario= user.obtenerItinerario();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			req.setAttribute("itinerarioUser", itinerario);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/historial.jsp");
			dispatcher.forward(req, resp);

		}

	
}
