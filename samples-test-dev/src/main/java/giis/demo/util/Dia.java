package giis.demo.util;

import java.util.LinkedList;

import giis.demo.Proyecto.DTO.DiasDTO;

public class Dia {
	private int Dia;
	private String ini;
	private String fin;
	public Dia(int dia, String ini, String fin) throws Exception {
		super();
		
		//Comprobar que las horas son correctas 
		if(Integer.parseInt(ini.split(":")[0])>=Integer.parseInt(fin.split(":")[0])){
			throw new Exception(Integer.toString(dia));
		}
		Dia = dia;
		this.ini = ini.split(":")[0];
		this.fin = fin.split(":")[0];
	}
	
	
	public Dia(int dia) {
		super();
		
		//Comprobar que las horas son correctas 
		
		Dia = dia;
		
	}
	public int getDia() {
		return Dia;
	}
	public void setDia(int dia) {
		Dia = dia;
	}
	public String getIni() {
		return ini;
	}
	public void setIni(String ini) {
		this.ini = ini;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	
	@Override
	public String toString() {
		return "Dia [Dia=" + Dia + ", ini=" + ini + ", fin=" + fin + "]";
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static LinkedList<Dia> DTOtoListDia( LinkedList<DiasDTO> a){
		 LinkedList<Dia> dias = new LinkedList();
		a.toString();
		for(DiasDTO i : a){
			try {
				dias.add(new Dia(Integer.parseInt(i.getDia_sem()),i.getHora_ini(),i.getHora_fin()));
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("al fin "+dias);
			
		}
		return dias;
		
		
		
		
	}
}
