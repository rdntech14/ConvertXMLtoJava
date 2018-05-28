package test;

import java.io.File;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLtoObject {

	public static void main(String[] args) {
		try {
//	XML can be passed to unmarshal as File object or String Reader object		
//			File file = new File("company.xml");
			StringReader stringReader = new StringReader("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + 
					"<company id=\"1\">\n" + 
					"	<employees>\n" + 
					"		<name>John</name>\n" + 
					"		<id>101</id>\n" + 
					"		<designation>Developer</designation>\n" + 
					"	</employees>\n" + 
					"	<employees>\n" + 
					"		<name>Tom</name>\n" + 
					"		<id>102</id>\n" + 
					"		<designation>QA</designation>\n" + 
					"	</employees>\n" + 
					"</company> ");

			JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//			Company company = (Company) jaxbUnmarshaller.unmarshal(file);
			Company company = (Company) jaxbUnmarshaller.unmarshal(stringReader);
			
			System.out.println("XMl to Object : \n" + company);
			System.out.println("Company Id : " + company.getId());
			System.out.println("First Employee Name : " + company.getEmployees().get(0).getName());

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
