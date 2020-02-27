package org.miralles.resume.service.infrastructure.rest.model;

import java.util.Objects;

public final class LocationView {

    private final String addressView;
    private final String postalCodeView;
    private final String cityView;
    private final String regionView;
    private final String countryCodeView;

    public LocationView(final String addressView, final String postalCodeView, final String cityView,
                        final String regionView, final String countryCodeView) {
        this.addressView = addressView;
        this.postalCodeView = postalCodeView;
        this.cityView = cityView;
        this.regionView = regionView;
        this.countryCodeView = countryCodeView;
    }

    public String getAddressView() {
        return addressView;
    }

    public String getPostalCodeView() {
        return postalCodeView;
    }

    public String getCityView() {
        return cityView;
    }

    public String getRegionView() {
        return regionView;
    }

    public String getCountryCodeView() {
        return countryCodeView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationView)) return false;
        LocationView that = (LocationView) o;
        return Objects.equals(getAddressView(), that.getAddressView()) &&
                Objects.equals(getPostalCodeView(), that.getPostalCodeView()) &&
                Objects.equals(getCityView(), that.getCityView()) &&
                Objects.equals(getRegionView(), that.getRegionView()) &&
                Objects.equals(getCountryCodeView(), that.getCountryCodeView());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressView(), getPostalCodeView(), getCityView(), getRegionView(), getCountryCodeView());
    }

    @Override
    public String toString() {
        return "LocationView{" +
                "addressView='" + addressView + '\'' +
                ", postalCodeView='" + postalCodeView + '\'' +
                ", cityView='" + cityView + '\'' +
                ", regionView='" + regionView + '\'' +
                ", countryCodeView='" + countryCodeView + '\'' +
                '}';
    }
}
