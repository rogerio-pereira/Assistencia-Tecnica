/*
 * ControladorPeca.java
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


import assistenciatecnica.model.Pecas;
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
public class ControladorPeca 
{
	/*
	 * Método getServicoByCodigo
	 * Obtem o serviço de acordo com o codigo
	 */
	public Pecas getPecaByCodigo(Long codigo, JFrame janela)
	{
		try
		{
			this.factory = Persistence.createEntityManagerFactory	(	
															"assistenciaTecnica", 
															new ControladorBancodeDados().getConfigBD()
														);
			this.manager = this.factory.createEntityManager();

			this.peca = manager.find(Pecas.class, codigo);

			return this.peca;
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
	public List<Pecas> buscaPecas(String nome)
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
			CriteriaQuery <Pecas> c = cb.createQuery(Pecas.class);
			Root <Pecas> p = c.from(Pecas.class);
			c.select(p);

			Predicate predicate = cb.like(p.<String>get("peca"), "%"+nome+"%");
			c.where(predicate);

			TypedQuery <Pecas> query = manager.createQuery(c);
			this.pecas = query.getResultList ();

			return this.pecas;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	private EntityManagerFactory	factory;
	private EntityManager		manager;
	private Pecas				peca;
	private List<Pecas>		pecas;
}
