package Solid.OCPrincipleExample;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        String password = "my-password";

        PasswordHasher passwordHasher = new PasswordHasher();

        String hash = passwordHasher.hash(password);

        System.out.println(hash);


    }
}
