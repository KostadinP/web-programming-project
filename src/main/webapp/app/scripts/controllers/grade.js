FirstApp.controller('GradeController', [ '$scope', 'Grade',
		function($scope, Grade) {

			$scope.entities = Grade.query();
			$scope.entity = {};

			$scope.edit = function(id) {
				$scope.entity = Grade.get({
					id : id
				});
			};

			$scope.studentName = function(item) {
				return item.ime + " " + item.prezime;
			}

			$scope.save = function() {
				Grade.save($scope.entity, function(data) {
					$scope.entity = {};
					$scope.entities = Grade.query();
				});
			};

			$scope.remove = function(id) {
				Grade.remove({
					id : id
				}, function() {
					$scope.entities = Grade.query();
				});
			};

		} ]);
