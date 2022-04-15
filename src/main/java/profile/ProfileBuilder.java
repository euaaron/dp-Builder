package profile;

import shared.interfaces.IBuilder;
import shared.utils.FormatDate;

import java.util.ArrayList;

public class ProfileBuilder implements IBuilder<Profile> {
    private Profile profile;

    public ProfileBuilder() {
        this.profile = new Profile();
    }

    public Profile build() {
        String currentDate = FormatDate.now();

        // Check if the username was informed
        if (this.profile.getUsername().equals("")) {
            throw new IllegalArgumentException("Usuário não informado");
        }

        // Check if the name was informed
        if (this.profile.getName().equals("")) {
            throw new IllegalArgumentException("Nome não informado");
        }

        // Check if the name contains numbers
        if (this.profile.getName().matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Nome não pode conter números");
        }

        // Check if the name has less than 3 characters
        if (this.profile.getName().length() < 3) {
            throw new IllegalArgumentException("Nome inválido");
        }

        // Check if birthday was provided
        if (this.profile.getBirthDate().equals("")) {
            throw new IllegalArgumentException("Data de Nascimento não informada");
        }

        // Check if birthday is a date in the format "dd/MM/yyyy" and the numbers are valid
        if (!this.profile.getBirthDate().matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("Data de Nascimento inválida");
        }

        // Check if birthday has more than 12 years from now
        String[] currentDateArray = currentDate.split("/");
        String[] birthdayArray = this.profile.getBirthDate().split("/");
        int currentYear = Integer.parseInt(currentDateArray[2]);
        int birthdayYear = Integer.parseInt(birthdayArray[2]);

        if (currentYear - birthdayYear < 12) {
            throw new IllegalArgumentException("Data de Nascimento inválida");
        }

        // Check if birthday year is in the past 150 years
        // TODO: May be changed according to human life expectancy or if the system is not used just by humans
        if (Integer.parseInt(this.profile.getBirthDate().split("/")[2]) < Integer.parseInt(currentDate.split("/")[2]) - 150) {
            throw new IllegalArgumentException("Data de Nascimento inválida");
        }

        // Check if day is valid greater than 0 and less than 31
        if (Integer.parseInt(this.profile.getBirthDate().split("/")[0]) < 1 || Integer.parseInt(this.profile.getBirthDate().split("/")[0]) > 31) {
            throw new IllegalArgumentException("Data de Nascimento inválida");
        }

        // Check if month is valid greater than 0 and less than 12
        if (Integer.parseInt(this.profile.getBirthDate().split("/")[1]) < 1 || Integer.parseInt(this.profile.getBirthDate().split("/")[1]) > 12) {
            throw new IllegalArgumentException("Data de Nascimento inválida");
        }

        // Checks if e-mail was informed and that contains an @
        if (this.profile.getEmail().equals("") || !this.profile.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }

        // Phone number can be null but if it isn't it should be valid
        if (!this.profile.getPhoneNumber().equals("") && !this.profile.getPhoneNumber().matches("^([+]?[\\s0-9]+)?(\\d{3}|[(]?[0-9]+[)])?([-]?[\\s]?[0-9])+$")) {
            throw new IllegalArgumentException("Telefone inválido");
        }
        return this.profile;
    }

    public ProfileBuilder setUsername(String username) {
        this.profile.setUsername(username);
        return this;
    }

    public ProfileBuilder setName(String name) {
        this.profile.setName(name);
        return this;
    }

    public ProfileBuilder setEmail(String email) {
        this.profile.setEmail(email);
        return this;
    }

    public ProfileBuilder setPhoneNumber(String phoneNumber) {
        this.profile.setPhoneNumber(phoneNumber);
        return this;
    }

    public ProfileBuilder setBirthDate(String birthday) {
        this.profile.setBirthDate(birthday);
        return this;
    }

    public ProfileBuilder setSocialProfiles(ArrayList<SocialUrl> socialUrlProfiles) {
        this.profile.setSocialUrls(socialUrlProfiles);
        return this;
    }
}
