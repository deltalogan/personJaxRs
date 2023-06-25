package personJaxRs.person.dao;

import personJaxRs.person.utilities.BeanResponseCRUD;

public interface CRUD<T> {

	BeanResponseCRUD create(T model);

	BeanResponseCRUD read();

	BeanResponseCRUD read(Long id);

	BeanResponseCRUD update(T model, Long id);

	BeanResponseCRUD delete(Long id);
}
