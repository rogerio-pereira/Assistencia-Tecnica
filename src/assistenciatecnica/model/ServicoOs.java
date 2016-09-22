/*
 * ServicoOs.java
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

package assistenciatecnica.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 21, 2014
 */
@Entity
public class ServicoOs 
{
	@Id
	@GeneratedValue
	private Long codigo;
	
	@OneToOne
	private Servicos servico;
	
	@Column(nullable = false, scale=2)
	private Double valor;
	
	@Column(scale=2)
	private Double desconto;


	public Long getCodigo ()
	{
		return codigo;
	}


	public void setCodigo (Long codigo)
	{
		this.codigo = codigo;
	}


	public Servicos getServico ()
	{
		return servico;
	}


	public void setServico (Servicos servico)
	{
		this.servico = servico;
	}


	public Double getValor ()
	{
		return valor;
	}


	public void setValor (Double valor)
	{
		this.valor = valor;
	}


	public Double getDesconto ()
	{
		return desconto;
	}


	public void setDesconto (Double desconto)
	{
		this.desconto = desconto;
	}
	
	
}
