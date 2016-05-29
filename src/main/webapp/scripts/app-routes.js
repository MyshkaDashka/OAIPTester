app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider

        .state('home', {
            url: '/',
            templateUrl: 'pages/home.html',
            controller: "HomeController"
        })

        .state('profile', {
            url: '/profile',
            templateUrl: 'pages/profile.html',
            controller: "HomeController"
        })

        .state('about', {
            url: '/about',
            templateUrl: 'pages/about.html'
        })

        .state('contact', {
            url: '/user/admins',
            templateUrl: 'pages/contact.html',
            controller: 'HomeController'
        })

        .state('signin', {
            url: '/signin',
            templateUrl: 'pages/signin.html'
        })

        .state('signout', {
            url: '/signout',
            templateUrl: 'pages/signout.html'
        })

        .state('registration', {
            url: '/registration',
            templateUrl: 'pages/registration.html',
            controller: 'AddUserController'
        })

        .state('edit', {
            url: '/edit',
            templateUrl: 'pages/editProfile.html',
            controller: 'EditUserController'
        })

        //.state('tests', {
        //    url: '/tests',
        //    templateUrl: 'pages/tests.html',
        //    controller: "TestController"
        //})

        .state('tests', {
            url: '/tests',
            templateUrl: 'pages/testsForAdmins.html',
            controller: "TestController"
        })

        .state('report', {
            url: '/report',
            templateUrl: 'pages/executedTests.html',
            controller: "ReportController"
        })

        .state('test', {
            url: '/test',
            templateUrl: 'pages/test.html'
        })

        .state('users', {
            url: '/users',
            templateUrl: 'pages/users.html',
            controller: "AllUsersController"
        })

        .state('registrationSuccess', {
            url: '/registrationSuccess',
            templateUrl: 'pages/registrationSuccess.html'
        })

        .state('testExecute', {
            url: '/testExecute',
            templateUrl: 'pages/testExecute.html'
        })

        .state('reportForTest', {
            url: '/reportForTest',
            templateUrl: 'pages/report.html'
        })

        .state('theory', {
            url: '/theory',
            templateUrl: 'pages/theory.html'
        })

});