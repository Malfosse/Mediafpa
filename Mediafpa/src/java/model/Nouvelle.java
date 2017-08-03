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
import javax.validation.constraints.Size;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "nouvelle")
@NamedQueries({
	@NamedQuery(name = "Nouvelle.findAll", query = "SELECT n FROM Nouvelle n")
	, @NamedQuery(name = "Nouvelle.findByIdNouvelle", query = "SELECT n FROM Nouvelle n WHERE n.idNouvelle = :idNouvelle")
	, @NamedQuery(name = "Nouvelle.findByTitre", query = "SELECT n FROM Nouvelle n WHERE n.titre = :titre")
	, @NamedQuery(name = "Nouvelle.findByContenu", query = "SELECT n FROM Nouvelle n WHERE n.contenu = :contenu")
	, @NamedQuery(name = "Nouvelle.findByDate", query = "SELECT n FROM Nouvelle n WHERE n.date = :date")})
public class Nouvelle implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nouvelle")
	private Integer idNouvelle;
	@Size(max = 128)
    @Column(name = "titre")
	private String titre;
	@Size(max = 4096)
    @Column(name = "contenu")
	private String contenu;
	@Column(name = "date")
    @Temporal(TemporalType.DATE)
	private Date date;
	@JoinColumn(name = "id_categorie_nouvelle", referencedColumnName = "id_categorie_nouvelle")
    @ManyToOne
	private CategorieNouvelle idCategorieNouvelle;
	@JoinColumn(name = "id_auteur", referencedColumnName = "id_utilisateur")
    @ManyToOne
	private Utilisateur idAuteur;

	public Nouvelle() {
	}

	public Nouvelle(Integer idNouvelle) {
		this.idNouvelle = idNouvelle;
	}

	public Integer getIdNouvelle() {
		return idNouvelle;
	}

	public void setIdNouvelle(Integer idNouvelle) {
		this.idNouvelle = idNouvelle;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CategorieNouvelle getIdCategorieNouvelle() {
		return idCategorieNouvelle;
	}

	public void setIdCategorieNouvelle(CategorieNouvelle idCategorieNouvelle) {
		this.idCategorieNouvelle = idCategorieNouvelle;
	}

	public Utilisateur getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Utilisateur idAuteur) {
		this.idAuteur = idAuteur;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idNouvelle != null ? idNouvelle.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Nouvelle)) {
			return false;
		}
		Nouvelle other = (Nouvelle) object;
		if ((this.idNouvelle == null && other.idNouvelle != null) || (this.idNouvelle != null && !this.idNouvelle.equals(other.idNouvelle))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Nouvelle[ idNouvelle=" + idNouvelle + " ]";
	}
	
}
