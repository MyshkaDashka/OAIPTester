app.controller('HomeController', ['$scope', 'User', '$rootScope', function ($scope, User, $rootScope) {
   User.getAllAdministrators(function(data){
       $scope.admins = data;
   });
}]);