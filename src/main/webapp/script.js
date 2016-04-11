var routerApp = angular.module('routerApp',
    [ 'ui.router', 'angularFileUpload' ]);

routerApp.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/home');

    $stateProvider

    // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url : '/home',
            templateUrl : 'pages/home.html'
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

        .state('sign', {
            url : '/sign',
            templateUrl : 'pages/sign.html',
            controller : 'AutorizationController'
        })

        .state('contact.maps', {
            url : '/maps',
            templateUrl : 'pages/maps.html'
        })

        .state('upload', {
            url : '/upload',
            templateUrl : 'pages/upload.html',
            controller : 'AppController'
        });

});