package org.boottrading.service.repository;

import org.boottrading.repository.BotRepository;
import org.boottrading.repository.BotRepositoryImpl;

public class BotService {
    BotRepository bootRepository = new BotRepositoryImpl();

    public void saveBoot(String nameBoot) {
        bootRepository.saveBootDataBase(nameBoot);
    }
}