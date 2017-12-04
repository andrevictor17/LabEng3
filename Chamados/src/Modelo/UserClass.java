package Modelo;

/**
 * 
 */
public enum UserClass {
	CLIENT(1),
	CHAMADO(2);
	
	private final int value;
	
	UserClass(int value){
		this.value = value;
	}
	public int getValue(){
		return value;
	}
}