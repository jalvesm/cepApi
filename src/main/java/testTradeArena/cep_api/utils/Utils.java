package testTradeArena.cep_api.utils;

public class Utils {

    private static final int CEP_LENGTH = 8;
    private static final String CEP_REGEX = "\\d+";

    public static boolean isCepFormatValid(String cep) {
        if (cep.matches(CEP_REGEX)) {
            return true;
        }
        return false;
    }

    public static boolean isCepLengthValid(String cep) {
        if (cep.length() == CEP_LENGTH) {
            return true;
        }
        return false;
    }
}
