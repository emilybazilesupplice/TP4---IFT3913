package currencyConverter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import currencyConverter.Currency;



public class CurrencyBoiteNoireTest {

    // Test pour un cas de base
    @Test
    public void testConversion() {
        double initialAmount = 100.00;
        double exchangeRate = 1.5;
        double expected = 150.0;
        double result = Currency.convert(initialAmount, exchangeRate);

        assertEquals(expected, result, "Conversion de montant positif avec taux de change positif");

    }

    // Test pour les valeurs limites (incluse)

    @Test
    public void testZeroAmmount() {
        double initialAmount = 0.00;
        double exchangeRate = 1.5;
        double expected = 0.0;
        double result = Currency.convert(initialAmount, exchangeRate);

        assertEquals(expected, result, "Conversion d'un montant nulle");

    }

    @Test
    public void testMillionAmmount() {
        double initialAmount = 1000000.00;
        double exchangeRate = 1.5;
        double expected = 1500000.0;
        double result = Currency.convert(initialAmount, exchangeRate);

        assertEquals(expected, result, "Conversion du montant maximal");

    }

    @Test
    public void testZeroRate() {
        double initialAmount = 100.00;
        double exchangeRate = 0;
        double expected = 0;
        double result = Currency.convert(initialAmount, exchangeRate);

        assertEquals(expected, result, "Conversion de montant avec taux de change nul");

    }


    // Test pour les valeurs limites (invalide)

    @Test
    public void testMontantNegatif() {
        double initialAmount = -1.0;
        double exchangeRate = 1.5;

        assertThrows(IllegalArgumentException.class, () -> Currency.convert(initialAmount, exchangeRate));

    }

    @Test
    public void testLargeAmmount() {
        double initialAmount = 1000001.00;
        double exchangeRate = 1.5;
        assertThrows(IllegalArgumentException.class, () -> Currency.convert(initialAmount, exchangeRate));

    }

    @Test
    public void testNegativeRate() {
        double initialAmount = 100.00;
        double exchangeRate = -1.5;
        assertThrows(IllegalArgumentException.class, () -> Currency.convert(initialAmount, exchangeRate));

    }


    @Test
    public void usdConversion() {
        double initialAmount = 100.00;

        // usd to usd
        assertEquals(100.00, Currency.convert(initialAmount, 1.0));

        // usd to CAD (not in it)
        // assertEquals(100.00, Currency.convert(initialAmount, 1.0));

        // usd to GBP
        assertEquals(66.00, Currency.convert(initialAmount, 0.66));

        // usd to EUR
        assertEquals(93.00, Currency.convert(initialAmount, 0.93));

        // usd to CHF
        assertEquals(101.00, Currency.convert(initialAmount, 1.01));

        // usd to AUD (not in it)
        //assertEquals(66.00, Currency.convert(initialAmount, 0.66));

    }
    
}
