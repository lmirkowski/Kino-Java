package pl.mirkowski.lukasz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrezerwacje;
	private String title;
	@Column(columnDefinition="date")
	private String data;
	private String godzina;
	private String nazwa_sali;
	private String imie;
	private String nazwisko;
	private String email;
	private int telefon;
	
	
	public int getIdrezerwacje() {
		return idrezerwacje;
	}
	public void setIdrezerwacje(int idrezerwacje) {
		this.idrezerwacje = idrezerwacje;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getNazwa_sali() {
		return nazwa_sali;
	}
	public void setNazwa_sali(String nazwa_sali) {
		this.nazwa_sali = nazwa_sali;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefon() {
		return telefon;
	}
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}
	public Reservation() {
		super();
	}
	public Reservation(String title, String data, String godzina, String nazwa_sali, String imie, String nazwisko,
			String email, int telefon) {
		super();
		this.title = title;
		this.data = data;
		this.godzina = godzina;
		this.nazwa_sali = nazwa_sali;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.telefon = telefon;
	}
	public Reservation(int idrezerwacje, String title, String data, String godzina, String nazwa_sali, String imie,
			String nazwisko, String email, int telefon) {
		super();
		this.idrezerwacje = idrezerwacje;
		this.title = title;
		this.data = data;
		this.godzina = godzina;
		this.nazwa_sali = nazwa_sali;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.telefon = telefon;
	}
	@Override
	public String toString() {
		return "Reservation [idrezerwacje=" + idrezerwacje + ", title=" + title + ", data=" + data + ", godzina="
				+ godzina + ", nazwa_sali=" + nazwa_sali + ", imie=" + imie + ", nazwisko=" + nazwisko + ", email="
				+ email + ", telefon=" + telefon + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((godzina == null) ? 0 : godzina.hashCode());
		result = prime * result + idrezerwacje;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((nazwa_sali == null) ? 0 : nazwa_sali.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + telefon;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Reservation other = (Reservation) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (godzina == null) {
			if (other.godzina != null)
				return false;
		} else if (!godzina.equals(other.godzina))
			return false;
		if (idrezerwacje != other.idrezerwacje)
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (nazwa_sali == null) {
			if (other.nazwa_sali != null)
				return false;
		} else if (!nazwa_sali.equals(other.nazwa_sali))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (telefon != other.telefon)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	

}
