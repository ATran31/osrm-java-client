# Usage
A set of classes and methods for accessing services from [Open Source Routing Machine HTTP API](http://project-osrm.org/docs/v5.7.0/api/#general-options).

## Classes

### Class: Match
Map matching matches/snaps given GPS points to the road network in the most plausible way. Please note the request might result multiple sub-traces. Large jumps in the timestamps (> 60s) or improbable transitions lead to trace splits if a complete matching could not be found. The algorithm might not be able to match all points. Outliers are removed if they can not be matched successfully.
**Not all request options have been implemented.**
See [http://project-osrm.org/docs/v5.7.0/api/#match-service](http://project-osrm.org/docs/v5.7.0/api/#match-service).
##### Match Methods
###### matchPoints(String coordinates)
>Snaps the supplied coordinates to the road network, and returns the most likely route given the points.  
**@param coordinates** The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.  
**@return** A JSON object containing the response code, an array of waypoint objects, and an array of route objects.
###### matchPoints(String coordinates, String profile)
>Snaps the supplied coordinates to the road network, and returns the most likely route given the points.  
**@param coordinates** The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.  
**@param profile** The mode of travel. Valid values are 'car', 'bike' and 'foot'.  
**@return** A JSON object containing the response code, an array of waypoint objects, and an array of route objects.

---

### Class: Nearest
Snaps a coordinate to the street network and returns the nearest n matches.
Where coordinates only supports a single {longitude},{latitude} entry.
See [http://project-osrm.org/docs/v5.7.0/api/#nearest-service](http://project-osrm.org/docs/v5.7.0/api/#nearest-service).
##### Nearest Methods
###### findNearestRoute(String coordinates)
>Finds the nearest route to the given location.  
**@param coordinates** The string containing a single comma separated lon/lat pair. Only one coordinate pair is permitted.  
**@return** A JSON object containing the response code, and an array of waypoint objects.  
###### findNearestRoute(String coordinates, int maxReturns)
>Finds the nearest route to the given location, limiting the number of results to a specified number.  
**@param coordinates** The string containing a single comma separated lon/lat pair. Only one coordinate pair is permitted.  
**@param maxReturns** The maximum number of matches to return.  
**@return** A JSON object containing the response code, and an array of waypoint objects.
###### findNearestRoute(String coordinates, String profile)
>Finds the nearest route to the given location, accounting for mode of travel.  
**@param coordinates** The string containing a single comma separated lon/lat pair. Only one coordinate pair is permitted.  
**@param profile** The mode of travel. Valid values are 'car', 'bike' and 'foot'.  
**@return** A JSON object containing the response code, and an array of waypoint objects.
###### findNearestRoute(String coordinates, String profile, int maxReturns)
>Finds the nearest route to the given location, accounting for mode of travel and limiting the number of results to a specified number.  
**@param coordinates** The string containing a single comma separated lon/lat pair. Only one coordinate pair is permitted.  
**@param profile** The mode of travel. Valid values are 'car', 'bike' and 'foot'.  
**@return** A JSON object containing the response code, and an array of waypoint objects.

---

### Class Route
Handles point to point routing.
**Not all request options have been implemented.**
See [http://project-osrm.org/docs/v5.7.0/api/#route-service](http://project-osrm.org/docs/v5.7.0/api/#route-service).
##### Route Methods
###### getFastestRoute(String coordinates)
>Finds the fastest route between coordinates in the supplied order.  
**@param coordinates** The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.  
**@return** A JSON object containing the response code, an array of waypoint objects, and an array of route objects
###### getFastestRoute(String coordinates, String profile)
>Finds the fastest route between coordinates in the supplied order, accounting for mode of travel.  
**@param coordinates** The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.  
**@param profile** The string specifying mode of travel. Valid values are 'car', 'bike' and 'foot'.  
**@return** A JSON object containing the response code, an array of waypoint objects, and an array of route objects.

---

### Class Table
Calculates the travel time matrix of the fastest route between all supplied coordinates. No geographic data is returned with this service. **Not all request options have been implemented.**
See [http://project-osrm.org/docs/v5.7.0/api/#table-service](http://project-osrm.org/docs/v5.7.0/api/#table-service).
##### Table Methods
###### generateTravelTimeMatrix(String coordinates)
>Finds the fastest route between coordinates in the supplied order.  
**@param coordinates** The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.  
**@return** A JSON object containing the response code, a 2d array of durations, and arrays of waypoint objects representing sources, and an destinations.
###### generateTravelTimeMatrix(String coordinates, String profile)
>Finds the fastest route between coordinates in the supplied order accounting for mode of travel.  
**@param coordinates** The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.  
**@param profile** The mode of travel. Valid values are 'car', 'bike' and 'foot'.  
**@return** A JSON object containing the response code, a 2d array of durations, and arrays of waypoint objects representing sources, and an destinations.

---

### Class Trip 
The trip service solves the Traveling Salesman Problem using a greedy heuristic (farthest-insertion algorithm) for 10 or more waypoints and uses brute force for less than 10 waypoints. The returned path does not have to be the fastest path. As TSP is NP-hard it only returns an approximation. Note that all input coordinates have to be connected for the trip service to work. **Not all request options have been implemented.**
See [http://project-osrm.org/docs/v5.7.0/api/#trip-service](http://project-osrm.org/docs/v5.7.0/api/#trip-service).
##### Trip Methods
###### generateTrip(String coordinates)
>Solves the Traveling Salesman Problem using the road network and input points.  
**@param coordinates** The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.  
**@return** A JSON object containing the response code, an array of waypoint objects, and an array of route objects.
###### generateTrip(String coordinates, String profile)
>Solves the Traveling Salesman Problem using the road network and input points.  
**@param coordinates** The string containing comma separated lon/lat. Multiple coordinate pairs are separated by a semicolon.  
**@param profile** The mode of travel. Valid values are 'car', 'bike' and 'foot'.  
**@return** A JSON object containing the response code, an array of waypoint objects, and an array of route objects.

---

### Class Tile
#### Not yet implemented.
The tile generates Mapbox Vector Tiles that can be viewed with a vector-tile capable slippy-map viewer. The tiles contain road geometries and metadata that can be used to examine the routing graph. The tiles are generated directly from the data in-memory, so are in sync with actual routing results, and let you examine which roads are actually routable, and what weights they have applied. See [http://project-osrm.org/docs/v5.7.0/api/#tile-service](http://project-osrm.org/docs/v5.7.0/api/#tile-service).