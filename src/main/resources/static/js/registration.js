var app = angular.module('registration', []);

app.controller("LoginServiceImpl", function ($scope, $http) {


    $scope.createNewUser = function () {

        const user = {
            login: $scope.login,
            email: $scope.email,
            hash: $scope.hash

        }
        console.log(user.login);
        console.log(user.hash);
        console.log(user.email);

        $http.post('/registration/', user)
            .success(function (data, status, headers, config) {
                    console.log("Registration sucessfull");
                window.location.href = '/aparts';

                }
            ).error(function (data, status, headers, config) {
            console.log(status, data, headers);
        });
    };


});