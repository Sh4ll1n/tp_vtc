package model;

public class Asso {
	private int id_association;
	private Conducteur conducteur;
	private Vehicule vehicule;
	
	public Asso(Conducteur conducteur, Vehicule vehicule) {
		super();
		this.conducteur = conducteur;
		this.vehicule = vehicule;
	}
	public Asso(int id_association, Conducteur conducteur, Vehicule vehicule) {
		super();
		this.setId_association(id_association);
		this.conducteur = conducteur;
		this.vehicule = vehicule;
	}


	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	public int getId_association() {
		return id_association;
	}
	public void setId_association(int id_association) {
		this.id_association = id_association;
	}
	
	
}
