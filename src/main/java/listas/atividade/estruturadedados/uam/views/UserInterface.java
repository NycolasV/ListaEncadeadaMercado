package listas.atividade.estruturadedados.uam.views;

import javax.swing.JOptionPane;
import listas.atividade.estruturadedados.uam.factory.*;

/**
 * @author NycolasVieira
 */
public class UserInterface {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        ProductFactory productFactory = new ProductFactory();
        SectorFactory sectorFactory = new SectorFactory();

        int endProgram = 1;

        do {
            String choiceMenu = (String) JOptionPane.showInputDialog(
                    null, "Escolha uma opção:", "MENU DO SISTEMA",
                    JOptionPane.QUESTION_MESSAGE, null, menuOptions(), menuOptions()[0]);

            try {
                switch (choiceMenu) {
                    case "Cadastrar setor":
                        sectorFactory.createSector();
                        break;

                    case "Atualizar setor":
                        sectorFactory.updateSector();
                        break;

                    case "Listar setores":
                        sectorFactory.printListSectors();
                        break;

                    case "Pesquisar setor":
                        sectorFactory.searchSector();
                        break;

                    case "Excluir setor":
                        sectorFactory.deleteSector();
                        break;

                    case "Cadastrar produto":
                        productFactory.createProduct();
                        break;

                    case "Atualizar produto":
                        productFactory.updateProduct();
                        break;

                    case "Listar produtos":
                        productFactory.printListProducts();
                        break;

                    case "Pesquisar produto":
                        productFactory.searchProduct();
                        break;

                    case "Excluir produto":
                        productFactory.deleteProduct();
                        break;

                    case "Sair":
                        endProgram = JOptionPane.showConfirmDialog(null, "Deseja encerrar o programa?");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Valor inserido está incorreto, tente novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Valor não encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } while (endProgram != JOptionPane.YES_OPTION);
    }

    public static String[] menuOptions() {
        return new String[]{
            "Cadastrar setor",
            "Atualizar setor",
            "Listar setores",
            "Pesquisar setor",
            "Excluir setor",
            "Cadastrar produto",
            "Atualizar produto",
            "Listar produtos",
            "Pesquisar produto",
            "Excluir produto",
            "Sair"};
    }
}
