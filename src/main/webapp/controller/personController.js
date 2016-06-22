var app = angular.module('personController', []);

app.controller('personList', function ($scope, $http) {
    $http.get('http://localhost:8080/angular-springmvc/person/list')
        .then(
            function(response) {
                $scope.persons = response.data;
            });
});

app.controller('formPerson', function($scope, $http) {
    $scope.person = {name:'', cpf:''};

    $scope.save = function(person) {
        $http.put('http://localhost:8080/angular-springmvc/person/save', $scope.person)
            .then(
                function(response) {
                    $scope.persons = response.data;
                }
            );

        // Inappropriate
        window.location.reload();
    }

});

app.filter('cpf', function(){
    return function(cpf){
        return cpf.substr(0, 3) + '.' + cpf.substr(3, 3) + '.' + cpf.substr(6, 3) + '-' + cpf.substr(9,2);
    };
});