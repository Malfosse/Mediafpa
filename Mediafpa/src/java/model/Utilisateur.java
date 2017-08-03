/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "utilisateur")
@NamedQueries({
	@NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
	, @NamedQuery(name = "Utilisateur.findByIdUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur")
	, @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
	, @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
	, @NamedQuery(name = "Utilisateur.findByForme", query = "SELECT u FROM Utilisateur u WHERE u.forme = :forme")
	, @NamedQuery(name = "Utilisateur.findByMail", query = "SELECT u FROM Utilisateur u WHERE u.mail = :mail")
	, @NamedQuery(name = "Utilisateur.findByDateNaissance", query = "SELECT u FROM Utilisateur u WHERE u.dateNaissance = :dateNaissance")
	, @NamedQuery(name = "Utilisateur.findByTelephone", query = "SELECT u FROM Utilisateur u WHERE u.telephone = :telephone")
	, @NamedQuery(name = "Utilisateur.findByGroupe", query = "SELECT u FROM Utilisateur u WHERE u.groupe = :groupe")})
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utilisateur")
	private Integer idUtilisateur;
	@Size(max = 45)
    @Column(name = "nom")
	private String nom;
	@Size(max = 45)
    @Column(name = "prenom")
	private String prenom;
	@Column(name = "forme")
	private Short forme;
	@Size(max = 45)
    @Column(name = "mail")
	private String mail;
	@Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Size(max = 45)
    @Column(name = "telephone")
	private String telephone;
	@Size(max = 45)
    @Column(name = "groupe")
	private String groupe;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
	private List<Fiche> ficheList;
	@OneToMany(mappedBy = "idValidateur")
	private List<Fiche> ficheList1;
	@JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
    @ManyToOne
	private Adresse idAdresse;
	@OneToMany(mappedBy = "idAuteur")
	private List<Nouvelle> nouvelleList;
	@OneToMany(mappedBy = "idUtilisateur")
	private List<Emprunter> emprunterList;

	public Utilisateur() {
	}

	public Utilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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

	public Short getForme() {
		return forme;
	}

	public void setForme(Short forme) {
		this.forme = forme;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public List<Fiche> getFicheList() {
		return ficheList;
	}

	public void setFicheList(List<Fiche> ficheList) {
		this.ficheList = ficheList;
	}

	public List<Fiche> getFicheList1() {
		return ficheList1;
	}

	public void setFicheList1(List<Fiche> ficheList1) {
		this.ficheList1 = ficheList1;
	}

	public Adresse getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Adresse idAdresse) {
		this.idAdresse = idAdresse;
	}

	public List<Nouvelle> getNouvelleList() {
		return nouvelleList;
	}

	public void setNouvelleList(List<Nouvelle> nouvelleList) {
		this.nouvelleList = nouvelleList;
	}

	public List<Emprunter> getEmprunterList() {
		return emprunterList;
	}

	public void setEmprunterList(List<Emprunter> emprunterList) {
		this.emprunterList = emprunterList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Utilisateur)) {
			return false;
		}
		Utilisateur other = (Utilisateur) object;
		if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Utilisateur[ idUtilisateur=" + idUtilisateur + " ]";
	}
	
}
