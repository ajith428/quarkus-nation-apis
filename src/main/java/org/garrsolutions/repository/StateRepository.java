package org.garrsolutions.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import org.garrsolutions.model.State;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class StateRepository implements PanacheRepositoryBase<State, UUID> {
}
