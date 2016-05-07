app.controller("EditUserController", ['$scope', 'User', '$state', function ($scope, User, $state) {
    $scope.user = {};
    $scope.saveEdit = function () {
        User.saveEdit($scope.user, function(data) {
            $state.go('profile');
        });
    }

    $scope.cancel=function(){
        $state.go('profile');
    }
}]);