package ca.ulaval.glo4002.gestionnairecontacts;

import java.time.LocalDate;
import java.util.UUID;

public class Contact {
    private final UUID identifiant;
    private Contact.Statut statut;
    private String nom;
    private LocalDate dateNaissance;
    private Courriel courriel;

    public Contact(UUID identifiant, String nom, LocalDate dateNaissance, Courriel courriel) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.courriel = courriel;
        this.statut = Statut.ACTIF;
    }

    public boolean possedeMemeIdentite(Contact autreContact) {
        throw new RuntimeException("A implémenter");
    }

    public boolean estSimilaireA(Contact autreContact) {
        throw new RuntimeException("A implémenter");
    }

    public void archiver() {
        this.statut = Statut.ARCHIVE;
    }

    public void activer() {
        this.statut = Statut.ACTIF;
    }

    public enum Statut {
        ACTIF, ARCHIVE
    }
}
