package org.garrsolutions.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "villageId")
public class Village extends PanacheEntityBase {

    @Id
    @GeneratedValue
    private UUID villageId;

    @Column
    private String villageName;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Village village)) return false;
        return Objects.equals(getVillageId(), village.getVillageId()) && Objects.equals(getVillageName(), village.getVillageName()) && Objects.equals(getDistrict(), village.getDistrict());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVillageId(), getVillageName(), getDistrict());
    }
}
