var app = angular.module('aparts', []);

app.controller("ApartController", function ($scope, $http) {

    $scope.currentApartId = 0;
    $scope.currentNumerId = 0;
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
            $scope.apartsList = $scope.apartsList.filter(function(apart) {
                return apart.apartId !== id;
            });
        }).error(function (data, status, headers, config) {
            console.log(data);
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        });
    };

    $scope.addAparts = function () {
        const values = {
            firstName: $scope.firstName,
            cost: $scope.cost,
            description: $scope.description,
            phone: $scope.phone,
            address: $scope.address
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

    $scope.getNumers = function (id) {
        $http.get('/apart/numers/' + id)
            .success(function (data, status, headers, config) {
                $scope.numerList = data;
                $scope.currentApartId = id;
            })
            .error(function (data, status, headers, config) {
                if (data.message === 'Time is out') {
                    $scope.finishByTimeout();
                }
            });
    };


    $scope.addNumer = function (id, numerName) {
        console.log(id,numerName);
        $http.post('/apart/numers/' +'addNumer/' + id + "/" + numerName)
            .success(function (data, status, headers, config) {
                $scope.numerList = data;
                console.log(data);
            })
            .error(function (data, status, headers, config) {
                console.log(data);
                if (data.message === 'Time is out') {
                    $scope.finishByTimeout();
                }
            });
    };

    $scope.deleteNumer = function (numerId) {
        $http.delete('/apart/numers/delete/' + numerId).success(function (data, status, headers, config) {
            $scope.numerList = $scope.numerList.filter(function(numer) {
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


    $scope.deleteMark = function (mId, numId) {
        $http.delete('/apart/marks/delete/' + mId)
            .success(function () {
                console.log($scope.numerList[numId-1]);
                console.log(numId);
                const numer = $scope.numerList[numId-1];
                numer.markList = numer.markList.filter(function(mark) {
                    return mark.markId !== mId;
                });
            })
            .error(function (data, status, headers, config) {
                console.log(data);
                if (data.message === 'Time is out') {
                    $scope.finishByTimeout();
                }
            });
    };

    $scope.addMark = function (value, numerId) {
        console.log(value,numerId);
        $http.post('/apart/numers/' +'addNumer/' + id + "/" + numerName)
            .success(function (data, status, headers, config) {
                $scope.numerList = data;
                console.log(data);
            })
            .error(function (data, status, headers, config) {
                console.log(data);
                if (data.message === 'Time is out') {
                    $scope.finishByTimeout();
                }
            });
    };

    $scope.addMark = function (numerId) {
        console.log($scope.value,numerId);
        $http.post('/apart/marks/add/' + $scope.value + "/" + numerId)
            .success(function (data, status, headers, config) {
            })
            .error(function (data, status, headers, config) {;
                if (data.message === 'Time is out') {
                    $scope.finishByTimeout();
                }
            });
    };

});