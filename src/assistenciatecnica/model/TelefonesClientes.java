/*
 * TelefonesClientes.java
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



/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 14, 2014
 */
@Entity
public class TelefonesClientes
{
    @Id
    @GeneratedValue
    private Long codigo;
    
    @Column(nullable=false, length=17)
    private String telefone;
    
    private int tipo;
    
    @Column(length=15)
    private String operadora;
    
    private int ramal;


    public Long getCodigo ()
    {
        return codigo;
    }


    public void setCodigo (Long codigo)
    {
        this.codigo = codigo;
    }


    public String getOperadora ()
    {
        return operadora;
    }


    public void setOperadora (String operadora)
    {
        this.operadora = operadora;
    }


    public int getRamal ()
    {
        return ramal;
    }


    public void setRamal (int ramal)
    {
        this.ramal = ramal;
    }


    public String getTelefone ()
    {
        return telefone;
    }


    public void setTelefone (String telefone)
    {
        this.telefone = telefone;
    }


    public int getTipo ()
    {
        return tipo;
    }


    public void setTipo (int tipo)
    {
        this.tipo = tipo;
    }
    
}
