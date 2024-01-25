package org.boottrading.controler;

import java.io.IOException;
import java.rmi.ServerException;

import org.boottrading.model.Boot;
import org.boottrading.service.BotService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nameBoot")
public class BotServlet extends HttpServlet {
    BotService bootService = new BotService();

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
        String nameBoot = request.getParameter("nameBoot");
        Boot newBoot = new Boot(nameBoot);

        bootService.saveBoot(newBoot.getNameBoot());
    }

}
