package com.PracticaSpringBoot.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "datper_persona")
public class PracspringbootPersona implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String cedula;

	private String apellidos;

	private String nombres;
	@Column(name = "correo_electronico")
	private String correoElectronico;

	private String provincia;

	private String canton;

	private String direcion;
//	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private String fechaNacimiento;

	private String telefono;

	public PracspringbootPersona() {
		super();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getDirecion() {
		return direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "PracspringbootPersona [cedula=" + cedula + ", apellidos=" + apellidos + ", nombres=" + nombres
				+ ", correoElectronico=" + correoElectronico + ", provincia=" + provincia + ",canton=" + canton
				+ ",direccion=" + direcion + ",correoElectronico=" + correoElectronico + ",telefono=" + telefono + "]";
	}
}
