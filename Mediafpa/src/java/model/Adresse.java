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
@Table(name = "adresse")
@NamedQueries({
	@NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a")
	, @NamedQuery(name = "Adresse.findByIdAdresse", query = "SELECT a FROM Adresse a WHERE a.idAdresse = :idAdresse")
	, @NamedQuery(name = "Adresse.findByNumero", query = "SELECT a FROM Adresse a WHERE a.numero = :numero")
	, @NamedQuery(name = "Adresse.findByVoie", query = "SELECT a FROM Adresse a WHERE a.voie = :voie")
	, @NamedQuery(name = "Adresse.findByCp", query = "SELECT a FROM Adresse a WHERE a.cp = :cp")
	, @NamedQuery(name = "Adresse.findByVille", query = "SELECT a FROM Adresse a WHERE a.ville = :ville")})
public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_adresse")
	private Integer idAdresse;
	@Size(max = 45)
    @Column(name = "numero")
	private String numero;
	@Size(max = 45)
    @Column(name = "voie")
	private String voie;
	@Size(max = 45)
    @Column(name = "cp")
	private String cp;
	@Size(max = 45)
    @Column(name = "ville")
	private String ville;
	@OneToMany(mappedBy = "idAdresse")
	private List<Utilisateur> utilisateurList;

	public Adresse() {
	}

	public Adresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	public Integer getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Utilisateur> getUtilisateurList() {
		return utilisateurList;
	}

	public void setUtilisateurList(List<Utilisateur> utilisateurList) {
		this.utilisateurList = utilisateurList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idAdresse != null ? idAdresse.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Adresse)) {
			return false;
		}
		Adresse other = (Adresse) object;
		if ((this.idAdresse == null && other.idAdresse != null) || (this.idAdresse != null && !this.idAdresse.equals(other.idAdresse))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Adresse[ idAdresse=" + idAdresse + " ]";
	}
	
}
