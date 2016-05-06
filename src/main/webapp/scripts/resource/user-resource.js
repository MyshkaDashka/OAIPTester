app.factory('User', ['$resource', function($resource) {
    return $resource('/user', {}, {
        getAll: {
            method: "GET",
            isArray: true
        },

        getUserInformation: {
            method: "GET",
            isArray: false,
            url: "/user/profile"
        }
    })
}]);