package org.boottrading.service;

import java.util.List;

import org.boottrading.repository.TokenPairRepository;

public class BotParametersService {
    TokenPairRepository botParametersRepositoty = new TokenPairRepository();

    public List<String> getTokenPairFromDataBase() {
        return botParametersRepositoty.getTokenPairFromDataBase();

    }
}
