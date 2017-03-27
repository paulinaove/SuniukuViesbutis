/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mano.jpa.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

@Entity
@Table(name = "virejas")
@NamedQueries({
    @NamedQuery(name = "Virejas.findAll", query = "SELECT v FROM Virejas v")
    , @NamedQuery(name = "Virejas.findById", query = "SELECT v FROM Virejas v WHERE v.id = :id")
    , @NamedQuery(name = "Virejas.findByNr", query = "SELECT v FROM Virejas v WHERE v.nr = :nr")
    , @NamedQuery(name = "Virejas.findByVardas", query = "SELECT v FROM Virejas v WHERE v.vardas = :vardas")
    , @NamedQuery(name = "Virejas.findByPavarde", query = "SELECT v FROM Virejas v WHERE v.pavarde = :pavarde")})
@Getter
@Setter
@EqualsAndHashCode(of = "nr")
@ToString(of = {"nr", "vardas", "pavarde"})
public class Virejas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nr")
    private int nr;

    @Column(name = "vardas")
    private String vardas;

    @Column(name = "pavarde")
    private String pavarde;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "virejas")
    private List<Uzsakymas> uzsakymasList;

}
