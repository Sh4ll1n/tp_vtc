package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conducteur;

public class ConducteurDAO implements IDAO<Conducteur> {
	public static Conducteur currentConducteur;
	Connection connect = GetConnection.getConnection();
	ResultSet rs = null;
	
	@Override
	public void create(Conducteur conducteur) {
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO "+
				"conducteur (prenom, nom) VALUES (?, ?)");
			sql.setString(1, conducteur.getNom());
			sql.setString(2, conducteur.getPrenom());
			
			sql.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Conducteur> read() {
		List<Conducteur> listeC = new ArrayList<>();
		PreparedStatement sql2;
		try {
			sql2 = connect.prepareStatement("SELECT prenom, nom FROM conducteur");
			sql2.setInt(1, 1);
			rs = sql2.executeQuery();
			while(rs.next()) {
				Conducteur conducteur = new Conducteur(
					rs.getString("prenom"),
					rs.getString("nom"));
				listeC.add(conducteur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeC;
	}

}
