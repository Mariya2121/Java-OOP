package DesignPatterns.BuilderPattern.PhoneBook;

public class Contact {

    private String name;
    private String number;
    private String company;
    private String title;
    private String email;
    private String website;
    private String birthday;

    public static class Builder {
        private Contact contact;

        public Builder() {
            this.contact = new Contact();
        }

        public Builder withName(String name) {
            setName(name);
            return this;
        }

        public Builder withNumber(String number) {
            setNumber(number);
            return this;
        }

        public Builder withCompany(String company) {
            contact.company = company;
            return this;
        }

        public Builder withTitle(String title) {
            contact.title = title;
            return this;
        }

        public Builder withEmail(String email) {
            contact.email = email;
            return this;
        }

        public Builder withWebsite(String website) {
            contact.website = website;
            return this;
        }

        public Builder withBirthday(String birthday) {
            contact.birthday = birthday;
            return this;
        }

        public Contact build() {
            return this.contact;
        }

        public void setName(String name) {
            if (name == null || name.trim().equals("") || name.length() < 2) {
                throw new IllegalStateException("The name must contain at least 2 characters!");
            }

            this.contact.name = name;
        }


        public void setNumber(String number) {
            if (number == null || number.trim().equals("") || number.length() < 5) {
                throw new IllegalStateException("The name must contain at least 5 characters!");
            }

            this.contact.number = number;
        }

    }

    public String getName() {
        return name;
    }

    public static Builder builder() {
        return new Builder();
    }


    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", company='" + company + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
