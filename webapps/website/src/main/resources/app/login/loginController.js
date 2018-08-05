(function () {
    'use strict';

    function LoginController($location, AuthenticationService) {
        var model = this;

        model.login = login;

        initController();

        function initController() {
            // Reset login status
            AuthenticationService.Logout();
        };

        function login() {
            model.loading = true;
            AuthenticationService.Login(model.username, model.password, function (result) {
                if (result === true) {
                    $location.path('/home');
                } else {
                    model.error = 'Username or password is incorrect';
                    model.loading = false;
                }
            });
        };
    }

    LoginController.$inject = ['$location', 'AuthenticationService'];
    module.exports = LoginController;
})();