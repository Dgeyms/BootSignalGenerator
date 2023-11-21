package org.boottrading;


import org.boottrading.controler.QuoteDataServlet;

public class Main {
    public static void main(String[] args) {

        QuoteDataServlet quoteDataServlet = new QuoteDataServlet();
        quoteDataServlet.play();
    }
}

