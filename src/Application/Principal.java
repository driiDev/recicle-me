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
			//u.setId(1);//É o número onde está o banco de dados
			
			//user.update(u);
			
			//Deletar o contato pelo número de ID
			//user.deleteByID(10);
			
			//Visualização dos registros do banco de dados TODOS
		
			for(User u : user.getUser()) {
				System.out.println("Nome: " + u.getNome() +  ", ID: " + u.getId());
			}
			
			//System.out.println("Digite seu bairro:");
			   String bairro = sc.nextLine().toLowerCase();
			
			
			/*
			switch(bairro) {
			case "camboim" : System.out.println("Quarta-Feira / Manhã");break;
			case "capão da cruz" : System.out.println("Terça-Feira / Tarde");break;
			case "centro" : System.out.println("Diariamente manhã e tarde");break;
			case "centro(bairro)" : System.out.println("Quarta e Sexta-Feira / Tarde");break;
			case "cohab" : System.out.println("Sexta-Feira / Manhã");break;
			case "diehl" : System.out.println("Quinta-Feira / Tarde");break;
			case "getulio vargas" : System.out.println("Quinta-Feira / Manhã");break;
			case "jardim" : System.out.println("Segunda-feira / Tarde");break;
			case "paraiso" : System.out.println("Terça-Feira / Tarde");break;
			case "piratini" : System.out.println("Sexta-Feira / Manhã");break;
			case "primor" : System.out.println("Quinta-Feira / Manhã");break;
			case "santa catarina" : System.out.println("Terça-Feira / Manhã");break;
			case "silva" : System.out.println("Quinta-Feira / Tarde");break;
			case "vacchi" : System.out.println("Quinta-Feira / Tarde");break;
			case "vargas" : System.out.println("Segunda-feira / Manhã");break;
			case "bela vista" : System.out.println("Segunda-feira / Tarde");break;
			case "boa vista" : System.out.println("Segunda-feira / Tarde");break;
			case "colonial" : System.out.println("Quinta-Feira / Manhã");break;
		    case "fortuna" : System.out.println("Quinta-Feira / Tarde");break;
		    case "freitas" : System.out.println("Quinta-Feira / Manhã");break;
		    case "imperatriz" : System.out.println("Quinta-Feira / Tarde");break;
		    case "jardim america" : System.out.println("Quarta-Feira / Tarde");break;
		    case "jardim europa" : System.out.println("Quarta-Feira / Tarde");break;
		    case "joão de barro" : System.out.println("Sexta-Feira / Tarde");break;
		    case "loteamento bela vista" : System.out.println("Sexta-Feira / Manhã");break;
		    case "nova sapucaia" : System.out.println("Segunda-feira / Manhã");break;
		    case "pasqualini" : System.out.println("Quarta-Feira / Manhã");break;
		    case "são jorge" : System.out.println("Quinta-Feira / Manhã");break;
		    case "são jose" : System.out.println("Terça-Feira / Manhã");break;
		    case "walderes" : System.out.println("Terça-Feira / Tarde");break;
		    case "três portos" : System.out.println("Terça-Feira / Tarde");break;
		    
			default : System.out.println("Bairro não encontrado e/ou não possui coleta seletiva.");
			}
*/
			sc.close();

}
		}

