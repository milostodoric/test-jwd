testApp.controller("automobilCtrl", automobilCtrl);

automobilCtrl.$inject = ['$scope', '$http', '$location', ];

function automobilCtrl($scope, $http, $location) {

    var baseUrlKompanije = "/api/kompanije";
    var baseUrlAutomobili = "/api/automobili";

    $scope.automobili = [];
    
    $scope.trazeniAutomobil = {};
    $scope.trazeniAutomobil.model = "";
    $scope.trazeniAutomobil.godiste = "";
    $scope.trazeniAutomobil.potrosnja = "";

    init();

    function init() {
        getAutomobili();
    }


    function getAutomobili(){

        var config = {
            params: {}
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


        $http.get(baseUrlAutomobili, config)
            .then(
                function success(res) {
                    $scope.automobili = res.data;
                    $scope.totalPages = res.headers('totalPages');
                },
                function error(res) {
                    alert("Neuspesno dobavljanje automobila!");
                }
            );
    };
}