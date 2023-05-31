package Exercise7;

public class Field {

	private boolean primaryKey;
	private String name;
	private String type;
	
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
