package test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLtoObject {

	public static void main(String[] args) {
		try {
			File file = new File("company.xml");

			JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Company company = (Company) jaxbUnmarshaller.unmarshal(file);

			System.out.println("XMl to Object : \n" + company);
			System.out.println("Company Id : " + company.getId());
			System.out.println("First Employee Name : " + company.getEmployees().get(0).getName());

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
