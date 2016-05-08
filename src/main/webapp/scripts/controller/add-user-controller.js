app.controller("AddUserController", ['$scope', 'User', '$state', function ($scope, User, $state) {
    $scope.user = {};
    $scope.addNewUser = function () {
        User.addNewUser($scope.user, function(data) {
            $state.go('signin');
        });
    };

    $scope.cancel=function(){
        $state.go('signin');
    };
}]);
