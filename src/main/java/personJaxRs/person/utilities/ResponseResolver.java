package personJaxRs.person.utilities;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import personJaxRs.person.models.PersonModel;

@Provider
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ResponseResolver implements ContextResolver<JAXBContext> {
	private JAXBContext jaxBContext;

	public ResponseResolver() {

		try {

			jaxBContext = JAXBContext.newInstance(Response.class, PersonModel.class);
		}

		catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JAXBContext getContext(Class<?> type) {

		return (type.equals(Response.class) ? jaxBContext : null);
	}
}