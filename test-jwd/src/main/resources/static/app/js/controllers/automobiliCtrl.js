function automobiliCtrl($scope, $http, $location, $log, automobiliService, kompanijeService) {

	$log.log("Instantiating automobiliCtrl");

	$scope.kompanije = [];
	$scope.automobili = [];

	$scope.pageNum = 0;
	$scope.totalPages = 0;

	$scope.trazeniAutomobil = {};
	$scope.trazeniAutomobil.model = "";
	$scope.trazeniAutomobil.godiste = "";
	$scope.trazeniAutomobil.potrosnja = "";

	var getAutomobili = function() {

		var config = {
			params : {}
		};

		config.params.pageNum = $scope.pageNum;

		if ($scope.trazeniAutomobil.model != "") {
			config.params.model = $scope.trazeniAutomobil.model;
		}

		if ($scope.trazeniAutomobil.godiste != "") {
			config.params.godiste = $scope.trazeniAutomobil.godiste;
		}

		if ($scope.trazeniAutomobil.potrosnja != "") {
			config.params.potrosnja = $scope.trazeniAutomobil.potrosnja;
		}

		automobiliService.getAutomobili(config, function(res) {
			$scope.automobili = res.data;
			$scope.totalPages = res.headers('totalPages');
		});
	};

	var getKompanije = function() {
		kompanijeService.getKompanije(function(res) {
			$log.log(res.data);
			$scope.kompanije = res.data;
		});
	};

	getAutomobili();
	getKompanije();

}