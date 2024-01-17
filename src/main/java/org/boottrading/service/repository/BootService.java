package org.boottrading.service.repository;

import org.boottrading.repository.BootRepository;
import org.boottrading.repository.BootRepositoryImpl;

public class BootService {
    BootRepository bootRepository = new BootRepositoryImpl();

    public void saveBoot(String nameBoot) {
        bootRepository.saveBootDataBase(nameBoot);
    }
}
