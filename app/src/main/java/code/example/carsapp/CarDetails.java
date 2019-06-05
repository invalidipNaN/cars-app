package code.example.carsapp;

public class CarDetails {

    private String vin;
    private int year;
    private String make;
    private String model;
    private String trim;
    private String subTrim;
    private String phone;
    private int mileage;
    private float currentPrice;
    private String exteriorColor;
    private String interiorColor;
    private String engine;
    private String driveType;
    private String transmission;
    private String bodyType;
    private String photo;

    public CarDetails(String vin, int year, String make, String model, String trim, String subTrim, String phone, int mileage, float currentPrice, String exteriorColor, String interiorColor, String engine, String driveType, String transmission, String bodyType, String photo) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.subTrim = subTrim;
        this.phone = phone;
        this.mileage = mileage;
        this.currentPrice = currentPrice;
        this.exteriorColor = exteriorColor;
        this.interiorColor = interiorColor;
        this.engine = engine;
        this.driveType = driveType;
        this.transmission = transmission;
        this.bodyType = bodyType;
        this.photo = photo;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getSubTrim() {
        return subTrim;
    }

    public void setSubTrim(String subTrim) {
        this.subTrim = subTrim;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
