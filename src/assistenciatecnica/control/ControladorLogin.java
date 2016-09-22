/*
 * EstudioFotografico 1.0 - Gerenciador de Estudio Fotografico
 * Copyright (C) 2014 Rog√©rio Eduardo Pereira
 * 
 * This file is part of EstudioFotografico 1.0.
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU 
 * General Public License as published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assistenciatecnica.control;


import assistenciatecnica.model.Usuario;
import assistenciatecnica.view.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Rog√©rio Eduardo Pereira
 * Data Cria√ß√£o: Feb 19, 2014
 */
public class ControladorLogin extends Usuario
{
	public Usuario ValidaLogin(String usuario, String senha, JFrame janela)
	{
		try
		{
			this.factory= Persistence.createEntityManagerFactory	(	
															"assistenciaTecnica", 
															new ControladorBancodeDados().getConfigBD()
														);
			this.manager			= factory.createEntityManager();
			String usuarioBD		= "";
			String senhaBD		= "";

			Query		query	= manager.createNamedQuery("Usuario.login", Usuario.class);
			query.setParameter(1, usuario);
			Usuario		user		= (Usuario)query.getSingleResult();
			usuarioBD			= user.getUsuario();
			senhaBD				= user.getSenha();
			
			if((usuario.equals(usuarioBD)) && (senha.equals(senhaBD)))
				return  user;
			else
			{
				JOptionPane.showMessageDialog(janela, "Usu·rio ou senha Inv·lidos!", "Erro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/error-circle.png"));
				return null;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(janela, "Usu·rio ou senha Inv·lidos!", "Erro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/error-circle.png"));
			return null;
		}
			
	}
	
	
	private EntityManagerFactory		factory;
	private EntityManager			manager;
	
	private Login					janelaLogin;
}
