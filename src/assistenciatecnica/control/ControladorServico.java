/*
 * ControladorServico.java
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


import assistenciatecnica.model.Servicos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 18, 2014
 */
public class ControladorServico 
{
	/*
	 * Método getServicoByCodigo
	 * Obtem o serviço de acordo com o codigo
	 */
	public Servicos getServicoByCodigo(Long codigo, JFrame janela)
	{
		try
		{
			this.factory = Persistence.createEntityManagerFactory	(	
															"assistenciaTecnica", 
															new ControladorBancodeDados().getConfigBD()
														);
			this.manager = this.factory.createEntityManager();

			this.servico = manager.find(Servicos.class, codigo);

			return this.servico;
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(janela, "Erro ao buscar Cliente", "Erro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/error-circle.png"));
			return null;
		}
	}
	
	/*
	 * Método buscaServico
	 * Busca o servico de acordo com o nome
	 */
	public List<Servicos> buscaServico(String nome)
	{
		try
		{
			this.factory				= Persistence.createEntityManagerFactory	(	
																			"assistenciaTecnica", 
																			new ControladorBancodeDados().getConfigBD()
																		);
			this.manager				= this.factory.createEntityManager();

			//Obtendo o Codigo do item
			CriteriaBuilder cb = manager . getCriteriaBuilder ();
			CriteriaQuery <Servicos> c = cb.createQuery(Servicos.class);
			Root <Servicos> s = c.from(Servicos.class);
			c.select(s);

			Predicate predicate = cb.like(s.<String>get("servico"), "%"+nome+"%");
			c.where(predicate);

			TypedQuery <Servicos> query = manager.createQuery(c);
			this.servicos = query.getResultList ();

			return this.servicos;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	private EntityManagerFactory	factory;
	private EntityManager		manager;
	private Servicos			servico;
	private List<Servicos>		servicos;
}
