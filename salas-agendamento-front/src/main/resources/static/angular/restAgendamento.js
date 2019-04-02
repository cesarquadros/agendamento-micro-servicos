angular.module('demo', [])
.controller('Hello', function($scope, $http) {
//    $http.get('http://127.0.0.1:8082/cliente').
//        then(function(response) {
//            $scope.greeting = response.data;
//        });
	$http({
		method : 'GET',
		url : 'http://34.73.225.130:8081/agenda',
		 headers: {
			   'Content-Type': undefined
			 },
	}).then(function(retorno) {
		$scope.agendamento = retorno.data[0];
	}, function(erro) {
		alert("Ops! Ocorreu um erro, atualize a pagina " + erro);
	});
});
