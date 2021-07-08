package org.garrsolutions.service;

import io.smallrye.mutiny.Uni;
import org.garrsolutions.model.Village;
import org.garrsolutions.repository.VillageRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class VillageService {

    private final VillageRepository villageRepository;

    public VillageService(VillageRepository villageRepository) {
        this.villageRepository = villageRepository;
    }

    public Uni<List<Village>> getVillages() {
        return villageRepository.listAll();
    }
}
