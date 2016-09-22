/*
 * ControladorClientes.java
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

package assistenciatecnica.control;


import assistenciatecnica.model.Clientes;
import assistenciatecnica.view.CadastroClientes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Mar 5, 2014
 */
public class ControladorClientes 
{
	/*
     * Método getClientesByCodigo
     * Obtem o cliente atraves do codigo
     */
    public Clientes getClientesByCodigo(Long codigo, JFrame janela)
    {
        try
        {
            this.factory = Persistence.createEntityManagerFactory	(	
													"assistenciaTecnica", 
													new ControladorBancodeDados().getConfigBD()
												);
            this.manager = this.factory.createEntityManager();
            
            this.cliente = manager.find(Clientes.class, codigo);
            
            return this.cliente;
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(janela, "Erro ao buscar Cliente", "Erro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/error-circle.png"));
            return null;
        }
    }
	
	/*
	 * Método getClientes
	 * Obtem o cliente
	 */
	public List<Clientes> getClientes(Long codigo, String nome, String cpf, String cnpj)
	{
		String filtro = new String();
		try
		{
			if(codigo != null)
				filtro += " AND codigo = "+codigo;
			if(nome != null)
				filtro += " AND nome LIKE '%"+nome+"%'";
			if(cpf != null)
				filtro += " AND cpf = '" + cpf +"'";
			if(cnpj != null)
				filtro += " AND cnpj = " + cnpj + "'";
			
			this.factory = Persistence.createEntityManagerFactory	(	
															"assistenciaTecnica", 
															new ControladorBancodeDados().getConfigBD()
														);
			this.manager = this.factory.createEntityManager();
			
			String qr = "Select c FROM Clientes c WHERE 1=1 " + filtro + " ORDER BY c.codigo";

			//Obtendo o Codigo do item
			Query query = this.manager.createQuery(qr);
			this.clientes = query.getResultList();
			return this.clientes;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	private EntityManagerFactory	factory;
	private EntityManager		manager;
	
	private CadastroClientes		cadastroClientes;
	
	private Clientes			cliente;
	private List<Clientes>		clientes;
}