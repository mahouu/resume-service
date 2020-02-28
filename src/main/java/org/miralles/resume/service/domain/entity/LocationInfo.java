package org.miralles.resume.service.domain.entity;

import java.util.Objects;

public final class LocationInfo {
    private final String address;
    private final String postalCode;
    private final String city;
    private final String region;
    private final String countryCode;

    public LocationInfo(String address, String postalCode, String city, String region, String countryCode) {
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.region = region;
        this.countryCode = countryCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationInfo)) return false;
        LocationInfo that = (LocationInfo) o;
        return Objects.equals(getAddress(), that.getAddress()) &&
                Objects.equals(getPostalCode(), that.getPostalCode()) &&
                Objects.equals(getCity(), that.getCity()) &&
                Objects.equals(getRegion(), that.getRegion()) &&
                Objects.equals(getCountryCode(), that.getCountryCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getPostalCode(), getCity(), getRegion(), getCountryCode());
    }

    @Override
    public String toString() {
        return "Locationinfo{" +
                "address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
