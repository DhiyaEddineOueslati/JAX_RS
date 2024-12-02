package tn.enig.rs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.enig.dao.GestionImpl;
import tn.enig.model.Etudiant;
import tn.enig.model.Groupe;

@Path("/service")
public class ServiceRS {

    private GestionImpl dao;

    public ServiceRS() {
		// TODO Auto-generated constructor stub
    	 dao = new GestionImpl();
	}
    
    @GET
    @Path("/groupes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Groupe> getAllGroupes() {
        return dao.getAllGroupes();
    }

    @GET
    @Path("/groupes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Groupe getGroupeById(@PathParam("id") int id) {
        return dao.getGroupeById(id);
    }

    @GET
    @Path("/groupes/{id}/etudiants")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Etudiant> getEtudiantsByGroupeId(@PathParam("id") int id) {
        return dao.getEtudiantsByGroupeId(id);
    }

    @POST
    @Path("/etudiants")
    @Consumes(MediaType.APPLICATION_JSON)
    public void ajouterEtudiant(Etudiant etudiant) {
        dao.ajouterEtudiant(etudiant);
    }
}
