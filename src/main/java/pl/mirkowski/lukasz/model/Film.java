package pl.mirkowski.lukasz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfilm;
	private String title;
	private String rezyser;
	@Column(name="rok_prod")
	private int rokProd;
	private String czas_trwania;
	private String kraj;
	@Column(columnDefinition="longtext")
	private String obsada;
	private String ogr_wiek;
	private String gatunek;
	@Column(columnDefinition="longtext")
	private String opis;
	
	public int getIdfilm() {
		return idfilm;
	}
	public void setIdfilm(int idfilm) {
		this.idfilm = idfilm;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRezyser() {
		return rezyser;
	}
	public void setRezyser(String rezyser) {
		this.rezyser = rezyser;
	}
	public int getRok_prod() {
		return rokProd;
	}
	public void setRok_prod(int rok_prod) {
		this.rokProd = rok_prod;
	}
	public String getCzas_trwania() {
		return czas_trwania;
	}
	public void setCzas_trwania(String czas_trwania) {
		this.czas_trwania = czas_trwania;
	}
	public String getKraj() {
		return kraj;
	}
	public void setKraj(String kraj) {
		this.kraj = kraj;
	}
	public String getObsada() {
		return obsada;
	}
	public void setObsada(String obsada) {
		this.obsada = obsada;
	}
	public String getOgr_wiek() {
		return ogr_wiek;
	}
	public void setOgr_wiek(String ogr_wiek) {
		this.ogr_wiek = ogr_wiek;
	}
	public String getGatunek() {
		return gatunek;
	}
	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Film() {
		super();
	}
	public Film(String title, String rezyser, int rok_prod, String czas_trwania, String kraj, String obsada,
			String ogr_wiek, String gatunek, String opis) {
		super();
		this.title = title;
		this.rezyser = rezyser;
		this.rokProd = rok_prod;
		this.czas_trwania = czas_trwania;
		this.kraj = kraj;
		this.obsada = obsada;
		this.ogr_wiek = ogr_wiek;
		this.gatunek = gatunek;
		this.opis = opis;
	}
	public Film(int idfilm, String title, String rezyser, int rok_prod, String czas_trwania, String kraj,
			String obsada, String ogr_wiek, String gatunek, String opis) {
		super();
		this.idfilm = idfilm;
		this.title = title;
		this.rezyser = rezyser;
		this.rokProd = rok_prod;
		this.czas_trwania = czas_trwania;
		this.kraj = kraj;
		this.obsada = obsada;
		this.ogr_wiek = ogr_wiek;
		this.gatunek = gatunek;
		this.opis = opis;
	}
	@Override
	public String toString() {
		return "Film [idfilm=" + idfilm + ", title=" + title + ", rezyser=" + rezyser + ", rok_prod=" + rokProd
				+ ", czas_trwania=" + czas_trwania + ", kraj=" + kraj + ", obsada=" + obsada + ", ogr_wiek=" + ogr_wiek
				+ ", gatunek=" + gatunek + ", opis=" + opis + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((czas_trwania == null) ? 0 : czas_trwania.hashCode());
		result = prime * result + ((gatunek == null) ? 0 : gatunek.hashCode());
		result = prime * result + (int) (idfilm ^ (idfilm >>> 32));
		result = prime * result + ((kraj == null) ? 0 : kraj.hashCode());
		result = prime * result + ((obsada == null) ? 0 : obsada.hashCode());
		result = prime * result + ((ogr_wiek == null) ? 0 : ogr_wiek.hashCode());
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + ((rezyser == null) ? 0 : rezyser.hashCode());
		result = prime * result + rokProd;
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
		Film other = (Film) obj;
		if (czas_trwania == null) {
			if (other.czas_trwania != null)
				return false;
		} else if (!czas_trwania.equals(other.czas_trwania))
			return false;
		if (gatunek == null) {
			if (other.gatunek != null)
				return false;
		} else if (!gatunek.equals(other.gatunek))
			return false;
		if (idfilm != other.idfilm)
			return false;
		if (kraj == null) {
			if (other.kraj != null)
				return false;
		} else if (!kraj.equals(other.kraj))
			return false;
		if (obsada == null) {
			if (other.obsada != null)
				return false;
		} else if (!obsada.equals(other.obsada))
			return false;
		if (ogr_wiek == null) {
			if (other.ogr_wiek != null)
				return false;
		} else if (!ogr_wiek.equals(other.ogr_wiek))
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (rezyser == null) {
			if (other.rezyser != null)
				return false;
		} else if (!rezyser.equals(other.rezyser))
			return false;
		if (rokProd != other.rokProd)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	

}
