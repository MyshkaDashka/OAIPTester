app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider

    // HOME STATES AND NESTED VIEWS ========================================
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
            url: '/contact',
            templateUrl: 'pages/contact.html'
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
            templateUrl: 'pages/registration.html'
        })

        .state('edit', {
            url: '/edit',
            templateUrl: 'pages/editProfile.html'
        })
        .state('tests', {
            url: '/tests',
            templateUrl: 'pages/tests.html'
        })
        .state('executedTests', {
            url: '/executedTests',
            templateUrl: 'pages/executedTests.html'
        })


});