jQuery(document).ready(function(){

	/***
	Adding Google Map.
	***/

	/* Calling goMap() function, initializing map and adding markers. */
	jQuery('#map').goMap({
		maptype: 'ROADMAP',
        latitude: -23.511688, 
        longitude: -47.493903,
        zoom: 16,
        disableDefaultUI: true,
        mapTypeControl: false,
        zoomControl: false,
        scrollwheel: false,
        icon: 'img/logoMap.png', 
		markers: [
			{latitude: -23.511688,longitude: -47.493903,}
		]
	});
	/* Hiding all the markers on the map. */
	for (var i in $.goMap.markers) {
		if (this[i] !== 0) {
			$.goMap.showHideMarker(jQuery.goMap.markers[i], true);
		}
	}

	/* Revealing markers from the first group - 'airport' */
	$.goMap.showHideMarkerByGroup('shop', true);

});