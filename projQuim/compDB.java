import java.util.ArrayList;
import java.util.Scanner;

public class compDB {
    final static Scanner LER = new Scanner(System.in);
    static ArrayList<compostos> list = new ArrayList<>();

    public static void setComp() {
        // Adicionando os compostos com seus potenciais de redução e se são anions
        list.add(new compostos("Li+", -3.04, false));
        list.add(new compostos("Ca²+", -2.87, false));
        list.add(new compostos("Na+", -2.71, false));
        list.add(new compostos("Mg²+", -2.36, false));
        list.add(new compostos("Al³+", -1.66, false));
        list.add(new compostos("Zn²+", -0.76, false));
        list.add(new compostos("Fe²+", -0.44, false));
        list.add(new compostos("Co²+", -0.28, false));
        list.add(new compostos("Ni²+", -0.25, false));
        list.add(new compostos("Sn²+", -0.14, false));
    }

    public static void menu() {
        System.out.println("Menu:");
        System.out.println("1 - Selecionar metais para oxidação e redução");
        System.out.print("Escolha uma opção: ");
        int choice = LER.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Selecione os metais para oxidação e redução:");
                operacoes();
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private static void operacoes() {
        // Imprime a lista de espécies e seus potenciais de redução
        System.out.println("Selecione o metal que oxida (Digite o número):");
        for (int i = 0; i < list.size(); i++) {
            compostos especie = list.get(i);
            System.out.println(i + " - " + especie.getEspecie() + " (Potencial de Red: " + especie.getPotencialDeRed() + " V)");
        }

        // Obter a escolha do metal que oxida
        int yOxidante = LER.nextInt();
        compostos especieOxidante = list.get(yOxidante);
        System.out.println("Você selecionou: " + especieOxidante.getEspecie());

        System.out.println("Selecione o metal que reduz (Digite o número):");
        // Imprime novamente a lista para o metal que reduz
        for (int i = 0; i < list.size(); i++) {
            compostos especie = list.get(i);
            System.out.println(i + " - " + especie.getEspecie() + " (Potencial de Red: " + especie.getPotencialDeRed() + " V)");
        }

        // Obter a escolha do metal que reduz
        int yRedutor = LER.nextInt();
        compostos especieRedutor = list.get(yRedutor);
        System.out.println("Você selecionou: " + especieRedutor.getEspecie());

        // Calcular o potencial de célula (E° da célula)
        calcularPotencial(especieOxidante, especieRedutor);
    }

    private static void calcularPotencial(compostos oxidante, compostos redutor) {
        // O potencial da célula (E°cel) é a diferença entre o potencial do redutor e o do oxidante
        double eCelula = redutor.getPotencialDeRed() - oxidante.getPotencialDeRed();
        
        System.out.println("Potencial da célula (E°cel): " + eCelula + " V");
        
        if (eCelula > 0) {
            System.out.println("A reação é espontânea.");
        } else {
            System.out.println("A reação não é espontânea.");
        }
    }

    public static void main(String[] args) {
        // Preencher a lista de compostos
        setComp();

        // Chamar o menu principal
        menu();
    }
}

class compostos {
    private String especie;
    private double potencialDeRed;
    private boolean anion;

    // Construtor
    public compostos(String especie, double potencialDeRed, boolean anion) {
        this.especie = especie;
        this.potencialDeRed = potencialDeRed;
        this.anion = anion;
    }

    // Métodos getters e setters
    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public double getPotencialDeRed() {
        return potencialDeRed;
    }

    public void setPotencialDeRed(double potencialDeRed) {
        this.potencialDeRed = potencialDeRed;
    }

    public boolean isAnion() {
        return anion;
    }

    public void setAnion(boolean anion) {
        this.anion = anion;
    }
}
