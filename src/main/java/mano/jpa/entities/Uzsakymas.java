/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mano.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author arturas
 */
//TODO lombok
@Entity
@Table(name = "uzsakymas")
@NamedQueries({
    @NamedQuery(name = "Uzsakymas.findAll", query = "SELECT u FROM Uzsakymas u")
    , @NamedQuery(name = "Uzsakymas.findById", query = "SELECT u FROM Uzsakymas u WHERE u.id = :id")
    , @NamedQuery(name = "Uzsakymas.findByNr", query = "SELECT u FROM Uzsakymas u WHERE u.nr = :nr")
    , @NamedQuery(name = "Uzsakymas.findByOptlock", query = "SELECT u FROM Uzsakymas u WHERE u.optlock = :optlock")})
public class Uzsakymas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nr")
    private long nr;
    @Basic(optional = false)
    @Column(name = "optlock")
    private int optlock;
    @JoinTable(name = "patiekalasuzsakymas", joinColumns = {
        @JoinColumn(name = "uzsakymas", referencedColumnName = "nr")}, inverseJoinColumns = {
        @JoinColumn(name = "patiekalas", referencedColumnName = "nr")})
    @ManyToMany
    private List<Patiekalas> patiekalasList;
    @JoinColumn(name = "virejas", referencedColumnName = "nr")
    @ManyToOne(optional = false)
    private Virejas virejas;

    public Uzsakymas() {
    }

    public Uzsakymas(Long id) {
        this.id = id;
    }

    public Uzsakymas(Long id, long nr, int optlock) {
        this.id = id;
        this.nr = nr;
        this.optlock = optlock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNr() {
        return nr;
    }

    public void setNr(long nr) {
        this.nr = nr;
    }

    public int getOptlock() {
        return optlock;
    }

    public void setOptlock(int optlock) {
        this.optlock = optlock;
    }

    public List<Patiekalas> getPatiekalasList() {
        return patiekalasList;
    }

    public void setPatiekalasList(List<Patiekalas> patiekalasList) {
        this.patiekalasList = patiekalasList;
    }

    public Virejas getVirejas() {
        return virejas;
    }

    public void setVirejas(Virejas virejas) {
        this.virejas = virejas;
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
        if (!(object instanceof Uzsakymas)) {
            return false;
        }
        Uzsakymas other = (Uzsakymas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mano.jpa.entities.Uzsakymas[ id=" + id + " ]";
    }
    
}
