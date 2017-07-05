package ComparatorOrdinateur;

public class Ordinateur {
	private int numinv,dd,ram;
	
	public Ordinateur(int numinv,int dd,int ram){
		this.numinv=numinv;
		this.dd=dd;
		this.ram=ram;
	}

	public int getNuminv() {
		return numinv;
	}

	public void setNuminv(int numinv) {
		this.numinv = numinv;
	}

	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Ordinateur [numinv=" + numinv + ", dd=" + dd + ", ram=" + ram + "]";
	}
	
	

}
