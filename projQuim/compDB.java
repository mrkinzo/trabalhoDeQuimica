import java.util.ArrayList;
import java.util.Scanner;

public class compDB {
    final static Scanner LER = new Scanner(System.in);
    static ArrayList<compostos> list = new ArrayList<>();

    public static void setComp(compostos comp) {

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

}