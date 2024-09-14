package CONTROLLER;

public class ValidadorCPF {

    public static boolean isCPF(String CPF) {
        // Remover caracteres não numéricos (espera-se apenas números)
        CPF = CPF.replaceAll("[^0-9]", "");

        // Verificar se o CPF tem 11 dígitos
        if (CPF.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais (ex. "11111111111")
        if (CPF.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcular o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (CPF.charAt(i) - '0') * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit == 10 || firstDigit == 11) {
            firstDigit = 0;
        }

        // Verificar o primeiro dígito verificador
        if (firstDigit != (CPF.charAt(9) - '0')) {
            return false;
        }

        // Calcular o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (CPF.charAt(i) - '0') * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit == 10 || secondDigit == 11) {
            secondDigit = 0;
        }

        // Verificar o segundo dígito verificador
        return secondDigit == (CPF.charAt(10) - '0');
    }
}