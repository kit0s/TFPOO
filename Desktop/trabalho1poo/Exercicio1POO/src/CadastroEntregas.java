import java.util.ArrayList;
import java.util.Collection;

public class CadastroEntregas {
    private ArrayList<Entrega> entregas;

    public CadastroEntregas() {
        entregas = new ArrayList<>();
    }

    public ArrayList<Entrega> getEntregas(){
        return entregas;
    }

    public Entrega pesquisaEntrega(int codigo) {
        for (Entrega e : entregas) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        return null;
    }

    public boolean cadastraEntrega(Entrega novaEntrega){
        if (pesquisaEntrega(novaEntrega.getCodigo()) == null){
            entregas.add(novaEntrega);
            return true;
        }
        return false;
    }

    public Collection<Entrega> pesquisaEntrega(String email) {
        ArrayList<Entrega> entregasDoCliente = new ArrayList<>();
        for (Entrega e : entregas) {
            if (e.getCliente() != null && e.getCliente().getEmail().equals(email)) {
                entregasDoCliente.add(e);
            }
        }
        if(entregasDoCliente.isEmpty()){
            return null;
        }else{
            return entregasDoCliente;
        }
    }
}
