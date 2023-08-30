package ca.ulaval.glo4002.gestionnairecontacts;


public class Courriel {
    private final String adresse;
    public Courriel(String adresse) {
        this.adresse = adresse;
    }
    public boolean estValide() {
        //https://owasp.org/www-community/OWASP_Validation_Regex_Repository
        throw new RuntimeException("A implémenter");
    }

}
