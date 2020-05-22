package logic;
public class TFieldLogik {

    opretLaan OpretLaan = new opretLaan();

    public enum TFieldResult {
        bilnavnIsEmpty, bilprisIsEmpty, udbetalingIsEmpty, laanleangdeIsEmpty, allIsEmpty, Success
    };

    public TFieldResult TFieldCheck(String tlfGetText, String bilnavnGetText, String bilprisGetText, String udbetalingGetText,
            String laanleangdeGetText, double rente) {

        if (bilnavnGetText.isEmpty() && udbetalingGetText.isEmpty() && bilprisGetText.isEmpty() && udbetalingGetText.isEmpty()
                && laanleangdeGetText.isEmpty()) {
            return TFieldResult.allIsEmpty;
        } else if (bilnavnGetText.isEmpty()) {
            return TFieldResult.bilnavnIsEmpty;
        } else if (bilprisGetText.isEmpty()) {
            return TFieldResult.bilprisIsEmpty;
        } else if (udbetalingGetText.isEmpty()) {
            return TFieldResult.udbetalingIsEmpty;
        } else if (laanleangdeGetText.isEmpty()) {
            return TFieldResult.laanleangdeIsEmpty;
        } else
        return TFieldResult.Success;
    }
}