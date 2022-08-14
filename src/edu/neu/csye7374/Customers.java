package edu.neu.csye7374;

public class Customers implements PersonAPI{
    private String firstName;
    private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private int customerID;

   
	private Customers(CustomersBuilder customers){
        this.firstName = customers.firstName;
        this.lastName = customers.lastName;
        this.birthYear = customers.birthYear;
        this.birthMonth = customers.birthMonth;
        this.birthDay = customers.birthDay;
        this.customerID = customers.customerID;
    }
	
	public int getCustomerID() {
		return customerID;
	}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public static class CustomersBuilder{
        private String firstName;
        private String lastName;
        private int birthYear;
        private int birthMonth;
        private int birthDay;
        private int customerID;
        public int getCustomerID() {
			return customerID;
		}
		public CustomersBuilder setCustomerID(int customerID) {
			this.customerID = customerID;
			return this;
		}
		public String getFirstName() {
            return firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public int getBirthYear() {
            return birthYear;
        }
        public int getBirthMonth() {
            return birthMonth;
        }
        public int getBirthDay() {
            return birthDay;
        }
        public CustomersBuilder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public CustomersBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public CustomersBuilder setBirthYear(int birthYear) {
            this.birthYear = birthYear;
            return this;
        }
        public CustomersBuilder setBirthMonth(int birthMonth) {
            this.birthMonth = birthMonth;
            return this;
        }
        public CustomersBuilder setBirthDay(int birthDay){
            this.birthDay = birthDay;
            return this;
        }
        
        public Customers createCustomers() {
        	return new Customers(this);
        }
    }
}
