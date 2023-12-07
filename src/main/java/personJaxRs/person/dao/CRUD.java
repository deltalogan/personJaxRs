package personJaxRs.person.dao;

import personJaxRs.person.utilities.BeanResponseCRUD;

public interface CRUD<T> {

	BeanResponseCRUD create(T model);

	BeanResponseCRUD read(String id, String limit, String numberOfPage);

	BeanResponseCRUD update(T model, Long id);

	BeanResponseCRUD delete(Long id);
}