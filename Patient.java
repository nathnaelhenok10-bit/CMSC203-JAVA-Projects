package assignment2;
public class Patient {
		//only zip code is an int
	
		private String firstName, middleName, lastName, address, city, state, emergencyName, emergencyCont;
		private int zipCode;
		
		public Patient() {
			
		}
		
		public Patient (String firstName, String middleName, String lastName) {
			
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
		}
		
		public Patient (String firstName, String middleName, String lastName, String address, String city, String state, int zipCode, String emergencyName, String emergencyCont) {
			
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zipCode = zipCode;
			this.emergencyName = emergencyName;
			this.emergencyCont = emergencyCont;
		}
		
//accessor & mutators
		public String getFirstName() {
			return firstName;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleName() {
			return middleName;
		}
		
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getLastName() {
			return lastName;
		}
		
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getAddress() {
			return address;
		}
		
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city; 
		}
		
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state; 
		}
		public void setState(String state) {
			this.state = state;
		}
		public int getZipCode() {
			return zipCode; 
		}
		
		public void setZipCode(int zipCode) {
			this.zipCode = zipCode;
		}
		public String getEmergencyName() {
			return  emergencyName;
		}
		
		public void setEmergencyName(String emergencyName) {
			this.emergencyName = emergencyName;
		}
		public String getEmergencyCont() {
			return emergencyCont;
		}
		
		public void setEmergencyCont(String emergencyCont) {
			this.emergencyCont = emergencyCont;
		}
		
//methods		
		public String buildFullName() {
			return firstName + " " + middleName + " " + lastName;
		}
		public String buildAddress() {
			return address + " " + city + " " + state + " " + zipCode;
		}
		public String buildEmergencyContact() {
			return emergencyName + " " + emergencyCont;
		}
		
// toString method
		@Override
		public String toString() {
			return "Patient info: \n" + "  Name: " + buildFullName() + 
					"\n  Address: " + buildAddress() + 
					"\n  Emergency Contact: " + buildEmergencyContact();
		}
		


}
