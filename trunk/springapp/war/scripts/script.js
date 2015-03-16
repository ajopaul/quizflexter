//script.js

//create the module and name it scotchApp
//include ngRoute for routing needs
var scotchApp = angular.module('scotchApp',['ngRoute']);

scotchApp.config(function($routeProvider){
	$routeProvider
	
	.when('/home',{
		templateUrl : 'pages/home.html',
		controller : 'mainController'
	})
	
	.when('/settings',{
		templateUrl : 'pages/settings.html',
		controller : 'settingsController'
	})
	
	.when('/about',{
		templateUrl : 'pages/about.html',
		controller : 'aboutController'
	})
	
	.when('/help',{
		templateUrl : 'pages/help.html',
		controller : 'helpController'
	})
	
	.when('/programs',{
		templateUrl : 'pages/programs.html',
		controller : 'programsController'
	})
	
	.when('/clients',{
		templateUrl : 'pages/clients.html',
		controller : 'clientsController'
	})
	
	.when('/events',{
		templateUrl : 'pages/events.html',
		controller : 'eventsController'
	})
	
	.when('/addProgram',{
		templateUrl : 'pages/createPrograms.html',
		controller : 'createProgramsController'
	});
	
	
});

//create the controller and inject Angular's $scope
scotchApp.controller('mainController',function($scope){
	//create a message to display in our view
	$scope.message = "Home page under construction!"
});

//create the controller and inject Angular's $scope
scotchApp.controller('aboutController',function($scope){
	//create a message to display in our view
	
	$scope.message = "About page under construction!"
});

//create the controller and inject Angular's $scope
scotchApp.controller('settingsController',function($scope){
	//create a message to display in our view
	$scope.message = "Settings page under construction"
		
});

scotchApp.controller('helpController',function($scope){
	//create a message to display in our view
	$scope.message = "Help page under construction"
		
});


scotchApp.controller('createProgramsController',function($scope){
	//create a message to display in our view
	$scope.message = "Help page under construction"
		
});
scotchApp.controller('programsController',function($scope,$http){
	
	 $http.get('responseservlet?listPrograms=true').
	    success(function(data, status, headers, config) {
	    /*  //$scope.posts = data;
	      $scope.region = data.Region;
	      $scope.category = data.Category;
	      $scope.message = data.message;*/
	    	var programs1 = data.programs1.split(",");
	    		    	alert(programs1);
	    	$scope.program11=programs1[0];
	    	$scope.program12=programs1[1];
	    	$scope.program13=programs1[2];
	    	
	    	var programs2 = data.programs2.split(",");
	    	
	    	$scope.program21=programs1[0];
	    	$scope.program22=programs1[1];
	    	$scope.program23=programs1[2];
	    	
	    	var programs3 = data.programs3.split(",");
	    	
	    	$scope.program31=programs1[0];
	    	$scope.program32=programs1[1];
	    	$scope.program33=programs1[2];
	    	
	    	
	    	
	    }).
	    error(function(data, status, headers, config) {
	      // log error
	    });
	
		
});

scotchApp.controller('clientsController',function($scope){
	//create a message to display in our view
	$scope.message = "Clients page under construction"
		
});

scotchApp.controller('eventsController',function($scope){
	//create a message to display in our view
	$scope.message = "Events page under construction"
		
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

