import java.util.ArrayList;

public class EmailValidator {

    ArrayList<String> correctTLDs = new ArrayList<>();


    public EmailValidator() {
        correctTLDs.add("com");
        correctTLDs.add("lt");
        correctTLDs.add("org");
    }

    public EmailValidator(ArrayList<String> additionalTLDs) {
        this();
        for(String additionalTLD : additionalTLDs) {
            correctTLDs.add(additionalTLD);
        }
    }


    public boolean validate(String email) {
        return email != null && checkForEta(email) && checkIfSymbolsAreValid(email) && checkDomain(email);
    }


    private boolean checkForEta(String email) {
        int etaCounter = 0;
        for (char symbol : email.toCharArray()) {
            if (symbol == '@') {
                etaCounter++;
            }
        }
        return etaCounter == 1;
    }

    private boolean checkIfSymbolsAreValid(String email) {
        char previousSymbol = 'A';
        for (char symbol : email.toCharArray()) {
            //checks if symbol is number or letter
            if (symbol == '@' || symbol >= 48 && symbol <= 57 || symbol >= 65 && symbol <= 90 || symbol >= 97 && symbol <= 122) {
                continue;
            } else if (symbol == '.' || symbol == '_' || symbol == '-' && symbol != previousSymbol) {
                previousSymbol = symbol;
                continue;
            } else return false;

        }
        return true;
    }

    private boolean checkDomain(String email) {
        String[] domains = email.split("@")[1].split("\\.");

        if(domains.length < 2) {
            return false;
        }

        String domain = domains[0];
        String tld = domains[1];
        if(domain.length() <= 1 || domain.length() > 64) {
            return false;
        }
        if(domain.charAt(0) == '-' || domain.charAt(domain.length() - 1) == '-') {
            return false;
        }
        for(char symbol : domain.toCharArray()) {
            if(!(symbol >= 48 && symbol <= 57 || symbol >= 65 && symbol <= 90 || symbol >= 97 && symbol <= 122)) {
                return false;
            }
        }
        for(String correctTLD : correctTLDs) {
            if(tld.equals(correctTLD)) {
                return true;
            }
        }
        return false;
    }


}
