app.controller("AddUserController", function ($scope, $http, $location) {
    $scope.user = {};
    $scope.addNewUser = function () {
        var response = $http({
            method: "post",
            url: "/registration",
            data: {
                name: $scope.user.name,
                lastName: $scope.user.lastName,
                fatherName: $scope.user.fatherName,
                email: $scope.user.email,
                login: $scope.user.login,
                password: $scope.user.password
            }
        });
        response.success(function () {
            $location.path('/signin');
            $location.replace();
        });
    }

    $scope.cancel = function () {
        $location.path('/signin');
        $location.replace();
    }
});
