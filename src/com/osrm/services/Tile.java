package com.osrm.services;

/**
 * Tile service generates Mapbox Vector Tiles that can be viewed with a vector-tile capable slippy-map viewer.
 * The tiles contain road geometries and metadata that can be used to examine the routing graph.
 * The tiles are generated directly from the data in-memory, so are in sync with actual routing results, and let you examine which roads are actually routable, and what weights they have applied.
 * @author An Tran
 * @see http://project-osrm.org/docs/v5.7.0/api/#tile-service 
 *
 */
public class Tile {

	public Tile(){}
	
	private static String getTileNumber(final double lat, final double lon, final int zoom) {
		int xtile = (int)Math.floor( (lon + 180) / 360 * (1<<zoom) ) ;
		int ytile = (int)Math.floor( (1 - Math.log(Math.tan(Math.toRadians(lat)) + 1 / Math.cos(Math.toRadians(lat))) / Math.PI) / 2 * (1<<zoom) ) ;
		if (xtile < 0)
			xtile=0;
		if (xtile >= (1<<zoom))
			xtile=((1<<zoom)-1);
		if (ytile < 0)
			ytile=0;
		if (ytile >= (1<<zoom))
			ytile=((1<<zoom)-1);
		return("" + zoom + "/" + xtile + "/" + ytile);
	}
	
	//TODO figure out how to handle application/x-protobuf responses

}
