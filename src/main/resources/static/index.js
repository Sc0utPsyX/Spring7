angular.module ('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/app/api/v1/students';
    $scope.start = 0;
    $scope.end = 10;
    $scope.studentList = [];
    $scope.length = 0;

    $scope.loadStudents = function () {
        $http.get(contextPath + "/get")
            .then(function (response) {
                console.log(response.data);
                $scope.studentList = response.data;
                $scope.length = $scope.studentList.length;
            });
    };



    $scope.deleteStudents = function (id) {
        $http.get(contextPath + "/delete/" + id)
            .then(function (response) {
                $scope.loadStudents();
            });
    };

    $scope.updateStudent = function (id, name, age){
        if (id == null){
            id = 0;
        }
        $http({
            url: contextPath + '/update?id=' + id + '&name=' + name + '&age=' + age,
            method: "POST"
        }).then(function (response){
            $scope.loadStudents();
        });
    };

    $scope.loadStudents();

});