(function () {
    'use strict';

    function HomeController($http) {
        var model = this;

        model.search = search;

        initController();

        function initController() {
        }

        function search() {
            $http.get('/search?name=' + model.searchInput + '&region=' + model.regionInput)
                .success(function (response) {
                    if (response.name) {
                        model.summoner = response;
                    } else {
                        model.error = "Generic error message";
                    }
                });
        }
    }

    HomeController.$inject = ['$http'];
    module.exports = HomeController;
})();
