import java.util.ArrayList;
import java.util.Scanner;

public class compDB {
    final static Scanner LER = new Scanner(System.in);
    static ArrayList<compostos> list = new ArrayList<>();

    // Preenche a lista de compostos com os dados fornecidos
    public static void setComp() {
        compostos especie1 = new compostos();
        especie1.setEspecie("Li+");
        especie1.setPotencialDeRed(-3.04);
        especie1.setAnion(false);
        list.add(especie1);

        compostos especie2 = new compostos();
        especie2.setEspecie("Ca²+");
        especie2.setPotencialDeRed(-2.87);
        especie2.setAnion(false);
        list.add(especie2);

        compostos especie3 = new compostos();
        especie3.setEspecie("Na+");
        especie3.setPotencialDeRed(-2.71);
        especie3.setAnion(false);
        list.add(especie3);

        compostos especie4 = new compostos();
        especie4.setEspecie("Mg²+");
        especie4.setPotencialDeRed(-2.36);
        especie4.setAnion(false);
        list.add(especie4);

        compostos especie5 = new compostos();
        especie5.setEspecie("Al³+");
        especie5.setPotencialDeRed(-1.66);
        especie5.setAnion(false);
        list.add(especie5);

        compostos especie6 = new compostos();
        especie6.setEspecie("Zn²+");
        especie6.setPotencialDeRed(-0.76);
        especie6.setAnion(false);
        list.add(especie6);

        compostos especie7 = new compostos();
        especie7.setEspecie("Fe²+");
        especie7.setPotencialDeRed(-0.44);
        especie7.setAnion(false);
        list.add(especie7);

        compostos especie8 = new compostos();
        especie8.setEspecie("Co²+");
        especie8.setPotencialDeRed(-0.28);
        especie8.setAnion(false);
        list.add(especie8);

        compostos especie9 = new compostos();
        especie9.setEspecie("Ni²+");
        especie9.setPotencialDeRed(-0.25);
        especie9.setAnion(false);
        list.add(especie9);

        compostos especie10 = new compostos();
        especie10.setEspecie("Sn²+");
        especie10.setPotencialDeRed(-0.14);
        especie10.setAnion(false);
        list.add(especie10);
    }

    public static void menu() {
        System.out.println("Selecione uma operação:");
        System.out.println("1 - Calcular Potencial de Célula");
        int escolha = LER.nextInt();
        switch (escolha) {
            case 1:
                System.out.println("Selecione as espécies para a célula eletroquímica:");
                operacoes();
                break;
            default:
                break;
        }
    }

    private static void operacoes() {
        // Imprimir a lista de espécies com seus potenciais de redução
        System.out.println("Selecione as espécies (Digite o número) e insira os potenciais de oxidação:");
        for (int i = 0; i < list.size(); i++) {
            compostos especie = list.get(i);
            System.out.println(i + " - " + especie.getEspecie() + " (Potencial de Red: " + especie.getPotencialDeRed() + " V)");
        }

        // Escolher as espécies
        System.out.print("Selecione a espécie do ânodo (oxidação): ");
        int indiceAnodo = LER.nextInt();
        compostos especieAnodo = list.get(indiceAnodo);
        System.out.println("Você selecionou: " + especieAnodo.getEspecie());
        System.out.println("Potencial de Redução: " + especieAnodo.getPotencialDeRed() + " V");

        System.out.print("Selecione a espécie do cátodo (redução): ");
        int indiceCatodo = LER.nextInt();
        compostos especieCatodo = list.get(indiceCatodo);
        System.out.println("Você selecionou: " + especieCatodo.getEspecie());
        System.out.println("Potencial de Redução: " + especieCatodo.getPotencialDeRed() + " V");

        // Pedir o potencial de oxidação do ânodo
        System.out.print("Digite o potencial de oxidação da espécie " + especieAnodo.getEspecie() + " (em V): ");
        double oxidaAnodo = LER.nextDouble();

        // O potencial de oxidação é negativo do valor de redução
        double oxiAnodo = -oxidaAnodo;
        System.out.println("Potencial de Oxidação (Ânodo): " + oxiAnodo + " V");

        // Calcular o potencial de célula
        double potencialCelula = especieCatodo.getPotencialDeRed() - oxiAnodo;
        System.out.println("Potencial da célula eletroquímica: " + potencialCelula + " V");

        // Exibir se a célula é espontânea
        if (potencialCelula > 0) {
            System.out.println("A célula é espontânea.");
        } else {
            System.out.println("A célula não é espontânea.");
        }
    }

    public static void main(String[] args) {
        setComp();  // Inicializar as espécies
        menu();  // Chamar o menu
    }
}
