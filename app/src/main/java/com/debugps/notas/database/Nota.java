package com.debugps.notas.database;

public class Nota {
    private String id;
    private String catedratico;
    private String materia;
    private String nota;

    public Nota() {
    }

    public Nota(String id, String catedratico, String materia, String nota) {
        this.id = id;
        this.catedratico = catedratico;
        this.materia = materia;
        this.nota = nota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(String catedratico) {
        this.catedratico = catedratico;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
