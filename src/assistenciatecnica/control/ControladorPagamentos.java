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
import assistenciatecnica.model.Pagamentos;
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
public class ControladorPagamentos 
{
	/*
	 * Método getPagamentos
	 * Obtem o nome de todas os pagamentos
	 */
	public List<String> getPagamentos()
	{
		this.factory			= Persistence.createEntityManagerFactory	(	
																	"assistenciaTecnica", 
																	new ControladorBancodeDados().getConfigBD()
																);
		this.manager			= factory.createEntityManager();
		
		Query query             = manager.createNamedQuery("Pagamento.findAll");
		this.pagamentosString	= query.getResultList();
		
		return this.pagamentosString;
	}
	
	/*
	 * Método getCodigoByPagamento
	 * Obtem o código do Pagamento com o nome passado por paremetros
	 */
	public Long getCodigoByPagamento(String pagamento)
	{
		this.factory				= Persistence.createEntityManagerFactory	(	
																		"assistenciaTecnica", 
																		new ControladorBancodeDados().getConfigBD()
																	);
		this.manager				= this.factory.createEntityManager();

		//Obtendo o Codigo do item
		TypedQuery<Long> query	= manager.createNamedQuery("Pagamento.findOne", Long.class);
		query.setParameter(0, pagamento);
		
		this.codigo = query.getSingleResult();
		
		return this.codigo;
	}
    
    /*
	 * Método getPagamentoByNome
	 * Obtem o pagamento pelo nome
	 */
	public Pagamentos getPagamentoByNome(String nome)
	{
		this.factory	= Persistence.createEntityManagerFactory	(	
                                                                        "assistenciaTecnica", 
                                                                        new ControladorBancodeDados().getConfigBD()
                                                                    );
		this.manager	= factory.createEntityManager();
		
		Query query	= manager.createNamedQuery("Pagamento.findName");
		query.setParameter(0, nome);
		this.pagamento	= (Pagamentos) query.getSingleResult();
		
		return pagamento;
	}
	
	private EntityManagerFactory    factory;
	private EntityManager			manager;
	private List<String>			pagamentosString;
	private Long					codigo;
    private Pagamentos              pagamento;
}
