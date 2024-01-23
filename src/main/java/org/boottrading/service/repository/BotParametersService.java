package org.boottrading.service.repository;

import java.util.List;

import org.boottrading.repository.BotParametersRepositoty;

public class BotParametersService {
    BotParametersRepositoty botParametersRepositoty = new BotParametersRepositoty();

    public List<String> getTokenPairFromDataBase() {
        return privateGetTokenPairFromDataBase();
    }

    private List<String> privateGetTokenPairFromDataBase() {
        return botParametersRepositoty.getTokenPairFromDataBase();

    }
}
