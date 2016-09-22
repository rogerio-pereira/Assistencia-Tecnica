/*
 * OrdemServico.java
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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 21, 2014
 */
@Entity
public class OrdemServico 
{
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Column(nullable = false)
	private int status;
	
	@OneToOne
	private Clientes cliente;
	
	@OneToOne
	private Usuario tecnico;
	
	@OneToOne
	private Atendimentos atendimento;
	
	@Column(nullable = false, length = 100)
	private String equipamento;
	
	@Column(length = 100)
	private String modelo;
	
	@Column(length = 100)
	private String numeroSerie;
	
	@Column(nullable = false, length=999999999)
	private String defeito;
	
	@OneToMany
	private Collection<PecasOs> pecas;
	
	@OneToMany
	private Collection<ServicoOs> servicos;
	
	@OneToMany
	private Collection<PagamentosOs> Pagamentos;
	
	@Column(length=999999999)
	private String observacao;


	public Long getCodigo ()
	{
		return codigo;
	}


	public void setCodigo (Long codigo)
	{
		this.codigo = codigo;
	}


	public int getStatus ()
	{
		return status;
	}


	public void setStatus (int status)
	{
		this.status = status;
	}


	public Clientes getCliente ()
	{
		return cliente;
	}


	public void setCliente (Clientes cliente)
	{
		this.cliente = cliente;
	}


	public Usuario getTecnico ()
	{
		return tecnico;
	}


	public void setTecnico (Usuario tecnico)
	{
		this.tecnico = tecnico;
	}


	public String getEquipamento ()
	{
		return equipamento;
	}


	public void setEquipamento (String equipamento)
	{
		this.equipamento = equipamento;
	}


	public String getModelo ()
	{
		return modelo;
	}


	public void setModelo (String modelo)
	{
		this.modelo = modelo;
	}


	public String getNumeroSerie ()
	{
		return numeroSerie;
	}


	public void setNumeroSerie (String numeroSerie)
	{
		this.numeroSerie = numeroSerie;
	}


	public String getDefeito ()
	{
		return defeito;
	}


	public void setDefeito (String defeito)
	{
		this.defeito = defeito;
	}


	public Collection<PecasOs> getPecas ()
	{
		return pecas;
	}


	public void setPecas (Collection<PecasOs> pecas)
	{
		this.pecas = pecas;
	}


	public Collection<ServicoOs> getServicos ()
	{
		return servicos;
	}


	public void setServicos (Collection<ServicoOs> servicos)
	{
		this.servicos = servicos;
	}


	public Collection<PagamentosOs> getPagamentos ()
	{
		return Pagamentos;
	}


	public void setPagamentos (Collection<PagamentosOs> Pagamentos)
	{
		this.Pagamentos = Pagamentos;
	}
	
	


	public String getObservacao ()
	{
		return observacao;
	}


	public void setObservacao (String observacao)
	{
		this.observacao = observacao;
	}
	
	
}
