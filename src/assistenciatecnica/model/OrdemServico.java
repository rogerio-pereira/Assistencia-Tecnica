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


import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


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
	
	@Column(nullable = false, length = 12)
	private String status;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar abertura;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Calendar fechamento;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Calendar entrega;
    
    @OneToOne
    private Pagamentos pagamento;
    
    private int parcelasPagamento;
	
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
	
	@OneToMany(cascade={javax.persistence.CascadeType.ALL}, orphanRemoval=true, fetch = FetchType.LAZY)
	private Collection<PecasOs> pecas;
	
	@OneToMany(cascade={javax.persistence.CascadeType.ALL}, orphanRemoval=true, fetch = FetchType.LAZY)
	private Collection<ServicoOs> servicos;
	
	@Column(length=999999999)
	private String observacao;
    
    private double valor;
    
    private double desconto;
    
    private double porcentagemDesconto;
    
    private double valorFinal;
    
    public Long getCodigo()
    {
        return codigo;
    }

    public void setCodigo(Long codigo)
    {
        this.codigo = codigo;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Calendar getAbertura()
    {
        return abertura;
    }

    public void setAbertura(Calendar abertura)
    {
        this.abertura = abertura;
    }

    public Calendar getFechamento()
    {
        return fechamento;
    }

    public void setFechamento(Calendar fechamento)
    {
        this.fechamento = fechamento;
    }

    public Calendar getEntrega()
    {
        return entrega;
    }

    public void setEntrega(Calendar entrega)
    {
        this.entrega = entrega;
    }

    public Pagamentos getPagamento()
    {
        return pagamento;
    }

    public void setPagamento(Pagamentos pagamento)
    {
        this.pagamento = pagamento;
    }

    public int getParcelasPagamento()
    {
        return parcelasPagamento;
    }

    public void setParcelasPagamento(int parcelasPagamento)
    {
        this.parcelasPagamento = parcelasPagamento;
    }

    public Clientes getCliente()
    {
        return cliente;
    }

    public void setCliente(Clientes cliente)
    {
        this.cliente = cliente;
    }

    public Usuario getTecnico()
    {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico)
    {
        this.tecnico = tecnico;
    }

    public Atendimentos getAtendimento()
    {
        return atendimento;
    }

    public void setAtendimento(Atendimentos atendimento)
    {
        this.atendimento = atendimento;
    }

    public String getEquipamento()
    {
        return equipamento;
    }

    public void setEquipamento(String equipamento)
    {
        this.equipamento = equipamento;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getNumeroSerie()
    {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie)
    {
        this.numeroSerie = numeroSerie;
    }

    public String getDefeito()
    {
        return defeito;
    }

    public void setDefeito(String defeito)
    {
        this.defeito = defeito;
    }

    public Collection<PecasOs> getPecas()
    {
        return pecas;
    }

    public void setPecas(Collection<PecasOs> pecas)
    {
        this.pecas = pecas;
    }

    public Collection<ServicoOs> getServicos()
    {
        return servicos;
    }

    public void setServicos(Collection<ServicoOs> servicos)
    {
        this.servicos = servicos;
    }

    public String getObservacao()
    {
        return observacao;
    }

    public void setObservacao(String observacao)
    {
        this.observacao = observacao;
    }

    public double getValor()
    {
        return valor;
    }

    public void setValor(double valor)
    {
        this.valor = valor;
    }

    public double getDesconto()
    {
        return desconto;
    }

    public void setDesconto(double desconto)
    {
        this.desconto = desconto;
    }

    public double getPorcentagemDesconto()
    {
        return porcentagemDesconto;
    }

    public void setPorcentagemDesconto(double porcentagemDesconto)
    {
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public double getValorFinal()
    {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal)
    {
        this.valorFinal = valorFinal;
    }
    
    
}
