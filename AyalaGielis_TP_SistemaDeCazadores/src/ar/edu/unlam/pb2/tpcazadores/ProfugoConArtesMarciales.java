package ar.edu.unlam.pb2.tpcazadores;

public class ProfugoConArtesMarciales implements ProfugoInterfaz{
	
	private ProfugoInterfaz profugoBase;

	public ProfugoConArtesMarciales (ProfugoInterfaz profugoBase) {
		this.profugoBase = profugoBase;
	}

	@Override
	public Integer getInocencia() {
		return null;
	}

	@Override
	public Integer getHabilidad() {
		return null;
	}

	@Override
	public Boolean getNervioso() {
		
		return null;
	}

	@Override
	public void reducirInocencia() {
		
		
	}

	@Override
	public void reducirHabilidad() {
		
		
	}

	@Override
	public void setNervioso(Boolean nervioso) {
		
		
	}

}
