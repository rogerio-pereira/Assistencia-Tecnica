/*
 * ControladorBancodeDados.java
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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 13, 2014
 */
public class ControladorBancodeDados 
{
	/*
	 * MÃ©todo criaTabelas
	 * Cria as tabelas do banco
	 */
	public Boolean criaTabelas()
	{
		try
		{
			this.factory    = Persistence.createEntityManagerFactory("assistenciaTecnica", this.getConfigBD()); 
			factory.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	/*
	 * MÃ©todo cadastrar
	 * Cadastra o objeto no banco de dados
	 */
	public Boolean cadastrar(Object o, JFrame janela)
	{
		try
		{
			this.factory    = Persistence.createEntityManagerFactory("assistenciaTecnica", this.getConfigBD());
			this.manager    = factory.createEntityManager();

			this.manager.getTransaction().begin();

			this.manager.persist(o);

			this.manager.getTransaction().commit();

			this.manager.close();
			this.factory.close();

			JOptionPane.showMessageDialog(janela, "Sucesso ao Cadastrar", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/accept-grande.png"));

			return true;
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(janela, "Erro ao cadastrar", "Erro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/error-circle.png"));
			return false;
		}
	}
	
	/*
	 * MÃ©todo atualiza
	 * Atualiza o objeto no banco de dados
	 */
	public Boolean atualizar(Object o, JFrame janela)
	{
		try
		{
			this.factory    = Persistence.createEntityManagerFactory("assistenciaTecnica", this.getConfigBD());
			this.manager     = factory.createEntityManager();

			this.manager.getTransaction().begin();

			this.manager.merge(o);

			this.manager.getTransaction().commit();

			this.manager.close();
			this.factory.close();

			JOptionPane.showMessageDialog(janela, "Sucesso ao Alterar", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/accept-grande.png"));

			return true;
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(janela, "Erro ao Alterar", "Erro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/error-circle.png"));
			return false;
		}
	}
	
	/*
	 * Método apagar
	 * Apaga o objeto do banco de dados
	 * PARAMETROS
	 *		Long	codigo	= Codigo do objeto que sera buscado
	 *		Object	o		= Objeto que sera deletado
	 *		JFrame	janela	= janela que chamou o método
	 *							Usado em caso de erro para setar a janela de erro como modal
	 */
	public Boolean apagar(Long codigo, Object o,  JFrame janela)
	{
		try
		{
			this.factory    = Persistence.createEntityManagerFactory("assistenciaTecnica", this.getConfigBD());
			this.manager = this.factory.createEntityManager();

			this.manager.getTransaction().begin();

			//Apagando
			o = manager.find(o.getClass(), codigo);
			this.manager.remove(o);

			this.manager.getTransaction().commit();

			this.manager.close();
			this.factory.close();

			JOptionPane.showMessageDialog(janela, "Sucesso ao Apagar", "Sucesso", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/accept-grande.png"));

			return true;
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(janela, "Erro ao Apagar", "Erro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/error-circle.png"));
			return false;
		}
	}
	
	/*
	 * MÃ©todo getConfigBD
	 * Obtem as configuracoes do Banco de dados
	 */
	public HashMap getConfigBD()
	{
		Map			cfg		= new HashMap();
		Properties	prop		= new Properties();
		InputStream	input	= null;
		String		show_sql	= new String();
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
			show_sql	= prop.getProperty("show_sql");
			user		= prop.getProperty("user");
			password	= prop.getProperty("password");
			server	= prop.getProperty("server");
			port		= prop.getProperty("port");
			database	= prop.getProperty("database");
			
			//Mapeia as propriedades
			cfg.put("hibernate.show_sql",				show_sql);
			cfg.put("javax.persistence.jdbc.user",		user);
			cfg.put("javax.persistence.jdbc.password",	password);
			cfg.put("javax.persistence.jdbc.url",		"jdbc:mysql://"+server+":"+port+"/"+database);
		}
		catch (IOException ex)
		{
			return null;
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
		
		return (HashMap)cfg;
	}
	
	private Map					config;
	private EntityManagerFactory		factory;
	private EntityManager			manager;
}
