package ass.model.Model.Enum;

public enum Status {
	AVAILABLE(1),
	UNAVAILABLE(0);
	private int value;
	Status(int value){
		this.value=value;
	}
	public int getValue() {
		return value;
	}

	
	
}
