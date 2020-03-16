/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.entities;

import dal.PhotoDAO;
import dal.PosterDAO;
import dal.TopicDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Photo;
import models.Poster;
import models.Topic;

/**
 *
 * @author hongq
 */
public class ListController extends BaseRequiredAuthenticationController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PosterDAO posterDAO = new PosterDAO();
        ArrayList<Poster> posters = posterDAO.getPostersByRecent();
        request.setAttribute("posters", posters);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
