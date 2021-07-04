package org.garrsolutions.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class State extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID stateId;

    @Column
    public String state;

    @ManyToOne
    @JoinColumn(name = "nationId", nullable = false)
    public Nation nation;

    @OneToMany(mappedBy = "state", cascade = {CascadeType.ALL})
    public List<District> districts = new ArrayList<>();

}

