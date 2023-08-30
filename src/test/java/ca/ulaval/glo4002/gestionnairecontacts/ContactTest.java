package ca.ulaval.glo4002.gestionnairecontacts;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static ca.ulaval.glo4002.gestionnairecontacts.DonneesTest.Contacts;
import static ca.ulaval.glo4002.gestionnairecontacts.DonneesTest.Courriels;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    
    @Test
    public void deuxContactsAvecMemesChamps_NontPasLaMemeIdentite() {
        var contact = new Contact(UUID.randomUUID(), Contacts.NOM, Contacts.DATE_NAISSANCE, Courriels.AUTRE_COURRIEL);
        var contactIdentique = new Contact(UUID.randomUUID(), Contacts.NOM, Contacts.DATE_NAISSANCE, Courriels.AUTRE_COURRIEL);
        assertFalse(contact.possedeMemeIdentite(contactIdentique));
    }

    @Test
    public void unContact_ALaMemeIdentiteQueLuiMeme() {
        assertTrue(Contacts.CONTACT.possedeMemeIdentite(Contacts.CONTACT));
    }

    @Test
    public void deuxContactsAvecMemeIdentifiant_OntLaMemeIdentite() {
        var identifiant = UUID.randomUUID();
        var contact = new Contact(identifiant, Contacts.NOM, Contacts.DATE_NAISSANCE, Courriels.COURRIEL);
        var memeContactAutresAttributs = new Contact(identifiant, Contacts.AUTRE_NOM, Contacts.AUTRE_DATE_NAISSANCE, Courriels.AUTRE_COURRIEL);
        assertTrue(contact.possedeMemeIdentite(memeContactAutresAttributs));
    }

    @Test
    public void unContact_EstSimilaireALuiMeme() {
        var contact = Contacts.CONTACT;
        assertTrue(contact.estSimilaireA(contact));
    }

    @Test
    public void deuxContactsAvecMemesAttributsMaisIdDifferents_SontSimilaires() {
        var contact = new Contact(UUID.randomUUID(), Contacts.NOM, Contacts.DATE_NAISSANCE, Courriels.COURRIEL);
        var contactSimilaire = new Contact(UUID.randomUUID(), Contacts.NOM, Contacts.DATE_NAISSANCE, Courriels.COURRIEL);
        assertTrue(contact.estSimilaireA(contactSimilaire));
    }

    @Test
    public void deuxContactsAvecMemesAttributesMaisStatutsDifferents_SontSimilaires() {
        var contact = new Contact(UUID.randomUUID(), Contacts.NOM, Contacts.DATE_NAISSANCE, Courriels.COURRIEL);
        var contactSimilaire = new Contact(UUID.randomUUID(), Contacts.NOM, Contacts.DATE_NAISSANCE, Courriels.COURRIEL);
        contactSimilaire.archiver();
        assertTrue(contact.estSimilaireA(contactSimilaire));
    }
    
    @Test
    public void deuxContactsAvecAttributsDifferents_NeSontPasSimilaires() {
        assertFalse(Contacts.CONTACT.estSimilaireA(Contacts.AUTRE_CONTRACT));
    }

    
    

}