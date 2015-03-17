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


scotchApp.controller('createProgramsController',function($scope,$http){

	
		$scope.submitMyForm=function(){
        /* while compiling form , angular created this object*/
        var data=$scope.programs;  
        /* post to server*/
        $http.post('responseservlet?addProgram=true', data);        
    }	
});
scotchApp.controller('programsController',function($scope,$http){
	$scope.programs = [];	
	 $http.get('responseservlet?listPrograms=true').
	    success(function(data, status, headers, config) {
	    	$scope.programs = data;	
	    	    	
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

