package Domain.ValueObjects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailVO {
    private String email;

    public Boolean validaEmail(String email){
        boolean isEmailIdValid = false;
        if (email != null && !email.isEmpty()) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
}
