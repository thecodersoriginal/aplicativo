package br.com.thecoders.tasktool.Classes;

public class ServicoEquipamento
{

    private int id;
    private int nomeEquipamento;

    public ServicoEquipamento(int id, int nomeEquipamento) {
        this.id = id;
        this.nomeEquipamento = nomeEquipamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(int nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }
}
