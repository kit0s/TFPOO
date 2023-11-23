import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;

public class ACMEDelivery {
    private Clientela clientela;
    private CadastroEntregas cadastroEntregas;
    Scanner scannerArquivo;
    Scanner scannerUsuario;

    public ACMEDelivery(){
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("C:\\Users\\mathe\\Desktop\\POO\\ACMEDelivery\\Exercicio1POO\\src\\arquivoentrada.txt"));
            scannerArquivo = new Scanner(streamEntrada);
            PrintStream streamSaida = new PrintStream(new File("C:\\Users\\mathe\\Desktop\\POO\\ACMEDelivery\\Exercicio1POO\\src\\arquivosaida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);
        scannerArquivo.useLocale(Locale.ENGLISH);

        clientela = new Clientela();
        cadastroEntregas = new CadastroEntregas();
    }

    public void executar(){
        scannerUsuario = new Scanner(System.in);
        int escolha;

        System.out.println("Menu:");
        System.out.println("1. Cadastrar clientes");
        System.out.println("2. Cadastrar entregas");
        System.out.println("3. Mostrar quantos clientes foram cadastrados");
        System.out.println("4. Mostrar quantas entregas foram cadastradas");
        System.out.println("5. Mostrar os dados de um determinado cliente");
        System.out.println("6. Mostrar os dados de uma determinada entrega");
        System.out.println("7. Mostrar os dados das entregas de um determinado cliente");
        System.out.println("8. Mostrar os dados da entrega de maior valor");
        System.out.println("9. Mostrar o endereço de uma entrega");
        System.out.println("10. Mostrar a soma dos valores das entregas de um determinado cliente");

        while (true){
            escolha = scannerUsuario.nextInt();
            scannerUsuario.nextLine(); // Consumir a quebra de linha

            switch (escolha){
                case 1:
                    cadastraClientes();
                    break;
                case 2:
                    cadastraEntregas();
                    break;
                case 3:
                    contaClientes();
                    break;
                case 4:
                    contaEntregas();
                    break;
                case 5:
                    dadosDoCliente();
                    break;
                case 6:
                    dadosDaEntrega();
                    break;
                case 7:
                    dadosEntregaCliente();
                    break;
                case 8:
                    entregaMaiorValor();
                    break;
                case 9:
                    enderecoEntrega();
                    break;
                case 10:
                    valorEntregasCliente();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void cadastraClientes() {
        while (true) {
            String email = scannerArquivo.nextLine();

            if (email.equals("-1")) {
                return;
            }

            String nome = scannerArquivo.nextLine();
            String endereco = scannerArquivo.nextLine();

            Cliente cliente = new Cliente(email, nome, endereco);
            if (clientela.adicionaCliente(cliente)) {
                System.out.println(cliente.toString());
            } else {
                return;
            }
        }
    }

    private void cadastraEntregas() {

    }



    private void contaClientes() {
        int qtdeClientes = clientela.getClientela().size();
        System.out.println("Quantidade de clientes cadastrados: " + qtdeClientes);
    }


    private void contaEntregas(){
        int qtdeEntregas = cadastroEntregas.getEntregas().size();
        System.out.println("Quantidade de clientes cadastrados: " + qtdeEntregas);
    }

    private void dadosDoCliente() {
        System.out.print("Digite o email do cliente: ");
        String email = scannerArquivo.nextLine();


        Cliente cliente = clientela.pesquisaCliente(email);

        if (cliente != null) {

            System.out.println("Dados do cliente:");
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco());
        } else {
            // Se o cliente não existe, mostra uma mensagem de erro
            System.out.println("Cliente com email " + email + " não encontrado.");
        }
    }


    private void dadosDaEntrega() {
        System.out.print("Digite o código da entrega: ");
        int codigo = scannerUsuario.nextInt();
        scannerUsuario.nextLine();


        Entrega entrega = cadastroEntregas.pesquisaEntrega(codigo);

        if (entrega != null) {

            System.out.println("Dados da entrega:");
            System.out.println("Código: " + entrega.getCodigo());
            System.out.println("Valor: " + entrega.getValor());
            System.out.println("Descrição: " + entrega.getDescricao());
            System.out.println("Email do Cliente: " + entrega.getCliente().getEmail());
            System.out.println("Nome do Cliente: " + entrega.getCliente().getNome());
            System.out.println("Endereço do Cliente: " + entrega.getCliente().getEndereco());
        } else {
            // Se a entrega não existe, mostra uma mensagem de erro
            System.out.println("Entrega com código " + codigo + " não encontrada.");
        }
    }


    private void dadosEntregaCliente() {
        System.out.print("Digite o email do cliente: ");
        String email = scannerUsuario.nextLine();


        Cliente cliente = clientela.pesquisaCliente(email);

        if (cliente != null) {
            // Se o cliente existe, mostra os dados das entregas do cliente
            System.out.println("Dados das entregas do cliente " + cliente.getNome() + ":");
            for (Entrega entrega : cliente.getEntregas()) {
                System.out.println("Código da Entrega: " + entrega.getCodigo());
                System.out.println("Valor: " + entrega.getValor());
                System.out.println("Descrição: " + entrega.getDescricao());
                System.out.println("-------------------------");
            }
        } else {

            System.out.println("Cliente com email " + email + " não encontrado.");
        }
    }


    private void entregaMaiorValor() {
        double maiorValor = -1.0;
        Entrega entregaMaior = null;


        for (Entrega entrega : cadastroEntregas.getEntregas()) {
            if (entrega.getValor() > maiorValor) {
                maiorValor = entrega.getValor();
                entregaMaior = entrega;
            }
        }

        if (entregaMaior != null) {
            System.out.println("Entrega com o maior valor:");
            System.out.println("Código: " + entregaMaior.getCodigo());
            System.out.println("Valor: " + entregaMaior.getValor());
            System.out.println("Descrição: " + entregaMaior.getDescricao());
            System.out.println("Email do Cliente: " + entregaMaior.getCliente().getEmail());
            System.out.println("Nome do Cliente: " + entregaMaior.getCliente().getNome());
            System.out.println("Endereço do Cliente: " + entregaMaior.getCliente().getEndereco());
        } else {
            System.out.println("Nenhuma entrega cadastrada no sistema.");
        }
    }


    private void enderecoEntrega() {
        System.out.print("Digite o código da entrega: ");
        int codigo = scannerUsuario.nextInt();
        scannerUsuario.nextLine();

        Entrega entrega = cadastroEntregas.pesquisaEntrega(codigo);

        if (entrega != null) {
            System.out.println("Endereço de entrega:");
            System.out.println("Código da Entrega: " + entrega.getCodigo());
            System.out.println("Endereço: " + entrega.getCliente().getEndereco());
        } else {
            System.out.println("Entrega com código " + codigo + " não encontrada.");
        }
    }


    private void valorEntregasCliente() {
        System.out.print("Digite o email do cliente: ");
        String email = scannerUsuario.nextLine();

        Cliente cliente = clientela.pesquisaCliente(email);

        if (cliente != null) {

            double valorTotalEntregas = 0.0;
            for (Entrega entrega : cliente.getEntregas()) {
                valorTotalEntregas += entrega.getValor();
            }

            System.out.println("Valor total das entregas para o cliente " + cliente.getNome() + ": " + valorTotalEntregas);
        } else {
            System.out.println("Cliente com email " + email + " não encontrado.");
        }
    }

}