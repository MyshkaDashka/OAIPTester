app.controller("EditUserController", ['$scope', 'User', '$state','$rootScope', function ($scope, User, $state, $rootScope) {
    $scope.user = $rootScope.user;
    $scope.editUserInformation = function () {
        User.editUserInformation($scope.user, function (data) {
            $state.go('profile');
        });
    };

    $scope.cancel = function () {
        $state.go('profile');
    };
}]);