/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Moi
 */
@Entity
@Table(name = "exemplaire")
@NamedQueries({
	@NamedQuery(name = "Exemplaire.findAll", query = "SELECT e FROM Exemplaire e")
	, @NamedQuery(name = "Exemplaire.findByIdExemplaire", query = "SELECT e FROM Exemplaire e WHERE e.idExemplaire = :idExemplaire")
	, @NamedQuery(name = "Exemplaire.findByEtat", query = "SELECT e FROM Exemplaire e WHERE e.etat = :etat")})
public class Exemplaire implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_exemplaire")
	private Integer idExemplaire;
	@Size(max = 45)
    @Column(name = "etat")
	private String etat;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idExemplaire")
	private List<Emprunter> emprunterList;
	@JoinColumn(name = "id_document", referencedColumnName = "id_document")
    @ManyToOne
	private Document idDocument;

	public Exemplaire() {
	}

	public Exemplaire(Integer idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	public Integer getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(Integer idExemplaire) {
		this.idExemplaire = idExemplaire;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public List<Emprunter> getEmprunterList() {
		return emprunterList;
	}

	public void setEmprunterList(List<Emprunter> emprunterList) {
		this.emprunterList = emprunterList;
	}

	public Document getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Document idDocument) {
		this.idDocument = idDocument;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idExemplaire != null ? idExemplaire.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Exemplaire)) {
			return false;
		}
		Exemplaire other = (Exemplaire) object;
		if ((this.idExemplaire == null && other.idExemplaire != null) || (this.idExemplaire != null && !this.idExemplaire.equals(other.idExemplaire))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Exemplaire[ idExemplaire=" + idExemplaire + " ]";
	}
	
}
