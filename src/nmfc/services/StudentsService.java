package nmfc.services;

import nmfc.entities.Students;

public interface StudentsService {
	
	public abstract Students findStudentByBarcode(String barcode_number);
}
