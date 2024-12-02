package tn.enig.dao;

import java.util.List;

import tn.enig.model.Etudiant;
import tn.enig.model.Groupe;

public interface IGestion {
	List<Groupe> getAllGroupes();
    Groupe getGroupeById(int id);
    List<Etudiant> getEtudiantsByGroupeId(int id);
    void ajouterEtudiant(Etudiant etudiant);
}
