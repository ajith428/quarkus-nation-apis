package org.garrsolutions.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class District extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID districtId;

    @Column
    public String district;

    @ManyToOne
    @JoinColumn(name = "stateId", nullable = false)
    public State state;

    @OneToMany(mappedBy = "district", cascade = {CascadeType.ALL})
    public List<Village> villages = new ArrayList<>();

}