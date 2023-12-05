package currencyConverter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MainWindowBoiteBlanche {
    // Ces tests devraient couvrir les autres critères aussi.

    @Test
    public void testConvertD1() {
        ArrayList<Currency> currencies = Currency.init();
        String currency1 = currencies.get(0).getName(); // Supposons que cela soit "USD"
        String currency2 = currencies.get(1).getName(); // Supposons que cela soit "EUR"

        double result = MainWindow.convert(currency1, currency2, currencies, 100.0);
        assertTrue(result != 0.0, "La conversion devrait réussir pour une devise valide");
    }

    @Test
    public void testConvertD2() {
        // D2 : Tests pour vérifier la branche où currency2 n'est pas trouvée
        ArrayList<Currency> currencies = Currency.init();
        double result = MainWindow.convert("USD", "Fake Currency", currencies, 100.0);

        assertEquals(0.0, result, 0.0, "Aucune conversion ne devrait être faite pour une devise invalide");
    }

    @Test
    public void testConvertD3() {
        // D3 : Tests pour vérifier la branche où currency1 et currency2 sont trouvés
        ArrayList<Currency> currencies = Currency.init();
        String currency1 = currencies.get(0).getName();
        String currency2 = currencies.get(1).getName();

        double result = MainWindow.convert(currency1, currency2, currencies, 100.0);

        assertTrue(result != 0.0, "La conversion devrait réussir pour des devises valides");
    }

    // Test pour vérifier le comportement avec une liste de devises vide
    @Test
    public void testConvertEmptyCurrencies() {
        // Créez une liste de devises vide
        ArrayList<Currency> emptyCurrencies = new ArrayList<>();
        double result = MainWindow.convert("USD", "EUR", emptyCurrencies, 100.0);

        assertEquals(0.0, result, 0.0, "Aucune conversion ne devrait être faite avec une liste de devises vide");
    }

}
