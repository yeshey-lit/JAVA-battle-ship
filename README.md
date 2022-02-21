<h3>Overview</h3>
Using the provided battleship.jar game in the zip, the Java program in the zip/src generates a strategy to enhance the efficiency of hunting battleships. <br><br>
•	In every round, A6.java is the main() to call out SampleBot object, which contains strategy and random Battleship coordinates created by BattlesShip object from battleship.jar.<br>
•	SampleBot makes a scan on the map from top to down, left to right. When a ship hits, the neighbor coordinates in “down, right, left, up” will be prioritized in the queue. <br>
•	The neighbor coordinates are imported into the queue in the “down, right, left, up” order, because the initial scan came from top to down. The rest of the battleship is more likely to be in downward neighbor coordinates.<br>
•	10,000 games finished in 63 nanoseconds.
