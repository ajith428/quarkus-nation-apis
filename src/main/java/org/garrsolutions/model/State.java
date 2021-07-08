package org.garrsolutions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class State {

    @Id
    @GeneratedValue
    private UUID stateId;

    @Column
    private String stateName;

    @ManyToOne
    @JoinColumn(name = "nation_id", nullable = false)
    @JsonIgnore
    private Nation nation;

    @OneToMany(mappedBy = "state", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<District> districts = new ArrayList<>();

    public void addDistrict() {
        getDistricts().forEach(district -> {
            district.setState(this);
            district.addVillage();
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state = (State) o;
        return Objects.equals(getStateId(), state.getStateId()) && Objects.equals(getStateName(), state.getStateName()) && Objects.equals(getNation(), state.getNation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStateId(), getStateName(), getNation());
    }
}

