public class Main {

    public static void main(String[] args) {
        // Inicializa o banco de dados de compostos (Zn e Cu)
        compDB.setComp(new compostos());
    
        
        // Inicia a interação
        compDB.operate();
        
        // Fecha o Scanner
        compDB.LER.close(); 
    }
    
    
}