package listas.atividade.estruturadedados.uam.controllers;

import java.util.ArrayList;
import listas.atividade.estruturadedados.uam.linkedlist.*;
import listas.atividade.estruturadedados.uam.models.*;

/**
 * @author NycolasVieira
 */
public class SectorController {
    private static LinkedList<Sector> sectorList;

    public SectorController() {
        this.sectorList = new LinkedList<>();
    }
    
    public String showSectorList(){
        return sectorList.showList();
    }
    
    public ArrayList<Sector> getSectorList(){
        return sectorList.getAllValues();
    }

    public Sector getSector(Sector sector){
        return sectorList.getValue(sector);
    }
    
    public Sector getSector(int id){
        return getSectorList()
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst().get();
    }
    
    public Sector createSector(Sector sector){
        if(sector != null){
            sector.setId();
            var result = sectorList.insertStart(sector);
            return (Sector)result.value;
        }
        
        return null;
    }
    
    public void updateSector(String floor, String hall, String type, Sector sector) throws Exception{
        sector.setFloor(Integer.parseInt(floor));
        sector.setHall(hall);
        sector.setType(type);
    }
    
    public void deleteSector(int id){
        var sector = getSector(id);
        
        sectorList.removeNode(sector);
    }
    
    public void deleteLastSector(){
        sectorList.removeStart();
    }
}
