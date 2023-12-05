package currencyConverter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CurrencyBoiteBlanche {

    @Test
    public void testConvert() {
        // Test qui couvre les intructions de Convert de Currency
        double amount = 100.25;
        double exchangeValue = 1.337;
        double expected = Math.round(amount * exchangeValue * 100d) / 100d;
        double result = Currency.convert(amount, exchangeValue);

        assertEquals(expected, result, 0.001, "Le résultat de la conversion doit correspondre à la valeur attendue après arrondi");
    }
    
}
