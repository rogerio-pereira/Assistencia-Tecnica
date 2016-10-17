/*
 * ControladorTabelas.java
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

package assistenciatecnica.control.util;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 18, 2014
 */
public abstract class ControladorTabelas 
{
	public static void apagaTabela(JTable tabela)
	{
		DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
		while(tabela.getRowCount() > 0)
			modelo.removeRow(0);
	}
    
    public static void removerLinhaTabela(JTable tabela)
    {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.removeRow(tabela.getSelectedRow());
    }
}
