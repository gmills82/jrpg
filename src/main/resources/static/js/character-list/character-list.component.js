angular.module('characterList')
	.component('characterList', {
		templateUrl: "js/character-list/character-list.template.html",
		controller: ['$http', function CharacterListController($http) {
			var self = this;
			this.characters = $http.get("api/characters").then(function (response) {
				self.characters = response.data._embeddedItems;
			});
		}]
	});