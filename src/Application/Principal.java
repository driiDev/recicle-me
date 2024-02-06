package Application;

import java.util.Scanner;

import entities.User;
import persistencia.Conexao;
import persistencia.UserDAO;
import persistencia.UserDAOimpl;

public class Principal {
	

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			UserDAO user = new UserDAOimpl(Conexao.conectaBD());
			
			User usu = new User();
			
            System.out.print("Deseja se cadastrar (C) ou fazer login (L)? ");
			
			char t = sc.next().charAt(0);
			
			if(t == 'C') {
					
			System.out.println("Digite seu nome: ");
			usu.setNome(sc.next());
			System.out.println("Digite seu email: ");
			usu.setEmail(sc.next());
			System.out.println("Digite sua senha: ");
			usu.setSenha(sc.next());
				
		    user.save(usu);
		    user.getUser().add(usu);
		    
			}
			
			if(t == 'L') {
				
		    //Realizar login
		    System.out.println("Digite seu email: ");
		    usu.setEmail(sc.next());
		    System.out.println("Digite sua senha: ");
		    usu.setSenha(sc.next());
		    
		    user.login(usu);
			
			}
			
			//Atualizar cadastro
			//User u = new User();
			//u.setNome(sc.next());
			//u.setEmail(sc.next());
			//u.setId(1);//� o n�mero onde est� o banco de dados
			
			//user.update(u);
			
			//Deletar o contato pelo n�mero de ID
			//user.deleteByID(10);
			
			//Visualiza��o dos registros do banco de dados TODOS
		
			for(User u : user.getUser()) {
				System.out.println("Nome: " + u.getNome() +  ", ID: " + u.getId());
			}
			
			//System.out.println("Digite seu bairro:");
			   String bairro = sc.nextLine().toLowerCase();
			
			
			/*
			switch(bairro) {
			case "camboim" : System.out.println("Quarta-Feira / Manh�");break;
			case "cap�o da cruz" : System.out.println("Ter�a-Feira / Tarde");break;
			case "centro" : System.out.println("Diariamente manh� e tarde");break;
			case "centro(bairro)" : System.out.println("Quarta e Sexta-Feira / Tarde");break;
			case "cohab" : System.out.println("Sexta-Feira / Manh�");break;
			case "diehl" : System.out.println("Quinta-Feira / Tarde");break;
			case "getulio vargas" : System.out.println("Quinta-Feira / Manh�");break;
			case "jardim" : System.out.println("Segunda-feira / Tarde");break;
			case "paraiso" : System.out.println("Ter�a-Feira / Tarde");break;
			case "piratini" : System.out.println("Sexta-Feira / Manh�");break;
			case "primor" : System.out.println("Quinta-Feira / Manh�");break;
			case "santa catarina" : System.out.println("Ter�a-Feira / Manh�");break;
			case "silva" : System.out.println("Quinta-Feira / Tarde");break;
			case "vacchi" : System.out.println("Quinta-Feira / Tarde");break;
			case "vargas" : System.out.println("Segunda-feira / Manh�");break;
			case "bela vista" : System.out.println("Segunda-feira / Tarde");break;
			case "boa vista" : System.out.println("Segunda-feira / Tarde");break;
			case "colonial" : System.out.println("Quinta-Feira / Manh�");break;
		    case "fortuna" : System.out.println("Quinta-Feira / Tarde");break;
		    case "freitas" : System.out.println("Quinta-Feira / Manh�");break;
		    case "imperatriz" : System.out.println("Quinta-Feira / Tarde");break;
		    case "jardim america" : System.out.println("Quarta-Feira / Tarde");break;
		    case "jardim europa" : System.out.println("Quarta-Feira / Tarde");break;
		    case "jo�o de barro" : System.out.println("Sexta-Feira / Tarde");break;
		    case "loteamento bela vista" : System.out.println("Sexta-Feira / Manh�");break;
		    case "nova sapucaia" : System.out.println("Segunda-feira / Manh�");break;
		    case "pasqualini" : System.out.println("Quarta-Feira / Manh�");break;
		    case "s�o jorge" : System.out.println("Quinta-Feira / Manh�");break;
		    case "s�o jose" : System.out.println("Ter�a-Feira / Manh�");break;
		    case "walderes" : System.out.println("Ter�a-Feira / Tarde");break;
		    case "tr�s portos" : System.out.println("Ter�a-Feira / Tarde");break;
		    
			default : System.out.println("Bairro n�o encontrado e/ou n�o possui coleta seletiva.");
			}
*/
			sc.close();

}
		}

