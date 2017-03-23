/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mano.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author arturas
 */
//TODO lombok
@Entity
@Table(name = "patiekalas")
@NamedQueries({
    @NamedQuery(name = "Patiekalas.findAll", query = "SELECT p FROM Patiekalas p")
    , @NamedQuery(name = "Patiekalas.findById", query = "SELECT p FROM Patiekalas p WHERE p.id = :id")
    , @NamedQuery(name = "Patiekalas.findByOptlock", query = "SELECT p FROM Patiekalas p WHERE p.optlock = :optlock")
    , @NamedQuery(name = "Patiekalas.findByNr", query = "SELECT p FROM Patiekalas p WHERE p.nr = :nr")
    , @NamedQuery(name = "Patiekalas.findByPavadinimas", query = "SELECT p FROM Patiekalas p WHERE p.pavadinimas = :pavadinimas")})
public class Patiekalas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "optlock")
    private int optlock;
    @Basic(optional = false)
    @Column(name = "nr")
    private int nr;
    @Basic(optional = false)
    @Column(name = "pavadinimas")
    private String pavadinimas;
    @ManyToMany(mappedBy = "patiekalasList")
    private List<Uzsakymas> uzsakymasList;

    public Patiekalas() {
    }

    public Patiekalas(Long id) {
        this.id = id;
    }

    public Patiekalas(Long id, int optlock, int nr, String pavadinimas) {
        this.id = id;
        this.optlock = optlock;
        this.nr = nr;
        this.pavadinimas = pavadinimas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOptlock() {
        return optlock;
    }

    public void setOptlock(int optlock) {
        this.optlock = optlock;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public List<Uzsakymas> getUzsakymasList() {
        return uzsakymasList;
    }

    public void setUzsakymasList(List<Uzsakymas> uzsakymasList) {
        this.uzsakymasList = uzsakymasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patiekalas)) {
            return false;
        }
        Patiekalas other = (Patiekalas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mano.entities.Patiekalas[ id=" + id + " ]";
    }
    
}
