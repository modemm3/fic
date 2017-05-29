/**
 * Directiva de productos 
 */
//
//angular.module('app.directive').directive('producto',function(){
//	return{
//		restrict:'AE',
//		scope:{
//			cliente:'=cliente'
//		},
////		template:'name: {{cliente}}'
//			templateUrl:'directive/views/product.html'
//	}
//});
angular.module('app.directive').directive('product',function(){

    return {
        restrict: 'E',
        scope: {
          tag: '=',
          autocomplete: '=autocomplete'
        },
        templateUrl:'directive/views/product.html',
        link: function ( $scope, $element ) {
            
      		var input = angular.element($element).find('input');

      		// setup autocomplete
      		if ($scope.autocomplete) {
              $scope.autocompleteFocus = function(event, ui) {
                input.val(ui.item.value);
                return false;
              };
              $scope.autocompleteSelect = function(event, ui) {
                $scope.newValue = ui.item.value;
                $scope.$apply( $scope.add );
                
                return false;
              };
              $($element).find('input').autocomplete({
                    minLength: 0,
                    source: function(request, response) {
                      var item;
                      return response((function() {
                        var _i, _len, _ref, _results;
                        _ref = $scope.autocomplete;
                        _results = [];
                        for (_i = 0, _len = _ref.length; _i < _len; _i++) {
                          item = _ref[_i];
                          if (item.name.toLowerCase().indexOf(request.term.toLowerCase()) !== -1) {
                            _results.push(item.name);
                          }
                        }
                        return _results;
                      })());
                    },
                    focus: (function(_this) {
                      return function(event, ui) {
                        return $scope.autocompleteFocus(event, ui);
                      };
                    })(this),
                    select: (function(_this) {
                      return function(event, ui) {
                        return $scope.autocompleteSelect(event, ui);
                      };
                    })(this)
                  });
            }	
                  

             // adds the new tag to the array
            $scope.add = function() {
  				// if not dupe, add it
//  				if ($scope.tags.name.indexOf($scope.newValue)==-1){
//                	$scope.tags.name.push( $scope.newValue.name );
            		
            	
            	
  					$scope.tag.name=$scope.newValue;
//  					$scope.tag.description=$scope.tag.description;
  					
  					angular.forEach($scope.autocomplete, function(value, key) {
//  					  this.push(key + ': ' + value);
  					  if(value.name==$scope.newValue){
  						  $scope.tag=value;
  						  $scope.tag.measureUnit.name='Kilo';
  					  }
  					});
  					
//                }
//                $scope.newValue = "";
            };
            
            // remove an item
//            $scope.remove = function ( idx ) {
//                $scope.tags.splice( idx, 1 );
//            };
//            
            // capture keypresses
            input.bind( 'keypress', function ( event ) {
                // enter was pressed
                if ( event.keyCode == 13 ) {
                    $scope.$apply( $scope.add );
                }
            });
        }
    };
});