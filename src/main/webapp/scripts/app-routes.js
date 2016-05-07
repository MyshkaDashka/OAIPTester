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
            templateUrl: 'pages/editProfile.html'
        })
        .state('tests', {
            url: '/tests',
            templateUrl: 'pages/tests.html',
            controller: "TestController"
        })
        .state('executedTests', {
            url: '/executedTests',
            templateUrl: 'pages/executedTests.html'
        })


});