package trabajoInmobiliaria;

import javax.swing.JOptionPane;

public interface Validacion {
	
	
	default int validarDni(String mensaje) {
        int dni = 0;
        boolean confirmacion = false;
        
        do {
        	try {
				String dniString = JOptionPane.showInputDialog(mensaje);
        		
				if(dniString==null || dniString.trim().isEmpty()){//verificamos is esta vacio
					JOptionPane.showMessageDialog(null, "No se admiten campos en blanco. Por favor ingrese un DNI");
					continue; // q vuelva a ejecutarse el bucle para analizar nuevamente
				}
				
				dniString.trim(); //por las dudas eliminamos los espacios en blancos del principio o final
        	
        	
				if(dniString.length()!=8){
                    JOptionPane.showMessageDialog(null, "El DNI debe tener exactamente 8 dígitos. Ingrese DNI nuevamente");
                    continue;
				}
				
                boolean esNumerico = true; //para verificar si toda la cadena es de tipo entero
                for (int i = 0; i < dniString.length(); i++) {
                    if (!Character.isDigit(dniString.charAt(i))) {
                        esNumerico = false;
                        break; 
                    }
                }
                
                if(!esNumerico){
                    JOptionPane.showMessageDialog(null, "Solo se permiten caracteres numéricos. Ingrese DNI nuevamente");
                    continue;
                }
        	   	
                dni = Integer.parseInt(dniString); // Convertir a entero
                confirmacion = true; // Si todo está correcto, confirmar que el DNI es válido
        		
        	
			} catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al ingresar DNI. Ingrese DNI nuevamente");
			}
        	
        }while(confirmacion == false);
	
        return dni;
	}
	
	
	
	
	
	
	
}

	
