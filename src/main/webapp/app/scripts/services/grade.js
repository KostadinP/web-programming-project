var contextPath = "/web-programming";

/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('Grade', [ '$resource', function($resource) {
	return $resource(contextPath + '/data/rest/grades/:id', {}, {});
} ]);
