/*
 * Atendimentos.java
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

package assistenciatecnica.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 *
 * @author Rog�rio Eduardo Pereira
 * Data Cria��o: Jun 17, 2014
 */
@Entity
@NamedQueries
({
	@NamedQuery(name = "Atendimento.findAll",	query = "SELECT a.atendimento FROM Atendimentos  a ORDER BY a.atendimento ASC"),
	@NamedQuery(name = "Atendimento.findOne",	query = "SELECT a.codigo FROM Atendimentos a WHERE a.atendimento = ?0"),
	@NamedQuery(name = "Atendimento.findName",	query = "SELECT a FROM Atendimentos a WHERE a.atendimento = ?0")
})
public class Atendimentos 
{
	@Id
	@GeneratedValue
	private Long codigo;
    
	@Column(nullable=false, length=50, unique=true)
	private String atendimento;


	public Long getCodigo ()
	{
		return codigo;
	}


	public void setCodigo (Long codigo)
	{
		this.codigo = codigo;
	}


	public String getAtendimento ()
	{
		return atendimento;
	}


	public void setAtendimento (String atendimento)
	{
		this.atendimento = atendimento;
	}
	
	
}
