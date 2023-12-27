package com.example.orthelp;

import tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;



public class RequestSql
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Matiere> GetAllMatieres() {
        ArrayList<Matiere> lesMatieres = new ArrayList<>();
        try {
            cnx = ConnexionBDD.getCnx();
            ps = cnx.prepareStatement("SELECT id, designation FROM matiere");
            rs = ps.executeQuery();
            while (rs.next()) {
                lesMatieres.add(new Matiere(rs.getInt("id"), rs.getString("designation")));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return lesMatieres;
    }

    public ArrayList<String> GetAllSalles()
    {
        ArrayList<String> lesNomsDesActions = new ArrayList<>();
        try {
            cnx = ConnexionBDD.getCnx();
            ps = cnx.prepareStatement("SELECT code_salle FROM salle ");
            rs = ps.executeQuery();
            while(rs.next())
            {
                lesNomsDesActions.add(rs.getString(1));
            }
        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }

        return lesNomsDesActions;

    }

    public ArrayList<String> GetAllSousMatiere()
    {
        ArrayList<String> lesNomsDesActions = new ArrayList<>();
        try {
            cnx = ConnexionBDD.getCnx();
            ps = cnx.prepareStatement("SELECT sous_matiere FROM matiere ");
            rs = ps.executeQuery();
            while(rs.next())
            {
                lesNomsDesActions.add(rs.getString(1));
            }
        }
        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }

        return lesNomsDesActions;
    }


    public void addDemande(LocalDateTime dateUpdated, LocalDateTime dateFinDemande, String sousMatiere, int userId, int matiereId, int status) {
        try (Connection cnx = ConnexionBDD.getCnx();
             PreparedStatement ps = cnx.prepareStatement(
                     "INSERT INTO demande (date_updated, date_fin_demande, sous_matiere, id_user_id, id_matiere_id, status) VALUES (?, ?, ?, ?, ?, ?)")) {
            ps.setTimestamp(1, Timestamp.valueOf(dateUpdated));
            ps.setTimestamp(2, Timestamp.valueOf(dateFinDemande));
            ps.setString(3, sousMatiere);
            ps.setInt(4, userId);
            ps.setInt(5, matiereId);
            ps.setInt(6, status);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<String> getAllRequests(int userId) {
        ArrayList<String> requests = new ArrayList<>();
        try {
            cnx = ConnexionBDD.getCnx();
            ps = cnx.prepareStatement(
                    "SELECT matiere.designation, demande.sous_matiere " +
                            "FROM demande " +
                            "INNER JOIN matiere ON demande.id_matiere_id = matiere.id " +
                            "WHERE demande.id_user_id = ?"
            );
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String matiere = rs.getString("designation");
                String sousMatiere = rs.getString("sous_matiere");
                requests.add(matiere + " - " + sousMatiere);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return requests;
    }


    public User getUserInformation(int userId) {
        String query = "SELECT nom, prenom, email FROM user WHERE id = ?";
        try (Connection cnx = ConnexionBDD.getCnx();
             PreparedStatement ps = cnx.prepareStatement(query)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String email = rs.getString("email");


                    return new User(userId, nom, prenom, email, "", "", 0, "", "", "");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Map<String, Integer> getDemandesParUtilisateur() {
        Map<String, Integer> demandesParUtilisateur = new HashMap<>();
        try (Connection cnx = ConnexionBDD.getCnx();
             PreparedStatement ps = cnx.prepareStatement(
                     "SELECT user.nom, COUNT(demande.id) AS nombre_demandes " +
                             "FROM demande " +
                             "INNER JOIN user ON demande.id_user_id = user.id " +
                             "GROUP BY user.nom")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                demandesParUtilisateur.put(rs.getString("nom"), rs.getInt("nombre_demandes"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return demandesParUtilisateur;
    }


    public Map<String, Integer> getDemandesParMatiere() {
        Map<String, Integer> demandesParMatiere = new HashMap<>();
        try (Connection cnx = ConnexionBDD.getCnx();
             PreparedStatement ps = cnx.prepareStatement(
                     "SELECT matiere.designation, COUNT(demande.id) AS nombre_demandes " +
                             "FROM demande " +
                             "INNER JOIN matiere ON demande.id_matiere_id = matiere.id " +
                             "GROUP BY matiere.designation")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                demandesParMatiere.put(rs.getString("designation"), rs.getInt("nombre_demandes"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return demandesParMatiere;
    }

    public ArrayList<String> getSousMatieresPourMatiere(String designation) {
        ArrayList<String> sousMatieres = new ArrayList<>();
        String sql = "SELECT sous_matiere FROM matiere WHERE designation = ?";

        try (Connection conn = ConnexionBDD.getCnx();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, designation);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String allSousMatieres = rs.getString("sous_matiere");
                    // Séparer les sous-matières par ";"
                    String[] splitSousMatieres = allSousMatieres.split(";");
                    for (String sousMatiere : splitSousMatieres) {
                        sousMatieres.add(sousMatiere.trim());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sousMatieres;
    }


}

