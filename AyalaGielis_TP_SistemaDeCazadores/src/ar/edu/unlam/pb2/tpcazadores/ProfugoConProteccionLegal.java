package ar.edu.unlam.pb2.tpcazadores;

public class ProfugoConProteccionLegal implements ProfugoInterfaz{
	private ProfugoInterfaz profugoBase;

	public ProfugoConProteccionLegal (ProfugoInterfaz profugoBase) {
		this.profugoBase = profugoBase;
	}

	@Override
	public Integer getInocencia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getHabilidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getNervioso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reducirInocencia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reducirHabilidad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNervioso(Boolean nervioso) {
		// TODO Auto-generated method stub
		
	}

}
