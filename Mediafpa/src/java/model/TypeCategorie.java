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
@Table(name = "type_categorie")
@NamedQueries({
	@NamedQuery(name = "TypeCategorie.findAll", query = "SELECT t FROM TypeCategorie t")
	, @NamedQuery(name = "TypeCategorie.findByIdTypeCategorie", query = "SELECT t FROM TypeCategorie t WHERE t.idTypeCategorie = :idTypeCategorie")
	, @NamedQuery(name = "TypeCategorie.findByNom", query = "SELECT t FROM TypeCategorie t WHERE t.nom = :nom")})
public class TypeCategorie implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_type_categorie")
	private Integer idTypeCategorie;
	@Size(max = 45)
    @Column(name = "nom")
	private String nom;
	@OneToMany(mappedBy = "idTypeCategorie")
	private List<CategorieDocument> categorieDocumentList;

	public TypeCategorie() {
	}

	public TypeCategorie(Integer idTypeCategorie) {
		this.idTypeCategorie = idTypeCategorie;
	}

	public Integer getIdTypeCategorie() {
		return idTypeCategorie;
	}

	public void setIdTypeCategorie(Integer idTypeCategorie) {
		this.idTypeCategorie = idTypeCategorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<CategorieDocument> getCategorieDocumentList() {
		return categorieDocumentList;
	}

	public void setCategorieDocumentList(List<CategorieDocument> categorieDocumentList) {
		this.categorieDocumentList = categorieDocumentList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idTypeCategorie != null ? idTypeCategorie.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TypeCategorie)) {
			return false;
		}
		TypeCategorie other = (TypeCategorie) object;
		if ((this.idTypeCategorie == null && other.idTypeCategorie != null) || (this.idTypeCategorie != null && !this.idTypeCategorie.equals(other.idTypeCategorie))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.TypeCategorie[ idTypeCategorie=" + idTypeCategorie + " ]";
	}
	
}
