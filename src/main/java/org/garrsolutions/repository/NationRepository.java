package org.garrsolutions.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import org.garrsolutions.model.Nation;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class NationRepository implements PanacheRepositoryBase<Nation, UUID> {
}
