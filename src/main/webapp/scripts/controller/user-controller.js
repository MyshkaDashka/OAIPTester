app.controller('UserController', ['$scope', 'User', function ($scope, User) {

    User.getAll(function (data) {
        console.log(data);
    });
}]);