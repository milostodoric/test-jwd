testApp.config(function ($routeProvider) {
    $routeProvider.when('/automobili',{
        templateUrl: '/app/views/automobili.html'
    })
    .when('/automobili',{
        templateUrl: '/app/views/automobili.html'
    })
    .otherwise({
        redirectTo: '/'
    });
});