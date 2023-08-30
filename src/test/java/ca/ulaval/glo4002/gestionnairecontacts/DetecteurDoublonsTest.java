package ca.ulaval.glo4002.gestionnairecontacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.UUID;

import static java.util.Collections.emptySet;
import static org.junit.jupiter.api.Assertions.*;

class DetecteurDoublonsTest {

    private DetecteurDoublons detecteurDoublons;

    @BeforeEach
    public void setUp() {
        detecteurDoublons = new DetecteurDoublons();
    }
    @Test
    public void retourneSetVideSiSetVideDonne() {
        var doublons = detecteurDoublons.detecter(emptySet());
        assertTrue(doublons.isEmpty());
    }

    @Test
    public void retourneSetVideSiPasDeDoublons() {
        var contacts = new HashSet<Contact>();
        contacts.add(DonneesTest.Contacts.CONTACT);
        contacts.add(DonneesTest.Contacts.AUTRE_CONTRACT);

        var doublons = detecteurDoublons.detecter(contacts);

        assertTrue(doublons.isEmpty());
    }

    @Test
    public void detecteContactsAvecInfosSimilaires() {
        var contacts = new HashSet<Contact>();
        contacts.add(DonneesTest.Contacts.CONTACT);
        contacts.add(new Contact(UUID.randomUUID(), DonneesTest.Contacts.NOM, DonneesTest.Contacts.DATE_NAISSANCE, DonneesTest.Courriels.COURRIEL));
        contacts.add(DonneesTest.Contacts.AUTRE_CONTRACT);

        var doublons = detecteurDoublons.detecter(contacts);

        assertTrue(doublons.contains(DonneesTest.Contacts.CONTACT));
        assertTrue(doublons.contains(DonneesTest.Contacts.AUTRE_CONTRACT));
    }
}