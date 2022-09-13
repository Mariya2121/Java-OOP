package Solid.OCPrincipleExample;


public class PasswordHasher {
    private HashAlgorithm hashAlgorithm;

    public PasswordHasher() {
        this.hashAlgorithm = new Base64Algorithm();
    }

    public String hash(String password) {
        return hashAlgorithm.hash(password);
    }
}


