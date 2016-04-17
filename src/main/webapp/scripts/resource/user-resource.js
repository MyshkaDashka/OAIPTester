app.factory('User', ['$resource', function($resource) {
    return $resource('/user', {}, {
        getAll: {
            method: "GET",
            isArray: true
        },
        getCurrentUser: {
            method: "GET",
            isArray: false,
            url: "/user/current"
        }
    })
}]);