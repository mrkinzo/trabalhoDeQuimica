import java.util.ArrayList;
import java.util.Scanner;

public class compDB {
    final static Scanner LER = new Scanner(System.in);
    static ArrayList<compostos> list = new ArrayList<>();

    public static void setComp(compostos comp) {
        compostos comp1 = new compostos();
        comp1.setName("Zn(s)");
        comp1.ox = false; // Reduzida
        list.add(comp1);

        compostos comp2 = new compostos();
        comp2.setName("Zn²⁺(aq)");
        comp2.ox = true; // Oxidada
        list.add(comp2);

        compostos comp3 = new compostos();
        comp3.setName("Cu(s)");
        comp3.ox = false; // Reduzida
        list.add(comp3);

        compostos comp4 = new compostos();
        comp4.setName("Cu²⁺(aq)");
        comp4.ox = true; // Oxidada
        list.add(comp4);
    }

    public static void operate() {
        // Inicializa comp1 e comp2 para garantir que não estejam nulos.
        compostos comp1 = new compostos();
        compostos comp2 = new compostos();
        
        System.out.println("--- Selecione a Primeira Espécie ---");
        System.out.println(list);
        System.out.print("Selecione a posição (1-4): ");
        if (!LER.hasNextInt()) {
            System.out.println("Entrada inválida.");
            LER.next(); // Consome a entrada inválida
            return;
        }
        int x = LER.nextInt();
        if (x >= 1 && x <= 4) {
            comp1 = list.get(x - 1);
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        System.out.println();
        System.out.println("----- Selecione a Segunda Espécie -----");
        System.out.println(list);
        System.out.print("Selecione a posição (1-4): ");
        if (!LER.hasNextInt()) {
            System.out.println("Entrada inválida.");
            LER.next(); // Consome a entrada inválida
            return;
        }
        int x1 = LER.nextInt();
        if (x1 >= 1 && x1 <= 4) {
            comp2 = list.get(x1 - 1);
        } else {
            System.out.println("Opção inválida.");
            return;
        }
        
        compareEspecies(comp1, comp2);
    }

    private static void compareEspecies(compostos comp1, compostos comp2) {
        System.out.println("\n--- ANÁLISE QUÍMICA DE REDUÇÃO ---");

        // 1. Ambos Oxidado ou Ambos Reduzido (Não há reação redox)
        if (comp1.ox == true && comp2.ox == true) {
            System.out.println("Não pode ocorrer reação. As duas espécies (" + comp1.getName() + " e " + comp2.getName() + ") estão em estado oxidado. Nenhuma das duas pode reduzir a outra.");
        } else if (comp1.ox == false && comp2.ox == false) {
            System.out.println("Não pode ocorrer reação. As duas espécies (" + comp1.getName() + " e " + comp2.getName() + ") estão em estado reduzido. Não há oxidante para ser reduzido.");
        } 
        
        // 2. Um Oxidado e Outro Reduzido (Reação possível)
        else {
            compostos oxidante, redutor;

            // Identificar qual é o agente oxidante (espécie oxidada) = A espécie que PODE REDUZIR
            if (comp1.ox) {
                oxidante = comp1; 
                redutor = comp2; 
            } else {
                oxidante = comp2;
                redutor = comp1;
            }

            System.out.println("Espécie Oxidada (Potencial de Redução): " + oxidante.getName());
            System.out.println("Espécie Reduzida (Potencial de Oxidação): " + redutor.getName());
            
            // Reação Potencial (Cu²⁺ reduzido pelo Zn)
            if (oxidante.getName().equals("Cu2+(aq)") && redutor.getName().equals("Zn(s)")) {
                System.out.println("\nREDUÇÃO OCORRE!");
                System.out.println("O " + oxidante.getName() + " é reduzido pelo " + redutor.getName() + ".");
                System.out.println("Meia-reação de Redução: Cu2+(aq) + 2e⁻ ⟶ Cu(s)");
                
            // Reação Potencial (Zn²⁺ tentando ser reduzido pelo Cu)
            } else if (oxidante.getName().equals("Zn2+(aq)") && redutor.getName().equals("Cu(s)")) {
                System.out.println("\nREDUÇÃO NÃO OCORRE!");
                System.out.println("O " + oxidante.getName() + " NÃO é reduzido pelo " + redutor.getName() + ".");
                System.out.println("O agente redutor (" + redutor.getName() + ") é fraco demais para iniciar a redução.");
                
            // Reação de um par redox consigo mesmo (Ex: Zn²⁺ + Zn)
            } else {
                 System.out.println("\nAs espécies selecionadas formam o mesmo par redox ("+oxidante.getName()+" e "+redutor.getName()+"). Nenhuma redução líquida significativa ocorrerá.");
            }
        }
    }
}