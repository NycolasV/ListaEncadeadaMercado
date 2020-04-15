package listas.atividade.estruturadedados.uam.factory;

import javax.swing.JOptionPane;
import listas.atividade.estruturadedados.uam.controllers.*;
import listas.atividade.estruturadedados.uam.models.Sector;

/**
 * @author NycolasVieira
 */
public class SectorFactory {

    private final SectorController controller;

    public SectorFactory() {
        this.controller = new SectorController();
    }

    public void createSector() throws Exception {
        Sector sector = new Sector();

        var floor = inputIntDialog("Informe o nº do andar:", "Cadastro de setor");
        sector.setFloor(floor);

        sector.setHall(JOptionPane.showInputDialog(null, "Informe o corredor:", "Cadastro de setor", JOptionPane.QUESTION_MESSAGE));
        sector.setType(JOptionPane.showInputDialog(null, "Insira um tipo de estoque:", "Cadastro de setor", JOptionPane.QUESTION_MESSAGE));
        
        controller.createSector(sector);
        JOptionPane.showMessageDialog(null, sector.toString(), "Cadastro realizado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void updateSector() throws Exception {
        var sectorId = inputIntDialog("Informe o id do setor:", "Atualizar setor");
        var sector = controller.getSector(sectorId);

        String floor = (String)JOptionPane.showInputDialog(null, "Insira o nº de um andar:", "Andar do setor", JOptionPane.INFORMATION_MESSAGE, null, null, sector.getFloor());
        String hall = (String)JOptionPane.showInputDialog(null, "Insira um corredor:", "Corredor do setor", JOptionPane.INFORMATION_MESSAGE, null, null, sector.getHall());
        String type = (String)JOptionPane.showInputDialog(null, "Insira um tipo de estoque:", "Tipo de setor", JOptionPane.INFORMATION_MESSAGE, null, null, sector.getType());
        
        controller.updateSector(floor, hall, type, sector);
        
        JOptionPane.showMessageDialog(null, sector.toString(), "Setor atualizado!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void printListSectors() {
        JOptionPane.showMessageDialog(null, controller.showSectorList(), "Listar setores", JOptionPane.INFORMATION_MESSAGE);
    }

    public void searchSector() {
        var sectorId = inputIntDialog("Informe o id do setor:", "Pesquisa de setor");

        var sector = controller.getSector(sectorId);

        JOptionPane.showMessageDialog(null, sector.toString(), "Pesquisa de setor", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deleteSector() {
        var sectorId = inputIntDialog("Informe o id do setor que deseja apagar:", "Apagar setor");

        controller.deleteSector(sectorId);

        JOptionPane.showMessageDialog(null, "Setor apagado com sucesso!", "Apagar setor", JOptionPane.INFORMATION_MESSAGE);
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
}
