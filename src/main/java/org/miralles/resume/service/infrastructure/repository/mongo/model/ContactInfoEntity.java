package org.miralles.resume.service.infrastructure.repository.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "contactinfo")
public class ContactInfoEntity {
    private String email;
    private String name;
    private String surname;
    private String gitUrl;
    private String sonarUrl;
    private String phoneNumber;
    private String resumeOnlineUrl;
    private String address;
    private String postalCode;
    private String city;
    private String region;
    private String countryCode;

    public ContactInfoEntity(String email, String name, String surname, String gitUrl, String sonarUrl, String phoneNumber, String resumeOnlineUrl, String address, String postalCode, String city, String region, String countryCode) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.gitUrl = gitUrl;
        this.sonarUrl = sonarUrl;
        this.phoneNumber = phoneNumber;
        this.resumeOnlineUrl = resumeOnlineUrl;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.region = region;
        this.countryCode = countryCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getSonarUrl() {
        return sonarUrl;
    }

    public void setSonarUrl(String sonarUrl) {
        this.sonarUrl = sonarUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResumeOnlineUrl() {
        return resumeOnlineUrl;
    }

    public void setResumeOnlineUrl(String resumeOnlineUrl) {
        this.resumeOnlineUrl = resumeOnlineUrl;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactInfoEntity)) return false;
        ContactInfoEntity that = (ContactInfoEntity) o;
        return Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getSurname(), that.getSurname()) &&
                Objects.equals(getGitUrl(), that.getGitUrl()) &&
                Objects.equals(getSonarUrl(), that.getSonarUrl()) &&
                Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
                Objects.equals(getResumeOnlineUrl(), that.getResumeOnlineUrl()) &&
                Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getPostalCode(), that.getPostalCode()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getRegion(), that.getRegion()) &&
                Objects.equals(getCountryCode(), that.getCountryCode());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getEmail(), getName(), getSurname(), getGitUrl(), getSonarUrl(), getPhoneNumber(), getResumeOnlineUrl(), getAddress(), getPostalCode(), getCity(), getRegion(), getCountryCode());
    }

    @Override
    public String toString() {
        return "ContactInfoEntity{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", sonarUrl='" + sonarUrl + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", resumeOnlineUrl='" + resumeOnlineUrl + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
