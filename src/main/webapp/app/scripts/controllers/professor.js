FirstApp.controller('ProfessorController', ['$scope', 'Professor',
    function($scope, Professor) {
	
	$scope.entities = Professor.query();
	$scope.entity = {};

	$scope.edit = function(id) {
		$scope.entity = Professor.get({
			id : id
		});
	};

	$scope.save = function() {
		Professor.save($scope.entity, function(data) {
			$scope.entity = {};
			$scope.entities = Professor.query();
		});
	};

	$scope.remove = function(id) {
		Professor.remove({
			id : id
		}, function() {
			$scope.entities = Professor.query();
		});
	};
	
    }]);
