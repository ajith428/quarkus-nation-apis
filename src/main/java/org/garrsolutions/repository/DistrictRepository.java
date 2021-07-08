package org.garrsolutions.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import org.garrsolutions.model.District;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class DistrictRepository implements PanacheRepositoryBase<District, UUID> {
}
