/*
 * ControladorEmpresa.java
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


import assistenciatecnica.model.Empresa;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Apr 4, 2014
 */
public class ControladorEmpresa 
{
	/*
	 * Método getCategorias
	 * Obtem o nome de todas as categorias cadastradas
	 */
	public Empresa getEmpresa()
	{
		this.factory		= Persistence.createEntityManagerFactory	(	
														"assistenciaTecnica", 
														new ControladorBancodeDados().getConfigBD()
													);
		this.manager		= factory.createEntityManager();
		
		Query query		= manager.createNamedQuery("Empresa.getOne");
		query.setMaxResults(1);
		try
		{
			this.empresa	= (Empresa) query.getSingleResult();
		}
		catch (Exception e)
		{
			return null;
		}
		
		return this.empresa;
	}
	
	/*
	 * Método criaLogotipo
	 * Copia o arquivo de logotipo para a pasta
	 */
	public void criaLogotipo(String imagem, JFrame janela)
	{
		String logotipo			= new String("img/logotipo.jpg");
		String logotipoMenor	= new String("img/logotipoMenor.jpg");

		this.criaDiretorio(janela);
		this.copiaArquivo(imagem,			logotipo,	logotipoMenor,	janela);
		this.redimenImagem(logotipo,		500,		250,			janela);
		this.redimenImagem(logotipoMenor,	150,		75,			janela);
	}
	
	/*
	 * Método criaDiretorio
	 * Cria o diretorio img se nao existir
	 */
	private void criaDiretorio(JFrame janela)
	{
		File diretorio		= new File("img");
		
		//Se não existir diretorio cria
		try
		{
			if(!diretorio.exists())
				diretorio.mkdirs();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(janela, "Erro ao criar diret�rio", "Erro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/error-circle.png"));
		}
	}
	
	/*
	 * Método copiaArquivo
	 * Copia as imagens
	 */
	private void copiaArquivo(String imagem, String logotipo, String logotipoMenor, JFrame janela)
	{
		//Copia o arquivo
		try
		{
			FileInputStream	fisOrigem		= new FileInputStream(imagem); 
			FileOutputStream	fisDestino		= new FileOutputStream(logotipo); 
			FileOutputStream	fisDestino2	= new FileOutputStream(logotipoMenor); 
			FileChannel		fcOrigem		= fisOrigem.getChannel();   
			FileChannel		fcDestino		= fisDestino.getChannel();   
			FileChannel		fcDestino2	= fisDestino2.getChannel();
			fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);  
			fcOrigem.transferTo(0, fcOrigem.size(), fcDestino2);
			fisOrigem.close();   
			fisDestino.close(); 
			fisDestino2.close(); 
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(janela, "Erro ao copiar Imagem", "Erro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/error-circle.png"));
		}
	}
	
	private void redimenImagem(String caminhoImg, Integer imgLargura, Integer imgAltura, JFrame janela)
	{  
		try
		{
			BufferedImage imagem	= ImageIO.read(new File(caminhoImg));  

			Double novaImgLargura	= (double) imagem.getWidth();  
			Double novaImgAltura	= (double) imagem.getHeight();  

			Double imgProporcao = null;  
			if (novaImgLargura >= imgLargura) 
			{  
				imgProporcao	= (novaImgAltura / novaImgLargura);  
				novaImgLargura	= (double) imgLargura;  
				novaImgAltura	= (novaImgLargura * imgProporcao);  
				
				while (novaImgAltura > imgAltura) 
				{  
					novaImgLargura	= (double) (--imgLargura);  
					novaImgAltura		= (novaImgLargura * imgProporcao);  
				}  
			} 
			else if (novaImgAltura >= imgAltura) 
			{  
				imgProporcao	= (novaImgLargura / novaImgAltura);  
				novaImgAltura	= (double) imgAltura;  
				
				while (novaImgLargura > imgLargura) 
				{  
					novaImgAltura	= (double) (--imgAltura);  
					novaImgLargura	= (novaImgAltura * imgProporcao);  
				}  
			}  

			BufferedImage	novaImagem = new BufferedImage	(
															novaImgLargura.intValue(), 
															novaImgAltura.intValue(), 
															BufferedImage.TYPE_INT_RGB
														);  
			Graphics		g			= novaImagem.getGraphics();  
			
			g.drawImage	(imagem.getScaledInstance(novaImgLargura.intValue(), novaImgAltura.intValue(), 10000), 0, 0, null);  
			g.dispose();  
			
			ImageIO.write(novaImagem, "jpg", new File(caminhoImg));  
		}
		catch (IOException e)
		{
			JOptionPane.showMessageDialog(janela, "Erro ao redimensionar Imagem", "Erro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/error-circle.png"));
		}
    }  
	
	/*
	 * Método countEmpresa
	 * Verifica se existe empresa cadastrada
	 */
	public Boolean countEmpresa()
	{
		this.factory = Persistence.createEntityManagerFactory	(	
														"assistenciaTecnica", 
														new ControladorBancodeDados().getConfigBD()
													);
		this.manager		= factory.createEntityManager();
		
		TypedQuery<Long> query	= manager.createNamedQuery("Empresa.count", Long.class);
		try
		{
			Long c	= query.getSingleResult();
			
			if(c > 0)
				return true;
			else
				return false;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	
	private EntityManagerFactory		factory;
	private EntityManager			manager;
	
	private Empresa				empresa;
}
