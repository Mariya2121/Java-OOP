package DesignPatterns;

public class Address {
    private String country;
    private String city;
    private  String postcode;
    private String email;
    private String street;
    private String phoneNumber;

    public static class Builder{ // Builder pattern; създаваме обект с различни полета; каквито ние искаме;
        private Address address;

        public Builder() {
            this.address = new Address();
        }
        public Builder withCountry(String country){
            address.country = country;
            return this;
        }
        public Builder withCity(String city){
            address.city= city;
            return this;
        }
        public Builder withPostcode(String country){
            address.country = country;
            return this;
        }
        public Builder withEmail(String email){
            address.email = email;
            return this;
        }
        public Address build(){ // end
            return this.address;
        }
    }
    public static Builder builder(){
        return new Builder();
    }
}
