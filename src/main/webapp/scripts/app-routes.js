app.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider

    // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url : '/',
            templateUrl: 'pages/home.html',
            controller: "HomeController"
        })

        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('about', {
            url : '/about',
            templateUrl : 'pages/about.html'
        })

        .state('contact', {
            url : '/contact',
            templateUrl : 'pages/contact.html'
        })

        .state('signin', {
            url : '/signin',
            templateUrl : 'pages/signin.html'
        })
        .state('signout', {
            url : '/signout',
            templateUrl : 'pages/signout.html'
        })
        .state('registration', {
            url : '/registration',
            templateUrl : 'pages/registration.html'
        })

});