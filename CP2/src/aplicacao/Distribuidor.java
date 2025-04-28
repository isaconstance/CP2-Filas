package aplicacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import entidades.Encomenda;



public class Distribuidor {
	public static Scanner le = new Scanner(System.in);

	public static void main(String[] args) {

		// Declara e inicia a filaEncomendas da classe FilaEncomenda
		//com a fila de encomendas armazenadas no arquivo ListaEncomendas.txt
		//usa a funcao ja implemetada a seguir para ler o arquivo e enfileirar as encomendas
		geraFilaEncomendas(filaEncomendas);

		int opcao;
		do {
			System.out.println("0 - Encerrar atendimento");
			System.out.println("1 - Inserir encomenda na fila para aguarda atendimento");
			System.out.println("2 - Atender uma encomenda");
			System.out.println("Opcao: ");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				break;
			case 1:
				/*
				 * Le do teclado um encomenda: apenas ID do cliente e nome do arquivo com lista de produtos encomendados.
				 * A encomenda lida deve ser enfileirada na filaEncomendas.
				 */
				break;
			case 2:
				/*
				 * Retira da filaEncomendas uma encomenda.
				 * Atendimento e´ iniciado lendo o arquivo txt que contem a lista de produtos da encomenda.
				 * Cada produto lido do teclado deve ser armazenado na filaProdutos para que o robo possa busca-los na 
				 * ordem.
				 * Caso o produto nao esteja disponivel na prateleira o produto volta para o final da filaProdutos.
				 * 
				 */
				break;
			default:
				System.out.println("Opcao Invalida");
			}

		} while (opcao != 0);

		le.close();

	}

	public static void geraFilaEncomendas(FilaEncomendas fila) {

		String caminhoDoArquivo = "d:/eclipse-workspace/CP2/src/arquivos/ListaEncomendas.txt";
		
		try {
			// Criar um objeto File com o caminho do arquivo
			File arquivo = new File(caminhoDoArquivo);

			// Criar um Scanner para ler o arquivo
			Scanner leArq = new Scanner(arquivo);

			// Loop para ler linha por linha até o final do arquivo
			while (leArq.hasNextLine()) {

				// Ler a próxima linha
				String linha = leArq.nextLine();
				String[] partes = linha.split(",");
				Encomenda obj = new Encomenda();
				obj.clienteID = partes[0];
				obj.nomeArquivo = partes[1];
				System.out.println(obj);
				System.out.println();
				fila.enqueue(obj);
			}
			// Fechar o objeto da classe Scanner le
			leArq.close();
		} catch (FileNotFoundException e) {
			// Caso o arquivo não seja encontrado
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		}
	}

	public static void geraFilaProdutos(FilaProdutos filaProd, String nomeArquivo) {

		/*Implementar esse metodo*/
	}
}
