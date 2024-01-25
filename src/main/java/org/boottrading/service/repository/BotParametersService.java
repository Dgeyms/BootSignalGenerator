package org.boottrading.service.repository;

import java.util.List;

import org.boottrading.repository.BotParametersRepository;

public class BotParametersService {
    BotParametersRepository botParametersRepositoty = new BotParametersRepository();

    public List<String> getTokenPairFromDataBase() {
        return botParametersRepositoty.getTokenPairFromDataBase();

    }
}
