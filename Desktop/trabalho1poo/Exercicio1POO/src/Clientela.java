import java.util.ArrayList;

public class Clientela {
    private ArrayList<Cliente> clientela;

    public Clientela(){
     clientela = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientela(){
        return clientela;
    }

    public Cliente pesquisaCliente(String email){
        for (Cliente c : clientela) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    public boolean adicionaCliente(Cliente novoCliente) {
        String email = novoCliente.getEmail();
        if (pesquisaCliente(novoCliente.getEmail()) == null) {
            clientela.add(novoCliente);
            return true;
        }
        return false;
    }
}
