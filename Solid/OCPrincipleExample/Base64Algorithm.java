package Solid.OCPrincipleExample;

import java.util.Base64;

public class Base64Algorithm implements HashAlgorithm {
    @Override
    public String hash(String password) {
       return new String(Base64.getEncoder().encode(password.getBytes()));
    }
}
