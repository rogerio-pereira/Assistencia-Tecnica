/*
 * ControladorAtendimentos.java
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


import assistenciatecnica.model.Atendimentos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 17, 2014
 */
public class ControladorAtendimentos 
{
	/*
	 * Método getCategorias
	 * Obtem o nome de todas as categorias cadastradas
	 */
	public List<String> getAtendimentos()
	{
		this.factory			= Persistence.createEntityManagerFactory	(	
																	"assistenciaTecnica", 
																	new ControladorBancodeDados().getConfigBD()
																);
		this.manager			= factory.createEntityManager();
		
		Query query             = manager.createNamedQuery("Atendimento.findAll");
		this.atendimentoString	= query.getResultList();
		
		return this.atendimentoString;
	}
	
	/*
	 * Método getCodigoByCategoria
	 * Obtem o código da Categoria com o nome passado por paremetros
	 */
	public Long getCodigoByAtendimento(String categoria)
	{
		this.factory				= Persistence.createEntityManagerFactory	(	
																		"assistenciaTecnica", 
																		new ControladorBancodeDados().getConfigBD()
																	);
		this.manager				= this.factory.createEntityManager();

		//Obtendo o Codigo do item
		TypedQuery<Long> query	= manager.createNamedQuery("Atendimento.findOne", Long.class);
		query.setParameter(0, categoria);
		
		this.codigo = query.getSingleResult();
		
		return this.codigo;
	}
    
    /*
	 * MÃ©todo getAtendimentoByNome
	 * Obtem o atendimento pelo nome
	 */
	public Atendimentos getAtendimentoByNome(String nome)
	{
		this.factory	= Persistence.createEntityManagerFactory	(	
                                                                        "assistenciaTecnica", 
                                                                        new ControladorBancodeDados().getConfigBD()
                                                                    );
		this.manager	= factory.createEntityManager();
		
		Query query	= manager.createNamedQuery("Atendimento.findName");
		query.setParameter(0, nome);
		this.atendimento	= (Atendimentos) query.getSingleResult();
		
		return atendimento;
	}
	
	private EntityManagerFactory    factory;
	private EntityManager			manager;
	private List<String>			atendimentoString;
	private Long					codigo;
    private Atendimentos            atendimento;
}
