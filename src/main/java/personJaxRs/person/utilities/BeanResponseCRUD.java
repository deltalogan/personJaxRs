package personJaxRs.person.utilities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import personJaxRs.person.models.PersonModel;

@XmlRootElement(name = "BeanResponseCRUD")
@XmlSeeAlso({ PersonModel.class })
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanResponseCRUD {

	public enum MessageCode {
		SUCCESS, ERROR, UNKNOWN
	}

	@XmlElement(name = "message")
	private String message;

	@XmlElement(name = "status")
	private MessageCode status;

	@XmlElement(name = "beanResponseRead")
	private BeanResponseRead beanResponseRead;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageCode getStatus() {
		return status;
	}

	public void setStatus(MessageCode status) {
		this.status = status;
	}

	public BeanResponseRead getBeanResponseRead() {
		return beanResponseRead;
	}

	public void setBeanResponseRead(BeanResponseRead beanResponseRead) {
		this.beanResponseRead = beanResponseRead;
	}
}