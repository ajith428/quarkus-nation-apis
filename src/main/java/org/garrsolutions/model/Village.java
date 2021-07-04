package org.garrsolutions.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Village extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public UUID villageId;

    @Column
    public String village;

    @ManyToOne
    @JoinColumn(name = "districtId", nullable = false)
    public District district;

}
