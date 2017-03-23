/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mano.jpa.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author arturas
 */

//TODO pabaigti lombok
@Getter
@Setter
@Entity
@Table(name = "virejas")
@NamedQueries({
    @NamedQuery(name = "Virejas.findAll", query = "SELECT v FROM Virejas v")
    , @NamedQuery(name = "Virejas.findById", query = "SELECT v FROM Virejas v WHERE v.id = :id")
    , @NamedQuery(name = "Virejas.findByNr", query = "SELECT v FROM Virejas v WHERE v.nr = :nr")
    , @NamedQuery(name = "Virejas.findByVardas", query = "SELECT v FROM Virejas v WHERE v.vardas = :vardas")
    , @NamedQuery(name = "Virejas.findByPavarde", query = "SELECT v FROM Virejas v WHERE v.pavarde = :pavarde")})
public class Virejas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nr")
    private int nr;
    @Basic(optional = false)
    @Column(name = "vardas")
    private String vardas;
    @Basic(optional = false)
    @Column(name = "pavarde")
    private String pavarde;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "virejas")
    private List<Uzsakymas> uzsakymasList;

    public Virejas() {
    }

    public Virejas(Long id) {
        this.id = id;
    }

    public Virejas(Long id, int nr, String vardas, String pavarde) {
        this.id = id;
        this.nr = nr;
        this.vardas = vardas;
        this.pavarde = pavarde;
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
        if (!(object instanceof Virejas)) {
            return false;
        }
        Virejas other = (Virejas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mano.jpa.entities.Virejas[ id=" + id + " ]";
    }
    
}
