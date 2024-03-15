import java.util.Scanner;

// Antiga classe de conversão que só suporta a conversão de USD para GBP
class OldCurrencyConverter {
    public double convertUSDtoGBP(double amount) {
        return amount * 0.80; // 80% do valor em USD
    }
}

// Novo adaptador que usa a antiga conversão e aplica a taxa adicional de GBP para EUR
class CurrencyAdapter {
    private final OldCurrencyConverter oldConverter;

    public CurrencyAdapter(OldCurrencyConverter oldConverter) {
        this.oldConverter = oldConverter;
    }
    public double convertUSDtoEur(double amount) {
        return amount * 0.85; // 85% do valor em USD
    }

    // TODO: Implementar método de conversão de USD para outra moeda (por exemplo, JPY)
    // Dica: Você pode criar métodos adicionais conforme necessário.

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

        OldCurrencyConverter oldConverter = new OldCurrencyConverter();
        CurrencyAdapter adapter = new CurrencyAdapter(oldConverter);

        // TODO: Chamar o método para converter USD para a nova moeda desejada (por exemplo, JPY)
        double ResultEuro = oldConverter.convertUSDtoGBP(input);

        double ResultEuroS = adapter.convertUSDtoEur(input);
        // TODO: Imprimir o resultado da conversão

        System.out.println("USD: " + input);
        System.out.println("EUR: " + ResultEuroS);
        // TODO: Imprimir o resultado da conversão com a nova moeda (por exemplo, JPY)
    }
}