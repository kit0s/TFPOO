public class Entrega {
    private int codigo;
    private Double valor;
    private String descricao;
    private Cliente cliente;

    public Entrega(int codigo, double valor, String descricao, Cliente cliente){
        this.codigo = codigo;
        this.valor = valor;
        this.descricao = descricao;
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public Double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "2:" + getCodigo() + ";" + getValor() + ";" + getDescricao() + ";" + cliente.getEmail();
    }
}
