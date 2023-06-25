package personJaxRs.person.utilities;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BeanResponseRead")
//@XmlTransient
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanResponseRead {

	@XmlElement(name = "count")
	private Long count;

	@XmlAnyElement(lax = true)
//	@XmlElement(name = "list"/* , type = PersonModel.class */)
	private List<?> list;

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
}