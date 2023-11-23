import java.util.ArrayList;

public class Cliente {
    private String email;
    private String nome;
    private String endereco;
    private ArrayList<Entrega> entregas;

    public Cliente(String email, String nome, String endereco){
        entregas = new ArrayList<>();
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public ArrayList<Entrega> getEntregas() {
        return entregas;
    }

    public void pesquisaEntregas(){
        System.out.println("Entregas do cliente " + nome + ":");
        for (Entrega entrega : entregas) {
            System.out.println("Código: " + entrega.getCodigo());
            System.out.println("Descrição: " + entrega.getDescricao());
            System.out.println("Valor: " + entrega.getValor());
            System.out.println("-------------------------");
        }
    }

    public Entrega consultaEntregas(int codigo){
        for (Entrega e : entregas) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        return null;
    }

    public boolean adicionaEntrega(Entrega entrega) {
        int codigo = entrega.getCodigo();
        if (consultaEntregas(codigo) == null) {
            entregas.add(entrega);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "1;" + getEmail() + ";" + getNome() + ";" + getEndereco();
    }
}

