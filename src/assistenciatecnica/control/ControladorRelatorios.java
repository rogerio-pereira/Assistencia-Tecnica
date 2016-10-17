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

import java.awt.Toolkit;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rogério Eduardo Pereira <rogerio@groupsofter.com.br>
 * @version 1.0
 */
public class ControladorRelatorios {
    public Connection	conexao;
	public HashMap		parametros;
    
    public ControladorRelatorios ()
	{
		this.conexao	= new ControladorBancodeDados().getConexaoReport();
	}
    
    public void geraRelatorios(String relatorio, HashMap parametros)
	{
		try
		{
			JasperPrint jp;
			
			if(!relatorio.equals("relatorios/Recibo.jasper"))
				jp		= JasperFillManager.fillReport(relatorio, parametros, this.conexao);
			else
				jp		= JasperFillManager.fillReport(relatorio, parametros, new JREmptyDataSource());
            
			JasperViewer	jv		= new JasperViewer(jp, false);
			jv.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assistenciatecnica/view/img/icone.png")));
            jv.setTitle(relatorio.replace("relatorios/", "").replace(".jasper", ""));
			jv.setVisible(true);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Erro ao gerar Relatorio\n"+e.getCause()+"\n"+e.getMessage(), "Erro ao gerar o relatorio!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
