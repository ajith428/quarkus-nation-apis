package org.garrsolutions.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nationId")
public class Nation extends PanacheEntityBase {

    @Id
    @GeneratedValue
    private UUID nationId;

    @Column(unique = true)
    private String country;

    @OneToMany(mappedBy = "nation", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @ToString.Exclude
    @Builder.Default
    private List<State> states = new ArrayList<>();

    public void addState() {
        states.forEach(state -> {
            state.setNation(this);
            state.addDistrict();
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nation nation)) return false;
        return Objects.equals(getNationId(), nation.getNationId()) && Objects.equals(getCountry(), nation.getCountry()) && Objects.equals(getStates(), nation.getStates());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNationId(), getCountry(), getStates());
    }
}