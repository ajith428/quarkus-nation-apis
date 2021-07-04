package org.garrsolutions.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Nation extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID nationId;

    @Column
    public String country;

    @OneToMany(mappedBy = "nation", cascade = {CascadeType.ALL})
    public List<State> states = new ArrayList<>();

}