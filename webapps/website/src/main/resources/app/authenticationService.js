(function () {
    'use strict';

    function AuthenticationService($http, $localStorage) {
        var service = {};

        service.Login = Login;
        service.Logout = Logout;

        return service;

        function Login(username, password, callback) {
            var params = "username=" + username + "&password=" + password;

            var config = {
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            };

            $http.post('/authenticate', params, config)
                .success(function (response) {
                    // Login successful if there's a token in the response
                    if (response.token) {

                        // Store username and token in local storage to keep user logged in between page refreshes
                        $localStorage.currentUser = { username: username, token: response.token };

                        // Add JWT token to auth header for all requests made by the $http service
                        $http.defaults.headers.common.Authorization = 'Bearer ' + response.token;

                        // Execute callback with true to indicate successful login
                        callback(true);
                    } else {
                        // Execute callback with false to indicate failed login
                        callback(false);
                    }
                })
                .error(function () {
                    callback(false);
                });
        }

        function Logout() {
            // Remove user from local storage and clear http auth header
            delete $localStorage.currentUser;
            $http.defaults.headers.common.Authorization = '';
        }
    }

    AuthenticationService.$inject = ['$http', '$localStorage'];
    module.exports = AuthenticationService;
})();