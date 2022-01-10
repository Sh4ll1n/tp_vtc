package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VehiculeDAO;

/**
 * Servlet implementation class Vehicule
 */
@WebServlet("/vehicule")
public class Vehicule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VehiculeDAO vehiculeDao = new VehiculeDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vehicule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<model.Vehicule> listeVehicules = new ArrayList<>();
		listeVehicules = vehiculeDao.read();
		request.setAttribute("listeVehicules", listeVehicules);
		request.getRequestDispatcher("vehicule.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		model.Vehicule nouveau = new model.Vehicule(request.getParameter("marque"), request.getParameter("modele"),
				request.getParameter("couleur"), request.getParameter("immatriculation"));
		vehiculeDao.create(nouveau);
		
		request.setAttribute("marque", request.getParameter("marque"));
		request.setAttribute("modele", request.getParameter("modele"));
		request.setAttribute("couleur", request.getParameter("couleur"));
		request.setAttribute("immatriculation", request.getParameter("immatriculation"));
		
		doGet(request, response);
	}

}
