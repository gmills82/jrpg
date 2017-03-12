angular.module('JRPGApp', ['ui.bootstrap'])

	.controller('CharacterDisplayController', function($scope) {
		$scope.characters = [
			{
				name: "El Blanco Diablo",
				initiative: "7",
				combatSpeed: "3"
			},
			{
				name: "Chaddius Thunderloins",
				initiative: "4",
				combatSpeed: "4"
			}
		];

	});