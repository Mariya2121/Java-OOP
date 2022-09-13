package Solid.OCPrincipleExample;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Algorithm implements HashAlgorithm {
    @Override
    public String hash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return new String(digest.digest(password.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
