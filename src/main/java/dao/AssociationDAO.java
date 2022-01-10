package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Asso;
import model.Conducteur;
import model.Vehicule;

public class AssociationDAO implements IDAO<Asso> {
	Connection connect = GetConnection.getConnection();
	ResultSet rs = null;
	@Override
	public void create(Asso association) {
		PreparedStatement req;
		try {
			req = connect.prepareStatement("INSERT INTO association"
			    + "(conducteur, vehicule) VALUES (?,?) ");
			req.setString(1, association.getConducteur().toString());
	        req.setString(2, association.getVehicule().toString());
	        
	        req.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}    
		
	}

	@Override
	public List<Asso> read() {
		List<Asso> listeA = new ArrayList<>();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM association"
            	+ " INNER JOIN conducteur ON conducteur.id_conducteur=association.conducteur"
            	+ " INNER JOIN vehicule ON vehicule.id_vehicule=association.vehicule");
            req.setInt(1, 1);
            req.setInt(2, 1);
            rs = req.executeQuery();

            while(rs.next()) {
            	Asso association = 
            	new Asso(rs.getInt("id_association"),
            	new Conducteur(rs.getInt("id_conducteur"), rs.getString("prenom"), rs.getString("nom")),
                new Vehicule(rs.getInt("id_vehicule"), rs.getString("marque"), rs.getString("modele")));
            	listeA.add(association);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return listeA;
	}

}
