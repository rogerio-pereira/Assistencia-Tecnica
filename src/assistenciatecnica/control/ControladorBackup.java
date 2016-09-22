/*
 * ControladorBackup.java
 * 
 * Copyright � 2014 Rog�rio Eduardo Pereira <rogeriopereira.info@gmail.com>. 
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


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Apr 4, 2014
 */
public class ControladorBackup extends Thread
{
	/*
	 * Método run
	 * Inicia Thread
	 */
	public void run () 
	{
		
	}
	
	/*
	 * Método realizaBackup
	 * Realiza o backup do banco de dados
	 */
	public Boolean realizaBackup(String diretorio)
	{
		Properties	prop			= new Properties();
		InputStream	input		= null;
		String		user			= new String();
		String		password		= new String();
		String		server		= new String();
		String		database		= new String();
		
		try
		{
			//Abre arquivo de configurações
			input = new FileInputStream("config/bd.config.properties");
			
			//Obtem as informações do arquivo
			prop.load(input);
			
			//Seta as propriedades
			user				= prop.getProperty("user");
			password			= prop.getProperty("password");
			server			= prop.getProperty("server");
			database			= prop.getProperty("database");
			
			Runtime	bckp		= Runtime.getRuntime(); 
			File		arquivo	= new File(diretorio); 

			//Se ja existe arquivos
			if(arquivo.exists())
			{
				//Exibe Confirmação
				Object[] options = { "Sim", "Não" };
				int opcao = JOptionPane.showOptionDialog	(
														null,
														"Este arquivo j� existe. Quer sobreescrever este arquivo?",	
														"Aten��o!!!",
														JOptionPane.YES_NO_OPTION, 
														JOptionPane.QUESTION_MESSAGE, 
														null,
														options, 
														options[0]
													);
				//Se a confirmação for sim
				if (opcao == JOptionPane.YES_OPTION) 
				{
					//Faz Backup
					if(password.isEmpty())
						bckp.exec("cmd /c util\\mysqldump.exe -u "+user+" -h "+server+" "+database+" > \""+arquivo+"\"");
					else
						bckp.exec("cmd /c util\\mysqldump.exe -u "+user+" -p "+password+" -h "+server+" "+database+" > \""+arquivo+"\"");
				}
			}
			//Não existe o arquivo
			else
			{
				//Faz Backup
				if(password.isEmpty())
					bckp.exec("cmd /c util\\mysqldump.exe -u "+user+" -h "+server+" "+database+" > \""+arquivo+"\"");
				else
					bckp.exec("cmd /c util\\mysqldump.exe -u "+user+" -p "+password+" -h "+server+" "+database+" > \""+arquivo+"\"");
			}
			
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	/*
	 * Método restauraBackup
	 * Inicia a restauração do backup
	 */
	public Boolean restauraBackup(String diretorio)
	{
		Properties	prop			= new Properties();
		InputStream	input		= null;
		String		user			= new String();
		String		password		= new String();
		String		server		= new String();
		String		database		= new String();
		
		try
		{
			//Abre arquivo de configurações
			input = new FileInputStream("config/bd.config.properties");
			
			//Obtem as informações do arquivo
			prop.load(input);
			
			//Seta as propriedades
			user		= prop.getProperty("user");
			password	= prop.getProperty("password");
			server	= prop.getProperty("server");
			database	= prop.getProperty("database");
			
			File	arquivo	= new File(diretorio);  
			Runtime rt	= Runtime.getRuntime();
			Process proc;
				
			if(password.isEmpty())
				rt.exec("cmd /c util\\mysql.exe -u "+user+" -h "+server+" "+database+" < \""+arquivo+"\"");
			else
				rt.exec("cmd /c util\\mysql.exe -u "+user+" -p "+password+" -h "+server+" "+database+" < \""+arquivo+"\"");
				
			return true;
		} 
		//Erro
		catch (Exception e) 
		{
            return false;
        }
	}
}
