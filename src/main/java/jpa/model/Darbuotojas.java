/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulinaoveraite
 */
@Entity
@Table(name = "Darbuotojas")
@NamedQueries({
    @NamedQuery(name = "Darbuotojas.findAll", query = "SELECT d FROM Darbuotojas d")
    , @NamedQuery(name = "Darbuotojas.findById", query = "SELECT d FROM Darbuotojas d WHERE d.id = :id")
    , @NamedQuery(name = "Darbuotojas.findByVardas", query = "SELECT d FROM Darbuotojas d WHERE d.vardas = :vardas")
    , @NamedQuery(name = "Darbuotojas.findByPavarde", query = "SELECT d FROM Darbuotojas d WHERE d.pavarde = :pavarde")
    , @NamedQuery(name = "Darbuotojas.findByPareigos", query = "SELECT d FROM Darbuotojas d WHERE d.pareigos = :pareigos")})
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
//@XmlRootElement
public class Darbuotojas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "Vardas")
    private String vardas;
    @Column(name = "Pavarde")
    private String pavarde;
    @Column(name = "Pareigos")
    private String pareigos;
    @JoinTable(name = "Darbuotoju_Suniuku_Sarasas", joinColumns = {
        @JoinColumn(name = "DarbuotojoID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SuniukoID", referencedColumnName = "GyvunoID")})
    @ManyToMany
    @JohnzonIgnore
    //@XmlTransient
    private List<Suniukas> suniukasList = new ArrayList<Suniukas>();
    @JoinColumn(name = "Viesbutis", referencedColumnName = "Kodas")
    @ManyToOne
   @JohnzonIgnore
    //@XmlTransient
    private Viesbutis viesbutis;

}
