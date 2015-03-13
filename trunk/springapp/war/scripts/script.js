//script.js

//create the module and name it scotchApp
//include ngRoute for routing needs
var scotchApp = angular.module('scotchApp',['ngRoute']);

scotchApp.config(function($routeProvider){
	$routeProvider
	
	.when('/',{
		templateUrl : 'pages/home.html',
		controller : 'mainController'
	})
	
	.when('/about',{
		templateUrl : 'pages/about.html',
		controller : 'aboutController'
	})
	
	.when('/contact',{
		templateUrl : 'pages/contact.html',
		controller : 'contactController'
	})
	
	.when('/sampledata',{
		templateUrl : 'pages/sampledata.html',
		controller : 'sampleDataController'
	});
	
});

//create the controller and inject Angular's $scope
scotchApp.controller('mainController',function($scope){
	//create a message to display in our view
	$scope.message = "Everyone come and see how good I look!'"
});

//create the controller and inject Angular's $scope
scotchApp.controller('aboutController',function($scope){
	//create a message to display in our view
	$scope.message = "Everyone come and see how good I look in about page!'"
});

//create the controller and inject Angular's $scope
scotchApp.controller('contactController',function($scope){
	//create a message to display in our view
	$scope.message = "Everyone come and see how good I look contact me page!'"
});

//create the controller and inject Angular's $scope
scotchApp.controller('sampleDataController',function($scope,$http){
	//create a message to display in our view
	

	 $http.get('responseservlet').
	    success(function(data, status, headers, config) {
	      //$scope.posts = data;
	      $scope.region = data.Region;
	      $scope.category = data.Category;
	      $scope.message = data.message;
	    }).
	    error(function(data, status, headers, config) {
	      // log error
	    });
	
	
	//$scope.message = "Everyone come and see how good I look contact me page!'"
});

