package Dados.Atendimento;

public enum Status {
    PENDENTE("Pendente"),
    EXECUTANDO("Executando"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
