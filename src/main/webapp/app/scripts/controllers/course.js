FirstApp.controller('CourseController', ['$scope', 'Course',
    function($scope, Course) {
	
	$scope.entities = Course.query();
	$scope.entity = {};

	$scope.edit = function(id) {
		$scope.entity = Course.get({
			id : id
		});
	};

	$scope.save = function() {
		Course.save($scope.entity, function(data) {
			$scope.entity = {};
			$scope.entities = Course.query();
		});
	};

	$scope.remove = function(id) {
		Course.remove({
			id : id
		}, function() {
			$scope.entities = Course.query();
		});
	};
	
    }]);
