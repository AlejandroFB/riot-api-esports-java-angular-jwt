(function () {
    'use strict';

    require('angular');
    require('angular-messages');
    require('angular-ui-router');
    require('ngstorage');

    angular
        .module('websiteApp', ['ui.router', 'ngMessages', 'ngStorage'])
        .config(config)
        .run(run)

        // Load controllers
        .controller('HomeController', require('./home/homeController.js'))
        .controller('LoginController', require('./login/loginController.js'))
        .controller('MainController', require('./main/mainController.js'))

        // Load services
        .factory('UserService', require('./userService.js'))
        .factory('AuthenticationService', require('./authenticationService.js'))
        // Interceptors
        .factory('AuthenticationInterceptor', require('./authenticationInterceptor.js'))

    function config($stateProvider, $urlRouterProvider, $httpProvider) {
        // Default route
        $urlRouterProvider.otherwise("/");

        // App routes
        $stateProvider
            .state('home', {
                url: '/home',
                templateUrl: '../templates/home/homeView.html',
                controller: 'HomeController',
                controllerAs: 'model'
            })
            .state('login', {
                url: '/login',
                templateUrl: '../templates/login/loginView.html',
                controller: 'LoginController',
                controllerAs: 'model'
            })
            .state('main', {
                url: '/',
                templateUrl: '../templates/main/main.html',
                controller: 'MainController',
                controllerAs: 'model'
            })

        // Interceptors
        $httpProvider.interceptors.push('AuthenticationInterceptor');
    }

    function run($rootScope, $location, UserService) {

        // Redirect to login page if not logged in and trying to access a restricted page
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            var publicPages = ['', '/', '/login'];

            var restrictedPage = publicPages.indexOf($location.path()) === -1;
            if (restrictedPage && UserService.IsAnonymous()) {
                $location.path('/login');
            }
        });
    }
})();