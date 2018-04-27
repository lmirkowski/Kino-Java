package pl.mirkowski.lukasz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seans {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idseans;
	@Column(columnDefinition="date")
	private String data;
	private String godzina;
	private int film_idfilm;
	private int sala_idsala;
	public int getIdseans() {
		return idseans;
	}
	public void setIdseans(int idseans) {
		this.idseans = idseans;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getGodzina() {
		return godzina;
	}
	public void setGodzina(String godzina) {
		this.godzina = godzina;
	}
	public int getFilm_idfilm() {
		return film_idfilm;
	}
	public void setFilm_idfilm(int film_idfilm) {
		this.film_idfilm = film_idfilm;
	}
	public int getSala_idsala() {
		return sala_idsala;
	}
	public void setSala_idsala(int sala_idsala) {
		this.sala_idsala = sala_idsala;
	}
	public Seans() {
		super();
	}
	public Seans(String data, String godzina, int film_idfilm, int sala_idsala) {
		super();
		this.data = data;
		this.godzina = godzina;
		this.film_idfilm = film_idfilm;
		this.sala_idsala = sala_idsala;
	}
	public Seans(int idseans, String data, String godzina, int film_idfilm, int sala_idsala) {
		super();
		this.idseans = idseans;
		this.data = data;
		this.godzina = godzina;
		this.film_idfilm = film_idfilm;
		this.sala_idsala = sala_idsala;
	}
	@Override
	public String toString() {
		return "Seans [idseans=" + idseans + ", data=" + data + ", godzina=" + godzina + ", film_idfilm=" + film_idfilm
				+ ", sala_idsala=" + sala_idsala + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + film_idfilm;
		result = prime * result + ((godzina == null) ? 0 : godzina.hashCode());
		result = prime * result + idseans;
		result = prime * result + sala_idsala;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seans other = (Seans) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (film_idfilm != other.film_idfilm)
			return false;
		if (godzina == null) {
			if (other.godzina != null)
				return false;
		} else if (!godzina.equals(other.godzina))
			return false;
		if (idseans != other.idseans)
			return false;
		if (sala_idsala != other.sala_idsala)
			return false;
		return true;
	}
	

}
