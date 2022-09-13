package DesignPatterns.BuilderPattern.Example;



public class Person {
    private String name;
    private String lastName;
    private String address;

    public Person(){

    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder {
        private Person person;

        public Builder() {
            this.person = new Person();
        }

        public Builder withName(String name) {
            person.name = name;
            return this;
        }

        public Builder withLastName(String lastName) {
            person.lastName = lastName;
            return this;
        }

        public Builder withAddress(String address) {
            person.address = address;
            return this;
        }

        public Person build() {
            return this.person;
        }
    }
}
