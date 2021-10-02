public class PasswordChecker {

    private char[] specialSymbols = {'!', '@', '#', '$', '%', '^', '&', '*'};
    private int minLength;

    public PasswordChecker(int minLength) {
        this.minLength = minLength;
    }

    public boolean validate(String password) {
        char[] passwordSymbols = password.toCharArray();
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
