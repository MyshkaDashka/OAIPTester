app.factory('Test', ['$resource', function($resource) {
    return $resource('/tests', {}, {
        getAll: {
            method: "GET",
            isArray: true,
            url:"/tests"
        }
    })
}]);