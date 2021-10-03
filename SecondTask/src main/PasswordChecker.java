/**
 * class to check if password is valid
 * need to set password's minLength in constructor before validation
 * also can give minLength and specialSymbols char[] to constructor to create specific special symbols list
 */


public class PasswordChecker {

    private char[] specialSymbols;
    private int minLength;

    public PasswordChecker(int minLength) {
        this.minLength = minLength;
        specialSymbols = new char[]{'!', '@', '#', '$', '%', '^', '&', '*'};
    }

    public PasswordChecker(int minLength, char[] specialSymbols) {
        this.minLength = minLength;
        this.specialSymbols = specialSymbols;
    }

    public boolean validate(String password) {
        return  password != null && checkLength(password) && checkUpperCase(password)  && checkSpecialSymbols(password);

    }

    private boolean checkLength(String password) {
        return password.length() >= minLength;
    }

    private boolean checkUpperCase(String password) {
        for(char symbol : password.toCharArray()) {
            for(int i = 65; i < 91; i++) {
                if(symbol == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkSpecialSymbols(String password) {
        boolean hasSpecialSymbol = false;
        for(char symbol : password.toCharArray()) {
            boolean isSignValid = false;

            for (char specialSymbol : specialSymbols) {
                if (symbol == specialSymbol) {
                    hasSpecialSymbol = true;
                    isSignValid = true;
                }
            }
            if (!isSignValid) {

                //checks if symbol is number or letter
                if (symbol >= 48 && symbol <= 57 || symbol >= 65 && symbol <= 90 || symbol >= 97 && symbol <= 122) {
                    continue;
                } else return false;
            }
        }
        return hasSpecialSymbol;
    }

}
