package Application;

import java.util.Scanner;

import entities.Contato;
import persistencia.ContatoDAO;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Maria");
		contato.setIdade(52);
		
		//contatoDao.save(contato);
		
		//Atualizar contato
		//Contato c1 = new Contato();
		//c1.setNome(sc.next());
		//c1.setIdade(sc.nextInt());
		//c1.setId(1);//É o número onde está o banco de dados
		
		//contatoDao.update(c1);
		
		//Deletar o contato pelo número de ID
		//contatoDao.deleteByID(10);
		
		//Visualização dos registros do banco de dados TODOS
		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Contato: " + c.getNome() + ", Idade: " + c.getIdade() + ", ID: " + c.getId());
		}

		sc.close();
	}

}
