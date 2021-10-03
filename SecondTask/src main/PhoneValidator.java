import java.util.ArrayList;


public class PhoneValidator {

    private ArrayList<ValidationRule> phoneRules = new ArrayList<>();

    public PhoneValidator() {
        new ArrayList<String>().add("tld");
        phoneRules.add(new ValidationRule("+370", 12, "LT"));
    }

    public boolean validate(String phoneNumber, String countryCode) {
        if(phoneNumber == null || countryCode == null || phoneNumber.isEmpty()) {
            return false;
        }
        phoneNumber = changeNumber(phoneNumber);
        return checkNumbers(phoneNumber) && checkIfValidCountryNumber(phoneNumber, countryCode);
    }

    private boolean checkNumbers (String phoneNumber) {
        if(phoneNumber.charAt(0) == '+') {
            phoneNumber = phoneNumber.substring(1);
        }
        for(char symbol : phoneNumber.toCharArray()) {

            //checks if symbol letter
            if(symbol < 48 || symbol > 57) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfValidCountryNumber(String  phoneNumber, String countryCode) {
        for (ValidationRule rule : phoneRules) {
            if (rule.getCountryCode().equals(countryCode) && rule.getLength() == phoneNumber.length()) {
                String prefix = rule.getPrefix();
                phoneNumber = phoneNumber.substring(0, prefix.length());
                if(phoneNumber.equals(prefix)) {
                    return true;
                }
            }
        }
        return false;
    }


    private void addNewRule(String prefix, int length, String countryCode) {
        ValidationRule rule = new ValidationRule(prefix, length, countryCode);
        phoneRules.add(rule);
    }


    public String changeNumber(String phoneNumber) {
        if(phoneNumber.charAt(0) == '8') {
            String prefix = "+370";
            String numberWithoutPrefix = phoneNumber.substring(1);
            return prefix + numberWithoutPrefix;
        }
        return phoneNumber;
    }


}
