testApp.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/automobili',{
        templateUrl: '/app/views/automobili.html'
    }).otherwise({
        redirectTo: '/'
    });
}]);