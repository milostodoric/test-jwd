function automobiliService($http, $log) {
	
	var apiAutomobili = "/api/automobili";

	this.getAutomobili = function(config, cb) {
		
		$log.log("Called getAutomobili function")

		$http.get(apiAutomobili, config).then(function success(res) {
			$log.log(res.data);
			cb(res);
		}, function error(res) {
			$log.error("Couldn't fetch automobili");
		});

	};

}