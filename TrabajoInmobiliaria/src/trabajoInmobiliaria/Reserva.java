package trabajoInmobiliaria;

import java.time.LocalDate;

public class Reserva {
	private int id_reserva;
	private int fk_inmueble;
	private int fk_cliente;
	private Inmueble inmueble;
	private Cliente cliente;
	private LocalDate fecha_pago;
	private double pago;
    private String forma_pago;
    private int fk_empleado;
    private Empleado empleado;
    
    
    
	public Reserva(int id_reserva, Inmueble inmueble, Cliente cliente, LocalDate fecha_pago, double pago,
			String forma_pago, Empleado empleado) {
		super();
		this.id_reserva = id_reserva;
		this.inmueble = inmueble;
		this.cliente = cliente;
		this.fecha_pago = fecha_pago;
		this.pago = pago;
		this.forma_pago = forma_pago;
		this.empleado = empleado;
	}

	
	public Reserva (int id_reserva, int fk_inmueble, int fk_cliente, LocalDate fecha_pago, double pago, String forma_pago, int fk_empleado) {
		
		
		this.id_reserva = id_reserva;
		this.fk_inmueble = fk_inmueble;
		this.fk_cliente = fk_cliente;
		this.fecha_pago = fecha_pago;
		this.pago = pago;
		this.forma_pago = forma_pago;
		this.fk_empleado = fk_empleado;
		
		
		
	}
	
	


	public int getFk_inmueble() {
		return fk_inmueble;
	}


	public void setFk_inmueble(int fk_inmueble) {
		this.fk_inmueble = fk_inmueble;
	}


	public int getFk_cliente() {
		return fk_cliente;
	}


	public void setFk_cliente(int fk_cliente) {
		this.fk_cliente = fk_cliente;
	}


	public int getFk_empleado() {
		return fk_empleado;
	}


	public void setFk_empleado(int fk_empleado) {
		this.fk_empleado = fk_empleado;
	}


	public int getId_reserva() {
		return id_reserva;
	}






	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}






	public Inmueble getInmueble() {
		return inmueble;
	}



	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public LocalDate getFecha_pago() {
		return fecha_pago;
	}



	public void setFecha_pago(LocalDate fecha_pago) {
		this.fecha_pago = fecha_pago;
	}



	public double getPago() {
		return pago;
	}



	public void setPago(double pago) {
		this.pago = pago;
	}



	public String getForma_pago() {
		return forma_pago;
	}



	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}



	public Empleado getEmpleado() {
		return empleado;
	}



	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 /* ------------------------------------------------------------------------------ CONSTRUCTOR VIEJO ------------------------------------------------------------------------------------------------------------ */   
 
	/*	private LocalDate fecha_expiracion; */
	/*	private Comprador comprador;
	private Inquilino inquilino; */
	/*private Boolean estadoreserva; */
	
	/*public Reserva(Inmueble inmueble, LocalDate fecha_reserva, LocalDate fecha_expiracion, double pago,
			Comprador comprador, Inquilino inquilino, Boolean estadoreserva) {
		super();
		this.inmueble = inmueble;
		this.fecha_reserva = fecha_reserva;       
		this.fecha_expiracion = fecha_expiracion; 
		this.pago = pago;
		this.comprador = comprador;
		this.inquilino = inquilino;               
		this.estadoreserva = estadoreserva;       
	}*/
	
	


	
	
}
