package org.garrsolutions.service;

import io.smallrye.mutiny.Uni;
import org.garrsolutions.model.State;
import org.garrsolutions.repository.StateRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class StateService {

    private final StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public Uni<List<State>> getStates() {
        return stateRepository.listAll();
    }
}
