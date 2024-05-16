package trabajoInmobiliaria;

public class Inmueble {

	private int id_inmueble;
	private String localizacion;
	private double precio;
	private double tamaño;
	private int cantidadPersonas;
	private Propietario propietario;
	private String operacion; // Puede ser booleano
	private Ambiente ambiente;
	private String baños;
	private String Estado;
	private String lavadero;
	private String patio;
	private String dormitorios;
	private String cocina;
	
	
	
	public Inmueble(int id_inmueble, String localizacion, double precio, double tamaño, int cantidadPersonas,
			Propietario propietario, String operacion, Ambiente ambiente, String baños, String estado, String lavadero,
			String patio, String dormitorios, String cocina) {
		super();
		this.id_inmueble = id_inmueble;
		this.localizacion = localizacion;
		this.precio = precio;
		this.tamaño = tamaño;
		this.cantidadPersonas = cantidadPersonas;
		this.propietario = propietario;
		this.operacion = operacion;
		this.ambiente = ambiente;
		this.baños = baños;
		Estado = estado;
		this.lavadero = lavadero;
		this.patio = patio;
		this.dormitorios = dormitorios;
		this.cocina = cocina;
	}



	public int getId_inmueble() {
		return id_inmueble;
	}



	public void setId_inmueble(int id_inmueble) {
		this.id_inmueble = id_inmueble;
	}



	public String getLocalizacion() {
		return localizacion;
	}



	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public double getTamaño() {
		return tamaño;
	}



	public void setTamaño(double tamaño) {
		this.tamaño = tamaño;
	}



	public int getCantidadPersonas() {
		return cantidadPersonas;
	}



	public void setCantidadPersonas(int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}



	public Propietario getPropietario() {
		return propietario;
	}



	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}



	public String getOperacion() {
		return operacion;
	}



	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}



	public Ambiente getAmbiente() {
		return ambiente;
	}



	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}



	public String getBaños() {
		return baños;
	}



	public void setBaños(String baños) {
		this.baños = baños;
	}



	public String getEstado() {
		return Estado;
	}



	public void setEstado(String estado) {
		Estado = estado;
	}



	public String getLavadero() {
		return lavadero;
	}



	public void setLavadero(String lavadero) {
		this.lavadero = lavadero;
	}



	public String getPatio() {
		return patio;
	}



	public void setPatio(String patio) {
		this.patio = patio;
	}



	public String getDormitorios() {
		return dormitorios;
	}



	public void setDormitorios(String dormitorios) {
		this.dormitorios = dormitorios;
	}



	public String getCocina() {
		return cocina;
	}



	public void setCocina(String cocina) {
		this.cocina = cocina;
	}



	
	
	
	
	
	
	
	
}
