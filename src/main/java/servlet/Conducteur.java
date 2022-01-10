package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConducteurDAO;

/**
 * Servlet implementation class Conducteur
 */
@WebServlet("/conducteur")
public class Conducteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConducteurDAO conducteurDao = new ConducteurDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Conducteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<model.Conducteur> listeC = new ArrayList<>();
		listeC = conducteurDao.read();
		request.setAttribute("listeConducteurs", listeC);
		request.getRequestDispatcher("conducteur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		model.Conducteur nouveau = new model.Conducteur(request.getParameter("prenom"), request.getParameter("nom"));
		conducteurDao.create(nouveau);
		
		request.setAttribute("prenom", request.getParameter("prenom"));
		request.setAttribute("nom", request.getParameter("nom"));
		
		doGet(request, response);
	}

}
