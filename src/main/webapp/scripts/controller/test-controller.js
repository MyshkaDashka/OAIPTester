app.controller('TestController', ['$scope', 'Test', '$rootScope', function ($scope, Test, $rootScope) {
    Test.getAll(function (data) {
        $rootScope.tests = data;
    }, function (error) {
        delete $rootScope.tests;
    });
}]);