app.factory('Report', ['$resource', function($resource) {
    return $resource('/report', {}, {
        getAllReportsForUser: {
            method: "GET",
            isArray: true,
            url:"/report"
        }
    })
}]);