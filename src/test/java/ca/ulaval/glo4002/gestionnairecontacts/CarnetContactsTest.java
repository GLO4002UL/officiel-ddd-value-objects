package ca.ulaval.glo4002.gestionnairecontacts;

import ca.ulaval.glo4002.gestionnairecontacts.DonneesTest.Contacts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CarnetContactsTest {

    private CarnetContacts carnet;

    @BeforeEach
    public void setUp() {
        carnet = new CarnetContacts();
    }

    @Test
    public void unCarnet_PeutAjouterEtRetrouverUnContact() {
        carnet.ajouter(Contacts.CONTACT, Contacts.AUTRE_CONTRACT);

        var contacts = carnet.chercherContact(DonneesTest.Courriels.COURRIEL);

        assertIterableEquals(new HashSet<>(List.of(Contacts.CONTACT)), contacts);
    }

    @Test
    public void unCarnet_PeutDetecterLesDoublons() {
        var contact = new Contact(UUID.randomUUID(), Contacts.NOM, Contacts.DATE_NAISSANCE, DonneesTest.Courriels.COURRIEL);
        var doublon = new Contact(UUID.randomUUID(), Contacts.NOM, Contacts.DATE_NAISSANCE, DonneesTest.Courriels.COURRIEL);
        carnet.ajouter(contact, doublon, Contacts.AUTRE_CONTRACT);

        var doublons = carnet.listerDoublons();

        assertIterableEquals(List.of(contact, doublon), doublons);
    }

    @Test
    public void unCarnet_PeutArchiverUnContact() {
        carnet.ajouter(Contacts.CONTACT);

        carnet.archiver(Contacts.CONTACT);

        assertIterableEquals(new ArrayList(), carnet.chercherContact(DonneesTest.Courriels.COURRIEL));
        assertIterableEquals(new ArrayList(List.of(Contacts.CONTACT)), carnet.listerContactsArchives());
    }

}