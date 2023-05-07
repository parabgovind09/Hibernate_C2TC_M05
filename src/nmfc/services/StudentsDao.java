package nmfc.services;

import nmfc.entities.Students;

public interface StudentsDao {
	
	public abstract Students findStudentByBarcode(String barcode_number);
}
