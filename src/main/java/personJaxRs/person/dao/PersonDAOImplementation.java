package personJaxRs.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import personJaxRs.person.models.PersonModel;
import personJaxRs.person.tools.ConexionSQL;
import personJaxRs.person.utilities.BeanResponseCRUD;
import personJaxRs.person.utilities.BeanResponseCRUD.MessageCode;
import personJaxRs.person.utilities.BeanResponseRead;

public class PersonDAOImplementation implements PersonDAO {

	@Override
	public BeanResponseCRUD create(PersonModel model) {
		// TODO Auto-generated method stub
		Connection connection = ConexionSQL.getConnection();

		BeanResponseCRUD beanResponseCRUD = new BeanResponseCRUD();

		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into person (birthday, cuil, dni, last_Name, email, name) values (?, ?, ?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, model.getBirthday());
			preparedStatement.setString(2, model.getCuil());
			preparedStatement.setString(3, model.getDni());
			preparedStatement.setString(4, model.getLastName());
			preparedStatement.setString(5, model.getEmail());
			preparedStatement.setString(6, model.getName());
			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next())

				model.setId(resultSet.getLong(1));

			preparedStatement.close();
			connection.commit();
			connection.close();
			beanResponseCRUD = read(model.getId());
			beanResponseCRUD.setMessage(read(model.getId()).getBeanResponseRead().getCount() > 0
					? "Se agreg\u00f3 el registro con ID: " + model.getId() + "."
					: "No se agreg\u00f3 el registro.");
		}

		catch (SQLException e) {

			beanResponseCRUD.setMessage(e.getMessage().toString());
			beanResponseCRUD.setStatus(MessageCode.ERROR);
		}

		return beanResponseCRUD;
	}

	@Override
	public BeanResponseCRUD read() {
		// TODO Auto-generated method stub
		Connection connection = ConexionSQL.getConnection();

		List<PersonModel> personModelList = new ArrayList<PersonModel>();

		BeanResponseRead beanResponseRead = new BeanResponseRead();

		BeanResponseCRUD beanResponseCRUD = new BeanResponseCRUD();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select count(id) as count from person p;");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				beanResponseRead.setCount(resultSet.getLong("count"));

				if (resultSet.getLong("count") > 0) {

					resultSet.close();
					preparedStatement = connection.prepareStatement("select * from person p;");
					resultSet = preparedStatement.executeQuery();

					while (resultSet.next()) {

						PersonModel personModel = new PersonModel();

						personModel.setBirthday(resultSet.getString("birthday"));
						personModel.setCuil(resultSet.getString("cuil"));
						personModel.setDni(resultSet.getString("dni"));
						personModel.setEmail(resultSet.getString("email"));
						personModel.setId(resultSet.getLong("id"));
						personModel.setLastName(resultSet.getString("last_name"));
						personModel.setName(resultSet.getString("name"));
						personModelList.add(personModel);
					}
				}
			}

			beanResponseRead.setList(personModelList);
			beanResponseCRUD.setBeanResponseRead(beanResponseRead);
			beanResponseCRUD.setMessage(
					beanResponseRead.getCount() > 0 ? "Se listaron " + beanResponseRead.getCount() + " registro/s."
							: "No se listaron registros.");
			beanResponseCRUD.setStatus(MessageCode.SUCCESS);
			preparedStatement.close();
			resultSet.close();
			connection.close();
		}

		catch (SQLException e) {

			beanResponseCRUD.setMessage(e.getMessage().toString());
			beanResponseCRUD.setStatus(MessageCode.ERROR);
		}

		return beanResponseCRUD;
	}

	@Override
	public BeanResponseCRUD read(Long id) {
		// TODO Auto-generated method stub
		Connection connection = ConexionSQL.getConnection();

		List<PersonModel> personModelList = new ArrayList<PersonModel>();

		BeanResponseRead beanResponseRead = new BeanResponseRead();

		BeanResponseCRUD beanResponseCRUD = new BeanResponseCRUD();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select count(id) as count from person p where id = ?;");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				beanResponseRead.setCount(resultSet.getLong("count"));

				if (resultSet.getLong("count") > 0) {

					resultSet.close();
					preparedStatement = connection.prepareStatement("select * from person p where id = ?;");
					preparedStatement.setLong(1, id);
					resultSet = preparedStatement.executeQuery();

					while (resultSet.next()) {
						PersonModel personModel = new PersonModel();

						personModel.setBirthday(resultSet.getString("birthday"));
						personModel.setCuil(resultSet.getString("cuil"));
						personModel.setDni(resultSet.getString("dni"));
						personModel.setEmail(resultSet.getString("email"));
						personModel.setId(resultSet.getLong("id"));
						personModel.setLastName(resultSet.getString("last_name"));
						personModel.setName(resultSet.getString("name"));
						personModelList.add(personModel);
					}
				}
			}

			beanResponseRead.setList(personModelList);
			beanResponseCRUD.setBeanResponseRead(beanResponseRead);
			beanResponseCRUD
					.setMessage(beanResponseRead.getCount() > 0 ? "Se list\u00f3 el registro con ID: " + id + "."
							: "No se encontr\u00f3 el registro con ID: " + id + ".");
			beanResponseCRUD.setStatus(MessageCode.SUCCESS);
			preparedStatement.close();
			resultSet.close();
			connection.close();
		}

		catch (SQLException e) {

			beanResponseCRUD.setMessage(e.getMessage().toString());
			beanResponseCRUD.setStatus(MessageCode.ERROR);
		}

		return beanResponseCRUD;
	}

	@Override
	public BeanResponseCRUD update(PersonModel model, Long id) {
		// TODO Auto-generated method stub
		Connection connection = ConexionSQL.getConnection();

//		Integer updateCount = 0;

		BeanResponseCRUD beanResponseCRUD = new BeanResponseCRUD();

		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update person set birthday = ?, cuil = ?, dni = ?, email = ?, last_name = ?, name = ? where id = ?");
			preparedStatement.setString(1, model.getBirthday());
			preparedStatement.setString(2, model.getCuil());
			preparedStatement.setString(3, model.getDni());
			preparedStatement.setString(4, model.getLastName());
			preparedStatement.setString(5, model.getEmail());
			preparedStatement.setString(6, model.getName());
			preparedStatement.setLong(7, id);
			preparedStatement.executeUpdate();
//			updateCount = preparedStatement.getUpdateCount();
			model.setId(id);
			preparedStatement.close();
			connection.commit();
			connection.close();
			beanResponseCRUD = read(model.getId());
			beanResponseCRUD.setMessage(
					read(id).getBeanResponseRead().getCount() > 0 ? "Se modific\u00f3 el registro con ID: " + id + "."
							: "No se encontr\u00f3 el registro.");
		}

		catch (SQLException e) {

			beanResponseCRUD.setMessage(e.getMessage().toString());
			beanResponseCRUD.setStatus(MessageCode.ERROR);
		}

		return beanResponseCRUD;
	}

	@Override
	public BeanResponseCRUD delete(Long id) {
		// TODO Auto-generated method stub
		Connection connection = ConexionSQL.getConnection();

//		Integer updateCount = 0;

		BeanResponseCRUD beanResponseCRUD = new BeanResponseCRUD();

		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement("delete from person where id = ?;");
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
//			updateCount = preparedStatement.getUpdateCount();
			beanResponseCRUD = read(id);
			beanResponseCRUD.setMessage(
					read(id).getBeanResponseRead().getCount() > 0 ? "Se elimin\u00f3 el registro con ID: " + id + "."
							: "No se encontr\u00f3 el registro.");
			preparedStatement.close();
			connection.commit();
			connection.close();
		}

		catch (SQLException e) {

			beanResponseCRUD.setMessage(e.getMessage().toString());
			beanResponseCRUD.setStatus(MessageCode.ERROR);
		}

		return beanResponseCRUD;
	}
}