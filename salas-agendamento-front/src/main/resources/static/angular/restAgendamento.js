angular.module('demo', [])
.controller('Hello', function($scope, $http) {
//    $http.get('http://127.0.0.1:8082/cliente').
//        then(function(response) {
//            $scope.greeting = response.data;
//        });
	$http({
		method : 'GET',
		url : 'http://192.168.0.10:8081/agendamento',
		 headers: {
			   'Content-Type': undefined
			 },
	}).success(function(retorno) {
		$scope.agendamento = retorno[0];
	}).
	error(function(status) {
		alert("Ops! Ocorreu um erro, atualize a pagina");
	});
});
