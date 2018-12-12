var app = angular.module('aparts', []);

app.controller("ApartController", function ($scope, $http) {

    $scope.currentApartId = 0;
    $scope.currentOrderId = 0;
    $scope.value = 0;

    $scope.getAparts = function () {
        $http.get('/aparts/').success(function (data, status, headers, config) {
            console.log(data);
            $scope.apartsList = data;
            console.log(data);
        }).error(function (data, status, headers, config) {
            console.log(data);
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };

    $scope.deleteApart = function (id) {
        $http.delete('/aparts/delete/' + id).success(function (data, status, headers, config) {
            console.log(data);
            $scope.apartsList = $scope.apartsList.filter(function (apart) {
                return apart.apartId !== id;
            });
        }).error(function (data, status, headers, config) {
            console.log(data);
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };

    $scope.getApartList = function () {

        const temp = {
            date_begin: $scope.date_begin,
            date_end: $scope.date_end,
            apart_cost:parseInt($scope.apart_cost),
            apart_city:$scope.apart_city
        }
        console.log(temp.cost);
        console.log(temp.city);
        $http.post('/aparts/find_available_aparts', temp)
            .success(function (data, status, headers, config) {
                    $scope.apartsList = data;

                }
            ).error(function (data, status, headers, config) {
            console.log(status, data, headers);
        });
    };

    $scope.addAparts = function () {
        const values = {

            apart_name:'ligov',
            apart_city:'spb',
            apart_address:'ligovskiy 24',
            apart_phone:'893131',
            apart_x:'10',
            apart_y:'10',
            apart_cost:'1000',
            apart_description:'goood',
            apart_image_url:'http'

        };

        console.log('values:', values);

        $http.post('/aparts/add/', values)
            .success(function (data, status, headers, config) {
                    $scope.apartsList.push(data);
                }
            ).error(function (data, status, headers, config) {
            console.log(status, data, headers);
        });
    };

    $scope.getOrders = function (id) {
        $http.get('/apart/orders/' + id)
            .success(function (data, status, headers, config) {
                $scope.orderList = data;
                $scope.currentApartId = id;
            })
            .error(function (data, status, headers, config) {
                if (data.message === 'Time is out') {
                    $scope.finishByTimeout();
                }
            });
    };

    $scope.getOrders = function (id) {
        $http.get('/apart/orders/' + id)
            .success(function (data, status, headers, config) {
                $scope.orderList = data;
                $scope.currentApartId = id;
            })
            .error(function (data, status, headers, config) {
                if (data.message === 'Time is out') {
                    $scope.finishByTimeout();
                }
            });
    };


    $scope.addOrder = function (id, orderName) {
        console.log(id, orderName);
        $http.post('/apart/orders/' + 'addOrder/' + id + "/" + orderName)
            .success(function (data, status, headers, config) {
                $scope.orderList = data;
                console.log(data);
            })
            .error(function (data, status, headers, config) {
                console.log(data);
                if (data.message === 'Time is out') {
                    $scope.finishByTimeout();
                }
            });
    };

    $scope.deleteOrder = function (numerId) {
        $http.delete('/apart/orders/delete/' + numerId).success(function (data, status, headers, config) {
            $scope.numerList = $scope.numerList.filter(function (numer) {
                return numer.numerId !== numerId;
            });
            console.log($scope.numerList);
        }).error(function (data, status, headers, config) {
            console.log(data);
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };


});