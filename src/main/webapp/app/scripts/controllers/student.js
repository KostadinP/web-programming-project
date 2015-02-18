FirstApp.controller('StudentController', ['$scope', 'Student',
    function($scope, Student) {
	
	$scope.entities = Student.query();
	$scope.entity = {};

	$scope.edit = function(id) {
		$scope.entity = Student.get({
			id : id
		});
	};

	$scope.save = function() {
		Student.save($scope.entity, function(data) {
			$scope.entity = {};
			$scope.entities = Student.query();
		});
	};

	$scope.remove = function(id) {
		Student.remove({
			id : id
		}, function() {
			$scope.entities = Student.query();
		});
	};
	
    }]);
