/*
 * CriaTabelas.java
 * 
 * Copyright © 2014 Rogério Eduardo Pereira <rogeriopereira.info@gmail.com>. 
 * 
 * This file is part of AssistenciaTecnica.
 * 
 * AssistenciaTecnica is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * AssistenciaTecnica is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with AssistenciaTecnica.  If not, see <http ://www.gnu.org/licenses/>.
 */
package assistenciatecnica.control;

import assistenciatecnica.model.Usuario;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 13, 2014
 */
public class CriaTabelas
{
	/*
	 * MÃ©todo criaBanco
	 * Cria o banco de dados
	 */
	public Boolean criaBanco()
	{
		Properties	prop		= new Properties();
		InputStream	input	= null;
		String		user		= new String();
		String		password	= new String();
		String		server	= new String();
		String		port		= new String();
		String		database	= new String();
		
		try
		{
			//Abre arquivo de configuraÃ§Ãµes
			input = new FileInputStream("config/bd.config.properties");
			
			//Obtem as informaÃ§Ãµes do arquivo
			prop.load(input);
			
			//Seta as propriedades
			user		= prop.getProperty("user");
			password	= prop.getProperty("password");
			server	= prop.getProperty("server");
			port		= prop.getProperty("port");
			database	= prop.getProperty("database");
			
			Statement   stmt;
			//Connection  conexao = DriverManager.getConnection("jdbc:mysql://localhost/","root","");
			Connection  conexao = DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/",user,password);
			stmt = conexao.createStatement();
			
			String query = "CREATE DATABASE IF NOT EXISTS "+database+";";
			stmt.executeUpdate(query);
			
			conexao.close();
		}
		catch(Exception exception)
		{
			return false;
		}
		finally
		{
			if (input != null) 
			{
				try 
				{
					input.close();
				} 
				catch (IOException e) 
				{
					return null;
				}
			}
		}
		
		return true;
	}
	
    /*
     * MÃ©todo criaTabelas
     * Cria as tabelas no banco
     */
    public Boolean criaTabelas()
    {
        this.controlBD = new ControladorBancodeDados();
		return(this.controlBD.criaTabelas());
    }
    
	/*
	 * Método insereUsuarioSuporte
	 * Insere um usuario de Suporte
	 * Precisa ser feita a inserção aqui, porque ele nao gera a exceção se ja estiver cadastrado
	 */
	public void insereUsuarioSuporte()
	{
		try
		{
			this.factory = Persistence.createEntityManagerFactory	(	
															"assistenciaTecnica", 
															new ControladorBancodeDados().getConfigBD()
														);
			this.manager    = factory.createEntityManager();

			manager.getTransaction().begin();

			Usuario user = new Usuario();
			user.setNome("SUPORTE");
			user.setUsuario("SUPORTE");
			user.setSenha("SUPORTE");
			user.setNivel(true);

			manager.persist(user);

			manager.getTransaction().commit();

			manager.close();
			factory.close();
		}
		catch (Exception e)
		{

		}
	}
	
	private EntityManagerFactory		factory;
	private EntityManager			manager;
	
	private ControladorBancodeDados controlBD;
}
