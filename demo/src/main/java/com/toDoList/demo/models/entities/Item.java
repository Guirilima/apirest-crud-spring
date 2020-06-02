package com.toDoList.demo.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity //Essa classe será uma Entidade no meu BD
public class Item {

    @Id //Obrigatorio
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerador de ID's
    private int id;
    private String materia;
    private String tarefa;
    private String dtEntrega;
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(String  dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
