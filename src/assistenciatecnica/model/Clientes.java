/*
 * Clientes.java
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

import java.util.Calendar;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 *
 * @author Rog�rio Eduardo Pereira
 * Data Cria��o: Jun 14, 2014
 */
@Entity
public class Clientes
{
    @Id
    @GeneratedValue
    private Long codigo;
    
    @Column(nullable=false, length=100)
    private String nome;
    
    /*
     *  1 - Pessoa Fisica
     *  0 - Pessoa Juridica
     */
    @Column
    private Boolean pessoa;
    
    @Column (length=13)
    private String rg;
    
    @Column (length=14,unique=true)
    private String cpf;
    
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    
    /*
     * 1 - Masculino
     * 2 - Feminino
     */
    private Boolean sexo;
    
    @Column(length=18, unique=true)
    private String cnpj;
    
    @Column(length=100)
    private String responsavel;
    
    @Column (length=13)
    private String rgResponsavel;
    
    @Column (length=14)
    private String cpfResponsavel;
    
    @Column(length=100)
    private String Endereco;
    
    @Column()
    private int numero;
    
    @Column(length=40)
    private String bairro;
    
    @Column(length=15)
    private String complemento;
    
    @Column(length=50)
    private String cidade;
    
    private int estado;
    
    @Column(length=9)
    private String cep;
    
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, fetch = FetchType.LAZY)
    private Collection<TelefonesClientes> telefones;
    
    @OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, fetch = FetchType.LAZY)
    private Collection<EmailsClientes> emails;
    
    @Column(length=999999999)
    private String observacao;
	
    @Column(nullable=false, columnDefinition="bit default 1", insertable=false)
    private Boolean ativo;


	public Long getCodigo ()
	{
		return codigo;
	}


	public void setCodigo (Long codigo)
	{
		this.codigo = codigo;
	}


	public String getNome ()
	{
		return nome;
	}


	public void setNome (String nome)
	{
		this.nome = nome;
	}


	public Boolean getPessoa ()
	{
		return pessoa;
	}


	public void setPessoa (Boolean pessoa)
	{
		this.pessoa = pessoa;
	}


	public String getRg ()
	{
		return rg;
	}


	public void setRg (String rg)
	{
		this.rg = rg;
	}


	public String getCpf ()
	{
		return cpf;
	}


	public void setCpf (String cpf)
	{
		this.cpf = cpf;
	}


	public Calendar getNascimento ()
	{
		return nascimento;
	}


	public void setNascimento (Calendar nascimento)
	{
		this.nascimento = nascimento;
	}


	public Boolean getSexo ()
	{
		return sexo;
	}


	public void setSexo (Boolean sexo)
	{
		this.sexo = sexo;
	}


	public String getCnpj ()
	{
		return cnpj;
	}


	public void setCnpj (String cnpj)
	{
		this.cnpj = cnpj;
	}


	public String getResponsavel ()
	{
		return responsavel;
	}


	public void setResponsavel (String responsavel)
	{
		this.responsavel = responsavel;
	}


	public String getRgResponsavel ()
	{
		return rgResponsavel;
	}


	public void setRgResponsavel (String rgResponsavel)
	{
		this.rgResponsavel = rgResponsavel;
	}


	public String getCpfResponsavel ()
	{
		return cpfResponsavel;
	}


	public void setCpfResponsavel (String cpfResponsavel)
	{
		this.cpfResponsavel = cpfResponsavel;
	}


	public String getEndereco ()
	{
		return Endereco;
	}


	public void setEndereco (String Endereco)
	{
		this.Endereco = Endereco;
	}


	public int getNumero ()
	{
		return numero;
	}


	public void setNumero (int numero)
	{
		this.numero = numero;
	}


	public String getBairro ()
	{
		return bairro;
	}


	public void setBairro (String bairro)
	{
		this.bairro = bairro;
	}


	public String getComplemento ()
	{
		return complemento;
	}


	public void setComplemento (String complemento)
	{
		this.complemento = complemento;
	}


	public String getCidade ()
	{
		return cidade;
	}


	public void setCidade (String cidade)
	{
		this.cidade = cidade;
	}


	public int getEstado ()
	{
		return estado;
	}


	public void setEstado (int estado)
	{
		this.estado = estado;
	}


	public String getCep ()
	{
		return cep;
	}


	public void setCep (String cep)
	{
		this.cep = cep;
	}


	public Collection<TelefonesClientes> getTelefones ()
	{
		return telefones;
	}


	public void setTelefones (Collection<TelefonesClientes> telefones)
	{
		this.telefones = telefones;
	}


	public Collection<EmailsClientes> getEmails ()
	{
		return emails;
	}


	public void setEmails (Collection<EmailsClientes> emails)
	{
		this.emails = emails;
	}


	public String getObservacao ()
	{
		return observacao;
	}


	public void setObservacao (String observacao)
	{
		this.observacao = observacao;
	}


	public Boolean isAtivo ()
	{
		return ativo;
	}


	public void setAtivo (Boolean ativo)
	{
		this.ativo = ativo;
	}


	
}
