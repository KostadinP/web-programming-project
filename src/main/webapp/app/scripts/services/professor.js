var contextPath = "/web-programming";

/*
 * Generic CRUD resource REST service
 */
FirstApp.factory('Professor', [ '$resource', function($resource) {
	return $resource(contextPath + '/data/rest/professors/:id', {}, {});
} ]);
