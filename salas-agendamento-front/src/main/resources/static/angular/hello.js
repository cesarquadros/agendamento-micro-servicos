angular.module('demo', [])
.controller('Hello', function($scope, $http) {
//    $http.get('http://127.0.0.1:8082/cliente').
//        then(function(response) {
//            $scope.greeting = response.data;
//        });
	$http({
		method : 'GET',
		url : 'http://127.0.0.1:8082/cliente',
		 headers: {
			   'Content-Type': undefined
			 },
	}).success(function(retorno) {
		$scope.cliente = retorno[0];
	}).
	error(function(status) {
		alert("Ops! Ocorreu um erro, atualize a pagina");
	});
});
