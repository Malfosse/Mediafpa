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
@Table(name = "categorie_document")
@NamedQueries({
	@NamedQuery(name = "CategorieDocument.findAll", query = "SELECT c FROM CategorieDocument c")
	, @NamedQuery(name = "CategorieDocument.findByIdCategorieDocument", query = "SELECT c FROM CategorieDocument c WHERE c.idCategorieDocument = :idCategorieDocument")
	, @NamedQuery(name = "CategorieDocument.findByNom", query = "SELECT c FROM CategorieDocument c WHERE c.nom = :nom")})
public class CategorieDocument implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categorie_document")
	private Integer idCategorieDocument;
	@Size(max = 45)
    @Column(name = "nom")
	private String nom;
	@JoinColumn(name = "id_type_categorie", referencedColumnName = "id_type_categorie")
    @ManyToOne
	private TypeCategorie idTypeCategorie;
	@OneToMany(mappedBy = "idCategorieDocument")
	private List<Document> documentList;

	public CategorieDocument() {
	}

	public CategorieDocument(Integer idCategorieDocument) {
		this.idCategorieDocument = idCategorieDocument;
	}

	public Integer getIdCategorieDocument() {
		return idCategorieDocument;
	}

	public void setIdCategorieDocument(Integer idCategorieDocument) {
		this.idCategorieDocument = idCategorieDocument;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypeCategorie getIdTypeCategorie() {
		return idTypeCategorie;
	}

	public void setIdTypeCategorie(TypeCategorie idTypeCategorie) {
		this.idTypeCategorie = idTypeCategorie;
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
		hash += (idCategorieDocument != null ? idCategorieDocument.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CategorieDocument)) {
			return false;
		}
		CategorieDocument other = (CategorieDocument) object;
		if ((this.idCategorieDocument == null && other.idCategorieDocument != null) || (this.idCategorieDocument != null && !this.idCategorieDocument.equals(other.idCategorieDocument))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CategorieDocument[ idCategorieDocument=" + idCategorieDocument + " ]";
	}
	
}
