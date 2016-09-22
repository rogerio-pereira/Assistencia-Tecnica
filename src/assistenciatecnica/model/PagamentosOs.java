/*
 * PagamentosOs.java
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


import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 21, 2014
 */
@Entity
public class PagamentosOs 
{
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Calendar vencimento;
	
	@Column(nullable = false, scale=2)
	private Double valor;
	
	@Column(nullable=false)
	private Boolean pago;
	
	@Column(scale=2)
	private Double recebido;
	
	private int formaPagamento;
	
	@Column(length=1000)
	private String obs;


	public Long getCodigo ()
	{
		return codigo;
	}


	public void setCodigo (Long codigo)
	{
		this.codigo = codigo;
	}


	public Calendar getVencimento ()
	{
		return vencimento;
	}


	public void setVencimento (Calendar vencimento)
	{
		this.vencimento = vencimento;
	}


	public Double getValor ()
	{
		return valor;
	}


	public void setValor (Double valor)
	{
		this.valor = valor;
	}


	public Boolean isPago ()
	{
		return pago;
	}


	public void setPago (Boolean pago)
	{
		this.pago = pago;
	}


	public Double getRecebido ()
	{
		return recebido;
	}


	public void setRecebido (Double recebido)
	{
		this.recebido = recebido;
	}


	public int getFormaPagamento ()
	{
		return formaPagamento;
	}


	public void setFormaPagamento (int formaPagamento)
	{
		this.formaPagamento = formaPagamento;
	}


	public String getObs ()
	{
		return obs;
	}


	public void setObs (String obs)
	{
		this.obs = obs;
	}
	
	
}
