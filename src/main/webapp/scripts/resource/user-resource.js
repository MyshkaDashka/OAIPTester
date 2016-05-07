app.factory('User', ['$resource', function ($resource) {
    return $resource('/user', {}, {
        getAll: {
            method: "GET",
            isArray: true
        },

        getUserInformation: {
            method: "GET",
            isArray: false,
            url: "/user/profile"
        },

        getAllAdministrators: {
            method: "GET",
            isArray: true,
            url: "/user/admins"
        },

        addNewUser: {
            method: "POST",
            url: "/user/registration"
        },

        editUserInformation: {
            method: "POST",
            url:"/user/edit"
        }
    })
}]);