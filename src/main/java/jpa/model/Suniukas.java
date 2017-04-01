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

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulinaoveraite
 */
@Entity
@Table(name = "Suniukas")
@NamedQueries({
    @NamedQuery(name = "Suniukas.findAll", query = "SELECT s FROM Suniukas s")
    , @NamedQuery(name = "Suniukas.findByGyvunoID", query = "SELECT s FROM Suniukas s WHERE s.gyvunoID = :gyvunoID")
    , @NamedQuery(name = "Suniukas.findByVardas", query = "SELECT s FROM Suniukas s WHERE s.vardas = :vardas")
    , @NamedQuery(name = "Suniukas.findByVeisle", query = "SELECT s FROM Suniukas s WHERE s.veisle = :veisle")})
@Getter
@Setter
@EqualsAndHashCode(of = "gyvunoID")
@ToString(of = "gyvunoID")
public class Suniukas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GyvunoID")
    private String gyvunoID;
    @Column(name = "Vardas")
    private String vardas;
    @Column(name = "Veisle")
    private String veisle;
    @ManyToMany(mappedBy = "suniukasList")
    private List<Darbuotojas> darbuotojasList = new ArrayList<Darbuotojas>();
    @JoinColumn(name = "Viesbutis", referencedColumnName = "Kodas")
    @ManyToOne
    private Viesbutis viesbutis;

}
