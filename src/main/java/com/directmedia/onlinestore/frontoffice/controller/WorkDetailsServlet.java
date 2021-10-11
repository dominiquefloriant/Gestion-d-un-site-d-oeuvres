
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
@WebServlet(name = "WorkDetailsServlet", urlPatterns = {"/work-details"})
public class WorkDetailsServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        /*HttpSession session=request.getSession();
        String numeroSession = session.getId();*/
        
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("id");
        long identifiant = Long.parseLong(id);
        
        Work work = null;
        
        for(Work w : Catalogue.set){
            if (w.getId() == identifiant){
                work = w;
                break;
                
            }
            
          
        }
     // session.setAttribute("identifiant", identifiant);
        out.print("<HTML><BODY>");
            out.print("Description des oeuvres"+"</BR></BR>");
            
            out.print("Titre : "+work.getTitle()+"</BR>");
            out.print("Genre : "+work.getGenre()+"</BR>");
            out.print("MainArtist :"+work.getMainArtist().getName()+"</BR>");
            out.print("Summary : "+work.getSummary()+"</BR>");
            out.print("Release : "+work.getRelease()+"</BR></BR>");
            
            out.print("<form action = \"addToCart\" method = \"POST\">");
                out.print("<input type = \"hidden\" name = \"identifiant\" value=\""+work.getId()+"\">");
                out.print("<input type = \"submit\" value = \"Ajouter au caddie\">");
            out.print("</form>");
            

        out.print("</BODY></HTML>");
        
    }

   
 

}
