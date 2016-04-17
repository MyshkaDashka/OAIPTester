app.controller('HomeController', ['$scope', 'User', '$rootScope', function ($scope, User, $rootScope) {

    User.getCurrentUser(function (data) {
        if (data && data.login) {
            $rootScope.user = data;
        } else {
            delete $rootScope.user;
        }
    }, function (error) {
        delete $rootScope.user;
    });


    //демонстрация секьюрити - вернёт результат только для админа, для остальных - вернёт ошибку
    User.getAll(function (data) {
        console.log(data);
    }, function (error) {
        console.log(error);
    })
}]);