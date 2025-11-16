public class compostos {
    
    // Propriedades (campos)
    public String name;
    public boolean ox;
    
    // Getter para 'name'
    public String getName() {
        return name;
    }
    
    // Setter para 'name'
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter para 'ox' (booleano, normalmente 'is' prefixado)
    public boolean isOx() {
        return ox;
    }
    
    // Setter para 'ox'
    public void setOx(boolean ox) {
        this.ox = ox;
    }

    /**
     * Sobrescreve o método toString() para fornecer uma representação legível do objeto.
     * Isto é usado por System.out.println(list) na classe compDB.
     */
    @Override
    public String toString() {
        String estado = ox ? "Oxidada (Agente Oxidante)" : "Reduzida (Agente Redutor)";
        return "\n" + name + " | Estado: " + estado;
    }
}