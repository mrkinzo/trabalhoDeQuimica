import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class compDB {

    final static Scanner LER = new Scanner(System.in);

    // Potenciais de redução
    static HashMap<String, Double> potenciais = new HashMap<>();
    // Semirreações de redução
    static HashMap<String, String> semirreacoes = new HashMap<>();

    public static void setComp() {

        potenciais.put("Li+", -3.04);
        semirreacoes.put("Li+", "Li+ + e⁻ → Li(s)");

        potenciais.put("Ca²+", -2.87);
        semirreacoes.put("Ca²+", "Ca²+ + 2e⁻ → Ca(s)");

        potenciais.put("Na+", -2.71);
        semirreacoes.put("Na+", "Na+ + e⁻ → Na(s)");

        potenciais.put("Mg²+", -2.36);
        semirreacoes.put("Mg²+", "Mg²+ + 2e⁻ → Mg(s)");

        potenciais.put("Al³+", -1.66);
        semirreacoes.put("Al³+", "Al³+ + 3e⁻ → Al(s)");

        potenciais.put("Zn²+", -0.76);
        semirreacoes.put("Zn²+", "Zn²+ + 2e⁻ → Zn(s)");

        potenciais.put("Fe²+", -0.44);
        semirreacoes.put("Fe²+", "Fe²+ + 2e⁻ → Fe(s)");

        potenciais.put("Co²+", -0.28);
        semirreacoes.put("Co²+", "Co²+ + 2e⁻ → Co(s)");

        potenciais.put("Ni²+", -0.25);
        semirreacoes.put("Ni²+", "Ni²+ + 2e⁻ → Ni(s)");

        potenciais.put("Sn²+", -0.14);
        semirreacoes.put("Sn²+", "Sn²+ + 2e⁻ → Sn(s)");
    }

    public static void menu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1 - Calcular Potencial da Célula");
        System.out.print("Escolha: ");

        int opc = LER.nextInt();
        if (opc == 1)
            operacoes();
    }

    public static void operacoes() {

        System.out.println("\n===== LISTA DE ESPÉCIES =====");
        String[] keys = potenciais.keySet().toArray(new String[0]);

        for (int i = 0; i < keys.length; i++) {
            System.out.println(i + " - " + keys[i] +
                    " | E°red = " + potenciais.get(keys[i]) + " V" +
                    " | " + semirreacoes.get(keys[i]));
        }

        System.out.print("\nSelecione o ânodo (oxidação): ");
        int indiceAnodo = LER.nextInt();

        System.out.print("Selecione o cátodo (redução): ");
        int indiceCatodo = LER.nextInt();

        String anodo = keys[indiceAnodo];
        String catodo = keys[indiceCatodo];

        double EredCatodo = potenciais.get(catodo);
        double EoxiAnodo  = -potenciais.get(anodo);
        double Ecelula    = EredCatodo + EoxiAnodo;

        System.out.println("\n===== RESULTADO =====");

        // Semirreações
        String reducaoCatodo = semirreacoes.get(catodo);
        String oxidacaoAnodo = inverterSemirreacao(semirreacoes.get(anodo));

        System.out.println("\nSemirreação no ÂNODO (oxidação):");
        System.out.println(oxidacaoAnodo + "    E°oxi = " + EoxiAnodo + " V");

        System.out.println("\nSemirreação no CÁTODO (redução):");
        System.out.println(reducaoCatodo + "    E°red = " + EredCatodo + " V");

        System.out.println("\nPotencial da célula: " + Ecelula + " V");
        if (Ecelula > 0)
            System.out.println("A célula é funcional.");
        else
            System.out.println("A célula NÃO é funcional.");
    }

    // Função para inverter semirreação (redução → oxidação)
    private static String inverterSemirreacao(String reducao) {
        String[] lados = reducao.split("→");
        return lados[1].trim() + " → " + lados[0].trim();
    }

    public static void main(String[] args) {
        setComp();
        menu();
    }
}
