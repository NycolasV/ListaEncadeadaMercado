package listas.atividade.estruturadedados.uam.models;

/**
 * @author NycolasVieira
 */
public class Sector {

    private static int idDefault = 1;

    public Sector() {
    }

    public Sector(int floor, String hall, String type) {
        this.id = this.idDefault;
        this.idDefault++;

        this.floor = floor;
        this.hall = hall;
        this.type = type;
    }

    private int id;

    private int floor;

    private String hall;

    private String type;

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = this.idDefault;
        this.idDefault++;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) throws Exception {
        if (empty(hall)) {
            throw new Exception("Campo corredor não pode ser nulo!");
        }

        this.hall = hall;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws Exception {
        if (empty(type)) {
            throw new Exception("Campo tipo não pode ser nulo!");
        }

        this.type = type;
    }

    private boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }

    @Override
    public String toString() {
        return "Setor: " + id + ";\n"
                + " andar = " + floor + ";\n"
                + " corredor = " + hall + ";\n"
                + " tipo = " + type + ";\n"
                + "----------------------\n";
    }
}
