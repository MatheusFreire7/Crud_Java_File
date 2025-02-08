package src;

public class EmailUtils {

    // Verifica se o e-mail é válido
    public static boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        // Expressão regular para validar e-mails
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }
}