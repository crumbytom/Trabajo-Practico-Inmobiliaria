package trabajoInmobiliaria;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import controlador.AgenteControlador;
import controlador.GerenteControlador;
import controlador.InmuebleControlador;

public class Gerente extends Empleado implements Validacion, InicioSesion{

	private int id_gerente;

	public Gerente(int id_empleado, String nombre, String apellido, LocalDate fecha_nacimiento, int dni, int telefono,
			String correo, String tipo_empleado, String contraseña, int id_gerente) {
		super(id_empleado, nombre, apellido, fecha_nacimiento, dni, telefono, correo, tipo_empleado, contraseña);
		this.id_gerente = id_gerente;
	}



	public Gerente() {
		
	}

	
	
	public int getId_gerente() {
		return id_gerente;
	}

	public void setId_gerente(int id_gerente) {
		this.id_gerente = id_gerente;
	}
	
	

	InmuebleControlador inmuebleControlador = new InmuebleControlador();

	public boolean menuGerente() {
		boolean repetir;
		
		
		do {		
			repetir = true;
			String[] opcionesGerente = { "Gestionar Propiedades", 
											"Registrar Nuevo Cliente", 
											"Realizar Nueva Operacion",
											"Realizar Nuevo Contrato", 
											"Realizar Busqueda"   , 
											"Agendar Reunion o Visita", 
											"Registrar Pago",
											"Cargar Nuevo Documento",
											"Ver Ultimas Operaciones" , 
											"Gestionar Empleados",
											"Cerrar Sesion",
											"Salir" };
	
			String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:",
					"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, opcionesGerente,
					opcionesGerente[0]);

			try {
			
			switch (opcionSeleccionada) {
			
			case"Gestionar Propiedades":
				do {			
					
					Inmueble inmueble = new Inmueble();
					String[] opcionesGestion = { "Ver Inmuebles","Agregar Inmueble","Modificar Inmueble","Eliminar Inmueble","Volver" };
					
					String gestionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de Operacion:",
							"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, opcionesGestion,
							opcionesGestion[0]);
					
					if(gestionSeleccionada.equals("Ver Inmuebles")){
				        boolean volverSubmenu = false;

						do {
							try {
								

							
						String[] submenuPropieades = { "Ver todos los Inmuebles","Ver Inmuebles Disponibles","Activar Inmuebles cargados por Agente","Volver" };
						
						String seleccionSubmenu = (String) JOptionPane.showInputDialog(null, "Seleccione una Opción:",
								"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, submenuPropieades,
								submenuPropieades[0]);
						
						if(seleccionSubmenu.equals("Ver todos los Inmuebles")){
							verInmuebles();		
									
							
						}else if(seleccionSubmenu.equals("Ver Inmuebles Disponibles")) {
							verInmueblesDisponibles();
	
							
						}else if(seleccionSubmenu.equals("Activar Inmuebles cargados por Agente")){					
							activarInmueble();
							
						}else{
							volverSubmenu = true;						
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
							}
						} while (!volverSubmenu);
						break;
						
					}else if(gestionSeleccionada.equals("Agregar Inmueble")){
						agregarInmueble();					
	
						
					}else if(gestionSeleccionada.equals("Modificar Inmueble")){
						modificarInmueble();
						
		
					}else if(gestionSeleccionada.equals("Eliminar Inmueble")){
						eliminarInmueble();
						
					}else {						
						break;
					}
				} while (repetir);
				break;		
				
				
			case "Registrar Nuevo Cliente":
				do {
					String[] tipoCliente = { "Nuevo Propietario","Nuevo Inquilino","Volver" };
					
					String clienteSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione una Opción:",
							"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, tipoCliente,
							tipoCliente[0]);
					
					if(clienteSeleccionado.equals("Nuevo Propietario")){
						JOptionPane.showMessageDialog(null, "Completar Propietario");
						
					}else if(clienteSeleccionado.equals("Nuevo Inquilino")){
						JOptionPane.showMessageDialog(null, "Completar Inquilino");  

					}else {
						break;
					}
							
				} while (repetir);
	
				break;
			
			case "Realizar Nueva Operacion":
				do {
					String[] operacionesNueva = { "Realizar Venta","Realizar Alquiler","Confirmacion Operaciones","Volver" };
					
					String operacionNuevaSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
							"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, operacionesNueva,
							operacionesNueva[0]);
					
					if(operacionNuevaSeleccionada.equals("Realizar Venta")){
						JOptionPane.showMessageDialog(null, "Completar Venta");
						
					}else if(operacionNuevaSeleccionada.equals("Realizar Alquiler")){
						JOptionPane.showMessageDialog(null, "Completar Alquiler");  

					}else if(operacionNuevaSeleccionada.equals("Confirmacion Operaciones")){
						JOptionPane.showMessageDialog(null, "Mostrar operaciones hechas por el agente.. solo confirmar");
					}else {
						break;
					}
					
					
				} while (repetir);
	
				break;
	
			case "Realizar Nuevo Contrato":
	
				do {
					String[] operacionesContrato = { "Nuevo Contrato de Venta","Nuevo Contrato de Alquiler","Confirmar Contratos","Volver" };
					
					String operacionContratoSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
							"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, operacionesContrato,
							operacionesContrato[0]);
					
					if(operacionContratoSeleccionada.equals("Nuevo Contrato de Venta")){
						JOptionPane.showMessageDialog(null, "Completar y verificar datos de la venta");
						
					}else if(operacionContratoSeleccionada.equals("Nuevo Contrato de Alquiler")){
						JOptionPane.showMessageDialog(null, "Completar y verificar datos del alquiler");  

					}else if(operacionContratoSeleccionada.equals("Confirmar Contratos")){
						JOptionPane.showMessageDialog(null, "Mostrar contratos hechos por el agente.. solo confirmar");
					}else {
						break;
					}
					
					
				} while (repetir);
	
				break;
	
			case "Realizar Busqueda":
				do {
					String[] operacionesBuscador = { "Buscador","Volver" };
					
					String operacionBuscadorSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
							"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, operacionesBuscador,
							operacionesBuscador[0]);
					
					if(operacionBuscadorSeleccionada.equals("Buscador")){
						JOptionPane.showMessageDialog(null, "Buscador");
						
					}else {
						break;
					}
					
				} while (repetir);
				break;
	
			case "Agendar Reunion o Visita":
				do {
					String[] operacionesReunion = { "Programar Nueva Reunion","Programar Nueva Visita","Volver"};
					
					String operacionReunionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
							"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, operacionesReunion,
							operacionesReunion[0]);
					
					if(operacionReunionSeleccionada.equals("Programar Nueva Reunion")){
						JOptionPane.showMessageDialog(null, "Seleccionar Clientes");
						JOptionPane.showMessageDialog(null, "Seleccionar Fecha disponible | Mostrar un calendario");
						
					}else if(operacionReunionSeleccionada.equals("Programar Nueva Visita")){
						JOptionPane.showMessageDialog(null, "Seleccionar Clientes");
						JOptionPane.showMessageDialog(null, "Seleccionar Propiedades disponibles"); //mostramos una linkedList con las propiedades para visitar disponibles	
						JOptionPane.showMessageDialog(null, "Seleccionar Fecha disponible | Mostrar un calendario");

					}else {
						break;
					}
					
				} while (repetir);
				break;
	
			case "Registrar Pago":
				do {
					String[] operacionesPagos = { "Registrar Nuevo Pago de Venta","Registrar Nuevo Pago de Alquiler","Volver" };
					
					String operacionPagoSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
							"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, operacionesPagos,
							operacionesPagos[0]);
					
					if(operacionPagoSeleccionado.equals("Registrar Nuevo Pago de Venta")){
						JOptionPane.showMessageDialog(null, "Completar y verificar datos de la venta");
						
					}else if(operacionPagoSeleccionado.equals("Registrar Nuevo Pago de Alquiler")){
						JOptionPane.showMessageDialog(null, "Completar y verificar datos del alquiler");  

					}else {
						break;
					}
					
					
				} while (repetir);
	
				break;
				
			case "Cargar Nuevo Documento":
				do {
					String[] opciones = { "Cargar Contrato","Cargar Escritura","Cargar otro archivo","Volver" };
					
					String opcionSeleccionada3 = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
							"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, opciones,
							opciones[0]);
					
					if(opcionSeleccionada3.equals("Cargar Contrato")){
						JOptionPane.showMessageDialog(null, "Adjuntar contrato");
						
					}else if(opcionSeleccionada3.equals("Cargar Escritura")){
						JOptionPane.showMessageDialog(null, "Adjuntar escritura");  

					}else if(opcionSeleccionada3.equals("Cargar otro archivo")){
						JOptionPane.showMessageDialog(null, "Adjuntar otro archivo");  

					}else {
						break;
					}
		
					
				} while (repetir);
	
				break;
	
	
			case "Ver Ultimas Operaciones":
				do {
					String[] ultimasOperaciones = { "Operacion1","Operacion2","Operacion3","Volver" };
					
					String UltimasOperacionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
							"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, ultimasOperaciones,
							ultimasOperaciones[0]);
					
					if(UltimasOperacionSeleccionada.equals("Operacion1")){
						do {
							String[] operaciones2 = {"Modificar Operacion","Ver Operacion","Eliminar Operacion","Volver" };
							
							String operacionSeleccionada2 = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
									"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, operaciones2,
									operaciones2[0]);
						
							if(operacionSeleccionada2.equals("Modificar Operacion")){
								JOptionPane.showMessageDialog(null, "Modificar");
								
							}else if(operacionSeleccionada2.equals("Ver Operacion")){
								JOptionPane.showMessageDialog(null, "Ver");
								
							}else if(operacionSeleccionada2.equals("Eliminar Operacion")){
								JOptionPane.showMessageDialog(null, "Eliminar");
								
							}else {
								break;
							}
							
						} while (repetir);
						
					}else if(UltimasOperacionSeleccionada.equals("Operacion2")){
						do {
							String[] operaciones2 = {"Modificar Operacion","Ver Operacion","Eliminar Operacion","Volver" };
							
							String operacionSeleccionada2 = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
									"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, operaciones2,
									operaciones2[0]);
						
							if(operacionSeleccionada2.equals("Modificar Operacion")){
								JOptionPane.showMessageDialog(null, "Modificar");
								
							}else if(operacionSeleccionada2.equals("Ver Operacion")){
								JOptionPane.showMessageDialog(null, "Ver");
								
							}else if(operacionSeleccionada2.equals("Eliminar Operacion")){
								JOptionPane.showMessageDialog(null, "Eliminar");
								
							}else {
								break;
							}
							
						} while (repetir);

						
					}else if(UltimasOperacionSeleccionada.equals("Operacion3")){
						do {
							String[] operaciones2 = {"Modificar Operacion","Ver Operacion","Eliminar Operacion","Volver" };
							
							String operacionSeleccionada2 = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
									"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, operaciones2,
									operaciones2[0]);
						
							if(operacionSeleccionada2.equals("Modificar Operacion")){
								JOptionPane.showMessageDialog(null, "Modificar");
								
							}else if(operacionSeleccionada2.equals("Ver Operacion")){
								JOptionPane.showMessageDialog(null, "Ver");
								
							}else if(operacionSeleccionada2.equals("Eliminar Operacion")){
								JOptionPane.showMessageDialog(null, "Eliminar");
								
							}else {
								break;
							}
							
						} while (repetir);
						
						
					}else {
						break;
					}
		
				} 
				
				while (repetir);
	
				break;
			
			case "Gestionar Empleados":
				do {
					String[] gestionEmpleados = {"Ver Lista Empleados","Agregar Nuevo Empleado","Volver"};
					
					String gestionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
							"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, gestionEmpleados,
							gestionEmpleados[0]);
				
					if(gestionSeleccionada.equals("Ver Lista Empleados")){
						
						do {
							
							String[] gestionEmpleados2 = {"Ver Datos Empleado","Modificar Empleado","Agregar empleado","Eliminar Empleado","Volver"};
							
							String gestionSeleccionada2 = (String) JOptionPane.showInputDialog(null, "Seleccione una operación:",
									"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, gestionEmpleados2,
									gestionEmpleados2[0]);
							
/* --------------------- */    if(gestionSeleccionada2.equals("Ver Datos Empleado")){ /* ---------------------------------------------------------------------------------*/
								int seleccionopcion =0;
							do {
								String[] lista = {"Ver Agentes","Ver gerentes","Salir"};
	
								seleccionopcion = JOptionPane.showOptionDialog(null, "Elegir opcion", null, 0, 0, null, lista, lista[0]);
	
								switch(seleccionopcion) {
								
								case 0:
									
								SelectorAgentes();
								
								break;
								
								case 1:
									
								seleccionarGerentes();
								
								break;
								
								
								case 2:
									
									break;
								}}while(seleccionopcion!=2);
								
	
								
								
								
	/* -------------------------------------------------------MODIFICAR EMPLEADO---------------------------------------------------------------------------------------------------------------------------------------------*/							
							}else if(gestionSeleccionada2.equals("Modificar Empleado")){
							
								String[] lista = {"Modificar agente","Modificar gerente","Salir"};
								
								int seleccion = JOptionPane.showOptionDialog(null, "Ingresar opciones", "Gestor de empleados",0 , 0 , null, lista, lista[0]);
								
								switch (seleccion) {
								case 0:
									//ModificarAgente();
									
									break;
									
								case 1:
									ModificarGerente();
									
									break;

								case 2: //Salir									
									break;
								default:
									break;
								}
								
								
								
								
	/* ----------------------------------------------------------------------------------- FIN MODIFICAR EMPLEADO --------------------------------------------------------------------------------------------------------*/								
								
	/* --------------------------------------------------------------------ELIMINAR EMPLEADO-------------------------------------------------------------------------------------------------------------------------------*/							
								
							}else if(gestionSeleccionada2.equals("Eliminar Empleado")){
								
								String[] lista = {"Eliminar Agentes","Eliminar gerentes","Salir"};
								
							int	seleccionopcion = JOptionPane.showOptionDialog(null, "Elegir opcion", null, 0, 0, null, lista, lista[0]);
								
							switch (seleccionopcion) {

							case 0:
							//EliminarAgente();
							break;
							
							case 1:
								
								EliminarGerente();
								
								break;
							
							case 2: 
								
								break;
								
								
								
							}
							
										
							}else {
								break;
							}
							
						}while(repetir);
								
/*-----------------------------------------------------------------------------Agregar empleado --------------------------------------------------------------------------------------------------------------------------- */
					}else if(gestionSeleccionada.equals("Agregar Nuevo Empleado")){ 
						
					String[] OpcionesAgregar = {"Agregar Agente", "Agregar Gerente", "Salir"};	
						
					int Agregarseleccion = JOptionPane.showOptionDialog(null,"Elegir opcion", null, 0, 0, null, OpcionesAgregar, OpcionesAgregar[0]);
					
					switch (Agregarseleccion) {
					case 0:
						
						//AgregarAgente();
						
						break;

					case 1:
						
						AgregarGerente();
						
						break;
						
					case 2:
						
						break;
						
					default:
						break;
					}
					
										
						// Funciona 0 Porque es AI en la base de  datos y id_agente deberia ser AI tambien actualmente no lo es.

						
/*-----------------------------------------------------------------------------Fin Agregar empleado ---------------------------------------------------------------------------------------------------------------------- */
						
					}else {
						break;
					}
					
				} while (repetir);
				break;
			
			case "Cerrar Sesion":
				JOptionPane.showMessageDialog(null, "Sesion cerrada, Hasta luego!");
				repetir = false;
				break;

			case "Salir":
				System.exit(0);
				break;
	
			default:
				break;
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
		}
			
		} while (repetir);
		
		return true;
	}
	
	

	
	
	
// --------------------------------------------------------TODO INMUEBLES-----------------------------------------------------------
	
	//-----------------------------------------ACTIVAR INMUEBLE --------------------------------------	
	
		public boolean activarInmueble() { // solo activamos la lista de inmuebles cargados por agente 
			boolean repetir;

		do {
			repetir =true;
		
		try {
			
			int count = 0; // cuenta los inmuebles inactivos 
		    for (Inmueble inmueble : inmuebleControlador.getAllInmueble()) {
		        if (!inmueble.isActivo()) {
		            count++;
		        }
		    }

		    if (count == 0) {
		        JOptionPane.showMessageDialog(null, "No hay Inmuebles inactivos cargados");
			    repetir = false;
			    continue;	
		    }

		    
		    String[] opcionesInmuebles = new String[count];
		    int index = 0;
		    for (Inmueble inmueble : inmuebleControlador.getAllInmueble()) {
		        if (!inmueble.isActivo()) {
		            opcionesInmuebles[index++] = "ID Inmueble: " + inmueble.getId_inmueble() +
		            							 " - Dirección: " + inmueble.getDireccion() +
		                                         " - Ambientes: " + inmueble.getCantAmbientes();
		        }
		    }		    
		    
			opcionesInmuebles[opcionesInmuebles.length - 1] = "Volver";
	    
		    String inmuebleSeleccionado = (String) JOptionPane.showInputDialog(null,
		            "Seleccione Inmueble para activar","Activar Inmueble", JOptionPane.QUESTION_MESSAGE,null, opcionesInmuebles,
		            opcionesInmuebles[0]);
		    
		    
            if (inmuebleSeleccionado.equals("Volver")) {
                repetir = true; 
                continue;
            }

		     for (Inmueble inmueble : inmuebleControlador.getAllInmueble()) {
		          String opcion = "ID Inmueble: " + inmueble.getId_inmueble() +
		                          " - Dirección: " + inmueble.getDireccion() +
		                          " - Ambientes: " + inmueble.getCantAmbientes();
		          
		          if (opcion.equals(inmuebleSeleccionado)) {	            	
		        	  boolean activo = obtenerActivo();
		            	
		            if(activo){	            		
		            	inmueble.setActivo(true);
		            	inmuebleControlador.updateInmueble(inmueble);
		            	JOptionPane.showMessageDialog(null, "El inmueble ha sido activado Correctamente");	            		
		            }else {
		            	JOptionPane.showMessageDialog(null, "El inmueble no ha sido activado");
		            }
		          }	        
		    }	
		    
		} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
            repetir=false;
			}
		
		} while (!repetir);
		
		return true;
	}
		
	
	// ---------------------------LISTA INMUEBLES DISPONIBLES---------------------------
		public boolean verInmueblesDisponibles() {	
			boolean repetir;
			
			do {
				repetir = false;
				
			try {
				
				int count = 0; // cuenta los inmuebles activos y disponibles
				for (Inmueble inmueble : inmuebleControlador.getAllInmueble()) {
				    if (inmueble.isActivo() && inmueble.isDisponible()) {
				        count++;
				    }
				}
				
				if (count == 0) { // verificar si hay inmuebles disponibles 
				    JOptionPane.showMessageDialog(null, "No hay Inmuebles activos y disponibles cargados");
				    repetir = true;
				    continue;	
				}
				
				String[] opcionesInmuebles = new String[count]; // array con las opciones de inmuebles disponibles
				int index = 0;
				for (Inmueble inmueble : inmuebleControlador.getAllInmueble()) {
				    if (inmueble.isActivo() && inmueble.isDisponible()) {
				        opcionesInmuebles[index++] = "ID Inmueble: " + inmueble.getId_inmueble() +
				                                     " - Dirección: " + inmueble.getDireccion() +
				                                     " - Ambientes: " + inmueble.getCantAmbientes();
				    }
				}
				
				opcionesInmuebles[opcionesInmuebles.length - 1] = "Volver";
	
				
				//mostramos los inmuebles disponibles
				String inmuebleSeleccionado = (String) JOptionPane.showInputDialog(null,"Seleccione Inmueble", "Visualizar Inmueble",
				        JOptionPane.INFORMATION_MESSAGE,null,opcionesInmuebles, opcionesInmuebles[0]);
				
	            if (inmuebleSeleccionado.equals("Volver")) {
	                repetir = true; 
	                continue;
	            }
				
				//mostramos el inmueble seleccionado
				if (inmuebleSeleccionado != null) {
				    for (Inmueble inmueble : inmuebleControlador.getAllInmueble()) {
				        String opcion = "ID Inmueble: " + inmueble.getId_inmueble() +
				                        " - Dirección: " + inmueble.getDireccion() +
				                        " - Ambientes: " + inmueble.getCantAmbientes();
				        if (opcion.equals(inmuebleSeleccionado)) {
				            JOptionPane.showMessageDialog(null, 
				            		"Datos del Inmueble:\n" + inmueble.toString(),"Datos del Inmueble",JOptionPane.INFORMATION_MESSAGE);
				        }
				    }
				}
			} catch (Exception e) {
		            JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
				}
			} while (!repetir);
			return true;
		}
			

	// ---------------------------VER INMUEBLES---------------------------
		public boolean verInmuebles() {
			boolean repetir;
			do {
				
				repetir = false;
				
				try {
		
				if(inmuebleControlador.getAllInmueble().isEmpty()){
					JOptionPane.showMessageDialog(null, "No hay Inmuebles cargados" );
					repetir = true;
					continue;		
				}	
			
				String[] opcionesInmuebles = new String[inmuebleControlador.getAllInmueble().size()];
				for (int i = 0; i < opcionesInmuebles.length; i++) {
				Inmueble inmueble = inmuebleControlador.getAllInmueble().get(i);
				opcionesInmuebles[i] = "ID Inmueble: " + inmueble.getId_inmueble() + " - Dirección: " + inmueble.getDireccion()+ " - Ambientes: " +inmueble.getCantAmbientes();					
				}
						
				opcionesInmuebles[opcionesInmuebles.length - 1] = "Volver";

				String inmuebleSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione Inmueble", "Visualizar Inmueble",
				JOptionPane.QUESTION_MESSAGE, null, opcionesInmuebles, opcionesInmuebles[0]);
						
				
	            if (inmuebleSeleccionado.equals("Volver")) {
	                repetir = true; 
	                continue;
	            }
				
				if(inmuebleSeleccionado !=null){
					Inmueble inmuebleAmostrar = null;
				for (Inmueble inmueble : inmuebleControlador.getAllInmueble()) {
				String opcion = "ID Inmueble: " + inmueble.getId_inmueble() + " - Dirección: " + inmueble.getDireccion()+ " - Ambientes: " +inmueble.getCantAmbientes();
								
				if(opcion.equals(inmuebleSeleccionado)){
					inmuebleAmostrar=inmueble;
					}      
				}
							
				if(inmuebleAmostrar !=null){
					JOptionPane.showMessageDialog(null, "Datos del Inmueble:\n" + inmuebleAmostrar.toString(), "Datos del Inmueble", JOptionPane.INFORMATION_MESSAGE);		
					}
				} 
			
				} catch (Exception e) {
	            	JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
				}
			} while (!repetir);
			
			return true;

		} 
	
	
	
//-----------------------------------------MODIFICAR INMUEBLE --------------------------------------
	
	public boolean modificarInmueble() {
		boolean repetir;
		
		do {		
			repetir = false;
					
		try {

			if(inmuebleControlador.getAllInmueble().isEmpty()){
				JOptionPane.showMessageDialog(null, "No hay Inmuebles cargados");
				repetir = true;
				continue;
			}
			
			String[] opcionesInmuebles = new String[inmuebleControlador.getAllInmueble().size()];
			for (int i = 0; i < opcionesInmuebles.length; i++) {
				Inmueble inmueble = inmuebleControlador.getAllInmueble().get(i);				
				opcionesInmuebles[i] = "ID Inmueble: " + inmueble.getId_inmueble() + " - Dirección: " + inmueble.getDireccion()+ " - Ambientes: " +inmueble.getCantAmbientes();		
			
			}		
			opcionesInmuebles[opcionesInmuebles.length - 1] = "Volver";

			String inmuebleSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione Inmueble", "Modificar Inmueble",
					JOptionPane.QUESTION_MESSAGE, null, opcionesInmuebles, opcionesInmuebles[0]);
			
            if (inmuebleSeleccionado.equals("Volver")) {
                repetir = true; 
                continue;
            }
			
            Inmueble inmuebleAmodificar = null;
            
			if(inmuebleSeleccionado !=null){
				for (Inmueble inmueble : inmuebleControlador.getAllInmueble()) {
					String opcion = "ID Inmueble: " + inmueble.getId_inmueble() + " - Dirección: " + inmueble.getDireccion()+ " - Ambientes: " +inmueble.getCantAmbientes();							
					
					if(opcion.equals(inmuebleSeleccionado)){
						inmuebleAmodificar=inmueble;
						break;
						}      
					}			
		
	            if(inmuebleAmodificar !=null){	        
	            	
	            	boolean repetir2;
	            	
	            do {
	            	repetir2 = false;
	            	
	            try {
					String[] opcionesModificar = { "Tipo de Inmueble","Condición","Cantidad de Ambientes","Barrio","Dirección","Descripcion",
							"Años Antiguedad","Cantidad de Baños","Cantidad de Dormitorios","m2 Superficie Cubierta",
							"Precio","Disponibilidad actual","Refacción","Apto para Mascotas","Patio","Activar/Deshabilitar Inmueble","Volver"};
						
					String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione un atributo para Modificar:",
							"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, opcionesModificar,
							opcionesModificar[0]);		
								
				if(opcionSeleccionada.equals("Tipo de Inmueble")){
					String tipoInmueble = obtenerTipoInmueble();
					inmuebleAmodificar.setTipo_inmueble(tipoInmueble);
					JOptionPane.showMessageDialog(null, "Tipo de Inmueble actualizado");
					
					 if (!tipoInmueble.equals("Departamento")) {
                         inmuebleAmodificar.setPiso(null);
                         
                     }else {
                    	String piso = null;
             	    	piso = validarEntero("Ingrese el numero de piso donde se encuentra el Departamento");
                         inmuebleAmodificar.setPiso(piso);
                     }										
					
				}else if(opcionSeleccionada.equals("Condición")){
					String condicion = obtenerCondicion();
					inmuebleAmodificar.setCondicion(condicion);
					JOptionPane.showMessageDialog(null, "Tipo de Condicion actualizada");
					
					
				}else if(opcionSeleccionada.equals("Cantidad de Ambientes")){					
					String cantAmbientes = null;
					cantAmbientes = validarEntero("Ingrese la cantidad de Ambientes que tiene el Inmueble");
					inmuebleAmodificar.setCantAmbientes(cantAmbientes);		
					JOptionPane.showMessageDialog(null, "Cantidad de Ambientes Actualizada");
					
					
				}else if(opcionSeleccionada.equals("Barrio")){
					String barrio = obtenerBarrio();
					inmuebleAmodificar.setBarrio(barrio);
					JOptionPane.showMessageDialog(null, "Barrio Actualizado!");
					
					
				}else if(opcionSeleccionada.equals("Dirección")){
					String direccion = null;
					direccion = validarCadena("Ingrese la dirección");
					inmuebleAmodificar.setDireccion(direccion);
					JOptionPane.showMessageDialog(null, "Dirección Actualizada");

					
				}else if(opcionSeleccionada.equals("Descripcion")){
					String descripcion = null;
					descripcion = validarCadena("Ingrese una descripción del inmueble");
					inmuebleAmodificar.setDescripcion(descripcion);
					JOptionPane.showMessageDialog(null, "Descripcion Actualizada");

					
				}else if(opcionSeleccionada.equals("Años Antiguedad")){
					String antiguedad = null;
					antiguedad = validarEntero("Ingrese la antiguedad que tiene el inmueble");
					inmuebleAmodificar.setAntiguedad(antiguedad);
					JOptionPane.showMessageDialog(null, "Antiguedad actualizada");

					
				}else if(opcionSeleccionada.equals("Cantidad de Baños")){
					String banios = null;
					banios = validarCadena("Ingrese la cantidad de baños ");
					inmuebleAmodificar.setBanio(banios);
					JOptionPane.showMessageDialog(null, "Cantidad de baños Actualizada");

					
				}else if(opcionSeleccionada.equals("Cantidad de Dormitorios")){
					String dormitorio = null;
					dormitorio = validarCadena("Ingrese la cantidad de dormitorios");
					inmuebleAmodificar.setDormitorio(dormitorio);
					JOptionPane.showMessageDialog(null, "Cantidad de dormitorios Actualizada");

					
				}else if(opcionSeleccionada.equals("m2 Superficie Cubierta")) {
					double superficieCubierta = 0;
					superficieCubierta = validarDouble("Ingrese la cantidad la cantidad de m2 de superficie cubierta");
					inmuebleAmodificar.setSuperficie_cubierta(superficieCubierta);	
					JOptionPane.showMessageDialog(null, "m2 cubierta Actualizada");


				}else if(opcionSeleccionada.equals("Patio")){
					boolean tienePatio = obtenerPatio();	

					if(tienePatio==true){
						double superficieDescubierta = validarDouble("Ingrese la cantidad la cantidad de m2 de superficie descubierta");
						inmuebleAmodificar.setSuperficie_descubierta(superficieDescubierta);					
					}else {
						inmuebleAmodificar.setSuperficie_descubierta(0);
					}			
	
				}else if(opcionSeleccionada.equals("Precio")){
					double precio = 0;
					precio = validarDouble("Ingrese el precio del Inmueble");
					inmuebleAmodificar.setPrecio(precio);					
					JOptionPane.showMessageDialog(null, "Precio actualizado");

					
				}else if(opcionSeleccionada.equals("Disponibilidad actual")){
					boolean disponible = obtenerDisponible();
				    inmuebleAmodificar.setDisponible(disponible);

				    
				}else if(opcionSeleccionada.equals("Refacción")){
					boolean refaccionar = obtenerRefaccion().equals("Si");
					inmuebleAmodificar.setRefaccionar(refaccionar);				

					
				}else if(opcionSeleccionada.equals("Apto para Mascotas")){
					boolean aptoMascota = obtenerMascota().equals("Si");
					inmuebleAmodificar.setApto_mascota(aptoMascota);						
					
					
				}else if(opcionSeleccionada.equals("Activar/Deshabilitar Inmueble")){
					   boolean activo = obtenerActivo();
					    inmuebleAmodificar.setActivo(activo);
					    
				}else {
					break;
				}
				 inmuebleControlador.updateInmueble(inmuebleAmodificar);
                 JOptionPane.showMessageDialog(null, "Inmueble actualizado exitosamente");
        		
	            } catch (Exception e) {
	            	JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
	            }
	            
	            }while(!repetir2);
	            
		            	}
					
				}
			
			} catch (Exception e) {
            	JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
				
				}
		}while(!repetir);
			
		return true;
	}


//-----------------------------------------AGREGAR NUEVO INMUEBLE --------------------------------------
	public void agregarInmueble() {
		String descripcion = null;
		String piso = null; 
		String cantAmbientes = null;
		String antiguedad = null;
		String banios = null;
		String dormitorios= null;
		String direccion = null;
		String dormitorio = null;
		String tipoInmueble = obtenerTipoInmueble();
		String condicion = obtenerCondicion();
		double precio =0;
		double superficieCubierta = 0;
		double superficieDescubierta = 0;
		
		 cantAmbientes = validarEntero("Ingrese la cantidad de Ambientes que tiene el Inmueble");
	    if (tipoInmueble.equals("Departamento")) {
	    	piso = validarEntero("Ingrese el numero de piso donde se encuentra el Departamento");
	    }
		String barrio = obtenerBarrio();
		direccion = validarCadena("Ingrese la dirección");
		descripcion = validarCadena("Ingrese una descripción del inmueble");
		antiguedad = validarEntero("Ingrese la antiguedad que tiene el inmueble");
		banios = validarEntero("Ingrese la cantidad baños que tiene el inmueble");
		dormitorio = validarEntero("Ingrese la cantidad dormitorios que tiene el inmueble");
		superficieCubierta = validarDouble("Ingrese la cantidad la cantidad de m2 de superficie cubierta");
		
		boolean tienePatio = obtenerPatio();
		if(tienePatio==true){
			superficieDescubierta = validarDouble("Ingrese la cantidad la cantidad de m2 de superficie descubierta");
		}
		precio = validarDouble("Ingrese el precio del Inmueble");
		boolean disponible = obtenerDisponible();
		boolean refaccionar = obtenerRefaccion().equals("Si");
		boolean aptoMascota = obtenerMascota().equals("Si");
		boolean activo = obtenerActivo();
		
		    // Agregar el inmueble al controlador
		    inmuebleControlador.addInmueble(new Inmueble(0, tipoInmueble, condicion, cantAmbientes, piso,barrio, direccion, descripcion, antiguedad,
		            banios, dormitorio, superficieCubierta, superficieDescubierta, precio, disponible, refaccionar, aptoMascota, tienePatio,activo));
		}
	
	
	
	
	//-------------metodos para obtener los datos de Inmueble-----------------------------------------------------------------
	
	public String obtenerTipoInmueble() {
		String[] tipoInmueble = { "Casa","Departamento"};
		String seleccion = null;

		do {
			
			try {
				seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de Inmueble:",
						"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, tipoInmueble, tipoInmueble[0]);
				
				if(seleccion ==null){
		    		JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
		    	}else {
		    		return seleccion;
		    	}
				
			} catch (Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error! Porfavor Seleccione una opción valida.");
	
			}
			
		} while (true);
	    
	}
	

	
//-------------------------------------	
	public String obtenerCondicion() {
		String[] tipoInmueble = { "Excelente","Muy bueno","Bueno","Regular","Malo"};
		String seleccion = null;
   
		do {
				
			try {
				seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de condición del Inmueble:",
						"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, tipoInmueble, tipoInmueble[0]);
				
				if(seleccion ==null){
		    		JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
		    	}else {
		    		return seleccion;
		    	}
				
			} catch (Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error! Porfavor Seleccione una opción valida.");
	
			}
			
		} while (true);
    
	}
	
	
//--------------------------------------	
	public String obtenerBarrio() {
		String[] barrio = {"Agronomía", "Almagro", "Balvanera", "Barracas", "Belgrano", "Boedo", "Caballito", "Chacarita",
				"Coghlan", "Colegiales", "Constitución", "Flores", "Floresta", "La Boca", "La Paternal", "Liniers",
				"Mataderos", "Monte Castro", "Monserrat", "Nueva Pompeya", "Núñez", "Palermo", "Parque Avellaneda",
				"Parque Chacabuco", "Parque Chas", "Parque Patricios", "Puerto Madero", "Recoleta", "Retiro",
				"Saavedra", "San Cristóbal", "San Nicolás", "San Telmo", "Vélez Sársfield", "Versalles",
				"Villa Crespo", "Villa del Parque", "Villa Devoto", "Villa General Mitre", "Villa Lugano",
				"Villa Luro", "Villa Ortúzar", "Villa Pueyrredón", "Villa Real", "Villa Riachuelo",
				"Villa Santa Rita", "Villa Soldati", "Villa Urquiza"};
	    String seleccion = null;
		
		do {
			
			
			try {
				seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione el Barrio",
						"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, barrio, barrio[0]);
				
				if(seleccion ==null){
		    		JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
		    	}else {
		    		return seleccion;
		    	}
				
			} catch (Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error! Porfavor Seleccione una opción valida.");
	
			}
			
		} while (true);
		
			
	}
	
	public String obtenerPiso() {
	    return JOptionPane.showInputDialog("Ingrese en que piso se encuentra el Departamento");
	}
	
//---------------------------	
	public boolean obtenerDisponible() {
	    String[] disponibleSeleccion = { "Si","No"};
	    String seleccion = null;
	    boolean confirmacion = false;
	    
	    do {		
		    try {
		    	 seleccion = (String) JOptionPane.showInputDialog(null, "¿El inmueble esta Disponible para poder Ser reservado?",
		    			"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, disponibleSeleccion, disponibleSeleccion[0]);
		    	 
		    	if(seleccion ==null){
		    		JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
		    	}else {
		    		confirmacion = true;
		    	}
				
			} catch (Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error! Porfavor Seleccione una opción valida.");
	
			}
	    
	    } while (confirmacion == false);
	    
	    // Si la selección es "Si", devolvemos true, de lo contrario, devolvemos false
	    return seleccion.equals("Si");
	}
	
//-----------------------------------------
	public boolean obtenerActivo() {
	    String[] activoSeleccion = { "Si","No"};
	    String seleccion = null;
	    boolean confirmacion = false;
	   
	    do {		
		    try {
			     seleccion = (String) JOptionPane.showInputDialog(null, "¿Desea habilitar el Inmueble?",
				            "Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, activoSeleccion, activoSeleccion[0]);
		    	 
		    	if(seleccion ==null){
		    		JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
		    	}else {
		    		confirmacion = true;
		    	}
				
			} catch (Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error! Porfavor Seleccione una opción valida.");
	
			}
	    
	    } while (confirmacion == false);
	    
	    // Si la selección es "Si", devolvemos true, de lo contrario, devolvemos false
	    return seleccion.equals("Si");
	}
//---------------------------
	


	
	public String obtenerRefaccion() {
		String[] refaccionSeleccion = { "Si","No"};
		String seleccion = null;
	    
		do {
			
			try {
				seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione si hay que Refaccionar:",
						"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, refaccionSeleccion, refaccionSeleccion[0]);
				
				if(seleccion ==null){
		    		JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
		    	}else {
		    		return seleccion;
		    	}
				
			} catch (Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error! Porfavor Seleccione una opción valida.");
	
			}
			
		} while (true);
    
	}

	
	
//---------------------------		
	public boolean obtenerPatio() {
		
		String[] patioSeleccion = { "Si","No"};
		String seleccion = null;
		boolean confirmacion = false;
		do {		
			try {				
				seleccion = (String) JOptionPane.showInputDialog(null, "¿El inmueble tiene Patio?",
						"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, patioSeleccion, patioSeleccion[0]);
				
				if(seleccion ==null){
					JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
				}else {
					confirmacion = true;
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error! Porfavor Seleccione una opción valida.");
				
			}
			
		} while (confirmacion == false);
		
		    
	    // Si la selección es "Si", devolvemos true, de lo contrario, devolvemos false
	    return seleccion.equals("Si");
	}
//---------------------------
	
	
	public String obtenerMascota() {
		String[] mascotaSeleccion = { "Si","No"};

		String seleccion = null;
	    
		do {
			
			try {
				seleccion = (String) JOptionPane.showInputDialog(null, "¿Es apto para mascotas?",
						"Inmobiliaria Maguez | Menu Gerente", JOptionPane.DEFAULT_OPTION, null, mascotaSeleccion, mascotaSeleccion[0]);
				
				if(seleccion ==null){
		    		JOptionPane.showMessageDialog(null, "Porfavor Seleccione una opción valida.");
		    	}else {
		    		return seleccion;
		    	}
				
			} catch (Exception e) {
	    		JOptionPane.showMessageDialog(null, "Error! Porfavor Seleccione una opción valida.");
	
			}
			
		} while (true);
	    
	    
	}

	
	//-------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	public void eliminarInmueble() {
		
		if(inmuebleControlador.getAllInmueble().isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay Inmuebles cargados" );
		}else {
				
			JOptionPane.showMessageDialog(null, "Eliminar Inmueble");
			
		    String[] opcionesInmuebles = new String[inmuebleControlador.getAllInmueble().size()];
		    for (int i = 0; i < opcionesInmuebles.length; i++) {
	            Inmueble inmueble = inmuebleControlador.getAllInmueble().get(i);
	            opcionesInmuebles[i] = "ID Inmueble: " + inmueble.getId_inmueble() + " - Dirección: " + inmueble.getDireccion()+ " - Ambientes: " +inmueble.getCantAmbientes();
	        }
		       
		    String inmuebleSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione Inmueble a Eliminar", "Eliminar Inmueble",
		    		JOptionPane.QUESTION_MESSAGE, null, opcionesInmuebles, opcionesInmuebles[0]);
		   
		    if(inmuebleSeleccionado != null){
	            Inmueble inmuebleAEliminar = null;
	            // Buscar el inmueble seleccionado en la lista de inmuebles
	            for (Inmueble inmueble : inmuebleControlador.getAllInmueble()) {
	                String opcion = "ID Inmueble: " + inmueble.getId_inmueble() + " - Dirección: " + inmueble.getDireccion()+ " - Ambientes: " +inmueble.getCantAmbientes();
	                if (opcion.equals(inmuebleSeleccionado)) {
	                    inmuebleAEliminar = inmueble;
	                    break;
	                }
	            }
	            
	            if (inmuebleAEliminar != null) {
	                // Realizar la eliminación del inmueble
	                inmuebleControlador.deleteInmueble(inmuebleAEliminar.getId_inmueble());
	                JOptionPane.showMessageDialog(null, "Inmueble eliminado exitosamente");
	            }
		    }       
		}
	}
	
	
	
/* ---------------------------------------------------------------------------- Selector de Agentes ----------------------------------------------------------------------------------------- */	
	
	public void SelectorAgentes() {
		
		AgenteControlador agentecontrolador = new AgenteControlador();   	
		
		 /* desde aca */  //JOptionPane.showMessageDialog(null, "Empleado");
			
			String[] listaEmpleado = {"Ver empleados","seleccionar empleado","Salir"};
			
			int seleccionEmpleado = JOptionPane.showOptionDialog(null, "Elegir opcion", null, 0, 0, null, listaEmpleado, listaEmpleado[0]);
			
			switch(seleccionEmpleado) {
			
			case 0:  // Ver empleados
			
				 JOptionPane.showMessageDialog(null, "La lista de empleados"+"\n"+agentecontrolador.getAllAgente());	
				
			break;
			
			
			
/*---------------------------------*/  case 1: // Ver empleado por id /* ------------------------------------------------------------------------------------------------------------------------------------------------ */
		
	if (agentecontrolador.getAllAgente().size()==0) { JOptionPane.showMessageDialog(null, "No hay empleados registrados.");}
	else  {
		String[] empleados = new String[agentecontrolador.getAllAgente().size()];
			for (int i = 0; i < empleados.length; i++) {
			empleados[i] = Integer.toString(agentecontrolador.getAllAgente().get(i).getId_empleado());}
										
			
			String empleadoselect = (String) JOptionPane.showInputDialog(null, "Seleccione usuario", null, 0, null,
			empleados, empleados[0]);

				// JOptionPane.showMessageDialog(null, agentecontrolador.getAgenteById(Integer.parseInt(empleadoselect)));
					Agente seleccionado = agentecontrolador.getAgenteById(Integer.parseInt(empleadoselect));
					JOptionPane.showMessageDialog(null, "El agente seleccionado es:"+seleccionado.toString()); /* Recordar cambiar los nombres en el archivo princ */ }
				
				break;
				
			case 2: // Salir
				
				break;}}
	
	
/*----------------------------------------------------------------- Fin del metodo SelectorAgente ---------------------------------------------------------------------------------------------------------------------------*/	
	
	
/*-----------------------------------------------------------------------------SELECCIONAR GERENTES------------------------------------------------------------------------------------------------------------------------- */	
	
	public void seleccionarGerentes() {
		
		GerenteControlador gerentecontrolador = new GerenteControlador();
		
		
		String[] listaGerente = {"Ver gerentes","Seleccionar gerentes","Salir"};
		
		int seleccionGerente = JOptionPane.showOptionDialog(null,"Elegir opcion", null, 0, 0, null, listaGerente, listaGerente[0]);
		
		
		 switch(seleccionGerente) {
		 
		 
		 case 0: // Ver todos los gerentes.
			 
			if (gerentecontrolador.getAllGerente().size()>0) { 
			 JOptionPane.showMessageDialog(null, "La lista de empleados"+"\n"+gerentecontrolador.getAllGerente());} else {
			
				 JOptionPane.showMessageDialog(null, "No hay gerentes en la base de datos");}

		break;
		
		 case 1: // Ver gerente por id.
			 if(gerentecontrolador.getAllGerente().size()==0) {   JOptionPane.showMessageDialog(null, "No hay gerentes en la base de datos");}
			 else {
			 
			 String[] gerentes = new String[gerentecontrolador.getAllGerente().size()];
			 
			 for (int i = 0; i < gerentes.length; i++) {
				
				 gerentes[i] = Integer.toString(gerentecontrolador.getAllGerente().get(i).getId_empleado());
				 
			}
			 
			 String gerentesselect = (String) JOptionPane.showInputDialog(null,"seleccionar gerentes",null,0,null,gerentes,gerentes[0]);
			
				 Gerente gseleccionado = gerentecontrolador.getGerenteById(Integer.parseInt(gerentesselect));
			 JOptionPane.showMessageDialog(null, "El gerente seleccionado es: "+gseleccionado.toString());
			 }
		 
			 break;
			 
		 case 2: // Salir
			 
			 break;
		 
		 }
		 
	}
	
/* ---------------------------------------------------------------------------------------- AGREGAR GERENTES ----------------------------------------------------------------------------------------------------- */	
	
	
	public void AgregarGerente() {
		int dni = 0,telefono;	
		LocalDate fecha = null;
		String nombre="", apellido="" ,telefonoentrada="", contraseña;
		GerenteControlador gerentecontrolador = new GerenteControlador();
			
		//	JOptionPane.showMessageDialog(null, "Cargar datos");
			nombre =validarNombre("Escribir el nombre");
			apellido = validarNombre("Escribir el apellido");
			fecha = validarFecha(fecha);
			dni = validarDni("Validacion de dni");
			telefonoentrada = JOptionPane.showInputDialog("Ingresar telefono"); 
			telefono = validarTelefono(telefonoentrada);
			String correo = JOptionPane.showInputDialog(null, "Ingresar correo"); 
			String correoverificado = validarEmail(correo);
			String tipo_empleado = "Gerente"; 		
			do {
			contraseña = JOptionPane.showInputDialog("Ingresar password");
			} while(!validarContraseña(contraseña));
			int id_gerente = Integer.parseInt(JOptionPane.showInputDialog("Ingresar el id del gerente"));
		//	acumuladorgerentes++;
			gerentecontrolador.addGerente(new Gerente(0,nombre,apellido,fecha,dni,telefono,correoverificado,tipo_empleado,contraseña,id_gerente));
			
			
			
		}
	
	
/* ----------------------------------------------------------------------------------- ELIMINAR GERENTE ------------------------------------------------------------------------------------------------------------------ */	
	
	
	
	public void EliminarGerente() {
		
	
		
		GerenteControlador gerentecontrolador = new GerenteControlador();
		
		if (gerentecontrolador.getAllGerente().size()==0) {
			
			JOptionPane.showMessageDialog(null, "No se han encontrado agentes.");
			
		} else {
		
		String[] borrarempleado = new String[gerentecontrolador.getAllGerente().size()];
		for (int i = 0; i < borrarempleado.length; i++) {
			
		
			  Gerente gerente = gerentecontrolador.getAllGerente().get(i);
			    borrarempleado[i] = gerente.getId_empleado() + "  " + gerente.getNombre() + " " + gerente.getApellido() + "  " + gerente.getCorreo();
		   
		}
		
		try {
			String empleadoborrarselect = (String) JOptionPane.showInputDialog(null, "Seleccione usuario", null, 0, null,
					borrarempleado, borrarempleado[0]);
			
			int indiceSeleccionado = -1;

			for (int i = 0; i < borrarempleado.length; i++) {
		        if (borrarempleado[i].equals(empleadoborrarselect)) {
		            indiceSeleccionado = i; 
		        }
		    }
			

			 if (indiceSeleccionado != -1) {
			        
			 String idEmpleadoSeleccionado = Integer.toString(gerentecontrolador.getAllGerente().get(indiceSeleccionado).getId_empleado());

			 gerentecontrolador.deleteGerente((Integer.parseInt(idEmpleadoSeleccionado)));
			        
			        
			    } else {
			        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
			    }
			
			
		
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		
		}
		
	}
	
	
/* ----------------------------------------------------------------------------------- MODIFICAR GERENTE ----------------------------------------------------------------------------------------------------------------- */	
	
	
	
	
public void ModificarGerente() {
		
		GerenteControlador gerentecontrolador = new GerenteControlador();
		String contraseña;
		
		if (gerentecontrolador.getAllGerente().size()==0) {
			
			JOptionPane.showMessageDialog(null, "No se han encontrado gerentes.");
			
		} else {
		
	try {
		String[] empleados2 = new String[gerentecontrolador.getAllGerente().size()];
		for (int i = 0; i < empleados2.length; i++) {
			empleados2[i] = Integer.toString(gerentecontrolador.getAllGerente().get(i).getId_empleado());
		}
		String empleadoselect2 = (String) JOptionPane.showInputDialog(null, "Seleccione usuario", null, 0, null,
				empleados2, empleados2[0]);
		Gerente seleccionado = gerentecontrolador.getGerenteById(Integer.parseInt(empleadoselect2));
		
		LocalDate fecha = null;
		
		seleccionado.setNombre(validarNombre("Su nombre actual es: "+" "+seleccionado.getNombre()+" "+ "Ingrese el nuevo nombre: "));
		seleccionado.setApellido(validarNombre("Su apellido es: "+" "+seleccionado.getApellido()+" "+"Ingrese el nuevo apellido"));
		seleccionado.setFecha_nacimiento(validarFecha(fecha)); // Modificar despues
		seleccionado.setDni(validarDni("Su dni es: " +seleccionado.getDni()+"Ingrese el nuevo dni"));
		seleccionado.setTelefono(validarTelefono(JOptionPane.showInputDialog("Su telefono es: "+seleccionado.getTelefono()+"Ingrese el telefono")));
		seleccionado.setCorreo(validarEmail(JOptionPane.showInputDialog("Su correo es: "+seleccionado.getCorreo()+"Ingrese el nuevo correo")));

		seleccionado.setId_gerente(Integer.parseInt(JOptionPane.showInputDialog("Su id de agente es: "+seleccionado.getId_gerente()+"Ingrese el nuevo id de agente"))); // preguntarle a los chicos, si quieren que sea AI.
		
		do {
		contraseña = JOptionPane.showInputDialog("Ingresar la nueva contraseña");
		}while(!validarContraseña(contraseña));
		
		seleccionado.setContraseña((contraseña));
		gerentecontrolador.updateGerente(seleccionado);;
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Ocurrio un error"+e);}}}
	
	
	
	
	
	
	
	

	
}
