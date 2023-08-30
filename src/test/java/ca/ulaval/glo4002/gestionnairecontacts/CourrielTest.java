package ca.ulaval.glo4002.gestionnairecontacts;

import org.junit.jupiter.api.Test;

import ca.ulaval.glo4002.gestionnairecontacts.DonneesTest.Courriels;
import static org.junit.jupiter.api.Assertions.*;

class CourrielTest {

    @Test
    public void peutValiderUnCourrielValide() {
        assertTrue(Courriels.COURRIEL.estValide());
    }

    @Test
    public void peutDetecterUnCourrielInvalide() {
        assertFalse(new Courriel("abc123").estValide());
    }

    @Test
    public void unCourrielEstEgalALuiMeme() {
        assertEquals(Courriels.COURRIEL, Courriels.COURRIEL);
    }

    @Test
    public void unCourrielEstEgalAUnCourrielIdentique() {
        var memeCourriel = new Courriel("inconnu@ulaval.ca");
        assertEquals(Courriels.COURRIEL, memeCourriel);
    }

    @Test
    public void deuxCourrielsDifferentsNeSontPasEgaux() {
        assertNotEquals(Courriels.COURRIEL, Courriels.AUTRE_COURRIEL);
    }

}