/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tchan
 */
@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {



    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out =  response.getWriter();
        out.print("<HTML><BODY>");
        
        
          Artist artist1 = new Artist("Dominique");
		
		Work oeuvre1 =new Work("Naruto");
		oeuvre1.setGenre("Anime");
		oeuvre1.setMainArtist(artist1);
		oeuvre1.setSummary("Dans un monde de shinobi, tous les ninjas veulent la paix mais chacun utilise une manière particulière pour y arriver");
		oeuvre1.setRelease(1996);
		
		Artist artist2 = new Artist("Xavier");
		
		Work oeuvre2 =new Work("one piece");
		oeuvre2.setGenre("Standar");
		oeuvre2.setMainArtist(artist2);
		oeuvre2.setSummary("Dans un monde de luffy, tous les ninjas veulent la paix mais chacun utilise une manière particulière pour y arriver");
		oeuvre2.setRelease(1998);
		
                Artist artist3 = new Artist("Naga");
                
                Work oeuvre3 = new Work("Squid Game");
                oeuvre3.setGenre("Drame");
                oeuvre3.setMainArtist(artist3);
                oeuvre3.setSummary("Ils ont de lourdes dettes et décident de jouer à un jeu où le vainqueur recevra une fortune colossale mais tous les perdants sont voués à la mort ");
                oeuvre3.setRelease(2021);
		Catalogue catalogue = new Catalogue();
              if(catalogue.set.isEmpty()){
		catalogue.set.add(oeuvre1);
		catalogue.set.add(oeuvre2);
                catalogue.set.add(oeuvre3);
        
              }
        out.print("catalogue des oeuvres</BR></BR>");
        
        for (Work work : Catalogue.set) {
                        out.print("<a href=\"work-details?id="+work.getId()+"\">"+work.getTitle()+"("+work.getRelease()+")"+"</a></BR>");
			//out.println(work.getTitle()+ "("+work.getRelease()+")</BR>");
			
		};
                
        out.print("</BODY></HTML>");
    }

  

}
