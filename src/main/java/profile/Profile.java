package profile;

import shared.utils.FormatDate;

import java.util.*;

public class Profile {
    private String id;
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private List<SocialUrl> socialUrls;
    private String createdAt;
    private String updatedAt;

    public Profile() {
        this.username = "";
        this.name = "";
        this.email = "";
        this.phoneNumber = "";
        this.birthDate = "";
        this.updatedAt = "";
        this.createdAt = "";
        this.socialUrls = new ArrayList<>();
        this.setId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
        this.setCreatedAt();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        this.setUpdatedAt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setUpdatedAt();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.setUpdatedAt();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.setUpdatedAt();
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        this.setUpdatedAt();
    }

    public List<SocialUrl> getSocialUrls() {
        return socialUrls;
    }

    public void setSocialUrls(List<SocialUrl> socialUrlProfiles) {
        this.socialUrls = socialUrlProfiles;
        this.setUpdatedAt();
    }

    public void addSocialUrl(SocialUrl socialUrlProfiles) {
        this.socialUrls.add(socialUrlProfiles);
        this.setUpdatedAt();
    }

    public String getCreatedAt() {
        return createdAt;
    }

    private void setCreatedAt() {
        createdAt = FormatDate.now();
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    private void setUpdatedAt() {
        updatedAt = FormatDate.now();
    }
}
