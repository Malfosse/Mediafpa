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
import javax.persistence.ManyToMany;
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
@Table(name = "document")
@NamedQueries({
	@NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
	, @NamedQuery(name = "Document.findByIdDocument", query = "SELECT d FROM Document d WHERE d.idDocument = :idDocument")
	, @NamedQuery(name = "Document.findByTitre", query = "SELECT d FROM Document d WHERE d.titre = :titre")
	, @NamedQuery(name = "Document.findByAnnee", query = "SELECT d FROM Document d WHERE d.annee = :annee")
	, @NamedQuery(name = "Document.findByDescription", query = "SELECT d FROM Document d WHERE d.description = :description")
	, @NamedQuery(name = "Document.findByImage", query = "SELECT d FROM Document d WHERE d.image = :image")})
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_document")
	private Integer idDocument;
	@Size(max = 45)
    @Column(name = "titre")
	private String titre;
	@Size(max = 45)
    @Column(name = "annee")
	private String annee;
	@Size(max = 1024)
    @Column(name = "description")
	private String description;
	@Size(max = 256)
    @Column(name = "image")
	private String image;
	@ManyToMany(mappedBy = "documentList")
	private List<Auteur> auteurList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocument")
	private List<Fiche> ficheList;
	@JoinColumn(name = "id_categorie_document", referencedColumnName = "id_categorie_document")
    @ManyToOne
	private CategorieDocument idCategorieDocument;
	@JoinColumn(name = "id_editeur", referencedColumnName = "id_editeur")
    @ManyToOne
	private Editeur idEditeur;
	@OneToMany(mappedBy = "idDocument")
	private List<Exemplaire> exemplaireList;

	public Document() {
	}

	public Document(Integer idDocument) {
		this.idDocument = idDocument;
	}

	public Integer getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Auteur> getAuteurList() {
		return auteurList;
	}

	public void setAuteurList(List<Auteur> auteurList) {
		this.auteurList = auteurList;
	}

	public List<Fiche> getFicheList() {
		return ficheList;
	}

	public void setFicheList(List<Fiche> ficheList) {
		this.ficheList = ficheList;
	}

	public CategorieDocument getIdCategorieDocument() {
		return idCategorieDocument;
	}

	public void setIdCategorieDocument(CategorieDocument idCategorieDocument) {
		this.idCategorieDocument = idCategorieDocument;
	}

	public Editeur getIdEditeur() {
		return idEditeur;
	}

	public void setIdEditeur(Editeur idEditeur) {
		this.idEditeur = idEditeur;
	}

	public List<Exemplaire> getExemplaireList() {
		return exemplaireList;
	}

	public void setExemplaireList(List<Exemplaire> exemplaireList) {
		this.exemplaireList = exemplaireList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idDocument != null ? idDocument.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Document)) {
			return false;
		}
		Document other = (Document) object;
		if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Document[ idDocument=" + idDocument + " ]";
	}
	
}
