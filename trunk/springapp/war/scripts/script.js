//script.js

//create the module and name it adrApp
//include ngRoute for routing needs
var adrApp = angular.module('adrApp',['ngRoute','ui.bootstrap']);

adrApp.config(function($routeProvider){
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
adrApp.controller('mainController',function($scope){
	//create a message to display in our view
	$scope.message = "Home page under construction!"
});

//create the controller and inject Angular's $scope
adrApp.controller('aboutController',function($scope){
	//create a message to display in our view
	
	$scope.message = "About page under construction!"
});

//create the controller and inject Angular's $scope
adrApp.controller('settingsController',function($scope){
	//create a message to display in our view
	$scope.message = "Settings page under construction"
		
});

adrApp.controller('helpController',function($scope){
	//create a message to display in our view
	$scope.message = "Help page under construction"
		
});


adrApp.controller('createProgramsController',function($scope,$http){

$scope.programTypes = [
	                   { label: 'Level', value: 'Level' },
	                   { label: 'Delta', value: 'Delta' },
	                   { label: 'Duty Cycle', value: 'DutyCycle' },
	                   { label: 'Multiplier', value: 'Multiplier' },
	                   { label: 'Price', value: 'Price' },
	                   { label: 'Price Multiplier', value: 'PriceMultiplier' },
	                   { label: 'Price Relative', value: 'PriceRelative' },
	                   { label: 'Product', value: 'Product' }
	                 ];

$scope.venPushLevel = [
	                   { label: 'Min Event', value: 'MinLevel' },
	                   { label: 'Full Event', value: 'Full Event' },
	                   { label: 'All', value: 'All' }
	                 ];
	 



	$scope.ProgramType = $scope.programTypes[0];
	$scope.VenPushLevel = $scope.venPushLevel[1];

	
	$scope.programs = { DefIssueTime :'10:00', DefStartTime:'12:00' ,DefEventDur:'240'
	,DefTolStartTime:'0',DefTolStartAfterTime:'0',MinIssueStart:'0'	
	};
	 
		$scope.submitMyForm=function(){
        /* while compiling form , angular created this object*/
        var data=$scope.programs;  
     //   alert(data);
        /* post to server*/
        $http.post('responseservlet?addProgram=true', data).
        	success(function(data,status,headers,config){
        		
        	}).error(function(data,status,headers,config){
        		
        	});        
    }	
});
adrApp.controller('programsController',function($scope,$http){
	$scope.programs = [];	
	 $http.get('responseservlet?listPrograms=true').
	    success(function(data, status, headers, config) {
	    	$scope.programs = data;	
	    	    	
	    }).
	    error(function(data, status, headers, config) {
	      // log error
	    });
	
		
});

adrApp.controller('clientsController',function($scope){
	//create a message to display in our view
	$scope.message = "Clients page under construction"
		
});

adrApp.controller('eventsController',function($scope){
	//create a message to display in our view
	$scope.message = "Events page under construction"
		
});



//create the controller and inject Angular's $scope
adrApp.controller('sampleDataController',function($scope,$http){
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

