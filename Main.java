
import java.util.*;

import src.Produto;
import src.ProdutoDAO;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println( 
        "1 - Inserir | 2 - Listar | 3 - Atualizar | 4 - Deletar"
        );
        int opcao = sc.nextInt();

        switch (opcao){
            case 1:
                System.out.println("Nome: ");
                String nome = sc.nextLine();
                nome = sc.nextLine();
                System.out.println("Preço: ");
                double preco = sc.nextDouble();
                Produto p = new Produto(nome, preco);
                dao.inserir(p);
                break;

            case 2:
                for (Produto prod : dao.listar()) {
                    System.out.println(
                        prod.getId() + " - " + 
                        prod.getNome() + " -  R$" +
                        prod.getPreco());
                }
                break;
            
            case 3:
                System.out.println("ID do produto: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Novo nome: ");
                nome = sc.nextLine();
                System.out.println("Novo preço: ");
                preco = sc.nextDouble();
                p = new Produto(nome, preco);
                p.setId(id);
                dao.atualizar(p);
                break;
            case 4:
                System.out.println("ID do produto a deletar: ");
                id = sc.nextInt();
                dao.deletar(id);
                break;  
            default:
                System.out.println("Opção inválida");
        }
        sc.close();
    }
}
