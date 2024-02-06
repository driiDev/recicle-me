package Application;
import java.util.ArrayList;
import java.util.Scanner;

import persistencia.Conexao;
import persistencia.UserDAO;
import persistencia.UserDAOimpl;
import entities.User;

public class MainProgram {

	private static Scanner scanner = new Scanner (System.in);
	private static User usu = new User();
	private static UserDAO userDao = new UserDAOimpl(Conexao.conectaBD()); 

	private static int menuPageController = 0;
	private static int userPageController = 0;
	
	public static void main(String[] args) {
		
		/* Menu inicial onde o usuário poderá escolher entre cadastrar
		uma nova conta, fazer login, atualizar seus dados ou sair */
		while (menuPageController != 3) {
            menuInicial();
            menuPageController = scanner.nextInt();
            scanner.nextLine();
            
            switch (menuPageController) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    loginUsuario();
                    break;
                case 3:
                    System.out.println("Obrigado por usar nosso programa !!");
                    break;
                default:
                    System.out.println("Selecione um menu existente ");
            }
		
		}
		scanner.close();
	}
	
	// Primeira tela: menu inicial 
	private static void menuInicial() {
        System.out.println("|-------------------------------------|");
        System.out.println("|       Bem Vindo ao Recicle.me       |");
        System.out.println("|-------------------------------------|");
        System.out.println("|     1 - Cadastrar                   |");
        System.out.println("|     2 - Logar                       |");
        System.out.println("|     3 - Sair                        |");
        System.out.println("|-------------------------------------|");
        System.out.print("|Opção: ");

    }
	
	// Metódo para cadastrar usuário
	private static void cadastrarUsuario() {
        System.out.println("|-------------------------------------|");
        System.out.println("|          Cadastrar Usuário          |");
        System.out.println("|-------------------------------------|");

        System.out.print("|Nome: ");
        usu.setNome(scanner.next());
        System.out.print("|E-mail: ");
        usu.setEmail(scanner.next());
        System.out.print("|Senha: ");
        usu.setSenha(scanner.next());
        
        userDao.save(usu);
    }
    
	// Metodo para fazer login
    private static void loginUsuario() {
    	 System.out.println("|---------------------------------------|");
         System.out.println("|            Logar em Usuário           |");
         System.out.println("|---------------------------------------|");
         
    	boolean login = false;
    	while(! login) {
    	System.out.print("|Digite seu email: ");
    	String email = scanner.next();
    	System.out.print("|Digite sua senha: ");
    	String senha = scanner.next();
    	
    	usu.setEmail(email);
    	usu.setSenha(senha);
    	
    	if (userDao.login(usu)) {
    		 System.out.println("Login realizado com sucesso!" ); 
    		 login = true;
    		 } 
    	else 
    		 System.out.println("Login não realizado!" ); 
    	}
        if (login) {
            /* menu onde o usuário poderá escolher entre pesquisar
            o que pode ser reciclado, pesquisar o dia da coleta
            seletiva no seu bairro, vizualizar os pontos da
            coleta voluntaria ou sair. */
        	while (userPageController != 6) {
                menuDoUsuario();
                userPageController = scanner.nextInt();
                scanner.nextLine();
                switch (userPageController) {
                    case 1:
                        PesquisarLixoReciclavel();
                        break;
                    case 2:
                        PesquisarDiaColetaSeletiva();
                        break;
                    case 3:
                    	ImprimirPontosColetaVoluntaria();
                    	break;
                    case 4:
                        atualizarUsuario();
                        break;
                    case 5:
                    	deletarUsuario();
                    case 6:
                        System.out.println("Volte sempre!!");
                        break;
                    default:
                        System.out.println("Selecione um menu existente: ");
                        break;
                }
            }
        }
        else {
            System.out.println("Email/Senha estão errados!");
        }
        userPageController = 0;
 }
    
    // Segunda tela: menu do usuario
    private static void menuDoUsuario() {
           System.out.println("|---------------------------------------|");
           System.out.println("|     Bem Vindo ao menu do Usuário      |");
           System.out.println("|---------------------------------------|");
           System.out.println("|1 - Pesquisar Recicláveis              |");
           System.out.println("|2 - Dia da coleta seletiva seu bairro  |");
           System.out.println("|3 - Exibir Pontos Coleta Voluntária    |");
           System.out.println("|4 - Atualizar usuário                  |");
           System.out.println("|5 - Deletar usuário                    |");
           System.out.println("|6 - Sair                               |");
           System.out.println("|---------------------------------------|");
       }
 
    // Metódo que atualiza o cadastro do usuário
    private static void atualizarUsuario() {
    	System.out.println("|---------------------------------------|");
        System.out.println("|            Atualizar Usuário          |");
        System.out.println("|---------------------------------------|");
   	
   	 	System.out.print("|Atualizar nome: ");
   	 	usu.setNome(scanner.nextLine());
   	 	System.out.print("|Atualizar email: ");
   	 	usu.setEmail(scanner.nextLine());
   	 	System.out.print("|Atualizar senha: ");
   	 	usu.setSenha(scanner.nextLine());
   	 	usu.setId(22);
   	 	userDao.update(usu);
   } 
    
    // Metódo que deleta um usuário do banco de dados
    private static void deletarUsuario() {
	  System.out.println("|---------------------------------------|");
      System.out.println("|            Deletar Usuário            |");
      System.out.println("|---------------------------------------|");

      System.out.print("Digite o seu email: ");
      userDao.deleteByEmail(scanner.next());
   }   
    
    	/* Metódo em que o usuário coloca um item e retorna se
    	é reciclável ou não. */
    public static void PesquisarLixoReciclavel() {
    	System.out.println("Digite o que você deseja reciclar: ");
    	  String categoria = scanner.next();
    	   
    	   switch (categoria) {
    	   case "papel" :
    		   System.out.println("Pode ser reciclado.");
    		   break;
    	   case "vidro" :
    		   System.out.println("Pode ser reciclado.");
    		   break;
    	   case "plastico" :
    		   System.out.println("Pode ser reciclado.");
    		   break; 
    	   case "metal" :
    		   System.out.println("Pode ser reciclado.");
    		   break;
    	   default : 
    		   System.out.println("NÃ£o pode ser reciclado ou nÃ£o foi possÃ­vel reconhecer esta categoria.");
    	   }
   		
   	}
    
       /* Método em que o usuário digita seu bairro e retorna
          o dia e turno da coleta seletiva no seu bairro */
    public static void PesquisarDiaColetaSeletiva() {
    	   System.out.println("Digite seu bairro:");
			String bairro = scanner.nextLine().toLowerCase();	
			
			switch(bairro) {
			case "camboim" : 
				System.out.println("Quarta-Feira / Manhã");
				break;
			case "capão da cruz" :
				System.out.println("Terça-Feira / Tarde");
				break;
			case "centro" : 
				System.out.println("Diariamente manhã e tarde");
				break;
			case "centro(bairro)" :
				System.out.println("Quarta e Sexta-Feira / Tarde");
				break;
			case "cohab" :
				System.out.println("Sexta-Feira / Manhã");
				break;
			case "diehl" : 
				System.out.println("Quinta-Feira / Tarde");
				break;
			case "getulio vargas" : 
				System.out.println("Quinta-Feira / Manhã");
				break;
			case "jardim" : 
				System.out.println("Segunda-feira / Tarde");
				break;
			case "paraiso" : 
				System.out.println("Terça-Feira / Tarde");
				break;
			case "piratini" : 
				System.out.println("Sexta-Feira / Manhã");
				break;
			case "primor" : 
				System.out.println("Quinta-Feira / Manhã");
				break;
			case "santa catarina" : 
				System.out.println("Terça-Feira / Manhã");
				break;
			case "silva" : 
				System.out.println("Quinta-Feira / Tarde");
				break;
			case "vacchi" : 
				System.out.println("Quinta-Feira / Tarde");
				break;
			case "vargas" : 
				System.out.println("Segunda-feira / Manhã");
				break;
			case "bela vista" :
				System.out.println("Segunda-feira / Tarde");
				break;
			case "boa vista" : 
				System.out.println("Segunda-feira / Tarde");
				break;
			case "colonial" : 
				System.out.println("Quinta-Feira / Manhã");
				break;
		    case "fortuna" : 
		    	System.out.println("Quinta-Feira / Tarde");
		    	break;
		    case "freitas" :
		    	System.out.println("Quinta-Feira / Manhã");
		    	break;
		    case "imperatriz" : 
		    	System.out.println("Quinta-Feira / Tarde");
		    	break;
		    case "jardim america" : 
		    	System.out.println("Quarta-Feira / Tarde");
		    	break;
		    case "jardim europa" : 
		    	System.out.println("Quarta-Feira / Tarde");
		    	break;
		    case "joão de barro" :
		    	System.out.println("Sexta-Feira / Tarde");
		    	break;
		    case "loteamento bela vista" : 
		    	System.out.println("Sexta-Feira / Manhã");
		    	break;
		    case "nova sapucaia" : 
		    	System.out.println("Segunda-feira / Manhã");
		    	break;
		    case "pasqualini" :
		    	System.out.println("Quarta-Feira / Manhã");
		    	break;
		    case "são jorge" :
		    	System.out.println("Quinta-Feira / Manhã");
		    	break;
		    case "são jose" :
		    	System.out.println("Terça-Feira / Manhã");
		    	break;
		    case "walderes" : 
		    	System.out.println("Terça-Feira / Tarde");
		    	break;
		    case "três portos" : 
		    	System.out.println("Terça-Feira / Tarde");
		    	break;
		    
			default : System.out.println("Bairro não encontrado ou não possui coleta seletiva.");
			}

	}
       
    /* Metódo que exibe para o usuário uma lista com 
    todos os pontos de coleta voluntária da cidade. */
    public static void ImprimirPontosColetaVoluntaria() {
    	ArrayList<String> ListaPontosColeta = new ArrayList<>();
   		
   		ListaPontosColeta.add("E.M.E.F Afonso Guerreiro Lima");
   		ListaPontosColeta.add("E.M.E.B Alberto Santos Dumont");
   		ListaPontosColeta.add("E.M.E.F Alfred Adolfo Cassel");
   		ListaPontosColeta.add("E.M.E.F Alfredo Juliano");
   		ListaPontosColeta.add("E.M.E.F Dr. Júlio Casado");
   		ListaPontosColeta.add("E.M.E.F Francisco Greiss");
   		ListaPontosColeta.add("E.M.E.F Vanessa Ceconet");
   		ListaPontosColeta.add("E.M.E.B João de Barro");
   		ListaPontosColeta.add("E.M.E.F José Plácido de Castro");
   		ListaPontosColeta.add("E.M.E.F Justino Camboim");
   		ListaPontosColeta.add("E.M.E.F Lourdes F. da Silva");
   		ListaPontosColeta.add("E.M.E.F Marechal Bittencourt");
   		ListaPontosColeta.add("E.M.E.F Otaviano Silveira");
   		ListaPontosColeta.add("E.M.E.F Padre Réus");
   		ListaPontosColeta.add("E.M.E.F Prefeito João Freitas Filho ");
   		ListaPontosColeta.add("E.M.E.F Prefeito Walmir Martins");
   		ListaPontosColeta.add("E.M.E.F Primo Vacchi");
   		ListaPontosColeta.add("E.M.E.F Professora Aurialícia Chaxim Bes");
   		ListaPontosColeta.add("E.M.E.F Professora Maria da Glória da Silva");
   		ListaPontosColeta.add("E.M.E.F Professora Rosane Amaral Dias");
   		ListaPontosColeta.add("E.M.E.F Tiradentes");
   		ListaPontosColeta.add("E.M.E.I Hugo Gerdau");
   		ListaPontosColeta.add("E.M.E.I Romana Gonçalves");
   		ListaPontosColeta.add("E.M.E.I Dalila da Silveira Oliveira");
   		ListaPontosColeta.add("E.M.E.I Mara Mattos");
   		ListaPontosColeta.add("E.E.E.F Antonia Ramires");
   		ListaPontosColeta.add("E.E.E.F Alcides Maya");
   		ListaPontosColeta.add("E.E.E.F Padre Darcy Fernandes");
   		ListaPontosColeta.add("E.E.E.F Sapucaia do Sul");
   		ListaPontosColeta.add("E.E.E.F Santa Rita de Cássia");
   		ListaPontosColeta.add("E.E.E.F Anita Garibaldi");
   		ListaPontosColeta.add("E.E.E.F Gládis Rita");
   		ListaPontosColeta.add("E.E.E.F Érico Veríssimo");
   		ListaPontosColeta.add("E.E.E.F Miguel Gustavo");
   		ListaPontosColeta.add("E.E.E.F Vila Prado");
   		ListaPontosColeta.add("E.E.E.F Marcus Vinícios de Moraes");
   		ListaPontosColeta.add("E.E.E.F Bela Vista");
   		ListaPontosColeta.add("E.E.E.F Olaria Daudt");
   		ListaPontosColeta.add("Instituto de Educação Ruben Dario");
   		ListaPontosColeta.add("Unidade de Ensino São Lucas");
   		ListaPontosColeta.add("Escola Fátima");
   		ListaPontosColeta.add("Escola Fundamental La Salle");

   		for (String x : ListaPontosColeta) {
   			System.out.println(x);
   		}
   }
}
