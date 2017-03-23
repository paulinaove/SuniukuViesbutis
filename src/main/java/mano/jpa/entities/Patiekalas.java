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
import javax.persistence.*;

/**
 *
 * @author arturas
 */
@Entity
@Table(name = "patiekalas")
@NamedQueries({
    @NamedQuery(name = "Patiekalas.findAll", query = "SELECT p FROM Patiekalas p")
    , @NamedQuery(name = "Patiekalas.findById", query = "SELECT p FROM Patiekalas p WHERE p.id = :id")
    , @NamedQuery(name = "Patiekalas.findByOptlock", query = "SELECT p FROM Patiekalas p WHERE p.optlock = :optlock")
    , @NamedQuery(name = "Patiekalas.findByNr", query = "SELECT p FROM Patiekalas p WHERE p.nr = :nr")
    , @NamedQuery(name = "Patiekalas.findByPavadinimas", query = "SELECT p FROM Patiekalas p WHERE p.pavadinimas = :pavadinimas")})
@Getter
@Setter
@EqualsAndHashCode(of = "nr")
@ToString(of = {"id", "pavadinimas"})
public class Patiekalas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "optlock")
    private int optlock;

    @Column(name = "nr")
    private int nr;

    @Column(name = "pavadinimas")
    private String pavadinimas;

    @ManyToMany(mappedBy = "patiekalasList")
    private List<Uzsakymas> uzsakymasList;


    
}
