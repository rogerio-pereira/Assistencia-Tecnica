/*
 * ControladorUsuario.java
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


import assistenciatecnica.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Apr 3, 2014
 */
public class ControladorUsuario 
{
	/*
	 * Método getUsuarios
	 * Obtem os usuarios cadastrados
	 */
	public List<Usuario> getUsuarios()
	{
		this.factory	= Persistence.createEntityManagerFactory	(	
															"assistenciaTecnica", 
															new ControladorBancodeDados().getConfigBD()
														);
		this.manager	= factory.createEntityManager();
		
		Query query	= manager.createNamedQuery("Usuario.findAll");
		this.usuarios	= query.getResultList();
		
		return usuarios;
	}
	
	/*
	 * Método getCodigoByUser
	 * Obtem o codigo de acordo com o usuario
	 */
	public Long getCodigoByUser(String user)
	{
		this.factory	= Persistence.createEntityManagerFactory	(	
															"assistenciaTecnica", 
															new ControladorBancodeDados().getConfigBD()
														);
		this.manager	= this.factory.createEntityManager();

		//Obtendo o Codigo do item
		TypedQuery<Long> query = manager.createNamedQuery("Usuario.findOne", Long.class);
		query.setParameter(0, user);
		
		this.codigoUsuario = query.getSingleResult();
		
		return this.codigoUsuario;
	}
	
	private EntityManagerFactory		factory;
	private EntityManager			manager;
	
	private List<Usuario>			usuarios;
	private Long					codigoUsuario;
}
