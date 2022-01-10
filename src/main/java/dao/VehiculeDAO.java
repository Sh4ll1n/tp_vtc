package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Vehicule;

public class VehiculeDAO implements IDAO<Vehicule> {
	Connection connect = GetConnection.getConnection();
	ResultSet rs = null;
	@Override
	public void create(Vehicule vehicule) {
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO "+
				"vehicule (marque, modele, couleur, immatriculation)"+
				" VALUES (?, ?, ?, ?)");
			sql.setString(1, vehicule.getMarque());
			sql.setString(2, vehicule.getModele());
			sql.setString(3, vehicule.getCouleur());
			sql.setString(4, vehicule.getImmatriculation());
			
			sql.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Vehicule> read() {
		List<Vehicule> listeV = new ArrayList<>();
		PreparedStatement sql2;
		try {
			sql2 = connect.prepareStatement("SELECT marque, modele, couleur, immatriculation FROM vehicule");
			sql2.setInt(1, 1);
			rs = sql2.executeQuery();
			while(rs.next()) {
				Vehicule vehicule = new Vehicule(
					rs.getString("marque"),
					rs.getString("modele"),
					rs.getString("couleur"), 
					rs.getString("immatriculation"));
				listeV.add(vehicule);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeV;
	}
	
}
