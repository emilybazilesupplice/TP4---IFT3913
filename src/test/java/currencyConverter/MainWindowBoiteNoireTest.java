package currencyConverter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import currencyConverter.Currency;

public class MainWindowBoiteNoireTest {

    private MainWindow mainWindow;
    private ArrayList<Currency> currencies;

    @BeforeEach
    void setUp() {
        mainWindow = new MainWindow();
        currencies = Currency.init();
    }

    // Test pour chacune des devises

    @Test
    public void usdConversion() {
        double initialAmount = 100.00;

        assertAll("USD conversions",
            () -> assertEquals(100.0, MainWindow.convert("US Dollar", "US Dollar", currencies, initialAmount), "Conversion usd -> usd"),
            () -> assertEquals(137.0, MainWindow.convert("US Dollar", "Canadian Dollar", currencies, initialAmount), "Conversion usd -> cad"),
            () -> assertEquals(66.0, MainWindow.convert("US Dollar", "British Pound", currencies, initialAmount), "Conversion usd -> gbp"),
            () -> assertEquals(93.0, MainWindow.convert("US Dollar", "Euro", currencies, initialAmount), "Conversion usd -> eur"),
            () -> assertEquals(101.0, MainWindow.convert("US Dollar", "Swiss Franc", currencies, initialAmount), "Conversion usd -> chf"),
            () -> assertEquals(152.0, MainWindow.convert("US Dollar", "Dollar Australien", currencies, initialAmount), "Conversion usd -> aud")
        );

    }

    @Test
    public void cadConversion() {
        double initialAmount = 100.00;

        assertAll("CAD conversions",
            () -> assertEquals(73.0, MainWindow.convert("Canadian Dollar", "US Dollar", currencies, initialAmount), "Conversion cad -> usd"),
            () -> assertEquals(100.0, MainWindow.convert("Canadian Dollar", "Canadian Dollar", currencies, initialAmount), "Conversion cad -> cad"),
            () -> assertEquals(58.0, MainWindow.convert("Canadian Dollar", "British Pound", currencies, initialAmount), "Conversion cad -> gbp"),
            () -> assertEquals(67.0, MainWindow.convert("Canadian Dollar", "Euro", currencies, initialAmount), "Conversion cad -> eur"),
            () -> assertEquals(65.0, MainWindow.convert("Canadian Dollar", "Swiss Franc", currencies, initialAmount), "Conversion cad -> chf"),
            () -> assertEquals(111.0, MainWindow.convert("Canadian Dollar", "Dollar Australien", currencies, initialAmount), "Conversion cad -> aud")
        );
    }

    @Test
    public void gbpConversion() {
        double initialAmount = 100.00;

        assertAll("GBP conversions",
            () -> assertEquals(151.0, MainWindow.convert("British Pound", "US Dollar", currencies, initialAmount), "Conversion gbp -> usd"),
            () -> assertEquals(172.0, MainWindow.convert("British Pound", "Canadian Dollar", currencies, initialAmount), "Conversion gbp -> cad"),
            () -> assertEquals(100.0, MainWindow.convert("British Pound", "British Pound", currencies, initialAmount), "Conversion gbp -> gbp"),
            () -> assertEquals(141.0, MainWindow.convert("British Pound", "Euro", currencies, initialAmount), "Conversion gbp -> eur"),
            () -> assertEquals(152.0, MainWindow.convert("British Pound", "Swiss Franc", currencies, initialAmount), "Conversion gbp -> chf"),
            () -> assertEquals(191.0, MainWindow.convert("British Pound", "Dollar Australien", currencies, initialAmount), "Conversion gbp -> aud")
        );
    }

    @Test
    public void eurConversion() {
        double initialAmount = 100.00;

        assertAll("EUR conversions",
            () -> assertEquals(107.3, MainWindow.convert("Euro", "US Dollar", currencies, initialAmount), "Conversion eur -> usd"),
            () -> assertEquals(149.0, MainWindow.convert("Euro", "Canadian Dollar", currencies, initialAmount), "Conversion eur -> cad"),
            () -> assertEquals(71.0, MainWindow.convert("Euro", "British Pound", currencies, initialAmount), "Conversion eur -> gbp"),
            () -> assertEquals(100.0, MainWindow.convert("Euro", "Euro", currencies, initialAmount), "Conversion eur -> eur"),
            () -> assertEquals(108.0, MainWindow.convert("Euro", "Swiss Franc", currencies, initialAmount), "Conversion eur -> chf"),
            () -> assertEquals(166.0, MainWindow.convert("Euro", "Dollar Australien", currencies, initialAmount), "Conversion eur -> aud")
        );
    }

    @Test
    public void chfConversion() {
        double initialAmount = 100.00;

        assertAll("CHF conversions",
            () -> assertEquals(99.0, MainWindow.convert("Swiss Franc", "US Dollar", currencies, initialAmount), "Conversion chf -> usd"),
            () -> assertEquals(152.0, MainWindow.convert("Swiss Franc", "Canadian Dollar", currencies, initialAmount), "Conversion chf -> cad"),
            () -> assertEquals(66.0, MainWindow.convert("Swiss Franc", "British Pound", currencies, initialAmount), "Conversion chf -> gbp"),
            () -> assertEquals(93.0, MainWindow.convert("Swiss Franc", "Euro", currencies, initialAmount), "Conversion chf -> eur"),
            () -> assertEquals(100.0, MainWindow.convert("Swiss Franc", "Swiss Franc", currencies, initialAmount), "Conversion chf -> chf"),
            () -> assertEquals(172.0, MainWindow.convert("Swiss Franc", "Dollar Australien", currencies, initialAmount), "Conversion chf -> aud")
        );
    }
    
    @Test
    public void audConversion() {
        double initialAmount = 100.00;

        assertAll("AUD conversions",
            () -> assertEquals(66.0, MainWindow.convert("Dollar Australien", "US Dollar", currencies, initialAmount), "Conversion aud -> usd"),
            () -> assertEquals(90.0, MainWindow.convert("Dollar Australien", "Canadian Dollar", currencies, initialAmount), "Conversion aud -> cad"),
            () -> assertEquals(52.0, MainWindow.convert("Dollar Australien", "British Pound", currencies, initialAmount), "Conversion aud -> gbp"),
            () -> assertEquals(60.0, MainWindow.convert("Dollar Australien", "Euro", currencies, initialAmount), "Conversion aud -> eur"),
            () -> assertEquals(58.0, MainWindow.convert("Dollar Australien", "Swiss Franc", currencies, initialAmount), "Conversion aud -> chf"),
            () -> assertEquals(100.0, MainWindow.convert("Dollar Australien", "Dollar Australien", currencies, initialAmount), "Conversion aud -> aud")
        );
    }

    // Test avec une devise invalide
    @Test
    public void invalidConversion() {
        double initialAmount = 100.00;

        assertEquals(0.0, MainWindow.convert("US Dollar", "Devise invalide", currencies, initialAmount), "Conversion usd -> devise invalide");
        assertEquals(0.0, MainWindow.convert("Devise invalide", "US Dollar", currencies, initialAmount), "Conversion devise invalide -> usd");

    }
}
