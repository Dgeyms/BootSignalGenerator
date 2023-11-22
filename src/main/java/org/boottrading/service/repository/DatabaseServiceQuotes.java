package org.boottrading.service.repository;

import org.boottrading.model.Token;

/**
 * Service for working with the database of cryptocurrency quotations
 * Save in database
 */
public interface DatabaseServiceQuotes{
    // save quotes in database
    void saveClosePricesInDatabase(Token token);
}