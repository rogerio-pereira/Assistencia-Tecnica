/*
 * Copyright (C) 2016 AssistenciaTecnica
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package assistenciatecnica.control;

import assistenciatecnica.model.Clientes;
import assistenciatecnica.model.OrdemServico;
import com.sun.org.apache.xpath.internal.operations.Or;
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
 * @author Rog�rio Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class ControladorOS {
	private EntityManagerFactory	factory;
	private EntityManager           manager;
	
	private OrdemServico            os;
	private List<OrdemServico>      osList;
    
    /*
     * Método getOSByCodigo
     * Obtem o cliente atraves do codigo
     */
    public OrdemServico getOSByCodigo(Long codigo, JFrame janela)
    {
        try
        {
            this.factory = Persistence.createEntityManagerFactory	(	
													"assistenciaTecnica", 
													new ControladorBancodeDados().getConfigBD()
												);
            this.manager = this.factory.createEntityManager();
            
            this.os = manager.find(OrdemServico.class, codigo);
            
            return this.os;
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(janela, "Erro ao buscar OS", "Erro", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/error-circle.png"));
            return null;
        }
    }
    
    /*
	 * Método getClientes
	 * Obtem o cliente
	 */
	public List<OrdemServico> getOrdensServico(Long codigo, String nome, String cpf, String cnpj, boolean finalizada)
	{
		String filtro = new String();
		try
		{
			if(codigo != null)
				filtro += " AND codigo = "+codigo;
            
            if(nome != null)
				filtro += " AND o.cliente.nome = "+nome;
            
            if(cpf != null)
				filtro += " AND o.cliente.cpf = "+cpf;
            
            if(cnpj != null)
				filtro += " AND o.cliente.cnpj = "+cnpj;
            
            if(finalizada != true)
                filtro += " AND o.status <> 'Entregue'";
            
			this.factory = Persistence.createEntityManagerFactory	(	
															"assistenciaTecnica", 
															new ControladorBancodeDados().getConfigBD()
														);
			this.manager = this.factory.createEntityManager();
			
			String qr = "Select o FROM OrdemServico o WHERE 1=1 " + filtro + " ORDER BY o.codigo DESC";

			//Obtendo o Codigo do item
			Query query = this.manager.createQuery(qr);
			this.osList = query.getResultList();
			return this.osList;
		}
		catch (Exception e)
		{
			return null;
		}
	}
}
