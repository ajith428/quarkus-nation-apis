package org.garrsolutions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class District extends PanacheEntityBase {

    @Id
    @GeneratedValue
    private UUID districtId;

    @Column
    private String districtName;

    @ManyToOne
    @JoinColumn(name = "stateId", nullable = false)
    @JsonIgnore
    private State state;

    @OneToMany(mappedBy = "district", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<Village> villages = new ArrayList<>();

    public void addVillage() {
        villages.forEach(village -> {
            village.setDistrict(this);
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof District district1)) return false;
        return Objects.equals(getDistrictId(), district1.getDistrictId()) && Objects.equals(getDistrictName(), district1.getDistrictName()) && Objects.equals(getState(), district1.getState()) && Objects.equals(getVillages(), district1.getVillages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDistrictId(), getDistrictName(), getState(), getVillages());
    }
}