package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Contato;

public class ContatoDAO {
	
	/*
	 * CRUD
	 * c : CREATE - OK
	 * r : READ
	 * u : UPDATE - OK
	 * d : DELETE - OK
	 */

	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade) VALUES (?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexao com banco de dados
			conn = Conexao.conectaBD();
			
			//Para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Add os valoresque são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			
			//Executar a query
			pstm.execute();
			
			System.out.println("Contato salvo com sucesso");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Fechar as conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
			
	}

	public void update(Contato contato) {

	
		String sql = "UPDATE contatos SET nome = ?, idade = ? " +
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexao com o banco
			conn = Conexao.conectaBD();
			
			//Criar classe para executar query
			pstm = conn.prepareStatement(sql);
			
			//Add os valores para atualizar
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			
			//Qual o ID do registro que deseja atualizar
			pstm.setInt(3, contato.getId());
			
			//Executar a query
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteByID(int id) {

		String sql = "DELETE FROM contatos WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.conectaBD();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		
	}	
	public List<Contato> getContatos() {

		String sql = "SELECT * FROM contatos ";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que vai recuperar os dados do banco ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = Conexao.conectaBD();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			
			
			while(rset.next()) {
				Contato contato = new Contato();
				
				//Recuperar o id
				contato.setId(rset.getInt("id"));
				//Recuperar o nome
				contato.setNome(rset.getString("nome"));
				//Recuperar idade
				contato.setIdade(rset.getInt("idade"));
				
				contatos.add(contato);
			}	
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
				if(rset!=null) {
					rset.close();
				}
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			  }catch(Exception e) {
				  e.printStackTrace();
			  }
			}
		
			return contatos;
		}
	}
