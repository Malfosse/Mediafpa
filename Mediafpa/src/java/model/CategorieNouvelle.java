/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "categorie_nouvelle")
@NamedQueries({
	@NamedQuery(name = "CategorieNouvelle.findAll", query = "SELECT c FROM CategorieNouvelle c")
	, @NamedQuery(name = "CategorieNouvelle.findByIdCategorieNouvelle", query = "SELECT c FROM CategorieNouvelle c WHERE c.idCategorieNouvelle = :idCategorieNouvelle")
	, @NamedQuery(name = "CategorieNouvelle.findByNom", query = "SELECT c FROM CategorieNouvelle c WHERE c.nom = :nom")})
public class CategorieNouvelle implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categorie_nouvelle")
	private Integer idCategorieNouvelle;
	@Size(max = 45)
    @Column(name = "nom")
	private String nom;
	@OneToMany(mappedBy = "idCategorieNouvelle")
	private List<Nouvelle> nouvelleList;

	public CategorieNouvelle() {
	}

	public CategorieNouvelle(Integer idCategorieNouvelle) {
		this.idCategorieNouvelle = idCategorieNouvelle;
	}

	public Integer getIdCategorieNouvelle() {
		return idCategorieNouvelle;
	}

	public void setIdCategorieNouvelle(Integer idCategorieNouvelle) {
		this.idCategorieNouvelle = idCategorieNouvelle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Nouvelle> getNouvelleList() {
		return nouvelleList;
	}

	public void setNouvelleList(List<Nouvelle> nouvelleList) {
		this.nouvelleList = nouvelleList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCategorieNouvelle != null ? idCategorieNouvelle.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CategorieNouvelle)) {
			return false;
		}
		CategorieNouvelle other = (CategorieNouvelle) object;
		if ((this.idCategorieNouvelle == null && other.idCategorieNouvelle != null) || (this.idCategorieNouvelle != null && !this.idCategorieNouvelle.equals(other.idCategorieNouvelle))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CategorieNouvelle[ idCategorieNouvelle=" + idCategorieNouvelle + " ]";
	}
	
}
