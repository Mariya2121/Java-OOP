package Solid.SingleResponsibilityExample;

import java.util.Base64;

public class PasswordHasher {

    public String hash(String password){
        return new String(Base64.getEncoder().encode(password.getBytes()));
    }


//    public void savePassword(String hashedPass){
//        //
//    }
//    public String hashAndSave(String password){ // прави две неща, което е грешно
//        String hash = hash(password);
//        savePassword(hash);
//        return hash;
//    }

    // Пак е наручаване на Single Responsibility Principle
    // единствения правилен метод е hash();
}
