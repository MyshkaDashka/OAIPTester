app.controller('ReportController', ['$scope', 'Report', '$rootScope', function ($scope, Report, $rootScope) {
    Report.getAllReportsForUser(function (data) {
        $rootScope.reports = data;
    }, function (error) {
        delete $rootScope.reports;
    });
}]);