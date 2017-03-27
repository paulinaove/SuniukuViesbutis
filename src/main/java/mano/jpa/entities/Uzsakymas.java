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
@Table(name = "uzsakymas")
@NamedQueries({
    @NamedQuery(name = "Uzsakymas.findAll", query = "SELECT u FROM Uzsakymas u")
    , @NamedQuery(name = "Uzsakymas.findById", query = "SELECT u FROM Uzsakymas u WHERE u.id = :id")
    , @NamedQuery(name = "Uzsakymas.findByNr", query = "SELECT u FROM Uzsakymas u WHERE u.nr = :nr")
    , @NamedQuery(name = "Uzsakymas.findByOptlock", query = "SELECT u FROM Uzsakymas u WHERE u.optlock = :optlock")})
@Getter
@Setter
@EqualsAndHashCode(of = "nr")
@ToString(of = {"nr", "virejas",})
public class Uzsakymas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nr")
    private long nr;

    @Version
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
    
}
