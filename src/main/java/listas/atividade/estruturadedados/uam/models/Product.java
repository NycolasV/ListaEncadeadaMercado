package listas.atividade.estruturadedados.uam.models;

/**
 * @author NycolasVieira
 */
public class Product {
    
    private static int codeDefault = 1;
        
    public Product(){
    }
    
    public Product(String name, String brand, double price, Sector sector) {
        this.code = this.codeDefault;
        this.codeDefault++;
        
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.sector = sector;
    }
    
    private int code;
    
    private String name;
    
    private String brand;
        
    private double price;
    
    private Sector sector;

    public int getCode() {
        return code;
    }

    public void setCode() {
        this.code = this.codeDefault;
        this.codeDefault++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(empty(name))
            throw new Exception("Campo nome não pode ser vazio");
            
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) throws Exception {
        if(empty(brand))
            throw new Exception("Campo marca não pode ser vazio");
        
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if(price < 0)
            throw new Exception("Campo preço não pode ser negativo");
        
        this.price = price;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) throws Exception {
        if(sector == null)
            throw new Exception("Campo setor não pode ser vazio");
        
        this.sector = sector;
    }

    private boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }
    
    @Override
    public String toString() {
        return "Produto: " + code + ";\n"
                + " nome=" + name + ";\n"
                + " marca=" + brand + ";\n"
                + " preço=" + price + ";\n"
                + " setor=" + sector.getHall()+ ";\n"
                + "------------------------\n";
    }
}
