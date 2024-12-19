Provider URL: http://localhost:8081/user/graphql

query GetAllUsers {
    getAllUsers {
        id
        name
        userId
        password
    }
}


mutation UpdatePassWord {
    updatePassWord(id: 106, password: "98498") {
        id
        name
        userId
        password
    }
}


Query
*********************************

GetALLUsers:
===============
query GetAllUsers {
    getAllUsers {
        id
        name
        userId
        password
        addressEntity {
            addressLine1
            street
            pinCode
        }
    }
}

getUserById
=================
query GetUserById {
    getUserById(userId: 101) {
        id
        name
        userId
        password
        addressEntity {
            addressLine1
            street
            pinCode
        }
    }
}

validateUser
=================
query ValidateUser {
    validateUser(password: "Raju582#", userId: "gseelam") {
        id
        name
        userId
        password
        addressEntity {
            addressLine1
            street
            pinCode
        }
    }
}


Mutation:
********************
createUser
======================

mutation CreateUser {
    createUser(
        userRequest: {
            id: 105
            name: "Ramu"
            userId: "cseelam"
            password: "1234567"
            addressRequest: {
                pinCode: "500050"
                street: "Gandhi Statue Road"
                addressLine1: "Chanda Nagar"
            }
        }
    ) {
        id
        name
        userId
        password
        addressEntity {
            addressLine1
            street
            pinCode
        }
    }
}

updatePassWord:
==================
mutation UpdatePassWord {
    updatePassWord(password: "123456", id: 101) {
        id
        name
        userId
        password
        addressEntity {
            addressLine1
            street
            pinCode
        }
    }
}


