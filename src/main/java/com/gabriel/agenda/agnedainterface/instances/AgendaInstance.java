package com.gabriel.agenda.agnedainterface.instances;

public class AgendaInstance {
    private static AgendaInstance instance;
    private String dbSelect;
    private AgendaInstance(){}
    public static AgendaInstance getInstance() {
        if (instance == null) {
            instance = new AgendaInstance();
        }
        return instance;
    }
    public String getDbSelect() {
        System.out.println("Obteniendo " + dbSelect);
        return dbSelect;
    }
    public void setDbSelect(String dbSelect) {
        System.out.println("Insertadndo " + dbSelect);
        this.dbSelect = dbSelect;
    }


}
