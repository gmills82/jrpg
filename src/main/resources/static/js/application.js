var jrpgApp = angular.module("JRPGApp", ['ui.bootstrap', 'characterList', 'characterAdd', "spring-data-rest"]);

//Spring Data HATEOAS module as global interceptor
jrpgApp.config(function (SpringDataRestInterceptorProvider) {
	SpringDataRestInterceptorProvider.apply();
});