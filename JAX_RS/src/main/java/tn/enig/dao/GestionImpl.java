package tn.enig.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tn.enig.model.Etudiant;
import tn.enig.model.Groupe;

public class GestionImpl implements IGestion {
    private Connection connection;

    public GestionImpl() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tpjax_rs", "root", ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public List<Groupe> getAllGroupes() {
        List<Groupe> groupes = new ArrayList<Groupe>();
        String query = "SELECT * FROM groupe";

        try {
        	PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Groupe g = new Groupe();
                g.setId(rs.getInt("id"));
                g.setDescription(rs.getString("description"));
                g.setNiveau(rs.getString("niveau"));
                groupes.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupes;
    }

    public Groupe getGroupeById(int id) {
        Groupe groupe = null;
        String query = "SELECT * FROM groupe WHERE id = ?";

        try {
        	PreparedStatement ps = connection.prepareStatement(query);
        
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    groupe = new Groupe();
                    groupe.setId(rs.getInt("id"));
                    groupe.setDescription(rs.getString("description"));
                    groupe.setNiveau(rs.getString("niveau"));
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupe;
    }

    
    public List<Etudiant> getEtudiantsByGroupeId(int idGroupe) {
        List<Etudiant> etudiants = new ArrayList<Etudiant>();
        String query = "SELECT * FROM etudiant WHERE id_groupe = ?";

        try {
        PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idGroupe);

            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Etudiant e = new Etudiant();
                    e.setId(rs.getInt("id"));
                    e.setNom(rs.getString("nom"));
                    e.setPrenom(rs.getString("prenom"));
                    e.setIdGroupe(rs.getInt("id_groupe"));
                    etudiants.add(e);
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        String query = "INSERT INTO etudiant (nom, prenom, id_groupe) VALUES (?, ?, ?)";

        try {
        	PreparedStatement ps = connection.prepareStatement(query);
        
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setInt(3, etudiant.getIdGroupe());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
