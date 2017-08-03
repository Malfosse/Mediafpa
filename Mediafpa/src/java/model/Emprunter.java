/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "emprunter")
@NamedQueries({
	@NamedQuery(name = "Emprunter.findAll", query = "SELECT e FROM Emprunter e")
	, @NamedQuery(name = "Emprunter.findByIdEmprunt", query = "SELECT e FROM Emprunter e WHERE e.idEmprunt = :idEmprunt")
	, @NamedQuery(name = "Emprunter.findByDateEmprunt", query = "SELECT e FROM Emprunter e WHERE e.dateEmprunt = :dateEmprunt")
	, @NamedQuery(name = "Emprunter.findByDateRetour", query = "SELECT e FROM Emprunter e WHERE e.dateRetour = :dateRetour")})
public class Emprunter implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_emprunt")
	private Integer idEmprunt;
	@Basic(optional = false)
    @NotNull
    @Column(name = "date_emprunt")
    @Temporal(TemporalType.DATE)
	private Date dateEmprunt;
	@Column(name = "date_retour")
    @Temporal(TemporalType.DATE)
	private Date dateRetour;
	@JoinColumn(name = "id_exemplaire", referencedColumnName = "id_exemplaire")
    @ManyToOne(optional = false)
	private Exemplaire idExemplaire;
	@JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    @ManyToOne
	private Utilisateur idUtilisateur;

	public Emprunter() {
	}

	public Emprunter(Integer idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

	public Emprunter(Integer idEmprunt, Date dateEmprunt) {
		this.idEmprunt = idEmprunt;
		this.dateEmprunt = dateEmprunt;
	}

	public Integer getIdEmprunt() {
		return idEmprunt;
	}

	public void setIdEmprunt(Integer idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Exemplaire getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(Exemplaire idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	public Utilisateur getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Utilisateur idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idEmprunt != null ? idEmprunt.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Emprunter)) {
			return false;
		}
		Emprunter other = (Emprunter) object;
		if ((this.idEmprunt == null && other.idEmprunt != null) || (this.idEmprunt != null && !this.idEmprunt.equals(other.idEmprunt))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Emprunter[ idEmprunt=" + idEmprunt + " ]";
	}
	
}
