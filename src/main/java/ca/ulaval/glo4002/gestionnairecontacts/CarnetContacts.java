package ca.ulaval.glo4002.gestionnairecontacts;

import java.util.*;

public class CarnetContacts {

    private final HashSet<Contact> contacts;

    private DetecteurDoublons detecteurDoublons;

    public CarnetContacts() {
        this(new HashSet<>(), new DetecteurDoublons());
    }

    public CarnetContacts(Set<Contact> contacts, DetecteurDoublons detecteurDoublons) {
        this.contacts = new HashSet<>(contacts);
        this.detecteurDoublons = detecteurDoublons;
    }

    public void ajouter(Contact... aAjouter) {
    }

    public void archiver(Contact aSupprimer) {
    }

    public Set<Contact> chercherContact(Courriel courriel) {
        throw new RuntimeException("A implementer");
    }

    public Set<Contact> listerContactsArchives() {
        throw new RuntimeException("A implementer");
    }

    public List<Contact> listerDoublons() {
        throw new RuntimeException("A implementer");
    }
}
