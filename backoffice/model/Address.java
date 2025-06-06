package backoffice.model;

public class Address {

    private int id;
    private String postalCode;
    private String regionCode;
    private String administrativeArea;
    private String locality;
    private String sublocality;
    private String addressLine;

    public Address (
        int id,
        String postalCode,
        String regionCode,
        String administrativeArea,
        String locality,
        String sublocality,
        String addressLine
    ) {
        this.id = id;
        this.postalCode = postalCode;
        this.regionCode = regionCode;
        this.administrativeArea = administrativeArea;
        this.locality = locality;
        this.sublocality = sublocality;
        this.addressLine = addressLine;
    }

    public int getId() {
        return id;
    }

    public Address setId(int id) {
        this.id = id;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Address setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public Address setRegionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public String getAdministrativeArea() {
        return administrativeArea;
    }

    public Address setAdministrativeArea(String administrativeArea) {
        this.administrativeArea = administrativeArea;
        return this;
    }

    public String getLocality() {
        return locality;
    }

    public Address setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public String getSublocality() {
        return sublocality;
    }

    public Address setSublocality(String sublocality) {
        this.sublocality = sublocality;
        return this;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public Address setAddressLine(String addressLine) {
        this.addressLine = addressLine;
        return this;
    }
}