function kompanijeService($http, $log) {
	
	var apiKompanije = "/api/kompanije";

	this.getKompanije = function(cb) {
		$log.log("Called getKompanije function")
		$http.get(apiKompanije).then(function success(res) {
			$log.log(res.data);
			cb(res);
		}, function error(res) {
			$log.error("Couldn't fetch kompanije");
		});

	};

}