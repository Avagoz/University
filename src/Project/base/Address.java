package Project.base;

public class Address {
    private String city;
    private String street;
    private String home;
    private int apt;

    public Address(String city, String street, String home, int apt) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apt = apt;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        if (city.isEmpty()) {
            this.city = "No City!";
        } else {
            this.city = city;
        }
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        if (street.isEmpty()) {
            this.street = "No Street!";
        } else {
            this.street = street;
        }
    }

    public String getHome() {
        return this.home;
    }

    public void setHome(String home) {
        if (home.isEmpty()) {
            this.home = "No home's number!";
        } else {
            this.home = home;
        }
    }

    public int getApt() {
        return this.apt;
    }

    public void setApt(int apt) {
        if (apt >= 0 && apt < 10000) {
            this.apt = apt;
        } else {
            System.out.println("!!! Invalid Appartament !!!");
        }
    }



    public void displayAddress() {
        System.out.println("Address" +
                "\n=======================" +
                "\nApt " + getApt() + "; " + getHome() + ", "
                + getStreet()+"\n"+getCity());
    }

    @Override
    public String toString() {
        return "Address" +
                "\n=======================" +
                "\nApt " + getApt() + "; " + getHome() + ", "
                + getStreet()+
                "\n"+getCity();
    }
}
