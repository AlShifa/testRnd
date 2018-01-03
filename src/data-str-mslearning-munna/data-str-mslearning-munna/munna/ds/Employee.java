package munna.ds;
import static munna.ds.StaticImport.*;  

public class Employee {
	public Employee(int empID) {
		super();
		this.empID = empID;
	}
	int empID;
	String empName;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empID != other.empID)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		mstat();
		nstat();	
	}

}
