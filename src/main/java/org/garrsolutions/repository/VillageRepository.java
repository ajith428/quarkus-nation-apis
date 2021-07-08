package org.garrsolutions.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import org.garrsolutions.model.Village;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class VillageRepository implements PanacheRepositoryBase<Village, UUID> {
}
