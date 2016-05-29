app.controller('AllUsersController', ['$scope', 'User', '$rootScope', function ($scope, User, $rootScope) {
    User.getAll(function(data){
        $scope.allUsers = data;
    });
}]);