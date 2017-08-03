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
@Table(name = "fiche")
@NamedQueries({
	@NamedQuery(name = "Fiche.findAll", query = "SELECT f FROM Fiche f")
	, @NamedQuery(name = "Fiche.findByIdFiche", query = "SELECT f FROM Fiche f WHERE f.idFiche = :idFiche")
	, @NamedQuery(name = "Fiche.findByTitre", query = "SELECT f FROM Fiche f WHERE f.titre = :titre")
	, @NamedQuery(name = "Fiche.findByContenu", query = "SELECT f FROM Fiche f WHERE f.contenu = :contenu")
	, @NamedQuery(name = "Fiche.findByNote", query = "SELECT f FROM Fiche f WHERE f.note = :note")
	, @NamedQuery(name = "Fiche.findByDateFiche", query = "SELECT f FROM Fiche f WHERE f.dateFiche = :dateFiche")
	, @NamedQuery(name = "Fiche.findByValide", query = "SELECT f FROM Fiche f WHERE f.valide = :valide")})
public class Fiche implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fiche")
	private Integer idFiche;
	@Size(max = 128)
    @Column(name = "titre")
	private String titre;
	@Size(max = 4096)
    @Column(name = "contenu")
	private String contenu;
	@Column(name = "note")
	private Integer note;
	@Column(name = "date_fiche")
    @Temporal(TemporalType.DATE)
	private Date dateFiche;
	@Column(name = "valide")
	private Short valide;
	@JoinColumn(name = "id_document", referencedColumnName = "id_document")
    @ManyToOne(optional = false)
	private Document idDocument;
	@JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    @ManyToOne(optional = false)
	private Utilisateur idUtilisateur;
	@JoinColumn(name = "id_validateur", referencedColumnName = "id_utilisateur")
    @ManyToOne
	private Utilisateur idValidateur;

	public Fiche() {
	}

	public Fiche(Integer idFiche) {
		this.idFiche = idFiche;
	}

	public Integer getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(Integer idFiche) {
		this.idFiche = idFiche;
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

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Date getDateFiche() {
		return dateFiche;
	}

	public void setDateFiche(Date dateFiche) {
		this.dateFiche = dateFiche;
	}

	public Short getValide() {
		return valide;
	}

	public void setValide(Short valide) {
		this.valide = valide;
	}

	public Document getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Document idDocument) {
		this.idDocument = idDocument;
	}

	public Utilisateur getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Utilisateur idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Utilisateur getIdValidateur() {
		return idValidateur;
	}

	public void setIdValidateur(Utilisateur idValidateur) {
		this.idValidateur = idValidateur;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idFiche != null ? idFiche.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Fiche)) {
			return false;
		}
		Fiche other = (Fiche) object;
		if ((this.idFiche == null && other.idFiche != null) || (this.idFiche != null && !this.idFiche.equals(other.idFiche))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Fiche[ idFiche=" + idFiche + " ]";
	}
	
}
