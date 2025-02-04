package testTradeArena.cep_api.utils;

public class Utils {

    private static final int CEP_LENGTH = 8;
    private static final String CEP_REGEX = "\\d+";

    public static void validateCepFormat(String cep) {
        if (!cep.matches(CEP_REGEX)) {
            throw new IllegalArgumentException("CEP inválido! Informe apenas números, sem traços ou letras.");
        }
    }

    public static void validateCepLength(String cep) {
        if (cep.length() != CEP_LENGTH) {
            throw new IllegalArgumentException("CEP inválido! Você deve informar exatamente 8 números.");
        }
    }
}
