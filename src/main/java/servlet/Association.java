package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AssociationDAO;
import dao.ConducteurDAO;
import dao.VehiculeDAO;
import model.Asso;

/**
 * Servlet implementation class Association
 */
@WebServlet("/association")
public class Association extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ConducteurDAO conducteurDao = new ConducteurDAO();
	VehiculeDAO vehiculeDao = new VehiculeDAO();
    AssociationDAO assoDao = new AssociationDAO();
    List<Asso> listeAsso = new ArrayList<>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Association() {
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
		
		List<model.Vehicule> listeV = new ArrayList<>();
		listeV = vehiculeDao.read();
		request.setAttribute("listeVehicules", listeV);
		
		listeAsso = assoDao.read();
		request.setAttribute("listeAsso", listeAsso);
		request.getRequestDispatcher("association.jsp").forward(request, response);
	}
}
