package assignment2;

public class Procedure {
	
	private String procedureName, procedureDate, practitionerName;
	private Double charges;
	
	public Procedure() {
		
	}
	
	public Procedure(String procedureName, String procedureDate) {
		
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
	}
	
	public Procedure(String procedureName, String procedureDate, String practitionerName, double charges) {
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
		this.practitionerName = practitionerName;
		this.charges = charges;
		
	}
	
//accessors & mutators
	
	public String getProcedureName() {
		return procedureName;
	}
	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	public String getProcedureDate() {
		return procedureDate;
	}
	public void setProcedureDate(String procedureDate) {
		this.procedureDate = procedureDate;
	}
	public String getPractitionerName() {
		return practitionerName;
	}
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}
	public Double getCharges() {
		return charges;
	}
	public void setCharges(Double charges) {
		this.charges = charges;
	}
// toString method
	@Override
	public String toString() {
		return "\tProcedure: " + procedureName + "\n\tProcedure Date: "+ procedureDate + "\n\tPractitioner: " + 
	            practitionerName + "\n\tCharge: $" + charges;
	}
	
}
