app.controller('HomeController', ['$scope', 'User', '$rootScope', function ($scope, User, $rootScope) {

    User.getUserInformation(function (data) {
        if (data && data.login) {
            $rootScope.user = data;
        } else {
            delete $rootScope.user;
        }
    }, function (error) {
        delete $rootScope.user;
    });

   User.getAllAdministrators(function(data){
       $scope.admins = data;
   });
}]);