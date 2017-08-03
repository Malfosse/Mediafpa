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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "auteur")
@NamedQueries({
	@NamedQuery(name = "Auteur.findAll", query = "SELECT a FROM Auteur a")
	, @NamedQuery(name = "Auteur.findByIdAuteur", query = "SELECT a FROM Auteur a WHERE a.idAuteur = :idAuteur")
	, @NamedQuery(name = "Auteur.findByNom", query = "SELECT a FROM Auteur a WHERE a.nom = :nom")
	, @NamedQuery(name = "Auteur.findByPrenom", query = "SELECT a FROM Auteur a WHERE a.prenom = :prenom")})
public class Auteur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_auteur")
	private Integer idAuteur;
	@Size(max = 45)
    @Column(name = "nom")
	private String nom;
	@Size(max = 45)
    @Column(name = "prenom")
	private String prenom;
	@JoinTable(name = "realiser", joinColumns = {
    	@JoinColumn(name = "id_auteur", referencedColumnName = "id_auteur")}, inverseJoinColumns = {
    	@JoinColumn(name = "id_document", referencedColumnName = "id_document")})
    @ManyToMany
	private List<Document> documentList;

	public Auteur() {
	}

	public Auteur(Integer idAuteur) {
		this.idAuteur = idAuteur;
	}

	public Integer getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Integer idAuteur) {
		this.idAuteur = idAuteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Document> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<Document> documentList) {
		this.documentList = documentList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idAuteur != null ? idAuteur.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Auteur)) {
			return false;
		}
		Auteur other = (Auteur) object;
		if ((this.idAuteur == null && other.idAuteur != null) || (this.idAuteur != null && !this.idAuteur.equals(other.idAuteur))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Auteur[ idAuteur=" + idAuteur + " ]";
	}
	
}
