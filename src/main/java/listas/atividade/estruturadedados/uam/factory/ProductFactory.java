package listas.atividade.estruturadedados.uam.factory;

import javax.swing.JOptionPane;
import listas.atividade.estruturadedados.uam.controllers.*;
import listas.atividade.estruturadedados.uam.models.*;

/**
 *
 * @author NycolasVieira
 */
public class ProductFactory {

    private final ProductController productController;
    private final SectorController sectorController;

    public ProductFactory() {
        this.productController = new ProductController();
        this.sectorController = new SectorController();
    }

    public void createProduct() throws Exception {
        Product product = new Product();

        var sectorId = inputIntDialog("Informe o id do setor:", "Cadastro de produto");
        var sector = sectorController.getSector(sectorId);
        product.setSector(sector);
        
        product.setName(JOptionPane.showInputDialog(null, "Informe o nome:", "Cadastro de produto", JOptionPane.QUESTION_MESSAGE));
        product.setBrand(JOptionPane.showInputDialog(null, "Insira a marca:", "Cadastro de produto", JOptionPane.QUESTION_MESSAGE));

        var price = inputDoubleDialog("Informe o preço:", "Cadastro de produto");
        product.setPrice(price);

        productController.createProduct(product);
        JOptionPane.showMessageDialog(null, product.toString(), "Cadastro realizado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateProduct() throws Exception {
        var productId = inputIntDialog("Informe o código do produto:", "Atualizar produto");
        var product = productController.getProduct(productId);

        String name = (String) JOptionPane.showInputDialog(null, "Insira o nome:", "Nome do produto", JOptionPane.INFORMATION_MESSAGE, null, null, product.getName());
        String brand = (String) JOptionPane.showInputDialog(null, "Insira a marca:", "Marca do produto", JOptionPane.INFORMATION_MESSAGE, null, null, product.getBrand());
        String priceStr = (String) JOptionPane.showInputDialog(null, "Insira o preço:", "Preço do produto", JOptionPane.INFORMATION_MESSAGE, null, null, product.getPrice());
        String sectorStr = (String) JOptionPane.showInputDialog(null, "Insira o id do setor:", "Setor do produto", JOptionPane.INFORMATION_MESSAGE, null, null, product.getSector().getId());

        double price;
        if (!priceStr.matches("^[0-9-.]*$")) {
            price = inputDoubleDialog("Informe o preço corretamente: ", "ERRO");
        } else {
            price = Double.parseDouble(priceStr);
        }
        
        int sectorId;
        if (!sectorStr.matches("^[0-9]*$")) {
            sectorId = inputIntDialog("Informe o id do setor corretamente: ", "ERRO");
        } else {
            sectorId = Integer.parseInt(sectorStr);
        }

        var sector = sectorController.getSector(sectorId);
        productController.updateProduct(name, brand, price, sector, product);

        JOptionPane.showMessageDialog(null, sector.toString(), "Produto atualizado!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void printListProducts() {
        JOptionPane.showMessageDialog(null, productController.showProductList(), "Listar produtos", JOptionPane.INFORMATION_MESSAGE);
    }

    public void searchProduct() {
        var productId = inputIntDialog("Informe o código do produto:", "Pesquisa de produto");

        var product = productController.getProduct(productId);

        JOptionPane.showMessageDialog(null, product.toString(), "Pesquisa de produto", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deleteProduct() {
        var productId = inputIntDialog("Informe o código do produto a ser apagado:", "Apagar produto");

        productController.deleteProduct(productId);

        JOptionPane.showMessageDialog(null, "Produto apagado com sucesso!", "Apagar produto", JOptionPane.INFORMATION_MESSAGE);
    }

    public int inputIntDialog(String message, String title) {
        var value = "";
        var input = "";
        do {
            input = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
            if (input.matches("^[0-9]*$")) {
                value = input;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, insira apenas números", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } while (!input.matches("^[0-9]*$"));

        return Integer.parseInt(value);
    }

    public double inputDoubleDialog(String message, String title) {
        var value = "";
        var input = "";
        do {
            input = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
            if (input.matches("^[0-9-.]*$")) {
                value = input;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, insira apenas números", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } while (!input.matches("^[0-9-.]*$"));

        return Double.parseDouble(value);
    }
}
