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
	
	.when('/editProgram',{
		templateUrl : 'pages/createPrograms.html',
		controller : 'editProgramsController'
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


adrApp.service('programService', function() {
	  this.userData = {ProgramId:0};

	  this.user = function() {
	        return this.userData;
	  };

	  this.setProgramId = function(ProgramId){
		  this.userData.ProgramId = ProgramId;
	  };
	  
	  this.getProgramId = function(){
		  return this.userData.ProgramId;
	  };
	  
	 
	});



/**
 *	***** EDIT A PROGRAM ****  
 */

adrApp.controller('editProgramsController',function($scope,$http,$timeout,$location,programService){

	/*
	 * When user clicks on cancel button
	 */
	$scope.cancel = function () {
		  $location.path( '/programs' );
		};

		//alert(programService.getProgramId);
		$scope.programs = [];	
		 $http.get('responseservlet?editProgram=true&programId='+programService.getProgramId()).
		    success(function(data, status, headers, config) {
		    	$scope.programs = data;
		    }).
		    error(function(data, status, headers, config) {
		      // log error
		    });
		
		/*
		 *Select drop down values for program types 
		 */
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
/*
 *Select drop down values for Ven Push Level 
 */
$scope.venPushLevel = [
	                   { label: 'Min Event', value: 'MinLevel' },
	                   { label: 'Full Event', value: 'Full Event' },
	                   { label: 'All', value: 'All' }
	                 ];
	 


//Set default values of the select drop downs.
	$scope.ProgramType = $scope.programTypes[0];
	$scope.VenPushLevel = $scope.venPushLevel[1];

	//Set default values
	$scope.programs = { DefIssueTime :'10:00', DefStartTime:'12:00' ,DefEventDur:'240'
	,DefTolStartTime:'0',DefTolStartAfterTime:'0',MinIssueStart:'0'	
	};
	 
	/*
	 * Called when submit is pressed i.e. ok button
	 */
		$scope.submitMyForm=function(){

        var data=$scope.programs;  
        data.ProgramType=$scope.ProgramType.value;
        data.VenPushLevel=$scope.VenPushLevel.value;
        
        /* post to server*/
        $http.post('responseservlet?addProgram=true', data).
        	success(function(data,status,headers,config){
				/*
				 * On sucess show a succes message and disappear
				 */
        	    var messageTimer = false,
        	        displayDuration = 1000; // milliseconds 
        	    
        	    $scope.showMessage = false;
        	    $scope.msg = "Sucessfully created program!";
        	    if (messageTimer) {
        	            $timeout.cancel(messageTimer);
        	    }
        	        
        	        $scope.showMessage = true;
        	    
        	        //When timeout expires redirect to programs page.
        	        messageTimer = $timeout(function () {
        	            $scope.showMessage = false;
        	            $location.path('/programs');
        	        }, displayDuration);
        	    
        		
        	}).error(function(data,status,headers,config){

				/*
				 * On failure show a error message
				 */
        	    var messageTimer = false,
        	        displayDuration = 1000; // milliseconds 
        	    
        	    $scope.showErrMessage = false;
        	    $scope.errMsg = "Error while creating program.";
        	    if (messageTimer) {
        	            $timeout.cancel(messageTimer);
        	    }
        	        
        	        $scope.showErrMessage = true;
        	    
        	        //When timeout expires redirect to programs page.
        	        messageTimer = $timeout(function () {
        	            $scope.showErrMessage = false;
        	            //$location.path('/programs');
        	        }, displayDuration);
        	    
        		
        	
        	});        
    }
		
});

/**
 * ***** ADD A PROGRAM ***** 
 */
adrApp.controller('createProgramsController',function($scope,$http,$timeout,$location){
	
	/*
	 * When user clicks on cancel button
	 */
	$scope.cancel = function () {
		  $location.path( '/programs' );
		};

		/*
		 *Select drop down values for program types 
		 */
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
/*
 *Select drop down values for Ven Push Level 
 */
$scope.venPushLevel = [
	                   { label: 'Min Event', value: 'MinLevel' },
	                   { label: 'Full Event', value: 'Full Event' },
	                   { label: 'All', value: 'All' }
	                 ];
	 


//Set default values of the select drop downs.
	$scope.ProgramType = $scope.programTypes[0];
	$scope.VenPushLevel = $scope.venPushLevel[1];

	//Set default values
	$scope.programs = { DefIssueTime :'10:00', DefStartTime:'12:00' ,DefEventDur:'240'
	,DefTolStartTime:'0',DefTolStartAfterTime:'0',MinIssueStart:'0'	
	};
	 
	/*
	 * Called when submit is pressed i.e. ok button
	 */
		$scope.submitMyForm=function(){

        var data=$scope.programs;  
        data.ProgramType=$scope.ProgramType.value;
        data.VenPushLevel=$scope.VenPushLevel.value;
        
        /* post to server*/
        $http.post('responseservlet?addProgram=true', data).
        	success(function(data,status,headers,config){
				/*
				 * On sucess show a succes message and disappear
				 */
        	    var messageTimer = false,
        	        displayDuration = 1000; // milliseconds 
        	    
        	    $scope.showMessage = false;
        	    $scope.msg = "Sucessfully created program!";
        	    if (messageTimer) {
        	            $timeout.cancel(messageTimer);
        	    }
        	        
        	        $scope.showMessage = true;
        	    
        	        //When timeout expires redirect to programs page.
        	        messageTimer = $timeout(function () {
        	            $scope.showMessage = false;
        	            $location.path('/programs');
        	        }, displayDuration);
        	    
        		
        	}).error(function(data,status,headers,config){

				/*
				 * On failure show a error message
				 */
        	    var messageTimer = false,
        	        displayDuration = 1000; // milliseconds 
        	    
        	    $scope.showErrMessage = false;
        	    $scope.errMsg = "Error while creating program.";
        	    if (messageTimer) {
        	            $timeout.cancel(messageTimer);
        	    }
        	        
        	        $scope.showErrMessage = true;
        	    
        	        //When timeout expires redirect to programs page.
        	        messageTimer = $timeout(function () {
        	            $scope.showErrMessage = false;
        	            //$location.path('/programs');
        	        }, displayDuration);
        	    
        		
        	
        	});        
    }
		
		
});

/**
 * *** LIST PROGRAMS ***
 */

adrApp.controller('programsController',function($scope,$location,$route,$timeout,$http,$modal,programService){
	$scope.programs = [];	
	 $http.get('responseservlet?listPrograms=true').
	    success(function(data, status, headers, config) {
	    	$scope.programs = data;	
	    	//console.log(data.length);
	    
	    	/*angular.forEach($scope.programs,function(program){
	    		program.links=program.ProgramId;
	    	});*/
	    }).
	    error(function(data, status, headers, config) {
	      // log error
	    });
	
	 
	 $scope.edit = function (programId) {
		// alert(programId);
		  programService.setProgramId(programId);
		  $location.path( '/editProgram' );
		};
	
	$scope.remove = function (programId) {
			// alert(programId);
			  programService.setProgramId(programId);
			  
			  var modalInstance = $modal.open({
			      templateUrl: 'myModalContent.html',
			      controller: 'ModalInstanceCtrl',
			      size:'sm'
			    });

			    modalInstance.result.then(function (selectedItem) {
			    	/*
					 * On sucess show a succes message and disappear
					 */
	        	    var messageTimer = false,
	        	        displayDuration = 1500; // milliseconds 
	        	    
	        	    $scope.showMessage = false;
	        	    $scope.msg = "Sucessfully deleted program!";
	        	    if (messageTimer) {
	        	            $timeout.cancel(messageTimer);
	        	    }
	        	        
	        	        $scope.showMessage = true;
	        	    
	        	        //When timeout expires redirect to programs page.
	        	        messageTimer = $timeout(function () {
	        	            $scope.showMessage = false;
	        	            $route.reload();
	        	        }, displayDuration);
			    }, function () {
			     
			    	// $log.info('Modal dismissed at: ' + new Date());
			    });
			  
			 // $location.path( '/editProgram' );
			};	
});

//Please note that $modalInstance represents a modal window (instance) dependency.
//It is not the same as the $modal service used above.

	adrApp.controller('ModalInstanceCtrl', function ($scope, $http,$location, $timeout,$modalInstance,programService ) {

	$scope.ok = function () {
		$modalInstance.close();
		 $http.post('responseservlet?deleteProgram=true&programId='+programService.getProgramId()).
		    success(function(data, status, headers, config) {

				
        	    
        		
        	
		    	
		    }).
		    error(function(data, status, headers, config) {

				/*
				 * On failure show a error message
				 */
        	    var messageTimer = false,
        	        displayDuration = 3000; // milliseconds 
        	    
        	    $scope.showErrMessage = false;
        	    $scope.errMsg = "Error while deleting program.";
        	    if (messageTimer) {
        	            $timeout.cancel(messageTimer);
        	    }
        	        
        	        $scope.showErrMessage = true;
        	    
        	        //When timeout expires redirect to programs page.
        	        messageTimer = $timeout(function () {
        	            $scope.showErrMessage = false;
        	            //$location.path('/programs');
        	        }, displayDuration);
        	    
        		
        	
        	});
	};

	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
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

