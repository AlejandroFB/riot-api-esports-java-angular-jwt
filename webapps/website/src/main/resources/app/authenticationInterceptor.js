(function () {
    'use strict';

    function AuthenticationInterceptor($injector, UserService) {
        var authInterceptor = {
            request: function(config) {
                var $http = $injector.get('$http');
                $http.defaults.headers.common.Authorization = UserService.GetAuthenticationToken();

                return config;
            }
        }
        return authInterceptor;
    }

    AuthenticationInterceptor.$inject = ['$injector', 'UserService'];
    module.exports = AuthenticationInterceptor;
})();