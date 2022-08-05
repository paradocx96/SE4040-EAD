/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.PlateNumberManager;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author PARADOCX
 */
@Path("scanplate")
public class AnalyzeNumber {

    @Context
    private UriInfo context;

    @EJB
    PlateNumberManager pnm;

    /**
     * Creates a new instance of AnalyzeNumber
     */
    public AnalyzeNumber() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    // Using Query Parameters
    @GET
    @Path("getcategory")
    @Produces(MediaType.TEXT_HTML)
    public String getCategoryQueryParams(@QueryParam("regnum") @DefaultValue("CAA1234") String registration) {
        return "<h3>This Vehicle requires License for " + pnm.getDLCategory(registration) + "</h3>";
    }
    
    // Using Path Parameters
    @GET
    @Path("{regnum}")
    @Produces(MediaType.TEXT_HTML)
    public String getCategoryPath(@PathParam("regnum") String registerpath) {
        return "<h3>This Vehicle requires License for " + pnm.getDLCategory(registerpath) + "</h3>";
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String postGetCategory(@FormParam("regnum") String content) {
        return "<h3>This Vehicle requires License for " + pnm.getDLCategory(content) + "</h3>";
    }
}
