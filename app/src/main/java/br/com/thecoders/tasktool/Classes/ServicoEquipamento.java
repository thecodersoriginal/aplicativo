package br.com.thecoders.tasktool.Classes;

public class ServicoEquipamento {

    private Servico servico;
    private Equipamento equipamento;

    public ServicoEquipamento(Servico servico, Equipamento equipamento) {
        this.servico = servico;
        this.equipamento = equipamento;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}