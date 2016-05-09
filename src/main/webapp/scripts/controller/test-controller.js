app.controller('TestController', ['$scope', 'Test', '$rootScope', '$state' , function ($scope, Test, $rootScope, $state) {
    Test.getAll(function (data) {
        $rootScope.tests = data;
    }, function (error) {
        delete $rootScope.tests;
    });

    $scope.runTest = function(test){
        $state.go('test');
    }
}]);