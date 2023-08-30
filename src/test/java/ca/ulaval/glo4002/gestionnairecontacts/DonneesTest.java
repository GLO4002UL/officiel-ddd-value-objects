package ca.ulaval.glo4002.gestionnairecontacts;

import java.time.LocalDate;
import java.util.UUID;

public class DonneesTest {

    public static class Courriels {
        public static final Courriel COURRIEL = new Courriel("inconnu@ulaval.ca");
        public static final Courriel AUTRE_COURRIEL = new Courriel("inconnu2@domaine.com");
    }

    public static class Contacts {
        public static final String NOM = "nom";
        public static final LocalDate DATE_NAISSANCE = LocalDate.of(2000, 1, 1);

        public static final Contact CONTACT = new Contact(UUID.randomUUID(), NOM, DATE_NAISSANCE, Courriels.COURRIEL);
        public static final String AUTRE_NOM = "autre nom";
        public static final LocalDate AUTRE_DATE_NAISSANCE = LocalDate.of(1995, 07, 14);
        public static final Contact AUTRE_CONTRACT = new Contact(UUID.randomUUID(), AUTRE_NOM, AUTRE_DATE_NAISSANCE, Courriels.AUTRE_COURRIEL);
    }
}
