(function () {
    'use strict';

    function UserService($localStorage) {
        var service = {};

        service.IsAnonymous = IsAnonymous;
        service.GetAuthenticationToken = GetAuthenticationToken;

        return service;

        // Check if the user did not log in into the site
        function IsAnonymous() {
            return $localStorage.currentUser ? false : true;
        }

        function GetAuthenticationToken() {
            if (!IsAnonymous()) {
                return 'Bearer ' + $localStorage.currentUser.token;
            }
            return '';
        }
    }

    UserService.$inject = ['$localStorage'];
    module.exports = UserService;
})();