package com.login.password.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.GraphQlClient.RetrieveSpec;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import com.login.password.service.model.UserModel;
import com.login.password.service.model.UserRequest;

import reactor.core.publisher.Mono;

@Component
public class GraphQLClient {

	@Autowired
	private HttpGraphQlClient graphQlClient;

	public List<UserModel> fetchAllUsers() {
		String graphQLQuery = "query GetAllUsers {\r\n" + "    getAllUsers {\r\n" + "        id\r\n"
				+ "        name\r\n" + "        userId\r\n" + "        password\r\n" + "        addressEntity {\r\n"
				+ "            addressLine1\r\n" + "            street\r\n" + "            pinCode\r\n"
				+ "        }\r\n" + "    }\r\n" + "}\r\n" + "";
		Mono<List<UserModel>> entityList = graphQlClient.document(graphQLQuery).retrieve("getAllUsers")
				.toEntityList(UserModel.class);
		return graphQlClient.document(graphQLQuery).retrieve("getAllUsers").toEntityList(UserModel.class).block();
	}

	public UserModel getUserById(int userId) {
		String query = String.format("query GetUserById {\r\n" + "    getUserById(userId: %d) {\r\n" + "        id\r\n"
				+ "        name\r\n" + "        userId\r\n" + "        password\r\n" + "    }\r\n" + "}\r\n" + "",
				userId);
		return graphQlClient.document(query).retrieve("getUserById").toEntity(UserModel.class).block();
	}

	public UserModel validateUser(String userId, String password) {
		String query = String.format("query ValidateUser {\r\n"
				+ "    validateUser(userId: \"%s\", password: \"%s\") {\r\n" + "        id\r\n" + "        name\r\n"
				+ "        userId\r\n" + "        password\r\n" + "    }\r\n" + "}\r\n" + "", userId, password);
		return graphQlClient.document(query).retrieve("validateUser").toEntity(UserModel.class).block();
	}

	public UserModel createUser(UserRequest userRequest) {
		String query = String.format("mutation CreateUser {\r\n" + "    createUser(\r\n" + "        userRequest: {\r\n"
				+ "            addressRequest: {\r\n" + "                pinCode: \"%s\"\r\n"
				+ "                street: \"%s\"\r\n" + "                addressLine1: \"%s\"\r\n"
				+ "            }\r\n" + "            id: %d\r\n" + "            name: \"%s\"\r\n"
				+ "            userId: \"%s\"\r\n" + "            password: \"%s\"\r\n" + "        }\r\n"
				+ "    ) {\r\n" + "        id\r\n" + "        name\r\n" + "        userId\r\n" + "        password\r\n"
				+ "        addressEntity {\r\n" + "            addressLine1\r\n" + "            street\r\n"
				+ "            pinCode\r\n" + "        }\r\n" + "    }\r\n" + "}\r\n" + "",

				userRequest.getAddressRequest().getPinCode(), userRequest.getAddressRequest().getStreet(),
				userRequest.getAddressRequest().getAddressLine1(), userRequest.getId(), userRequest.getName(),
				userRequest.getUserId(), userRequest.getPassword());
		return graphQlClient.document(query).retrieve("createUser").toEntity(UserModel.class).block();

	}

	public UserModel updatePassWord(int id, String password) {
		String query = String.format("mutation UpdatePassWord {\r\n"
				+ "    updatePassWord(id: %d, password: \"%s\") {\r\n" + "        id\r\n" + "        name\r\n"
				+ "        userId\r\n" + "        password\r\n" + "    }\r\n" + "}\r\n" + "", id, password);
		return graphQlClient.document(query).retrieve("updatePassWord").toEntity(UserModel.class).block();
	}

}
