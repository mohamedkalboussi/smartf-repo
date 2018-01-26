var app=angular.module("myBanqueApp", []);

app.controller("myBanqueController", function($scope, $http) {
	
	$scope.compte = null;
	$scope.codeCompte = null;
	$scope.operation = {type:"versement",montant:0};
	$scope.pageOperations = [];
	$scope.pageCourante = 0;
	$scope.pageSize = 3;
	$scope.pages = [];
	
	$scope.chargerCompte = function() {
		$http.get("/comptes/"+$scope.codeCompte).success(function(data) {
			$scope.compte = data;
			$scope.pageCourante = 0;
			$scope.chargerOperations();
		});
	};
	
	$scope.chargerOperations = function() {
		$http.get("/operations?codeCompte="+$scope.codeCompte+"&page="+$scope.pageCourante+"&size="+$scope.pageSize)
		.success(function(data) {
			$scope.pageOperations = data;
			$scope.pages = new Array(data.totalPages);
		});
	};
	
	$scope.goToPage = function(p) {
		$scope.pageCourante = p;
		$scope.chargerOperations();
	};
	
	$scope.saveOperation = function() {
		$http({
			method  : 'PUT',
			url     : $scope.operation.type,
			data    : "codeCompte="+$scope.codeCompte+"&montant="+$scope.operation.montant+"&idEmploye=1",
			headers : {'Content-Type': 'application/x-www-form-urlencoded'}
		})
		.success(function(data) {
			$scope.chargerCompte();
			//$scope.loadOperations();
		});
	};
	
});

