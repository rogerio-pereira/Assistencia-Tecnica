/*
 * Pecas.java
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


import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 18, 2014
 */
@Entity
@NamedQueries
({
	@NamedQuery(name = "Pecas.findAll",		query = "SELECT p FROM Pecas p ORDER BY p.codigo ASC"),
	@NamedQuery(name = "Pecas.findOne",	query = "SELECT p.codigo FROM Pecas p WHERE p.peca = ?0")
})
public class Pecas 
{
	@Id
	@GeneratedValue
	private Long codigo;
    
	@Column(nullable=false, length=50, unique=true)
	private String peca;
	
	@Column(nullable=false, scale=2)
	private Double valor;
	
	@Column(nullable=false)
	private int quantidade;
	
	@Column(length=999999999)
	private String observacao;
	
	@OneToMany(cascade={CascadeType.REMOVE}, orphanRemoval=true, fetch = FetchType.LAZY)
	private Collection<Fornecedores> fornecedores;


	public Long getCodigo ()
	{
		return codigo;
	}


	public void setCodigo (Long codigo)
	{
		this.codigo = codigo;
	}


	public String getPeca ()
	{
		return peca;
	}


	public void setPeca (String peca)
	{
		this.peca = peca;
	}


	public Double getValor ()
	{
		return valor;
	}


	public void setValor (Double valor)
	{
		this.valor = valor;
	}


	public int getQuantidade ()
	{
		return quantidade;
	}


	public void setQuantidade (int quantidade)
	{
		this.quantidade = quantidade;
	}


	public String getObservacao ()
	{
		return observacao;
	}


	public void setObservacao (String observacao)
	{
		this.observacao = observacao;
	}


	public Collection<Fornecedores> getFornecedores ()
	{
		return fornecedores;
	}


	public void setFornecedores (Collection<Fornecedores> fornecedores)
	{
		this.fornecedores = fornecedores;
	}
	
}
