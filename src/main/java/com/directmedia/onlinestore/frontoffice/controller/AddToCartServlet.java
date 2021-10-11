/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.ShoppingCart;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tchan
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {

 
         ShoppingCart caddie = new ShoppingCart();
   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
       String identifiant =  request.getParameter("identifiant");
       long idAsLong = Long.parseLong(identifiant);
       HttpSession session = request.getSession();
       /* HttpSession session = request.getSession();
        int identifiant = (int)session.getAttribute("identifiant");*/
        
           ShoppingCart caddie =  (ShoppingCart)request.getSession().getAttribute("cart");
            if (caddie == null){
             caddie = new ShoppingCart();
            //request.getSession().setAttribute("cart", caddie);
        }
             for (Work work : Catalogue.set){
            if (work.getId() == idAsLong){
                caddie.getItems().add(work);
        }
            
        }
             for (Work work : caddie.getItems()) {
            out.print(work.getTitle());
        }
        
         out.print("<HTML><BODY>");
         
         /*if (caddie.getItems().isEmpty()){
             caddie.getItems().add(w);
            session.setAttribute("caddie", caddie);
            
         }
         else{
             
         }*/
         
         out.print("le nombre d'oeuvre ajoutée au caddie ("+caddie.getItems().size() +") </BR> </br><a href = \"catalogue\">retour au catalogue</a>");
       out.print("</BODY></HTML>");
    }

   
}
