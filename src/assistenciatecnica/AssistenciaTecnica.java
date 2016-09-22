/*
 * AssistenciaTecnica.java
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

package assistenciatecnica;


import assistenciatecnica.control.CriaTabelas;
import assistenciatecnica.model.Usuario;
import assistenciatecnica.view.Login;
import assistenciatecnica.view.Splash;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Rogério Eduardo Pereira
 * Data Criação: Jun 9, 2014
 */
public class AssistenciaTecnica {
	
	private static void setLookAndFeel()
	{
		//Look and Feel
		lookandfeel.LookAndFeel.setLookAndFeel();
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
		setLookAndFeel();
		
		Splash splash = new Splash();
		splash.setVisible(true);
		splash.progresso.setIndeterminate(true);
		
		CriaTabelas c = new CriaTabelas();
		c.criaBanco();
		c.criaTabelas();
		c.insereUsuarioSuporte();
		
		splash.Fechar();
		
		Login login = new Login();
		login.setVisible(true);
    }

	public Usuario usuario;
}
