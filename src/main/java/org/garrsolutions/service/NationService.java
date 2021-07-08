package org.garrsolutions.service;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import org.garrsolutions.model.Nation;
import org.garrsolutions.repository.NationRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Slf4j
public class NationService {

    private final NationRepository nationRepository;

    public NationService(NationRepository nationRepository) {
        this.nationRepository = nationRepository;
    }

    public Uni<Nation> saveNation(Nation nation) {
        nation.addState();
        return Panache.withTransaction(nation::persist);
    }

    public Uni<List<Nation>> getNations() {
        return nationRepository.listAll();
    }

    public Uni<Nation> getNation(UUID nationId) {
        return nationRepository.findById(nationId);
    }
}
