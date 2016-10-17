/*
 * Atendimentos.java
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 17, 2014
 */
@Entity
@NamedQueries
({
	@NamedQuery(name = "Pagamento.findAll",     query = "SELECT p.pagamento FROM Pagamentos p ORDER BY p.pagamento ASC"),
	@NamedQuery(name = "Pagamento.findOne",     query = "SELECT p.codigo FROM Pagamentos p WHERE p.pagamento = ?0"),
	@NamedQuery(name = "Pagamento.findName",	query = "SELECT p FROM Pagamentos p WHERE p.pagamento = ?0")
})
public class Pagamentos 
{
	@Id
	@GeneratedValue
	private Long codigo;
    
	@Column(nullable=false, length=50, unique=true)
	private String pagamento;


	public Long getCodigo ()
	{
		return codigo;
	}


	public void setCodigo (Long codigo)
	{
		this.codigo = codigo;
	}


	public String getPagamento ()
	{
		return pagamento;
	}


	public void setPagamento (String pagamento)
	{
		this.pagamento = pagamento;
	}
	
	
}
