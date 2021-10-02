public class ValidationRule {
    private String prefix;
    private int length;
    private String countryCode;

    public ValidationRule(String prefix, int length, String countryCode) {
        this.prefix = prefix;
        this.length = length;
        this.countryCode = countryCode;
    }


    public String getPrefix() {
        return prefix;
    }

    public int getLength() {
        return length;
    }

    public String getCountryCode() {
        return countryCode;
    }

}
